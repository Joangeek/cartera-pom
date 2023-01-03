package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblestEstudianteH;

import java.util.List;


/**
 * The persistent class for the tblfin_estado_financiacion database table.
 * 
 */
@Entity
@Table(name="tblfin_estado_financiacion", schema="academico")
@NamedQuery(name="TblfinEstadoFinanciacion.findAll", query="SELECT t FROM TblfinEstadoFinanciacion t")
public class TblfinEstadoFinanciacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_ESTADO_FINANCIACION_IDESTADOFINANCIERO_GENERATOR",sequenceName = "academico.tblfin_estado_financiacion_oid_seq", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_ESTADO_FINANCIACION_IDESTADOFINANCIERO_GENERATOR")
	@Column(name="idestado_financiero", unique=true, nullable=false)
	private Integer idestadoFinanciero;

	@Column(length=2147483647)
	private String descripcion;

	private Integer estado;

	@Column(nullable=false, length=500)
	private String nombre;

	//bi-directional many-to-one association to TblestEstudianteH
	@OneToMany(mappedBy="tblfinEstadoFinanciacion")
	private List<TblestEstudianteH> tblestEstudianteHs;

	//bi-directional many-to-one association to TblfinCreditoMatricula
	@OneToMany(mappedBy="tblfinEstadoFinanciacion")
	private List<TblfinCreditoMatricula> tblfinCreditoMatriculas;

	//bi-directional many-to-one association to TblfinCreditoMatriculaExt
	@OneToMany(mappedBy="tblfinEstadoFinanciacion")
	private List<TblfinCreditoMatriculaExt> tblfinCreditoMatriculaExts;

	public TblfinEstadoFinanciacion() {
	}

	public Integer getIdestadoFinanciero() {
		return this.idestadoFinanciero;
	}

	public void setIdestadoFinanciero(Integer idestadoFinanciero) {
		this.idestadoFinanciero = idestadoFinanciero;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TblestEstudianteH> getTblestEstudianteHs() {
		return this.tblestEstudianteHs;
	}

	public void setTblestEstudianteHs(List<TblestEstudianteH> tblestEstudianteHs) {
		this.tblestEstudianteHs = tblestEstudianteHs;
	}

	public TblestEstudianteH addTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().add(tblestEstudianteH);
		tblestEstudianteH.setTblfinEstadoFinanciacion(this);

		return tblestEstudianteH;
	}

	public TblestEstudianteH removeTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().remove(tblestEstudianteH);
		tblestEstudianteH.setTblfinEstadoFinanciacion(null);

		return tblestEstudianteH;
	}

	public List<TblfinCreditoMatricula> getTblfinCreditoMatriculas() {
		return this.tblfinCreditoMatriculas;
	}

	public void setTblfinCreditoMatriculas(List<TblfinCreditoMatricula> tblfinCreditoMatriculas) {
		this.tblfinCreditoMatriculas = tblfinCreditoMatriculas;
	}

	public TblfinCreditoMatricula addTblfinCreditoMatricula(TblfinCreditoMatricula tblfinCreditoMatricula) {
		getTblfinCreditoMatriculas().add(tblfinCreditoMatricula);
		tblfinCreditoMatricula.setTblfinEstadoFinanciacion(this);

		return tblfinCreditoMatricula;
	}

	public TblfinCreditoMatricula removeTblfinCreditoMatricula(TblfinCreditoMatricula tblfinCreditoMatricula) {
		getTblfinCreditoMatriculas().remove(tblfinCreditoMatricula);
		tblfinCreditoMatricula.setTblfinEstadoFinanciacion(null);

		return tblfinCreditoMatricula;
	}

	public List<TblfinCreditoMatriculaExt> getTblfinCreditoMatriculaExts() {
		return this.tblfinCreditoMatriculaExts;
	}

	public void setTblfinCreditoMatriculaExts(List<TblfinCreditoMatriculaExt> tblfinCreditoMatriculaExts) {
		this.tblfinCreditoMatriculaExts = tblfinCreditoMatriculaExts;
	}

	public TblfinCreditoMatriculaExt addTblfinCreditoMatriculaExt(TblfinCreditoMatriculaExt tblfinCreditoMatriculaExt) {
		getTblfinCreditoMatriculaExts().add(tblfinCreditoMatriculaExt);
		tblfinCreditoMatriculaExt.setTblfinEstadoFinanciacion(this);

		return tblfinCreditoMatriculaExt;
	}

	public TblfinCreditoMatriculaExt removeTblfinCreditoMatriculaExt(TblfinCreditoMatriculaExt tblfinCreditoMatriculaExt) {
		getTblfinCreditoMatriculaExts().remove(tblfinCreditoMatriculaExt);
		tblfinCreditoMatriculaExt.setTblfinEstadoFinanciacion(null);

		return tblfinCreditoMatriculaExt;
	}

}