package academico;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tblaca_programa database table.
 * 
 */
@Entity
@Table(name="tblaca_programa",schema="academico")
@NamedQuery(name="TblacaPrograma.findAll", query="SELECT t FROM TblacaPrograma t")
public class TblacaPrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_PROGRAMA_OID_GENERATOR",sequenceName = "ACADEMICO.TBLACA_PROGRAMA_OID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_PROGRAMA_OID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer oid;

	@Column(name="acto_admitivo", nullable=false, length=150)
	private String actoAdmitivo;

	@Column(name="ciclo_propedeut", nullable=false, length=2)
	private String cicloPropedeut;

	@Column(nullable=false)
	private Integer competencias;

	@Column(nullable=false, length=30)
	private String duracion;

	private Integer estado;

	@Column(nullable=false, length=2)
	private String idadmision;

	@Column(length=5)
	private String idclavepro;

	@Column(nullable=false, length=3)
	private String idmodalidad;

	@Column(name="metodologia_code", nullable=false, length=2)
	private String metodologiaCode;

	@Column(name="nbc_prim_area", nullable=false, precision=3)
	private java.math.BigDecimal nbcPrimArea;

	@Column(name="nbc_prim_code", nullable=false, precision=3)
	private java.math.BigDecimal nbcPrimCode;

	@Column(name="nbc_prim_especific", nullable=false, precision=3)
	private java.math.BigDecimal nbcPrimEspecific;

	@Column(name="nivel_code", nullable=false, length=2)
	private String nivelCode;

	@Column(nullable=false, length=95)
	private String nombre;

	@Column(name="num_creditos", nullable=false)
	private Integer numCreditos;

	@Column(name="num_periodos", nullable=false)
	private Integer numPeriodos;

	@Column(length=2147483647)
	private String objetivos;

	private Integer orden;

	@Column(nullable=false, length=2147483647)
	private String pensum;

	@Column(name="perfil_programa", length=2147483647)
	private String perfilPrograma;

	@Column(name="periodicidad_code", nullable=false, length=2)
	private String periodicidadCode;

	@Column(nullable=false, length=60)
	private String requisitos;

	@Column(length=50)
	private String resolucionmen;

	@Column(name="tipo_acreditacion", length=2)
	private String tipoAcreditacion;

	@Column(nullable=false, length=95)
	private String titulootorga;

	@Column(nullable=false, length=250)
	private String url;

	//bi-directional many-to-one association to TblestEstudiantePrograma
	@OneToMany(mappedBy="tblacaPrograma")
	private List<TblestEstudiantePrograma> tblestEstudianteProgramas;

	//bi-directional many-to-one association to TblacaMatriculado
	@OneToMany(mappedBy="tblacaPrograma")
	private List<TblacaMatriculado> tblacaMatriculados;

	//bi-directional many-to-one association to TblacaProgramaH
	@OneToMany(mappedBy="tblacaPrograma")
	private List<TblacaProgramaH> tblacaProgramaHs;

	public TblacaPrograma() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getActoAdmitivo() {
		return this.actoAdmitivo;
	}

	public void setActoAdmitivo(String actoAdmitivo) {
		this.actoAdmitivo = actoAdmitivo;
	}

	public String getCicloPropedeut() {
		return this.cicloPropedeut;
	}

	public void setCicloPropedeut(String cicloPropedeut) {
		this.cicloPropedeut = cicloPropedeut;
	}

	public Integer getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(Integer competencias) {
		this.competencias = competencias;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getIdadmision() {
		return this.idadmision;
	}

	public void setIdadmision(String idadmision) {
		this.idadmision = idadmision;
	}

	public String getIdclavepro() {
		return this.idclavepro;
	}

	public void setIdclavepro(String idclavepro) {
		this.idclavepro = idclavepro;
	}

	public String getIdmodalidad() {
		return this.idmodalidad;
	}

	public void setIdmodalidad(String idmodalidad) {
		this.idmodalidad = idmodalidad;
	}

	public String getMetodologiaCode() {
		return this.metodologiaCode;
	}

	public void setMetodologiaCode(String metodologiaCode) {
		this.metodologiaCode = metodologiaCode;
	}

	public java.math.BigDecimal getNbcPrimArea() {
		return this.nbcPrimArea;
	}

	public void setNbcPrimArea(java.math.BigDecimal nbcPrimArea) {
		this.nbcPrimArea = nbcPrimArea;
	}

	public java.math.BigDecimal getNbcPrimCode() {
		return this.nbcPrimCode;
	}

	public void setNbcPrimCode(java.math.BigDecimal nbcPrimCode) {
		this.nbcPrimCode = nbcPrimCode;
	}

	public java.math.BigDecimal getNbcPrimEspecific() {
		return this.nbcPrimEspecific;
	}

	public void setNbcPrimEspecific(java.math.BigDecimal nbcPrimEspecific) {
		this.nbcPrimEspecific = nbcPrimEspecific;
	}

	public String getNivelCode() {
		return this.nivelCode;
	}

	public void setNivelCode(String nivelCode) {
		this.nivelCode = nivelCode;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumCreditos() {
		return this.numCreditos;
	}

	public void setNumCreditos(Integer numCreditos) {
		this.numCreditos = numCreditos;
	}

	public Integer getNumPeriodos() {
		return this.numPeriodos;
	}

	public void setNumPeriodos(Integer numPeriodos) {
		this.numPeriodos = numPeriodos;
	}

	public String getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getPensum() {
		return this.pensum;
	}

	public void setPensum(String pensum) {
		this.pensum = pensum;
	}

	public String getPerfilPrograma() {
		return this.perfilPrograma;
	}

	public void setPerfilPrograma(String perfilPrograma) {
		this.perfilPrograma = perfilPrograma;
	}

	public String getPeriodicidadCode() {
		return this.periodicidadCode;
	}

	public void setPeriodicidadCode(String periodicidadCode) {
		this.periodicidadCode = periodicidadCode;
	}

	public String getRequisitos() {
		return this.requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getResolucionmen() {
		return this.resolucionmen;
	}

	public void setResolucionmen(String resolucionmen) {
		this.resolucionmen = resolucionmen;
	}

	public String getTipoAcreditacion() {
		return this.tipoAcreditacion;
	}

	public void setTipoAcreditacion(String tipoAcreditacion) {
		this.tipoAcreditacion = tipoAcreditacion;
	}

	public String getTitulootorga() {
		return this.titulootorga;
	}

	public void setTitulootorga(String titulootorga) {
		this.titulootorga = titulootorga;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<TblestEstudiantePrograma> getTblestEstudianteProgramas() {
		return this.tblestEstudianteProgramas;
	}

	public void setTblestEstudianteProgramas1(List<TblestEstudiantePrograma> tblestEstudianteProgramas) {
		this.tblestEstudianteProgramas = tblestEstudianteProgramas;
	}

	public TblestEstudiantePrograma addTblestEstudianteProgramas(TblestEstudiantePrograma tblestEstudianteProgramas) {
		getTblestEstudianteProgramas().add(tblestEstudianteProgramas);
		tblestEstudianteProgramas.setTblacaPrograma(this);

		return tblestEstudianteProgramas;
	}

	public TblestEstudiantePrograma removeTblestEstudianteProgramas(TblestEstudiantePrograma tblestEstudianteProgramas) {
		getTblestEstudianteProgramas().remove(tblestEstudianteProgramas);
		tblestEstudianteProgramas.setTblacaPrograma(null);

		return tblestEstudianteProgramas;
	}

	public List<TblacaMatriculado> getTblacaMatriculados() {
		return this.tblacaMatriculados;
	}

	public void setTblacaMatriculados(List<TblacaMatriculado> tblacaMatriculados) {
		this.tblacaMatriculados = tblacaMatriculados;
	}

	public TblacaMatriculado addTblacaMatriculado(TblacaMatriculado tblacaMatriculado) {
		getTblacaMatriculados().add(tblacaMatriculado);
		tblacaMatriculado.setTblacaPrograma(this);

		return tblacaMatriculado;
	}

	public TblacaMatriculado removeTblacaMatriculado(TblacaMatriculado tblacaMatriculado) {
		getTblacaMatriculados().remove(tblacaMatriculado);
		tblacaMatriculado.setTblacaPrograma(null);

		return tblacaMatriculado;
	}

	public List<TblacaProgramaH> getTblacaProgramaHs() {
		return this.tblacaProgramaHs;
	}

	public void setTblacaProgramaHs(List<TblacaProgramaH> tblacaProgramaHs) {
		this.tblacaProgramaHs = tblacaProgramaHs;
	}

	public TblacaProgramaH addTblacaProgramaH(TblacaProgramaH tblacaProgramaH) {
		getTblacaProgramaHs().add(tblacaProgramaH);
		tblacaProgramaH.setTblacaPrograma(this);

		return tblacaProgramaH;
	}

	public TblacaProgramaH removeTblacaProgramaH(TblacaProgramaH tblacaProgramaH) {
		getTblacaProgramaHs().remove(tblacaProgramaH);
		tblacaProgramaH.setTblacaPrograma(null);

		return tblacaProgramaH;
	}

}