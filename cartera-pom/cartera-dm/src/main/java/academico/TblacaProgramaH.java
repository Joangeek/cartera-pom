package academico;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the tblaca_programa_h database table.
 * 
 */
@Entity
@Table(name="tblaca_programa_h", schema="academico")
@NamedQuery(name="TblacaProgramaH.findAll", query="SELECT t FROM TblacaProgramaH t")
public class TblacaProgramaH implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_PROGRAMA_H_IDPROGRAMAH_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_PROGRAMA_H_IDPROGRAMAH_GENERATOR")
	@Column(name="idprograma_h", unique=true, nullable=false)
	private Integer idprogramaH;

	@Column(nullable=false)
	private Integer annio;

	@Column(name="cod_entidad_aula", nullable=false, length=10)
	private String codEntidadAula;

	@Column(nullable=false, length=50)
	private String codsnies;

	@Column(name="depto_code", nullable=false, length=3)
	private String deptoCode;

	@Column(nullable=false)
	private Integer idsede;

	@Column(name="ies_code", nullable=false, length=10)
	private String iesCode;

	@Column(name="matric_alum_antig", nullable=false, precision=15)
	private BigDecimal matricAlumAntig;

	@Column(name="matric_alum_nuev", nullable=false, precision=15)
	private BigDecimal matricAlumNuev;

	@Column(name="matric_ext_est_antig", nullable=false, precision=15)
	private BigDecimal matricExtEstAntig;

	@Column(name="matric_ext_est_nuev", nullable=false, precision=15)
	private BigDecimal matricExtEstNuev;

	@Column(name="metodologia_code", nullable=false, length=2)
	private String metodologiaCode;

	@Column(name="mun_code", nullable=false, length=5)
	private String munCode;

	@Column(nullable=false)
	private Integer ncreditos;

	private Integer ninscritos;

	@Column(name="proy_est_antiguos", nullable=false, precision=15)
	private BigDecimal proyEstAntiguos;

	@Column(name="proy_est_nuev", nullable=false, precision=15)
	private BigDecimal proyEstNuev;

	@Column(nullable=false)
	private Integer seguro;

	@Column(nullable=false, length=2)
	private String semestre;

	@Column(name="tipo_cubrimiento", nullable=false, length=2)
	private String tipoCubrimiento;

	@Column(nullable=false, precision=10)
	private BigDecimal vrcredito;

	//bi-directional many-to-one association to TblacaPrograma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idprograma", nullable=false)
	private TblacaPrograma tblacaPrograma;

	public TblacaProgramaH() {
	}

	public Integer getIdprogramaH() {
		return this.idprogramaH;
	}

	public void setIdprogramaH(Integer idprogramaH) {
		this.idprogramaH = idprogramaH;
	}

	public Integer getAnnio() {
		return this.annio;
	}

	public void setAnnio(Integer annio) {
		this.annio = annio;
	}

	public String getCodEntidadAula() {
		return this.codEntidadAula;
	}

	public void setCodEntidadAula(String codEntidadAula) {
		this.codEntidadAula = codEntidadAula;
	}

	public String getCodsnies() {
		return this.codsnies;
	}

	public void setCodsnies(String codsnies) {
		this.codsnies = codsnies;
	}

	public String getDeptoCode() {
		return this.deptoCode;
	}

	public void setDeptoCode(String deptoCode) {
		this.deptoCode = deptoCode;
	}

	public Integer getIdsede() {
		return this.idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public BigDecimal getMatricAlumAntig() {
		return this.matricAlumAntig;
	}

	public void setMatricAlumAntig(BigDecimal matricAlumAntig) {
		this.matricAlumAntig = matricAlumAntig;
	}

	public BigDecimal getMatricAlumNuev() {
		return this.matricAlumNuev;
	}

	public void setMatricAlumNuev(BigDecimal matricAlumNuev) {
		this.matricAlumNuev = matricAlumNuev;
	}

	public BigDecimal getMatricExtEstAntig() {
		return this.matricExtEstAntig;
	}

	public void setMatricExtEstAntig(BigDecimal matricExtEstAntig) {
		this.matricExtEstAntig = matricExtEstAntig;
	}

	public BigDecimal getMatricExtEstNuev() {
		return this.matricExtEstNuev;
	}

	public void setMatricExtEstNuev(BigDecimal matricExtEstNuev) {
		this.matricExtEstNuev = matricExtEstNuev;
	}

	public String getMetodologiaCode() {
		return this.metodologiaCode;
	}

	public void setMetodologiaCode(String metodologiaCode) {
		this.metodologiaCode = metodologiaCode;
	}

	public String getMunCode() {
		return this.munCode;
	}

	public void setMunCode(String munCode) {
		this.munCode = munCode;
	}

	public Integer getNcreditos() {
		return this.ncreditos;
	}

	public void setNcreditos(Integer ncreditos) {
		this.ncreditos = ncreditos;
	}

	public Integer getNinscritos() {
		return this.ninscritos;
	}

	public void setNinscritos(Integer ninscritos) {
		this.ninscritos = ninscritos;
	}

	public BigDecimal getProyEstAntiguos() {
		return this.proyEstAntiguos;
	}

	public void setProyEstAntiguos(BigDecimal proyEstAntiguos) {
		this.proyEstAntiguos = proyEstAntiguos;
	}

	public BigDecimal getProyEstNuev() {
		return this.proyEstNuev;
	}

	public void setProyEstNuev(BigDecimal proyEstNuev) {
		this.proyEstNuev = proyEstNuev;
	}

	public Integer getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Integer seguro) {
		this.seguro = seguro;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTipoCubrimiento() {
		return this.tipoCubrimiento;
	}

	public void setTipoCubrimiento(String tipoCubrimiento) {
		this.tipoCubrimiento = tipoCubrimiento;
	}

	public BigDecimal getVrcredito() {
		return this.vrcredito;
	}

	public void setVrcredito(BigDecimal vrcredito) {
		this.vrcredito = vrcredito;
	}

	public TblacaPrograma getTblacaPrograma() {
		return this.tblacaPrograma;
	}

	public void setTblacaPrograma(TblacaPrograma tblacaPrograma) {
		this.tblacaPrograma = tblacaPrograma;
	}

}