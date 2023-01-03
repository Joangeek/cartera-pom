package academico;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tblest_estudiante_programa database table.
 * 
 */
@Entity
@Table(name="tblest_estudiante_programa", schema = "academico")
@NamedQuery(name="TblestEstudiantePrograma.findAll", query="SELECT t FROM TblestEstudiantePrograma t")
public class TblestEstudiantePrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEST_ESTUDIANTE_PROGRAMA_IDEP_GENERATOR", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEST_ESTUDIANTE_PROGRAMA_IDEP_GENERATOR")
	@Column(name="id_ep", unique=true, nullable=false)
	private Integer idEp;

	@Column(length=200)
	private String acta;

	@Column(nullable=false)
	private Integer anio;

	@Column(name="codigo_unico", nullable=false, length=30)
	private String codigoUnico;

	@Column(length=2)
	private String departamento;

	@Column(name="ecaes_observaciones", length=250)
	private String ecaesObservaciones;

	@Column(name="ecaes_resultados", length=13)
	private String ecaesResultados;

	@Column(name="es_transferencia", nullable=false, length=2)
	private String esTransferencia;

	@Column(nullable=false)
	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_grado")
	private Date fechaGrado;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechaingreso;

	@Column(length=200)
	private String folio;

	@Column(name="grad_annio")
	private Integer gradAnnio;

	@Column(name="grad_semestre", length=2)
	private String gradSemestre;

	@Column(name="id_tipo_vinculacion")
	private Integer idTipoVinculacion;

	private Integer idinscrito;

	@Column(name="ies_code", nullable=false, length=10)
	private String iesCode;

	@Column(name="ins_annio")
	private Integer insAnnio;

	@Column(name="ins_semestre", length=2)
	private String insSemestre;

	@Column(length=5)
	private String municipio;

	@Column(name="primercurso_observaciones", length=500)
	private String primercursoObservaciones;

	@Column(name="pro_consecutivo", nullable=false)
	private Integer proConsecutivo;

	@Column(nullable=false, length=2)
	private String semestre;

	@Column(length=100)
	private String snp;

	@Column(name="tipo_doc_unico", nullable=false, length=3)
	private String tipoDocUnico;

	private Integer traslado;

	//bi-directional many-to-one association to TblacaPlanestudio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idplan", nullable=false)
	private TblacaPlanestudio tblacaPlanestudio;

	//bi-directional many-to-one association to TblacaPrograma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idprograma", nullable=false)
	private TblacaPrograma tblacaPrograma;
	
	//bi-directional many-to-one association to TblacaSede
	@ManyToOne
	@JoinColumn(name="idsede")
	private TblacaSede tblacaSede;

	//bi-directional many-to-one association to TblacaMatriculado
	@OneToMany(mappedBy="tblestEstudiantePrograma")
	private List<TblacaMatriculado> tblaca_matriculado; 

	//bi-directional many-to-one association to TblestEstudiante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idestudiante", nullable=false)
	private TblestEstudiante tblestEstudiante;

	public List<TblacaMatriculado> getTblaca_matriculado() {
		return tblaca_matriculado;
	}

	public void setTblaca_matriculado(List<TblacaMatriculado> tblaca_matriculado) {
		this.tblaca_matriculado = tblaca_matriculado;
	}

	public TblestEstudiante getTblestEstudiante() {
		return tblestEstudiante;
	}

	public void setTblestEstudiante(TblestEstudiante tblestEstudiante) {
		this.tblestEstudiante = tblestEstudiante;
	}

	public TblacaPrograma getTblacaPrograma() {
		return tblacaPrograma;
	}

	public TblestEstudiantePrograma() {
	}

	public Integer getIdEp() {
		return this.idEp;
	}

	public void setIdEp(Integer idEp) {
		this.idEp = idEp;
	}

	public String getActa() {
		return this.acta;
	}

	public void setActa(String acta) {
		this.acta = acta;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getCodigoUnico() {
		return this.codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEcaesObservaciones() {
		return this.ecaesObservaciones;
	}

	public void setEcaesObservaciones(String ecaesObservaciones) {
		this.ecaesObservaciones = ecaesObservaciones;
	}

	public String getEcaesResultados() {
		return this.ecaesResultados;
	}

	public void setEcaesResultados(String ecaesResultados) {
		this.ecaesResultados = ecaesResultados;
	}

	public String getEsTransferencia() {
		return this.esTransferencia;
	}

	public void setEsTransferencia(String esTransferencia) {
		this.esTransferencia = esTransferencia;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaGrado() {
		return this.fechaGrado;
	}

	public void setFechaGrado(Date fechaGrado) {
		this.fechaGrado = fechaGrado;
	}

	public Date getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Integer getGradAnnio() {
		return this.gradAnnio;
	}

	public void setGradAnnio(Integer gradAnnio) {
		this.gradAnnio = gradAnnio;
	}

	public String getGradSemestre() {
		return this.gradSemestre;
	}

	public void setGradSemestre(String gradSemestre) {
		this.gradSemestre = gradSemestre;
	}

	public Integer getIdTipoVinculacion() {
		return this.idTipoVinculacion;
	}

	public void setIdTipoVinculacion(Integer idTipoVinculacion) {
		this.idTipoVinculacion = idTipoVinculacion;
	}

	public Integer getIdinscrito() {
		return this.idinscrito;
	}

	public void setIdinscrito(Integer idinscrito) {
		this.idinscrito = idinscrito;
	}
	
	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public Integer getInsAnnio() {
		return this.insAnnio;
	}

	public void setInsAnnio(Integer insAnnio) {
		this.insAnnio = insAnnio;
	}

	public String getInsSemestre() {
		return this.insSemestre;
	}

	public void setInsSemestre(String insSemestre) {
		this.insSemestre = insSemestre;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getPrimercursoObservaciones() {
		return this.primercursoObservaciones;
	}

	public void setPrimercursoObservaciones(String primercursoObservaciones) {
		this.primercursoObservaciones = primercursoObservaciones;
	}

	public Integer getProConsecutivo() {
		return this.proConsecutivo;
	}

	public void setProConsecutivo(Integer proConsecutivo) {
		this.proConsecutivo = proConsecutivo;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getSnp() {
		return this.snp;
	}

	public void setSnp(String snp) {
		this.snp = snp;
	}

	public String getTipoDocUnico() {
		return this.tipoDocUnico;
	}

	public void setTipoDocUnico(String tipoDocUnico) {
		this.tipoDocUnico = tipoDocUnico;
	}

	public Integer getTraslado() {
		return this.traslado;
	}

	public void setTraslado(Integer traslado) {
		this.traslado = traslado;
	}

	public TblacaPlanestudio getTblacaPlanestudio() {
		return this.tblacaPlanestudio;
	}

	public void setTblacaPlanestudio(TblacaPlanestudio tblacaPlanestudio) {
		this.tblacaPlanestudio = tblacaPlanestudio;
	}

	public void setTblacaPrograma(TblacaPrograma tblacaPrograma) {
		this.tblacaPrograma = tblacaPrograma;
	}
	public TblacaSede getTblacaSede() {
		return this.tblacaSede;
	}

	public void setTblacaSede(TblacaSede tblacaSede) {
		this.tblacaSede = tblacaSede;
	}
}