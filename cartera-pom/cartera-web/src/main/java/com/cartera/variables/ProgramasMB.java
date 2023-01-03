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

import util.BOException;
import academico.TblacaPeriodo;
import academico.TblestEstudiante;
import academico.TblestEstudiantePrograma;

import com.academico.EstudianteProgramaBO;
import com.academico.PeriodoBO;
import com.academico.SedeProgramaBO;
import com.comun.controlador.util.Utilidad;
import com.comun.controlador.util.core.BaseControlador;
import com.comun.util.CrudBO;
import com.gestion.MenuUserGruPerBO;
import com.gestion.ParametrosBO;

import commons.util.Cfg;
import commons.util.UtilidadBean;

@SuppressWarnings("unused")
@ManagedBean(name = "programasMB")
@SessionScoped
public class ProgramasMB<T> extends BaseControlador implements Serializable {

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
	private transient EstudianteProgramaBO estudianteProgramaBO;

	// CONTROLADORES
	@SuppressWarnings("rawtypes")
	private EstudiantesMB estudiantesMB;

	private List<TblacaPeriodo> listaPeriodos;

	private List<TblestEstudiantePrograma> listaEp;
	private TblestEstudiante estudiante;

	private String user = Util.getUserSession();

	private boolean crear;
	private boolean editar;

	// ACCIONES
	private boolean acCrear;
	private boolean acEditar;
	private boolean acRegresar;
	private boolean acEliminar;
	private boolean acEstado;

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		listaEp = new ArrayList<TblestEstudiantePrograma>();

	}

	@PostConstruct
	public void init() throws BOException {
		try {
			LOGGER.debug("INIT CONTROLADOR");
			inicializar();

		} catch (Exception ex) {
			lanzarMensajeError(null, ex);
		}

	}

	public List<TblestEstudiantePrograma> listarProgramas() {
		if (Utilidad.validaNulos(estudiante)) {
			LOGGER.info(estudiante.getNombres()+  " ---------------**************-------------------- "+estudiante.getOid());

			try {
				listaEp = estudianteProgramaBO.buscarPorEstudiante(UtilidadBean
						.serialize(estudiante));
			} catch (exceptions.BOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			LOGGER.info(estudiante.getNombres());
		}

		return listaEp;
	}

	/**
	 * Método que evalúa las acciones activas de la página, ésta se encuentra
	 * referenciada como menú, se inicializan lolos botónes y se valida en menú
	 * y el menu_grupo_usuario: ésta última cargada desde loginBean en una
	 * variable de sessión
	 */

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
	/*
	 * private void cargarTodos() { try { listat = tipoAspectoBO.buscarTodos();
	 * ejecutarUpdate(DATATABLE); } catch (NullPointerException e) {
	 * LOGGER.info("Null P al cargarTodos: "); } catch (Exception e) {
	 * LOGGER.info("Error al cargarTodos: " + e.getMessage(), e); }
	 * 
	 * }
	 */

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

	@SuppressWarnings("rawtypes")
	public EstudiantesMB getEstudiantesMB() {
		return estudiantesMB;
	}

	@SuppressWarnings("rawtypes")
	public void setEstudiantesMB(EstudiantesMB estudiantesMB) {
		this.estudiantesMB = estudiantesMB;
	}

	public TblestEstudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(TblestEstudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<TblestEstudiantePrograma> getListaEp() {
		return listaEp;
	}

	public void setListaEp(List<TblestEstudiantePrograma> listaEp) {
		this.listaEp = listaEp;
	}

}
