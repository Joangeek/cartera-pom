package com.cartera.variables;

import exceptions.BOException;
import gestion.MenuUserGruPer;
import gestion.Util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import academico.TblacaMatriculado;
import academico.TblacaPeriodo;
import academico.TblestEstudiantePrograma;

import com.academico.EstudianteProgramaBO;
import com.academico.PeriodoBO;
import com.comun.controlador.util.Utilidad;
import com.comun.controlador.util.core.BaseControlador;
import com.comun.util.CrudBO;
import com.gestion.MenuUserGruPerBO;
import com.gestion.ParametrosBO;
import commons.util.Cfg;

@ManagedBean(name = "estudiantesMB")
@SessionScoped
public class EstudiantesMB<T> extends BaseControlador implements Serializable {

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
	private transient EstudianteProgramaBO estudianteProgramaBO;
	@EJB
	private transient MenuUserGruPerBO menuUserGruPerBO;
	@EJB
	private ParametrosBO parametrosBO;

	@SuppressWarnings("rawtypes")
	@ManagedProperty(value = "#{programasMB}")
	private ProgramasMB programasMB;
	
	@SuppressWarnings("rawtypes")
	@ManagedProperty(value = "#{recibosVariosMB}") 
	private RecibosVariosMB recibosVariosMB;

	/*
	 * @ManagedProperty("#{configurar}") private ResourceBundle configurar;
	 */
	private List<TblacaPeriodo> listaPeriodos;
	private List<TblacaMatriculado> listaEstudiantesMatriculados;

	private TblacaMatriculado selected;
	private TblestEstudiantePrograma selectedEp;

	@SuppressWarnings("unused")
	private String user = Util.getUserSession();
	private Integer periodoDefault = Integer.parseInt(Util.getPeriodoDefault());
	private Integer sedeDefault = 1;

	// CARGA DE INTERFACES
	private boolean verEstudiantes;
	private boolean verProgramas;
	private boolean verRecibos;

	// CARGA TITULOS
	private String titulo;

	// ACCIONES
	private boolean acCrear;
	private boolean acEditar;
	private boolean acRegresar;
	private boolean acEliminar;
	private boolean acEstado;

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		LOGGER.info("INT EstudiantesMB");
		setVerProgramas(false);
		setVerEstudiantes(true);
		setVerRecibos(false);
		titulo = new String();

		selected = new TblacaMatriculado();
		selectedEp = new TblestEstudiantePrograma();

	}

	@PostConstruct
	public void init() {
		inicializar();
		programasMB.setEstudiantesMB(this);
		titulo = obtenerResourceBundle(CARTERA).getString(
				"page.estudiantes.title.estudiantes");
	}

	public void verPorgramas() {
		if (Utilidad.validaNulos(selected)) {
			setVerProgramas(true);
			setVerEstudiantes(false);
			setVerRecibos(false);
			programasMB.setEstudiante(selected.getTblestEstudiante());
			titulo = obtenerResourceBundle(CARTERA).getString(
					"page.programas.title.programas");

		} else {
			msgNoSeleccionado();
		}

	}

	public void verRecibos() {
		if (Utilidad.validaNulos(selected)) {
			setVerProgramas(false);
			setVerEstudiantes(false);
			setVerRecibos(true);
			recibosVariosMB.setEstudiantePrograma(selectedEp);			
			titulo = obtenerResourceBundle(CARTERA).getString(
					"page.header.title_valores_derechos_pecuniarios");

		} else {
			msgNoSeleccionado();
		}
	}


	/**
	 * Método quwe controla la redirección del botón regresar dependia¿endo de
	 * la vista desplegada
	 */
	public void lanzarRegresar() {
		if (!verEstudiantes && verProgramas && !verRecibos) {
			LOGGER.info("1");
			selected = new TblacaMatriculado();
			init();
		} else if (!verEstudiantes && !verProgramas && verRecibos) {
			LOGGER.info("2");
			verPorgramas();
		}
	}

	public List<TblacaMatriculado> listarEstudiantes() {
		listaEstudiantesMatriculados = new ArrayList<TblacaMatriculado>();
		try {
			listaEstudiantesMatriculados = estudianteProgramaBO.buscarPorPeriodoSede(periodoDefault,sedeDefault);
		} catch (BOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaEstudiantesMatriculados;
	}

	public void onRowSelect() {
		lanzarMensajeInfo("Item seleccionado: " + selected.getTblestEstudiante().getNombres());
		programasMB.setEstudiante(selected.getTblestEstudiante());
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
	public ProgramasMB getProgramasMB() {
		return programasMB;
	}

	@SuppressWarnings("rawtypes")
	public void setProgramasMB(ProgramasMB programasMB) {
		this.programasMB = programasMB;
	}

	@SuppressWarnings("rawtypes")
	public RecibosVariosMB getRecibosVariosMB() {
		return recibosVariosMB;
	}
	@SuppressWarnings("rawtypes")
	public void setRecibosVariosMB(RecibosVariosMB recibosVariosMB) {
		this.recibosVariosMB = recibosVariosMB;
	}

	public boolean isVerProgramas() {
		return verProgramas;
	}

	public void setVerProgramas(boolean verProgramas) {
		this.verProgramas = verProgramas;
	}

	public boolean isVerEstudiantes() {
		return verEstudiantes;
	}

	public void setVerEstudiantes(boolean verEstudiantes) {
		this.verEstudiantes = verEstudiantes;
	}

	public boolean isVerRecibos() {
		return verRecibos;
	}

	public void setVerRecibos(boolean verRecibos) {
		this.verRecibos = verRecibos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TblestEstudiantePrograma getSelectedEp() {
		return selectedEp;
	}

	public void setSelectedEp(TblestEstudiantePrograma selectedEp) {
		this.selectedEp = selectedEp;
	}

	public TblacaMatriculado getSelected() {
		return selected;
	}

	public void setSelected(TblacaMatriculado selected) {
		this.selected = selected;
	}

}
