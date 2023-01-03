package com.cartera.variables;

import gestion.MenuUserGruPer;
import gestion.Util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import academico.TblacaPeriodo;
import academico.TblacaSede;
import academico.TblacaSedePrograma;
import cartera.TblEstrato;
import cartera.TblfinTarifa;
import cartera.TblfinTarifaMatricula;
import cartera.TblmerCategoriaComfacauca;

import com.academico.DescuentosBO;
import com.academico.PeriodoBO;
import com.academico.SedeProgramaBO;
import com.comun.controlador.util.core.BaseControlador;
import com.comun.util.CrudBO;
import com.gestion.MenuUserGruPerBO;
import com.gestion.ParametrosBO;
import commons.util.Cfg;
import commons.util.UtilidadBean;

@ManagedBean(name = "descuentosMB")
@SessionScoped
public class DescuentosMB<T> extends BaseControlador implements Serializable {

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
	private transient PeriodoBO periodoBO;
	@EJB
	private transient MenuUserGruPerBO menuUserGruPerBO;
	@EJB
	private transient ParametrosBO parametrosBO;
	@EJB
	private transient DescuentosBO descuentosBO;
	@EJB
	private transient SedeProgramaBO sedeProgramaBO;

	private List<TblacaPeriodo> listaPeriodos;

	private List<TblfinTarifaMatricula> listaDescuentos;
	private List<TblfinTarifaMatricula> listaDescuentosFilter;

	private List<TblEstrato> listaEstratos;
	private List<TblmerCategoriaComfacauca> listaCategoriasComfa;

	private List<TblacaSede> listaSedes;
	private List<TblacaSedePrograma> listaProgramas;
	private List<TblfinTarifa> listaTarifas;

	private TblfinTarifaMatricula entity;
	private TblfinTarifaMatricula selected;
	private TblacaSede sedeSelected;
	private TblacaSedePrograma programaSelected;

	@SuppressWarnings("unused")
	private String user = Util.getUserSession();

	private boolean crear;
	private boolean editar;

	// ACCIONES
	private boolean acCrear;
	private boolean acEditar;
	private boolean acRegresar;
	private boolean acEliminar;
	private boolean acEstado;

	@PostConstruct
	public void init() {
		listaPeriodos = new ArrayList<TblacaPeriodo>();
		listaTarifas = new ArrayList<TblfinTarifa>();
		listaSedes = new ArrayList<TblacaSede>();
		listaEstratos = new ArrayList<TblEstrato>();
		listaCategoriasComfa = new ArrayList<TblmerCategoriaComfacauca>();
		sedeSelected = new TblacaSede();
		programaSelected = new TblacaSedePrograma();

		inicializar();
		cargarCatalogos();

	}

	@Override
	public void inicializar() {
		listaDescuentos = new ArrayList<TblfinTarifaMatricula>();
		listar();
		setCrear(false);
		setEditar(false);

		selected = new TblfinTarifaMatricula();
		entity = new TblfinTarifaMatricula();

	}

	// Carga los catalogos o lista de selección de las vistas
	@SuppressWarnings("unchecked")
	private void cargarCatalogos() {

		try {
			listaPeriodos = (List<TblacaPeriodo>) crudBO
					.buscarTodos((Class<T>) TblacaPeriodo.class);

			listaTarifas = (List<TblfinTarifa>) crudBO
					.buscarTodos((Class<T>) TblfinTarifa.class);

			listaEstratos = (List<TblEstrato>) crudBO
					.buscarTodos((Class<T>) TblEstrato.class);

			listaCategoriasComfa = (List<TblmerCategoriaComfacauca>) crudBO
					.buscarTodos((Class<T>) TblmerCategoriaComfacauca.class);

			listaSedes = sedeProgramaBO.buscarSedes();

		} catch (NullPointerException e) {
			LOGGER.info("Null P lis ");
		} catch (Exception e) {
			LOGGER.info("Error al cargarListas: " + e.getMessage(), e);
		}
	}

	public void cargarProgramaPorSede() {

		try {
			listaProgramas = sedeProgramaBO.buscarPorSede(UtilidadBean
					.serialize(sedeSelected));

		} catch (NullPointerException e) {
			LOGGER.info("Null P lis ");
		} catch (Exception e) {
			LOGGER.info("Error al cargarListas: " + e.getMessage(), e);
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
			listaDescuentos = descuentosBO.listar();
		} catch (NullPointerException e) {
			LOGGER.info("Null P al cargarTodos: ");
		} catch (Exception e) {
			LOGGER.info("Error al cargarTodos: " + e.getMessage(), e);
		}

	}

	/**
	 * Método que registra la entidad
	 */
	public boolean create() {
		try {
			LOGGER.info("Entro a crear 1.0");
			// entity.setUsuario(user);
			entity.setTblacaSede(sedeSelected);
			entity.setTblacaPrograma(programaSelected.getTblacaPrograma());
			descuentosBO.crear(UtilidadBean.serialize(entity), true);

			inicializar();
			ejecutarUpdate("form");
			ejecutarUpdate("formDialogs");
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.creo"));

			return true;
		} catch (NullPointerException e) {
			LOGGER.info("Null CREATE: ");
			return false;
		} catch (Exception e) {
			LOGGER.info("Error CREATE: " + e.getMessage(), e);
			return false;
		}

	}

	/**
	 * Método que actualiza la entidad
	 */
	public boolean update() {
		try {
			descuentosBO.editar(UtilidadBean.serialize(selected));
			inicializar();
			ejecutarUpdate("form");
			ejecutarUpdate("formDialogsEdit");
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.edito"));

			return true;

		} catch (NullPointerException e) {
			LOGGER.info("NuLL UPDATE: ");
			return false;
		} catch (Exception e) {
			LOGGER.info("Error UPDATE: " + e.getMessage(), e);
			return false;
		}

	}

	public void reset() {
		entity = new TblfinTarifaMatricula();
		sedeSelected = new TblacaSede();
		programaSelected = new TblacaSedePrograma();
	}

	/**
	 * Método que elimina un registro
	 */
	public void delete() {
		try {
			
			descuentosBO.eliminar(UtilidadBean.serialize(selected));
			// /(UtilidadBean.serialize(selected));

			inicializar();
			ejecutarUpdate("form");
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.elimino"));
		} catch (NullPointerException e) {
			LOGGER.info("NuLL DELETE: ");
		} catch (Exception e) {
			LOGGER.info("Error DELETE: " + e.getMessage(), e);
		}

	}

	// SETES AND GETTES

	public List<TblacaPeriodo> getListaPeriodos() {
		return listaPeriodos;
	}

	public void setListaPeriodos(List<TblacaPeriodo> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}

	public boolean isCrear() {
		return crear;
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

	public List<TblfinTarifaMatricula> getListaDescuentos() {
		return listaDescuentos;
	}

	public void setListaDescuentos(List<TblfinTarifaMatricula> listaDescuentos) {
		this.listaDescuentos = listaDescuentos;
	}

	public List<TblfinTarifaMatricula> getListaDescuentosFilter() {
		return listaDescuentosFilter;
	}

	public void setListaDescuentosFilter(
			List<TblfinTarifaMatricula> listaDescuentosFilter) {
		this.listaDescuentosFilter = listaDescuentosFilter;
	}

	public List<TblEstrato> getListaEstratos() {
		return listaEstratos;
	}

	public void setListaEstratos(List<TblEstrato> listaEstratos) {
		this.listaEstratos = listaEstratos;
	}

	public List<TblmerCategoriaComfacauca> getListaCategoriasComfa() {
		return listaCategoriasComfa;
	}

	public void setListaCategoriasComfa(
			List<TblmerCategoriaComfacauca> listaCategoriasComfa) {
		this.listaCategoriasComfa = listaCategoriasComfa;
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

	public TblfinTarifaMatricula getEntity() {
		return entity;
	}

	public void setEntity(TblfinTarifaMatricula entity) {
		this.entity = entity;
	}

	public TblfinTarifaMatricula getSelected() {
		return selected;
	}

	public void setSelected(TblfinTarifaMatricula selected) {
		this.selected = selected;
	}

	public TblacaSede getSedeSelected() {
		return sedeSelected;
	}

	public void setSedeSelected(TblacaSede sedeSelected) {
		this.sedeSelected = sedeSelected;
	}

	public List<TblfinTarifa> getListaTarifas() {
		return listaTarifas;
	}

	public void setListaTarifas(List<TblfinTarifa> listaTarifas) {
		this.listaTarifas = listaTarifas;
	}

	public TblacaSedePrograma getProgramaSelected() {
		return programaSelected;
	}

	public void setProgramaSelected(TblacaSedePrograma programaSelected) {
		this.programaSelected = programaSelected;
	}

}
