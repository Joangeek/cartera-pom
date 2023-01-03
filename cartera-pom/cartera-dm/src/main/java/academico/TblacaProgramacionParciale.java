package academico;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tblaca_programacion_parciales database table.
 * 
 */
@Entity
@Table(name="tblaca_programacion_parciales", schema="academico")
@NamedQuery(name="TblacaProgramacionParciale.findAll", query="SELECT t FROM TblacaProgramacionParciale t")
public class TblacaProgramacionParciale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_PROGRAMACION_PARCIALES_IDPROGRAMACION_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_PROGRAMACION_PARCIALES_IDPROGRAMACION_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idprogramacion;

	@Temporal(TemporalType.DATE)
	@Column(name="final_fin", nullable=false)
	private Date finalFin;

	@Temporal(TemporalType.DATE)
	@Column(name="final_inicio", nullable=false)
	private Date finalInicio;

	@Column(nullable=false)
	private Integer idsede;

	@Temporal(TemporalType.DATE)
	@Column(name="parcial1_fin", nullable=false)
	private Date parcial1Fin;

	@Temporal(TemporalType.DATE)
	@Column(name="parcial1_inicio", nullable=false)
	private Date parcial1Inicio;

	@Temporal(TemporalType.DATE)
	@Column(name="parcial2_fin", nullable=false)
	private Date parcial2Fin;

	@Temporal(TemporalType.DATE)
	@Column(name="parcial2_inicio", nullable=false)
	private Date parcial2Inicio;

	//bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idperiodo", nullable=false)
	private TblacaPeriodo tblacaPeriodo;

	public TblacaProgramacionParciale() {
	}

	public Integer getIdprogramacion() {
		return this.idprogramacion;
	}

	public void setIdprogramacion(Integer idprogramacion) {
		this.idprogramacion = idprogramacion;
	}

	public Date getFinalFin() {
		return this.finalFin;
	}

	public void setFinalFin(Date finalFin) {
		this.finalFin = finalFin;
	}

	public Date getFinalInicio() {
		return this.finalInicio;
	}

	public void setFinalInicio(Date finalInicio) {
		this.finalInicio = finalInicio;
	}

	public Integer getIdsede() {
		return this.idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
	}

	public Date getParcial1Fin() {
		return this.parcial1Fin;
	}

	public void setParcial1Fin(Date parcial1Fin) {
		this.parcial1Fin = parcial1Fin;
	}

	public Date getParcial1Inicio() {
		return this.parcial1Inicio;
	}

	public void setParcial1Inicio(Date parcial1Inicio) {
		this.parcial1Inicio = parcial1Inicio;
	}

	public Date getParcial2Fin() {
		return this.parcial2Fin;
	}

	public void setParcial2Fin(Date parcial2Fin) {
		this.parcial2Fin = parcial2Fin;
	}

	public Date getParcial2Inicio() {
		return this.parcial2Inicio;
	}

	public void setParcial2Inicio(Date parcial2Inicio) {
		this.parcial2Inicio = parcial2Inicio;
	}

	public TblacaPeriodo getTblacaPeriodo() {
		return this.tblacaPeriodo;
	}

	public void setTblacaPeriodo(TblacaPeriodo tblacaPeriodo) {
		this.tblacaPeriodo = tblacaPeriodo;
	}

}