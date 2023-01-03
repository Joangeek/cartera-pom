package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblestEstudiante;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tbl_municipios database table.
 * 
 */
@Entity
@Table(name="tbl_municipios",schema="academico")
@NamedQuery(name="TblMunicipio.findAll", query="SELECT t FROM TblMunicipio t")
public class TblMunicipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_MUNICIPIOS_MUNICCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_MUNICIPIOS_MUNICCODE_GENERATOR")
	@Column(name="munic_code", unique=true, nullable=false, length=5)
	private String municCode;

	@Column(name="munic_descr", nullable=false, length=50)
	private String municDescr;

	@Column(precision=131089)
	private BigDecimal orden;

	//bi-directional many-to-one association to TblDepartamento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="depa_code", nullable=false)
	private TblDepartamento tblDepartamento;

	//bi-directional many-to-one association to TblestEstudiante
	@OneToMany(mappedBy="tblMunicipio")
	private List<TblestEstudiante> tblestEstudiantes;

	//bi-directional many-to-one association to TblmerAdmitido
	@OneToMany(mappedBy="tblMunicipio")
	private List<TblmerAdmitido> tblmerAdmitidos;

	public TblMunicipio() {
	}

	public String getMunicCode() {
		return this.municCode;
	}

	public void setMunicCode(String municCode) {
		this.municCode = municCode;
	}

	public String getMunicDescr() {
		return this.municDescr;
	}

	public void setMunicDescr(String municDescr) {
		this.municDescr = municDescr;
	}

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public TblDepartamento getTblDepartamento() {
		return this.tblDepartamento;
	}

	public void setTblDepartamento(TblDepartamento tblDepartamento) {
		this.tblDepartamento = tblDepartamento;
	}

	public List<TblestEstudiante> getTblestEstudiantes() {
		return this.tblestEstudiantes;
	}

	public void setTblestEstudiantes(List<TblestEstudiante> tblestEstudiantes) {
		this.tblestEstudiantes = tblestEstudiantes;
	}

	public TblestEstudiante addTblestEstudiante(TblestEstudiante tblestEstudiante) {
		getTblestEstudiantes().add(tblestEstudiante);
		tblestEstudiante.setTblMunicipio(this);

		return tblestEstudiante;
	}

	public TblestEstudiante removeTblestEstudiante(TblestEstudiante tblestEstudiante) {
		getTblestEstudiantes().remove(tblestEstudiante);
		tblestEstudiante.setTblMunicipio(null);

		return tblestEstudiante;
	}

	public List<TblmerAdmitido> getTblmerAdmitidos() {
		return this.tblmerAdmitidos;
	}

	public void setTblmerAdmitidos(List<TblmerAdmitido> tblmerAdmitidos) {
		this.tblmerAdmitidos = tblmerAdmitidos;
	}

	public TblmerAdmitido addTblmerAdmitido(TblmerAdmitido tblmerAdmitido) {
		getTblmerAdmitidos().add(tblmerAdmitido);
		tblmerAdmitido.setTblMunicipio(this);

		return tblmerAdmitido;
	}

	public TblmerAdmitido removeTblmerAdmitido(TblmerAdmitido tblmerAdmitido) {
		getTblmerAdmitidos().remove(tblmerAdmitido);
		tblmerAdmitido.setTblMunicipio(null);

		return tblmerAdmitido;
	}

}