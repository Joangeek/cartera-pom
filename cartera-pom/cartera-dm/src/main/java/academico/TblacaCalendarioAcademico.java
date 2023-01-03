package academico;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the tblaca_calendario_academico database table.
 * 
 */
@Entity
@Table(name = "tblaca_calendario_academico", schema = "academico")
@NamedQuery(name = "TblacaCalendarioAcademico.findAll", query = "SELECT t FROM TblacaCalendarioAcademico t")
public class TblacaCalendarioAcademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TBLACA_CALENDARIO_ACADEMICO_IDCALENDARIO_GENERATOR",sequenceName="academico.tblaca_periodo_oid_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBLACA_CALENDARIO_ACADEMICO_IDCALENDARIO_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer idcalendario;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fin;

	// bi-directional many-to-one association to TblacaSede
	@ManyToOne
	@JoinColumn(name = "idsede")
	private TblacaSede tblacaSede;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false) 
	private Date inicio;

	@Column(nullable = false)
	private Integer orden;

	@Column(name = "todas_sedes", length = 2)
	private String todasSedes;
	
	//ALTER TABLE academico.tblaca_calendario_academico ADD COLUMN descripcion character varying(20);
	//ALTER TABLE academico.tblaca_calendario_academico ALTER COLUMN descripcion SET NOT NULL;
	@Column(length = 20)
	private String descripcion;

	private double valor;

	// bi-directional many-to-one association to TblacaActividadCalendario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idactividad", nullable = false)
	private TblacaActividadCalendario actCalendario;

	// bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idperiodo", nullable = false)
	private TblacaPeriodo tblacaPeriodo;

	public TblacaCalendarioAcademico() {
	}

	public Integer getIdcalendario() {
		return this.idcalendario;
	}

	public void setIdcalendario(Integer idcalendario) {
		this.idcalendario = idcalendario;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public TblacaSede getTblacaSede() {
		return tblacaSede;
	}

	public void setTblacaSede(TblacaSede tblacaSede) {
		this.tblacaSede = tblacaSede;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getTodasSedes() {
		return this.todasSedes;
	}

	public void setTodasSedes(String todasSedes) {
		this.todasSedes = todasSedes;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TblacaPeriodo getTblacaPeriodo() {
		return this.tblacaPeriodo;
	}

	public void setTblacaPeriodo(TblacaPeriodo tblacaPeriodo) {
		this.tblacaPeriodo = tblacaPeriodo;
	}
	
	public TblacaActividadCalendario getActCalendario() {
		return actCalendario;
	}

	public void setActCalendario(TblacaActividadCalendario actCalendario) {
		this.actCalendario = actCalendario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}