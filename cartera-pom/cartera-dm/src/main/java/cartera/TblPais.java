package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblestEstudiante;

import java.util.List;


/**
 * The persistent class for the tbl_paises database table.
 * 
 */
@Entity
@Table(name="tbl_paises", schema="academico")
@NamedQuery(name="TblPais.findAll", query="SELECT t FROM TblPais t")
public class TblPais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_PAISES_PAISCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_PAISES_PAISCODE_GENERATOR")
	@Column(name="pais_code", unique=true, nullable=false, length=5)
	private String paisCode;

	@Column(nullable=false)
	private Integer idpais;

	@Column(nullable=false)
	private Integer orden;

	@Column(name="pais_descr", nullable=false, length=50)
	private String paisDescr;

	//bi-directional many-to-one association to TblDepartamento
	@OneToMany(mappedBy="tblPais")
	private List<TblDepartamento> tblDepartamentos;

	//bi-directional many-to-one association to TblestEstudiante
	@OneToMany(mappedBy="tblPais")
	private List<TblestEstudiante> tblestEstudiantes;

	public TblPais() {
	}

	public String getPaisCode() {
		return this.paisCode;
	}

	public void setPaisCode(String paisCode) {
		this.paisCode = paisCode;
	}

	public Integer getIdpais() {
		return this.idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getPaisDescr() {
		return this.paisDescr;
	}

	public void setPaisDescr(String paisDescr) {
		this.paisDescr = paisDescr;
	}

	public List<TblDepartamento> getTblDepartamentos() {
		return this.tblDepartamentos;
	}

	public void setTblDepartamentos(List<TblDepartamento> tblDepartamentos) {
		this.tblDepartamentos = tblDepartamentos;
	}

	public TblDepartamento addTblDepartamento(TblDepartamento tblDepartamento) {
		getTblDepartamentos().add(tblDepartamento);
		tblDepartamento.setTblPais(this);

		return tblDepartamento;
	}

	public TblDepartamento removeTblDepartamento(TblDepartamento tblDepartamento) {
		getTblDepartamentos().remove(tblDepartamento);
		tblDepartamento.setTblPais(null);

		return tblDepartamento;
	}

	public List<TblestEstudiante> getTblestEstudiantes() {
		return this.tblestEstudiantes;
	}

	public void setTblestEstudiantes(List<TblestEstudiante> tblestEstudiantes) {
		this.tblestEstudiantes = tblestEstudiantes;
	}

	public TblestEstudiante addTblestEstudiante(TblestEstudiante tblestEstudiante) {
		getTblestEstudiantes().add(tblestEstudiante);
		tblestEstudiante.setTblPais(this);

		return tblestEstudiante;
	}

	public TblestEstudiante removeTblestEstudiante(TblestEstudiante tblestEstudiante) {
		getTblestEstudiantes().remove(tblestEstudiante);
		tblestEstudiante.setTblPais(null);

		return tblestEstudiante;
	}

}