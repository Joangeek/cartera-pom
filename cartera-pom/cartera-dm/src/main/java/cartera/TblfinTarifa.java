package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblacaPeriodo;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblfin_tarifa database table.
 * 
 */
@Entity
@Table(name="tblfin_tarifa", schema="academico")
@NamedQuery(name="TblfinTarifa.findAll", query="SELECT t FROM TblfinTarifa t")
public class TblfinTarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_TARIFA_IDTARIFA_GENERATOR", sequenceName="academico.tblfin_tarifa_idtarifa_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_TARIFA_IDTARIFA_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idtarifa;

	@Column(nullable=false, length=100)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_aprobacion", nullable=false)
	private Date fechaAprobacion;

	//bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idperiodo", nullable=false)
	private TblacaPeriodo tblacaPeriodo;

	//bi-directional many-to-one association to TblfinTarifaMatricula
	@OneToMany(mappedBy="tblfinTarifa")
	private List<TblfinTarifaMatricula> tblfinTarifaMatriculas;

	public TblfinTarifa() {
	}

	public Integer getIdtarifa() {
		return this.idtarifa;
	}

	public void setIdtarifa(Integer idtarifa) {
		this.idtarifa = idtarifa;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAprobacion() {
		return this.fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}



	public TblacaPeriodo getTblacaPeriodo() {
		return tblacaPeriodo;
	}

	public void setTblacaPeriodo(TblacaPeriodo tblacaPeriodo) {
		this.tblacaPeriodo = tblacaPeriodo;
	}

	public List<TblfinTarifaMatricula> getTblfinTarifaMatriculas() {
		return this.tblfinTarifaMatriculas;
	}

	public void setTblfinTarifaMatriculas(List<TblfinTarifaMatricula> tblfinTarifaMatriculas) {
		this.tblfinTarifaMatriculas = tblfinTarifaMatriculas;
	}

	public TblfinTarifaMatricula addTblfinTarifaMatricula(TblfinTarifaMatricula tblfinTarifaMatricula) {
		getTblfinTarifaMatriculas().add(tblfinTarifaMatricula);
		tblfinTarifaMatricula.setTblfinTarifa(this);

		return tblfinTarifaMatricula;
	}

	public TblfinTarifaMatricula removeTblfinTarifaMatricula(TblfinTarifaMatricula tblfinTarifaMatricula) {
		getTblfinTarifaMatriculas().remove(tblfinTarifaMatricula);
		tblfinTarifaMatricula.setTblfinTarifa(null);

		return tblfinTarifaMatricula;
	}

}