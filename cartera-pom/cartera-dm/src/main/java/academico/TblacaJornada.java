package academico;

import java.io.Serializable;

import javax.persistence.*;

import cartera.TblmerAdmitido;

import java.util.List;


/**
 * The persistent class for the tblaca_jornada database table.
 * 
 */
@Entity
@Table(name="tblaca_jornada",schema="academico")
@NamedQuery(name="TblacaJornada.findAll", query="SELECT t FROM TblacaJornada t")
public class TblacaJornada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_JORNADA_OID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_JORNADA_OID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer oid;

	private Integer capacidad;

	@Column(nullable=false, length=20)
	private String descripcion;

	@Column(nullable=false, length=1)
	private String sigla;

	//bi-directional many-to-one association to TblacaAutorizacionPrograma
	@OneToMany(mappedBy="tblacaJornada")
	private List<TblacaAutorizacionPrograma> tblacaAutorizacionProgramas;

	//bi-directional many-to-one association to TblacaMatriculado
	@OneToMany(mappedBy="tblacaJornada")
	private List<TblacaMatriculado> tblacaMatriculados;

	//bi-directional many-to-one association to TblmerAdmitido
	@OneToMany(mappedBy="tblacaJornada")
	private List<TblmerAdmitido> tblmerAdmitidos;

	public TblacaJornada() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<TblacaAutorizacionPrograma> getTblacaAutorizacionProgramas() {
		return this.tblacaAutorizacionProgramas;
	}

	public void setTblacaAutorizacionProgramas(List<TblacaAutorizacionPrograma> tblacaAutorizacionProgramas) {
		this.tblacaAutorizacionProgramas = tblacaAutorizacionProgramas;
	}

	public TblacaAutorizacionPrograma addTblacaAutorizacionPrograma(TblacaAutorizacionPrograma tblacaAutorizacionPrograma) {
		getTblacaAutorizacionProgramas().add(tblacaAutorizacionPrograma);
		tblacaAutorizacionPrograma.setTblacaJornada(this);

		return tblacaAutorizacionPrograma;
	}

	public TblacaAutorizacionPrograma removeTblacaAutorizacionPrograma(TblacaAutorizacionPrograma tblacaAutorizacionPrograma) {
		getTblacaAutorizacionProgramas().remove(tblacaAutorizacionPrograma);
		tblacaAutorizacionPrograma.setTblacaJornada(null);

		return tblacaAutorizacionPrograma;
	}

	public List<TblacaMatriculado> getTblacaMatriculados() {
		return this.tblacaMatriculados;
	}

	public void setTblacaMatriculados(List<TblacaMatriculado> tblacaMatriculados) {
		this.tblacaMatriculados = tblacaMatriculados;
	}

	public TblacaMatriculado addTblacaMatriculado(TblacaMatriculado tblacaMatriculado) {
		getTblacaMatriculados().add(tblacaMatriculado);
		tblacaMatriculado.setTblacaJornada(this);

		return tblacaMatriculado;
	}

	public TblacaMatriculado removeTblacaMatriculado(TblacaMatriculado tblacaMatriculado) {
		getTblacaMatriculados().remove(tblacaMatriculado);
		tblacaMatriculado.setTblacaJornada(null);

		return tblacaMatriculado;
	}

	public List<TblmerAdmitido> getTblmerAdmitidos() {
		return this.tblmerAdmitidos;
	}

	public void setTblmerAdmitidos(List<TblmerAdmitido> tblmerAdmitidos) {
		this.tblmerAdmitidos = tblmerAdmitidos;
	}

	public TblmerAdmitido addTblmerAdmitido(TblmerAdmitido tblmerAdmitido) {
		getTblmerAdmitidos().add(tblmerAdmitido);
		tblmerAdmitido.setTblacaJornada(this);

		return tblmerAdmitido;
	}

	public TblmerAdmitido removeTblmerAdmitido(TblmerAdmitido tblmerAdmitido) {
		getTblmerAdmitidos().remove(tblmerAdmitido);
		tblmerAdmitido.setTblacaJornada(null);

		return tblmerAdmitido;
	}

}