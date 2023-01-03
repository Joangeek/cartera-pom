package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblestEstudiante;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tbl_departamentos database table.
 * 
 */
@Entity
@Table(name="tbl_departamentos", schema="academico")
@NamedQuery(name="TblDepartamento.findAll", query="SELECT t FROM TblDepartamento t")
public class TblDepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_DEPARTAMENTOS_DEPTOCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_DEPARTAMENTOS_DEPTOCODE_GENERATOR")
	@Column(name="depto_code", unique=true, nullable=false, length=3)
	private String deptoCode;

	@Column(name="depto_descr", length=50)
	private String deptoDescr;

	@Column(precision=131089)
	private BigDecimal orden;

	//bi-directional many-to-one association to TblPais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pais_code")
	private TblPais tblPais;

	//bi-directional many-to-one association to TblMunicipio
	@OneToMany(mappedBy="tblDepartamento")
	private List<TblMunicipio> tblMunicipios;

	//bi-directional many-to-one association to TblestEstudiante
	@OneToMany(mappedBy="tblDepartamento")
	private List<TblestEstudiante> tblestEstudiantes;

	public TblDepartamento() {
	}

	public String getDeptoCode() {
		return this.deptoCode;
	}

	public void setDeptoCode(String deptoCode) {
		this.deptoCode = deptoCode;
	}

	public String getDeptoDescr() {
		return this.deptoDescr;
	}

	public void setDeptoDescr(String deptoDescr) {
		this.deptoDescr = deptoDescr;
	}

	public BigDecimal getOrden() {
		return this.orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public TblPais getTblPais() {
		return this.tblPais;
	}

	public void setTblPais(TblPais tblPais) {
		this.tblPais = tblPais;
	}

	public List<TblMunicipio> getTblMunicipios() {
		return this.tblMunicipios;
	}

	public void setTblMunicipios(List<TblMunicipio> tblMunicipios) {
		this.tblMunicipios = tblMunicipios;
	}

	public TblMunicipio addTblMunicipio(TblMunicipio tblMunicipio) {
		getTblMunicipios().add(tblMunicipio);
		tblMunicipio.setTblDepartamento(this);

		return tblMunicipio;
	}

	public TblMunicipio removeTblMunicipio(TblMunicipio tblMunicipio) {
		getTblMunicipios().remove(tblMunicipio);
		tblMunicipio.setTblDepartamento(null);

		return tblMunicipio;
	}

	public List<TblestEstudiante> getTblestEstudiantes() {
		return this.tblestEstudiantes;
	}

	public void setTblestEstudiantes(List<TblestEstudiante> tblestEstudiantes) {
		this.tblestEstudiantes = tblestEstudiantes;
	}

	public TblestEstudiante addTblestEstudiante(TblestEstudiante tblestEstudiante) {
		getTblestEstudiantes().add(tblestEstudiante);
		tblestEstudiante.setTblDepartamento(this);

		return tblestEstudiante;
	}

	public TblestEstudiante removeTblestEstudiante(TblestEstudiante tblestEstudiante) {
		getTblestEstudiantes().remove(tblestEstudiante);
		tblestEstudiante.setTblDepartamento(null);

		return tblestEstudiante;
	}

}