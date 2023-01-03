package academico;

import java.io.Serializable;

import javax.persistence.*;

import cartera.TblextCursosExtensionH;
import cartera.TblfinEstudianteProgramaRecibo;
import cartera.TblmerAdmitido;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblaca_periodo database table.
 * 
 */
@Entity
@Table(name="tblaca_periodo",  schema="academico")
@NamedQuery(name="TblacaPeriodo.findAll", query="SELECT t FROM TblacaPeriodo t")
public class TblacaPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_PERIODO_OID_GENERATOR", sequenceName = "ACADEMICO.PERIODO_OID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_PERIODO_OID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer oid;

	@Column(nullable=false)
	private Integer anio;

	@Column(name="apertura_matricula")
	private Integer aperturaMatricula;

	@Column(name="apertura_recibo")
	private Integer aperturaRecibo;

	@Column(name="autocontrol_datos")
	private Integer autocontrolDatos;

	@Column(name="autocontrol_datos_h")
	private Integer autocontrolDatosH;

	@Column(nullable=false, length=20)
	private String descripcion;

	@Column(nullable=false)
	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechacreacion;

	@Column(nullable=false)
	private Integer preinscripcion;

	@Column(nullable=false, length=2)
	private String semestre;

	//bi-directional many-to-one association to TblacaCalendarioAcademico
	@OneToMany(mappedBy="tblacaPeriodo")
	private List<TblacaCalendarioAcademico> tblacaCalendarioAcademicos;

	//bi-directional many-to-one association to TblacaMatriculado
	@OneToMany(mappedBy="tblacaPeriodo")
	private List<TblacaMatriculado> tblacaMatriculados;

	//bi-directional many-to-one association to TblacaProgramacionParciale
	@OneToMany(mappedBy="tblacaPeriodo")
	private List<TblacaProgramacionParciale> tblacaProgramacionParciales;

	//bi-directional many-to-one association to TblextCursosExtensionH
	@OneToMany(mappedBy="tblacaPeriodo")
	private List<TblextCursosExtensionH> tblextCursosExtensionHs;

	//bi-directional many-to-one association to TblfinEstudianteProgramaRecibo
	@OneToMany(mappedBy="tblacaPeriodo")
	private List<TblfinEstudianteProgramaRecibo> tblfinEstudianteProgramaRecibos;

	//bi-directional many-to-one association to TblmerAdmitido
	@OneToMany(mappedBy="tblacaPeriodo")
	private List<TblmerAdmitido> tblmerAdmitidos;

	public TblacaPeriodo() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getAperturaMatricula() {
		return this.aperturaMatricula;
	}

	public void setAperturaMatricula(Integer aperturaMatricula) {
		this.aperturaMatricula = aperturaMatricula;
	}

	public Integer getAperturaRecibo() {
		return this.aperturaRecibo;
	}

	public void setAperturaRecibo(Integer aperturaRecibo) {
		this.aperturaRecibo = aperturaRecibo;
	}

	public Integer getAutocontrolDatos() {
		return this.autocontrolDatos;
	}

	public void setAutocontrolDatos(Integer autocontrolDatos) {
		this.autocontrolDatos = autocontrolDatos;
	}

	public Integer getAutocontrolDatosH() {
		return this.autocontrolDatosH;
	}

	public void setAutocontrolDatosH(Integer autocontrolDatosH) {
		this.autocontrolDatosH = autocontrolDatosH;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Integer getPreinscripcion() {
		return this.preinscripcion;
	}

	public void setPreinscripcion(Integer preinscripcion) {
		this.preinscripcion = preinscripcion;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<TblacaCalendarioAcademico> getTblacaCalendarioAcademicos() {
		return this.tblacaCalendarioAcademicos;
	}

	public void setTblacaCalendarioAcademicos(List<TblacaCalendarioAcademico> tblacaCalendarioAcademicos) {
		this.tblacaCalendarioAcademicos = tblacaCalendarioAcademicos;
	}

	public TblacaCalendarioAcademico addTblacaCalendarioAcademico(TblacaCalendarioAcademico tblacaCalendarioAcademico) {
		getTblacaCalendarioAcademicos().add(tblacaCalendarioAcademico);
		tblacaCalendarioAcademico.setTblacaPeriodo(this);

		return tblacaCalendarioAcademico;
	}

	public TblacaCalendarioAcademico removeTblacaCalendarioAcademico(TblacaCalendarioAcademico tblacaCalendarioAcademico) {
		getTblacaCalendarioAcademicos().remove(tblacaCalendarioAcademico);
		tblacaCalendarioAcademico.setTblacaPeriodo(null);

		return tblacaCalendarioAcademico;
	}

	public List<TblacaMatriculado> getTblacaMatriculados() {
		return this.tblacaMatriculados;
	}

	public void setTblacaMatriculados(List<TblacaMatriculado> tblacaMatriculados) {
		this.tblacaMatriculados = tblacaMatriculados;
	}

	public TblacaMatriculado addTblacaMatriculado(TblacaMatriculado tblacaMatriculado) {
		getTblacaMatriculados().add(tblacaMatriculado);
		tblacaMatriculado.setTblacaPeriodo(this);

		return tblacaMatriculado;
	}

	public TblacaMatriculado removeTblacaMatriculado(TblacaMatriculado tblacaMatriculado) {
		getTblacaMatriculados().remove(tblacaMatriculado);
		tblacaMatriculado.setTblacaPeriodo(null);

		return tblacaMatriculado;
	}

	public List<TblacaProgramacionParciale> getTblacaProgramacionParciales() {
		return this.tblacaProgramacionParciales;
	}

	public void setTblacaProgramacionParciales(List<TblacaProgramacionParciale> tblacaProgramacionParciales) {
		this.tblacaProgramacionParciales = tblacaProgramacionParciales;
	}

	public TblacaProgramacionParciale addTblacaProgramacionParciale(TblacaProgramacionParciale tblacaProgramacionParciale) {
		getTblacaProgramacionParciales().add(tblacaProgramacionParciale);
		tblacaProgramacionParciale.setTblacaPeriodo(this);

		return tblacaProgramacionParciale;
	}

	public TblacaProgramacionParciale removeTblacaProgramacionParciale(TblacaProgramacionParciale tblacaProgramacionParciale) {
		getTblacaProgramacionParciales().remove(tblacaProgramacionParciale);
		tblacaProgramacionParciale.setTblacaPeriodo(null);

		return tblacaProgramacionParciale;
	}

	public List<TblextCursosExtensionH> getTblextCursosExtensionHs() {
		return this.tblextCursosExtensionHs;
	}

	public void setTblextCursosExtensionHs(List<TblextCursosExtensionH> tblextCursosExtensionHs) {
		this.tblextCursosExtensionHs = tblextCursosExtensionHs;
	}

	public TblextCursosExtensionH addTblextCursosExtensionH(TblextCursosExtensionH tblextCursosExtensionH) {
		getTblextCursosExtensionHs().add(tblextCursosExtensionH);
		tblextCursosExtensionH.setTblacaPeriodo(this);

		return tblextCursosExtensionH;
	}

	public TblextCursosExtensionH removeTblextCursosExtensionH(TblextCursosExtensionH tblextCursosExtensionH) {
		getTblextCursosExtensionHs().remove(tblextCursosExtensionH);
		tblextCursosExtensionH.setTblacaPeriodo(null);

		return tblextCursosExtensionH;
	}

	public List<TblfinEstudianteProgramaRecibo> getTblfinEstudianteProgramaRecibos() {
		return this.tblfinEstudianteProgramaRecibos;
	}

	public void setTblfinEstudianteProgramaRecibos(List<TblfinEstudianteProgramaRecibo> tblfinEstudianteProgramaRecibos) {
		this.tblfinEstudianteProgramaRecibos = tblfinEstudianteProgramaRecibos;
	}

	public TblfinEstudianteProgramaRecibo addTblfinEstudianteProgramaRecibo(TblfinEstudianteProgramaRecibo tblfinEstudianteProgramaRecibo) {
		getTblfinEstudianteProgramaRecibos().add(tblfinEstudianteProgramaRecibo);
		tblfinEstudianteProgramaRecibo.setTblacaPeriodo(this);

		return tblfinEstudianteProgramaRecibo;
	}

	public TblfinEstudianteProgramaRecibo removeTblfinEstudianteProgramaRecibo(TblfinEstudianteProgramaRecibo tblfinEstudianteProgramaRecibo) {
		getTblfinEstudianteProgramaRecibos().remove(tblfinEstudianteProgramaRecibo);
		tblfinEstudianteProgramaRecibo.setTblacaPeriodo(null);

		return tblfinEstudianteProgramaRecibo;
	}

	public List<TblmerAdmitido> getTblmerAdmitidos() {
		return this.tblmerAdmitidos;
	}

	public void setTblmerAdmitidos(List<TblmerAdmitido> tblmerAdmitidos) {
		this.tblmerAdmitidos = tblmerAdmitidos;
	}

	public TblmerAdmitido addTblmerAdmitido(TblmerAdmitido tblmerAdmitido) {
		getTblmerAdmitidos().add(tblmerAdmitido);
		tblmerAdmitido.setTblacaPeriodo(this);

		return tblmerAdmitido;
	}

	public TblmerAdmitido removeTblmerAdmitido(TblmerAdmitido tblmerAdmitido) {
		getTblmerAdmitidos().remove(tblmerAdmitido);
		tblmerAdmitido.setTblacaPeriodo(null);

		return tblmerAdmitido;
	}

}