package com.cartera.variables;

import gestion.MenuUserGruPer;
import gestion.Util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import academico.TblacaSede;
import academico.TblacaSedePrograma;
import cartera.TblfinBanco;
import cartera.TblfinTipoCuenta;

import com.academico.SedeProgramaBO;
import com.cartera.BancoBO;
import com.comun.controlador.util.Utilidad;
import com.comun.controlador.util.core.BaseControlador;
import com.comun.util.CrudBO;
import com.gestion.MenuUserGruPerBO;
import com.gestion.ParametrosBO;

import commons.util.Cfg;
import commons.util.UtilidadBean;

@ManagedBean(name = "bancosMB")
@ViewScoped
public class BancosMB<T> extends BaseControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1487433293293730257L;
	private static final String CODMENU = "0016";

	/*
	 * EJB
	 */
	@EJB
	private transient CrudBO<T> crudBO;
	@EJB
	private transient MenuUserGruPerBO menuUserGruPerBO;
	@EJB
	private transient ParametrosBO parametrosBO;
	@EJB
	private transient SedeProgramaBO sedeProgramaBO;
	@EJB
	private transient BancoBO bancoBO;

	private List<TblfinBanco> listaBancos;
	private List<TblfinBanco> listaBancosFilter;
	private List<TblfinTipoCuenta> listaTiposbancos;
	private List<TblacaSede> listaSedes;
	private List<TblacaSedePrograma> listaProgramas;

	private TblfinBanco entity;
	private TblfinBanco selected;
	private TblacaSede sedeSelected;

	private String user = Util.getUserSession();

	private boolean crear;
	private boolean editar;
	private boolean estado;

	// ACCIONES
	private boolean acCrear;
	private boolean acEditar;
	private boolean acRegresar;
	private boolean acEliminar;
	private boolean acEstado;

	@PostConstruct
	public void init() {
		listaProgramas = new ArrayList<TblacaSedePrograma>();
		listaSedes = new ArrayList<TblacaSede>();
		inicializar();
		cargarCatalogos();
		setCrear(false);
		setEditar(false);
		setEstado(false);

	}

	@Override
	public void inicializar() {
		listar();
		selected = new TblfinBanco();
		entity = new TblfinBanco();

	}

	/*
	 * public void lanzarEdit(){
	 * 
	 * String js="$('[id$=BtnEditSelecBanco]').click();";
	 * Utilidad.ejecutarJavaScript(js); }
	 */

	// Carga los catalogos o lista de selección de las vistas
	@SuppressWarnings("unchecked")
	private void cargarCatalogos() {

		try {
			listaTiposbancos = (List<TblfinTipoCuenta>) crudBO
					.buscarTodos((Class<T>) TblfinTipoCuenta.class);
			listaSedes = sedeProgramaBO.buscarSedes();
		} catch (NullPointerException e) {
			LOGGER.info("Null P lis ");
		} catch (Exception e) {
			LOGGER.info("Error al cargarListas: " + e.getMessage(), e);
		}
	}

	// Busca los sede programa ´por la sede seleccionada
	public void cargarProgramas() {
		try {
			listaProgramas = sedeProgramaBO.buscarPorSede(UtilidadBean
					.serialize(sedeSelected));
		} catch (Exception e) {
			LOGGER.info("Error al cargarProgramas: ");
		}

	}

	/**
	 * Método que evalúa las acciones activas de la página, ésta se encuentra
	 * referenciada como menú, se inicializan lolos botónes y se valida en menú
	 * y el menu_grupo_usuario: ésta última cargada desde loginBean en una
	 * variable de sessión
	 */

	@SuppressWarnings("unused")
	private void cargarAccionesPerfil() {
		// HttpSession session = Util.getSession();
		List<Integer> listMenuUsuGrupo = new ArrayList<Integer>();
		listMenuUsuGrupo = Util.getMenuUsuarioGrupo();
		// listMenuUsuGrupo = (List<Integer>) session
		// .getAttribute("menuUsuarioGrupo");
		LOGGER.info(listMenuUsuGrupo.size());
		List<MenuUserGruPer> lista = new ArrayList<MenuUserGruPer>();
		try {

			// consulta los permisos que tiene de acuerdo al menú y al
			// menu_grupo_usuario logueado
			lista = menuUserGruPerBO.buscaPerfiles(listMenuUsuGrupo,
					parametrosBO.buscarCodigo(CODMENU).getVal_int());

		} catch (Exception e) {
			LOGGER.info(e);
		}
		/**
		 * ciclo que evalua las acciones permitidas al usuario. Renderiza
		 * componentes en la interfaz
		 */
		for (MenuUserGruPer grup : lista) {
			String permiso = grup.getPermiso().getAccion();
			if (permiso.equals(Cfg.REGRESAR)) {
				acRegresar = true;
			}
			if (permiso.equals(Cfg.CREAR)) {
				acCrear = true;
			}
			if (permiso.equals(Cfg.EDITAR)) {
				acEditar = true;
			}
			if (permiso.equals(Cfg.ELIMINAR)) {
				acEliminar = true;
			}
			if (permiso.equals(Cfg.ESTADO)) {
				acEstado = true;
			}

		}
	}

	/**
	 * Método que consulta todos los datos relacionados a la entidad
	 */
	private void listar() {
		try {
			listaBancos = bancoBO.buscarbancos();
		} catch (NullPointerException e) {
			LOGGER.info("Null P al cargarTodos: ");
		} catch (Exception e) {
			LOGGER.info("Error al cargarTodos: " + e.getMessage(), e);
		}

	}
	
	public HtmlSelectOneMenu getPeriodEndings(){
		  HtmlSelectOneMenu menu = new HtmlSelectOneMenu();
		  UISelectItems items = new UISelectItems();
		  
		  items.setValue(listaTiposbancos);
		  menu.getChildren().add(items);
		  // i set "selected" in the method that populates my arraylist.
		  menu.setValue(selected.getTblfinTipoCuenta());
		  return menu;
		}

	public List<SelectItem> getPossibleStates() {
		
		HashMap<Integer, TblfinTipoCuenta> myMap = new HashMap<Integer, TblfinTipoCuenta>();
		
		List<SelectItem> result = new ArrayList<SelectItem>(listaTiposbancos.size());
		result.add(new SelectItem("", ""));
		myMap.clear();
		for (TblfinTipoCuenta value : listaTiposbancos) {
			myMap.put(value.getOid(), value);
			// result.add(new SelectItem(state, new
			// I18n(state.toString()).getDefault()));
			result.add(new SelectItem(value.getOid(),value.getTipo()));
			//result.add(new SelectItem(value.toString(), (value));
		}
		return result;
	}
	
	/*
	public List<SelectItem> getPossibleStates() {
		RequestLanguageState[] states = RequestLanguageState.values();
		List<SelectItem> result = new ArrayList<SelectItem>(states.length);
		result.add(new SelectItem("", ""));
		myMap.clear();
		for (RequestLanguageState state : states) {
		myMap.put(state.toString(), state);
		// result.add(new SelectItem(state, new I18n(state.toString()).getDefault()));
		result.add(new SelectItem(state.toString(), new I18n(state.toString()).getDefault()));
		}
		return result;
		}
	*/

	/**
	 * Método que registra la entidad
	 */

	public void create() {
		try {
			LOGGER.info("Entro a crear 1.0");
			entity.setUsuario(user);
			bancoBO.crear(UtilidadBean.serialize(entity), true);
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.creo"));
			inicializar();
		} catch (NullPointerException e) {
			LOGGER.info("Null CREATE: ");
		} catch (Exception e) {
			LOGGER.info("Error CREATE: " + e.getMessage(), e);
		}

	}

	/**
	 * Método que actualiza la entidad
	 */

	public void update() {
		try {
			bancoBO.editar(UtilidadBean.serialize(selected));
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.edito"));
			inicializar();
		} catch (NullPointerException e) {
			LOGGER.info("NuLL UPDATE: ");
		} catch (Exception e) {
			LOGGER.info("Error UPDATE: " + e.getMessage(), e);
		}

	}

	/**
	 * Método que cambia el estado
	 */
	@SuppressWarnings({ "unchecked" })
	public void cambiarEstado() {

		try {

			if (estado) {
				if (Utilidad.validaNulos(selected)) {
					crudBO.editar((T) selected);
					inicializar();
					lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
							"global.msg.exito.edito"));
				} else {
					msgNoSeleccionado();
				}
			} else {
				lanzarMensajeWarn(obtenerResourceBundle(COMUN).getString(
						"global.msg.cambio.estado.sin.permisos"));
			}
		} catch (NullPointerException e) {
			LOGGER.info("NullPointerException " + e.getMessage(), e);
			// lanzarMensajeError("ERROR-", e);
		} catch (Exception e) {
			lanzarMensajeError("ERROR-", e);
			LOGGER.info("Exception " + e.getMessage(), e);
		}

	}

	// SETES AND GETTES

	public boolean isCrear() {
		return crear;
	}

	public List<TblfinBanco> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<TblfinBanco> listaBancos) {
		this.listaBancos = listaBancos;
	}

	public void setCrear(boolean crear) {
		this.crear = crear;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public boolean isAcCrear() {
		return acCrear;
	}

	public void setAcCrear(boolean acCrear) {
		this.acCrear = acCrear;
	}

	public boolean isAcEditar() {
		return acEditar;
	}

	public void setAcEditar(boolean acEditar) {
		this.acEditar = acEditar;
	}

	public boolean isAcRegresar() {
		return acRegresar;
	}

	public void setAcRegresar(boolean acRegresar) {
		this.acRegresar = acRegresar;
	}

	public boolean isAcEliminar() {
		return acEliminar;
	}

	public void setAcEliminar(boolean acEliminar) {
		this.acEliminar = acEliminar;
	}

	public boolean isAcEstado() {
		return acEstado;
	}

	public void setAcEstado(boolean acEstado) {
		this.acEstado = acEstado;
	}

	public TblfinBanco getEntity() {
		return entity;
	}

	public void setEntity(TblfinBanco entity) {
		this.entity = entity;
	}

	public TblfinBanco getSelected() {
		return selected;
	}

	public void setSelected(TblfinBanco selected) {
		this.selected = selected;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<TblfinTipoCuenta> getListaTiposbancos() {
		return listaTiposbancos;
	}

	public void setListaTiposbancos(List<TblfinTipoCuenta> listaTiposbancos) {
		this.listaTiposbancos = listaTiposbancos;
	}

	public List<TblfinBanco> getListaBancosFilter() {
		return listaBancosFilter;
	}

	public void setListaBancosFilter(List<TblfinBanco> listaBancosFilter) {
		this.listaBancosFilter = listaBancosFilter;
	}

	public List<TblacaSede> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(List<TblacaSede> listaSedes) {
		this.listaSedes = listaSedes;
	}

	public List<TblacaSedePrograma> getListaProgramas() {
		return listaProgramas;
	}

	public void setListaProgramas(List<TblacaSedePrograma> listaProgramas) {
		this.listaProgramas = listaProgramas;
	}

	public TblacaSede getSedeSelected() {
		return sedeSelected;
	}

	public void setSedeSelected(TblacaSede sedeSelected) {
		this.sedeSelected = sedeSelected;
	}

}
