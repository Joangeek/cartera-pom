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
import cartera.TblfinTarifa;

import com.academico.PeriodoBO;
import com.academico.TarifasBO;
import com.comun.controlador.util.core.BaseControlador;
import com.comun.util.CrudBO;
import com.gestion.MenuUserGruPerBO;
import com.gestion.ParametrosBO;

import commons.util.Cfg;


@ManagedBean(name = "tarifasMB")
@SessionScoped
public class TarifasMB<T> extends BaseControlador implements Serializable {

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
	private transient TarifasBO tarifasBO;

	private List<TblacaPeriodo> listaPeriodos;

	private List<TblfinTarifa> listaTarifas;
	private List<TblfinTarifa> listaTarifasFilter;



	private TblfinTarifa entity;
	private TblfinTarifa selected;

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
		inicializar();
		cargarCatalogos();

	}

	@Override
	public void inicializar() {
		listaTarifas = new ArrayList<TblfinTarifa>();
		listar();
		setCrear(false);
		setEditar(false);

		selected = new TblfinTarifa();
		entity = new TblfinTarifa();

	}

	// Carga los catalogos o lista de selección de las vistas
	@SuppressWarnings("unchecked")
	private void cargarCatalogos() {

		try {
			listaPeriodos = (List<TblacaPeriodo>) crudBO
					.buscarTodos((Class<T>) TblacaPeriodo.class);

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
			listaTarifas = tarifasBO.listar();
		} catch (NullPointerException e) {
			LOGGER.info("Null P al cargarTodos: ");
		} catch (Exception e) {
			LOGGER.info("Error al cargarTodos: " + e.getMessage(), e);
		}

	}
	
	/**
	 * Método que registra la entidad
	 */
	@SuppressWarnings({ "unchecked" })
	public boolean create() {
		try {
			LOGGER.info("Entro a crear 1.0");
			//entity.setUsuario(user);
			crudBO.crear((T) entity, true);
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.creo"));
			
			inicializar();
			ejecutarUpdate("form");
			ejecutarUpdate("formDialogs");
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
	@SuppressWarnings({ "unchecked" })
	public boolean update() {
		try {
			crudBO.editar((T) selected);
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.edito"));
			
			inicializar();
			ejecutarUpdate("form");
			ejecutarUpdate("formDialogsEdit");
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
		entity = new TblfinTarifa();	
		   }

	
	/**
	 * Método que elimina un registro
	 */
	@SuppressWarnings("unchecked")
	public void delete() {
		try {
			crudBO.remover((T) selected);
			///(UtilidadBean.serialize(selected));
			
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

	public TblfinTarifa getEntity() {
		return entity;
	}

	public void setEntity(TblfinTarifa entity) {
		this.entity = entity;
	}

	public TblfinTarifa getSelected() {
		return selected;
	}

	public void setSelected(TblfinTarifa selected) {
		this.selected = selected;
	}

	public List<TblfinTarifa> getListaTarifas() {
		return listaTarifas;
	}

	public void setListaTarifas(List<TblfinTarifa> listaTarifas) {
		this.listaTarifas = listaTarifas;
	}

	public List<TblfinTarifa> getListaTarifasFilter() {
		return listaTarifasFilter;
	}

	public void setListaTarifasFilter(List<TblfinTarifa> listaTarifasFilter) {
		this.listaTarifasFilter = listaTarifasFilter;
	}
	
}
