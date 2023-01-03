package academico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the tblaca_sede_programa database table.
 * 
 */
@Entity
@Table(name = "tblaca_sede_programa", schema = "academico")
@NamedQuery(name = "TblacaSedePrograma.findAll", query = "SELECT t FROM TblacaSedePrograma t")
public class TblacaSedePrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TBLACA_SEDE_PROGRAMA_OID_GENERATOR", sequenceName = "ACADEMICO.TBLACA_SEDE_PROGRAMA_OID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBLACA_SEDE_PROGRAMA_OID_GENERATOR")
	private Integer oid;

	@Column(name = "cod_entidad_aula")
	private String codEntidadAula;

	private String codsnies;

	@Column(name = "depto_code")
	private String deptoCode;

	@Column(name = "estado_prog_code")
	private String estadoProgCode;

	@Column(name = "ies_code")
	private String iesCode;

	@Column(name = "metodologia_code")
	private String metodologiaCode;

	@Column(name = "mun_code")
	private String munCode;

	@Column(name = "prog_code")
	private String progCode;

	@Column(name = "revision_code")
	private String revisionCode;

	@Column(name = "tipo_cubrimiento")
	private String tipoCubrimiento;
	
	
	private Integer estado;

	// bi-directional many-to-one association to TblacaPrograma
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprograma")
	private TblacaPrograma tblacaPrograma;

	// bi-directional many-to-one association to TblacaSede
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsede")
	private TblacaSede tblacaSede;

	
	public TblacaSedePrograma() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
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

	public String getEstadoProgCode() {
		return this.estadoProgCode;
	}

	public void setEstadoProgCode(String estadoProgCode) {
		this.estadoProgCode = estadoProgCode;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
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

	public String getProgCode() {
		return this.progCode;
	}

	public void setProgCode(String progCode) {
		this.progCode = progCode;
	}

	public String getRevisionCode() {
		return this.revisionCode;
	}

	public void setRevisionCode(String revisionCode) {
		this.revisionCode = revisionCode;
	}

	public String getTipoCubrimiento() {
		return this.tipoCubrimiento;
	}

	public void setTipoCubrimiento(String tipoCubrimiento) {
		this.tipoCubrimiento = tipoCubrimiento;
	}

	public TblacaPrograma getTblacaPrograma() {
		return this.tblacaPrograma;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	
}