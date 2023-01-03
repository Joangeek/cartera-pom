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

import academico.TblacaActividadCalendario;
import academico.TblacaCalendarioAcademico;
import academico.TblacaPeriodo;
import academico.TblacaSede;

import com.academico.CalendarioBO;
import com.academico.SedeProgramaBO;
import com.comun.controlador.util.Utilidad;
import com.comun.controlador.util.core.BaseControlador;
import com.comun.util.CrudBO;
import com.gestion.MenuUserGruPerBO;
import com.gestion.ParametrosBO;
import commons.util.Cfg;
import commons.util.UtilidadBean;

@ManagedBean(name = "calendarioMB")
@ViewScoped
public class CalendarioMB<T> extends BaseControlador implements Serializable {

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
	private transient CalendarioBO calendarioBO;

	private List<TblacaCalendarioAcademico> listaCalendarioAcademico;
	private List<TblacaCalendarioAcademico> listaCalendarioFilter;
	
	private List<TblacaSede> listaSedes;
	private List<TblacaActividadCalendario> listaActividad;
	private List<TblacaPeriodo> listaperiodo;
	
	
	

	private TblacaCalendarioAcademico entity;
	private TblacaCalendarioAcademico selected;

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
		listaActividad = new ArrayList<TblacaActividadCalendario>();
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
		selected = new TblacaCalendarioAcademico();
		entity = new TblacaCalendarioAcademico();

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
			
			listaActividad = (List<TblacaActividadCalendario>) crudBO
					.buscarTodos((Class<T>) TblacaActividadCalendario.class);
			
			listaSedes= (List<TblacaSede>) crudBO
					.buscarTodos((Class<T>) TblacaSede.class);
			
			listaperiodo= (List<TblacaPeriodo>) crudBO
					.buscarTodos((Class<T>) TblacaPeriodo.class);
			
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
			listaSedes = sedeProgramaBO.buscarSedes();
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
			listaCalendarioAcademico = calendarioBO.listar();
		} catch (NullPointerException e) {
			LOGGER.info("Null P al cargarTodos: ");
		} catch (Exception e) {
			LOGGER.info("Error al cargarTodos: " + e.getMessage(), e);
		}

	}
	
	
	/**
	 * Método que registra la entidad
	 */

	public void create() {
		try {
			LOGGER.info("Entro a crear 1.0");
			//entity.setUsuario(user);
			calendarioBO.crear(UtilidadBean.serialize(entity), true);
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
			calendarioBO.editar(UtilidadBean.serialize(selected));
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
	 * Método que actualiza la entidad
	 */

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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	

	public List<TblacaSede> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(List<TblacaSede> listaSedes) {
		this.listaSedes = listaSedes;
	}

	public List<TblacaCalendarioAcademico> getListaCalendarioAcademico() {
		return listaCalendarioAcademico;
	}

	public void setListaCalendarioAcademico(
			List<TblacaCalendarioAcademico> listaCalendarioAcademico) {
		this.listaCalendarioAcademico = listaCalendarioAcademico;
	}

	public List<TblacaCalendarioAcademico> getListaCalendarioFilter() {
		return listaCalendarioFilter;
	}

	public void setListaCalendarioFilter(
			List<TblacaCalendarioAcademico> listaCalendarioFilter) {
		this.listaCalendarioFilter = listaCalendarioFilter;
	}

	public List<TblacaActividadCalendario> getListaActividad() {
		return listaActividad;
	}

	public void setListaActividad(List<TblacaActividadCalendario> listaActividad) {
		this.listaActividad = listaActividad;
	}

	public List<TblacaPeriodo> getListaperiodo() {
		return listaperiodo;
	}

	public void setListaperiodo(List<TblacaPeriodo> listaperiodo) {
		this.listaperiodo = listaperiodo;
	}

	public TblacaCalendarioAcademico getEntity() {
		return entity;
	}

	public void setEntity(TblacaCalendarioAcademico entity) {
		this.entity = entity;
	}

	public TblacaCalendarioAcademico getSelected() {
		return selected;
	}

	public void setSelected(TblacaCalendarioAcademico selected) {
		this.selected = selected;
	}

	
}
