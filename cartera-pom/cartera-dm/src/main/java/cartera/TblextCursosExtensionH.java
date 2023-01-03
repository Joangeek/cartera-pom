package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblacaPeriodo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblext_cursos_extension_h database table.
 * 
 */
@Entity
@Table(name="tblext_cursos_extension_h", schema="academico")
@NamedQuery(name="TblextCursosExtensionH.findAll", query="SELECT t FROM TblextCursosExtensionH t")
public class TblextCursosExtensionH implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEXT_CURSOS_EXTENSION_H_IDCURSOEXTH_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEXT_CURSOS_EXTENSION_H_IDCURSOEXTH_GENERATOR")
	@Column(name="id_curso_ext_h", unique=true, nullable=false)
	private Integer idCursoExtH;

	@Column(name="cod_seccion", nullable=false, length=10)
	private String codSeccion;

	@Column(name="cur_ext_annio", nullable=false, precision=4)
	private BigDecimal curExtAnnio;

	@Column(name="cur_ext_semestre", nullable=false, length=2)
	private String curExtSemestre;

	@Column(name="d_afiliados", nullable=false)
	private Integer dAfiliados;

	@Column(name="d_egresados", nullable=false)
	private Integer dEgresados;

	@Column(name="d_estudiantes", nullable=false)
	private Integer dEstudiantes;

	@Column(name="d_particulares", nullable=false)
	private Integer dParticulares;

	@Column(name="des_dtoadicional", nullable=false, length=100)
	private String desDtoadicional;

	@Column(name="dto_adicional", nullable=false, length=100)
	private String dtoAdicional;

	@Column(nullable=false)
	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inscripcion")
	private Date fechaInscripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_limitepago")
	private Date fechaLimitepago;

	@Column(nullable=false)
	private Integer idsede;

	@Column(length=200)
	private String lugar;

	@Column(name="num_estudiantes", precision=4)
	private BigDecimal numEstudiantes;

	@Column(name="num_horas", precision=5, scale=2)
	private BigDecimal numHoras;

	@Column(nullable=false)
	private Integer valor;

	//bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idperiodo", nullable=false)
	private TblacaPeriodo tblacaPeriodo;

	//bi-directional many-to-one association to TblextCursosExtension
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_curso_ext", nullable=false)
	private TblextCursosExtension tblextCursosExtension;

	//bi-directional many-to-one association to TblextTipoCursoEdcont
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcurso_edcontinuada", nullable=false)
	private TblextTipoCursoEdcont tblextTipoCursoEdcont;

	//bi-directional many-to-one association to TblextInscripcionExtension
	@OneToMany(mappedBy="tblextCursosExtensionH")
	private List<TblextInscripcionExtension> tblextInscripcionExtensions;

	public TblextCursosExtensionH() {
	}

	public Integer getIdCursoExtH() {
		return this.idCursoExtH;
	}

	public void setIdCursoExtH(Integer idCursoExtH) {
		this.idCursoExtH = idCursoExtH;
	}

	public String getCodSeccion() {
		return this.codSeccion;
	}

	public void setCodSeccion(String codSeccion) {
		this.codSeccion = codSeccion;
	}

	public BigDecimal getCurExtAnnio() {
		return this.curExtAnnio;
	}

	public void setCurExtAnnio(BigDecimal curExtAnnio) {
		this.curExtAnnio = curExtAnnio;
	}

	public String getCurExtSemestre() {
		return this.curExtSemestre;
	}

	public void setCurExtSemestre(String curExtSemestre) {
		this.curExtSemestre = curExtSemestre;
	}

	public Integer getDAfiliados() {
		return this.dAfiliados;
	}

	public void setDAfiliados(Integer dAfiliados) {
		this.dAfiliados = dAfiliados;
	}

	public Integer getDEgresados() {
		return this.dEgresados;
	}

	public void setDEgresados(Integer dEgresados) {
		this.dEgresados = dEgresados;
	}

	public Integer getDEstudiantes() {
		return this.dEstudiantes;
	}

	public void setDEstudiantes(Integer dEstudiantes) {
		this.dEstudiantes = dEstudiantes;
	}

	public Integer getDParticulares() {
		return this.dParticulares;
	}

	public void setDParticulares(Integer dParticulares) {
		this.dParticulares = dParticulares;
	}

	public String getDesDtoadicional() {
		return this.desDtoadicional;
	}

	public void setDesDtoadicional(String desDtoadicional) {
		this.desDtoadicional = desDtoadicional;
	}

	public String getDtoAdicional() {
		return this.dtoAdicional;
	}

	public void setDtoAdicional(String dtoAdicional) {
		this.dtoAdicional = dtoAdicional;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaInscripcion() {
		return this.fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Date getFechaLimitepago() {
		return this.fechaLimitepago;
	}

	public void setFechaLimitepago(Date fechaLimitepago) {
		this.fechaLimitepago = fechaLimitepago;
	}

	public Integer getIdsede() {
		return this.idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public BigDecimal getNumEstudiantes() {
		return this.numEstudiantes;
	}

	public void setNumEstudiantes(BigDecimal numEstudiantes) {
		this.numEstudiantes = numEstudiantes;
	}

	public BigDecimal getNumHoras() {
		return this.numHoras;
	}

	public void setNumHoras(BigDecimal numHoras) {
		this.numHoras = numHoras;
	}

	public Integer getValor() {
		return this.valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public TblacaPeriodo getTblacaPeriodo() {
		return this.tblacaPeriodo;
	}

	public void setTblacaPeriodo(TblacaPeriodo tblacaPeriodo) {
		this.tblacaPeriodo = tblacaPeriodo;
	}

	public TblextCursosExtension getTblextCursosExtension() {
		return this.tblextCursosExtension;
	}

	public void setTblextCursosExtension(TblextCursosExtension tblextCursosExtension) {
		this.tblextCursosExtension = tblextCursosExtension;
	}

	public TblextTipoCursoEdcont getTblextTipoCursoEdcont() {
		return this.tblextTipoCursoEdcont;
	}

	public void setTblextTipoCursoEdcont(TblextTipoCursoEdcont tblextTipoCursoEdcont) {
		this.tblextTipoCursoEdcont = tblextTipoCursoEdcont;
	}

	public List<TblextInscripcionExtension> getTblextInscripcionExtensions() {
		return this.tblextInscripcionExtensions;
	}

	public void setTblextInscripcionExtensions(List<TblextInscripcionExtension> tblextInscripcionExtensions) {
		this.tblextInscripcionExtensions = tblextInscripcionExtensions;
	}

	public TblextInscripcionExtension addTblextInscripcionExtension(TblextInscripcionExtension tblextInscripcionExtension) {
		getTblextInscripcionExtensions().add(tblextInscripcionExtension);
		tblextInscripcionExtension.setTblextCursosExtensionH(this);

		return tblextInscripcionExtension;
	}

	public TblextInscripcionExtension removeTblextInscripcionExtension(TblextInscripcionExtension tblextInscripcionExtension) {
		getTblextInscripcionExtensions().remove(tblextInscripcionExtension);
		tblextInscripcionExtension.setTblextCursosExtensionH(null);

		return tblextInscripcionExtension;
	}

}