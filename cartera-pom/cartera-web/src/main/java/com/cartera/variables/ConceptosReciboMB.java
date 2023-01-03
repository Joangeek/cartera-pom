package com.cartera.variables;

import gestion.MenuUserGruPer;
import gestion.Util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cartera.TblfinConceptosRecibo;

import com.comun.controlador.util.Utilidad;
import com.comun.controlador.util.core.BaseControlador;
import com.comun.util.CrudBO;
import com.gestion.MenuUserGruPerBO;
import com.gestion.ParametrosBO;

import commons.util.Cfg;

@ManagedBean(name = "conceptosReciboMB")
@ViewScoped
public class ConceptosReciboMB<T> extends BaseControlador implements Serializable {

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
	private ParametrosBO parametrosBO;

	private List<TblfinConceptosRecibo> listaConceptos;
	private List<TblfinConceptosRecibo> listaConceptosFilter;

	private TblfinConceptosRecibo entity;
	private TblfinConceptosRecibo selected;

	//private String user = Util.getUserSession();

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
		inicializar();
	}

	@Override
	public void inicializar() {
		listar();
		setCrear(false);
		setEditar(false);
		setEstado(false);
		selected = new TblfinConceptosRecibo();
		entity = new TblfinConceptosRecibo();

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
	@SuppressWarnings("unchecked")
	private void listar() {
		try {
			listaConceptos = (List<TblfinConceptosRecibo>) crudBO
					.buscarTodos((Class<T>) TblfinConceptosRecibo.class);
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
	public void create() {
		try {
			LOGGER.info("Entro a crear 1.0");
	//		entity.setUsuario(user);
			crudBO.crear((T) entity, true);
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
	@SuppressWarnings({ "unchecked" })
	public void update() {
		try {
			crudBO.editar((T) selected);
			lanzarMensajeInfo(obtenerResourceBundle(COMUN).getString(
					"global.msg.exito.edito"));
			inicializar();
		} catch (NullPointerException e) {
			LOGGER.info("NuLL UPDATE: ");
		} catch (Exception e) {
			LOGGER.info("Error UPDATE: " + e.getMessage(), e);
		}

	}
	
	@SuppressWarnings("unchecked")
	public void delete() {
		try {
			crudBO.remover((T) selected);
			///(UtilidadBean.serialize(selected));
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

	public TblfinConceptosRecibo getEntity() {
		return entity;
	}

	public void setEntity(TblfinConceptosRecibo entity) {
		this.entity = entity;
	}

	public TblfinConceptosRecibo getSelected() {
		return selected;
	}

	public void setSelected(TblfinConceptosRecibo selected) {
		this.selected = selected;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<TblfinConceptosRecibo> getListaConceptos() {
		return listaConceptos;
	}

	public void setListaConceptos(List<TblfinConceptosRecibo> listaConceptos) {
		this.listaConceptos = listaConceptos;
	}

	public List<TblfinConceptosRecibo> getListaConceptosFilter() {
		return listaConceptosFilter;
	}

	public void setListaConceptosFilter(
			List<TblfinConceptosRecibo> listaConceptosFilter) {
		this.listaConceptosFilter = listaConceptosFilter;
	}


}
