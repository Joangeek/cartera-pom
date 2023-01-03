package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblacaJornada;
import academico.TblacaPeriodo;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tblmer_admitido database table.
 * 
 */
@Entity
@Table(name="tblmer_admitido", schema="academico")
@NamedQuery(name="TblmerAdmitido.findAll", query="SELECT t FROM TblmerAdmitido t")
public class TblmerAdmitido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLMER_ADMITIDO_IDADMITIDO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLMER_ADMITIDO_IDADMITIDO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idadmitido;

	@Column(name="adm_annio", nullable=false, precision=4)
	private BigDecimal admAnnio;

	@Column(name="adm_semestre", nullable=false, length=2)
	private String admSemestre;

	@Column(name="codigo_ent_aula", nullable=false, length=100)
	private String codigoEntAula;

	@Column(nullable=false, length=3)
	private String departamento;

	@Column(nullable=false, length=30)
	private String documento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_snp")
	private Date fechaSnp;

	@Column(nullable=false, length=2)
	private String genero;

	private Integer idinscrito;

	@Column(name="idsede_programa")
	private Integer idsedePrograma;

	@Column(name="ies_code", nullable=false, length=10)
	private String iesCode;

	@Column(name="primer_apellido", nullable=false, length=100)
	private String primerApellido;

	@Column(name="primer_nombre", nullable=false, length=100)
	private String primerNombre;

	@Column(name="pro_consecutivo", nullable=false, precision=10)
	private BigDecimal proConsecutivo;

	@Column(name="segundo_apellido", length=100)
	private String segundoApellido;

	@Column(name="segundo_nombre", length=100)
	private String segundoNombre;

	@Column(nullable=false, length=30)
	private String snp;

	@Column(name="tipo_identif", nullable=false, length=3)
	private String tipoIdentif;

	@Column(nullable=false, length=2147483647)
	private String usuario;

	//bi-directional many-to-one association to TblMunicipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="municipio", nullable=false)
	private TblMunicipio tblMunicipio;

	//bi-directional many-to-one association to TblacaJornada
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idjornada")
	private TblacaJornada tblacaJornada;

	//bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idperiodo")
	private TblacaPeriodo tblacaPeriodo;

	public TblmerAdmitido() {
	}

	public Integer getIdadmitido() {
		return this.idadmitido;
	}

	public void setIdadmitido(Integer idadmitido) {
		this.idadmitido = idadmitido;
	}

	public BigDecimal getAdmAnnio() {
		return this.admAnnio;
	}

	public void setAdmAnnio(BigDecimal admAnnio) {
		this.admAnnio = admAnnio;
	}

	public String getAdmSemestre() {
		return this.admSemestre;
	}

	public void setAdmSemestre(String admSemestre) {
		this.admSemestre = admSemestre;
	}

	public String getCodigoEntAula() {
		return this.codigoEntAula;
	}

	public void setCodigoEntAula(String codigoEntAula) {
		this.codigoEntAula = codigoEntAula;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaSnp() {
		return this.fechaSnp;
	}

	public void setFechaSnp(Date fechaSnp) {
		this.fechaSnp = fechaSnp;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getIdinscrito() {
		return this.idinscrito;
	}

	public void setIdinscrito(Integer idinscrito) {
		this.idinscrito = idinscrito;
	}

	public Integer getIdsedePrograma() {
		return this.idsedePrograma;
	}

	public void setIdsedePrograma(Integer idsedePrograma) {
		this.idsedePrograma = idsedePrograma;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public BigDecimal getProConsecutivo() {
		return this.proConsecutivo;
	}

	public void setProConsecutivo(BigDecimal proConsecutivo) {
		this.proConsecutivo = proConsecutivo;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getSnp() {
		return this.snp;
	}

	public void setSnp(String snp) {
		this.snp = snp;
	}

	public String getTipoIdentif() {
		return this.tipoIdentif;
	}

	public void setTipoIdentif(String tipoIdentif) {
		this.tipoIdentif = tipoIdentif;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TblMunicipio getTblMunicipio() {
		return this.tblMunicipio;
	}

	public void setTblMunicipio(TblMunicipio tblMunicipio) {
		this.tblMunicipio = tblMunicipio;
	}

	public TblacaJornada getTblacaJornada() {
		return this.tblacaJornada;
	}

	public void setTblacaJornada(TblacaJornada tblacaJornada) {
		this.tblacaJornada = tblacaJornada;
	}

	public TblacaPeriodo getTblacaPeriodo() {
		return this.tblacaPeriodo;
	}

	public void setTblacaPeriodo(TblacaPeriodo tblacaPeriodo) {
		this.tblacaPeriodo = tblacaPeriodo;
	}

}