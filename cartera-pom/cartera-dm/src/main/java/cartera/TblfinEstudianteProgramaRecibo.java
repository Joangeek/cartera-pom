package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblacaPeriodo;
import academico.TblestEstudiantePrograma;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tblfin_estudiante_programa_recibos database table.
 * 
 */
@Entity
@Table(name="tblfin_estudiante_programa_recibos", schema="academico")
@NamedQuery(name="TblfinEstudianteProgramaRecibo.findAll", query="SELECT t FROM TblfinEstudianteProgramaRecibo t")
public class TblfinEstudianteProgramaRecibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_ESTUDIANTE_PROGRAMA_RECIBOS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_ESTUDIANTE_PROGRAMA_RECIBOS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="descripcion_adicional", length=80)
	private String descripcionAdicional;

	@Column(name="estado_cancelacion")
	private Integer estadoCancelacion;

	@Column(name="fecha_creacion", nullable=false)
	private Timestamp fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	//bi-directional many-to-one association to TblestEstudiantePrograma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ep")
	private TblestEstudiantePrograma tblestEstudiantePrograma;
	

	@Column(nullable=false)
	private Integer idinscrito;

	@Column(name="nro_dias")
	private Integer nroDias;

	private Integer nrorecibo;

	@Column(name="participante_idparticipante", nullable=false)
	private Integer participanteIdparticipante;

	private Integer usuario;

	@Column(name="usuario_pago")
	private Integer usuarioPago;

	private Long valor;

	//bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idperiodo", nullable=false)
	private TblacaPeriodo tblacaPeriodo;

	//bi-directional many-to-one association to TblfinConceptosRecibosParticipante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="estado", referencedColumnName="estado", nullable=false),
		@JoinColumn(name="idconcepto", referencedColumnName="idparticipante", nullable=false),
		@JoinColumn(name="idparticipante", referencedColumnName="idconcepto", nullable=false)
		})
	private TblfinConceptosRecibosParticipante tblfinConceptosRecibosParticipante;

	public TblfinEstudianteProgramaRecibo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcionAdicional() {
		return this.descripcionAdicional;
	}

	public void setDescripcionAdicional(String descripcionAdicional) {
		this.descripcionAdicional = descripcionAdicional;
	}

	public Integer getEstadoCancelacion() {
		return this.estadoCancelacion;
	}

	public void setEstadoCancelacion(Integer estadoCancelacion) {
		this.estadoCancelacion = estadoCancelacion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}



	public Integer getIdinscrito() {
		return this.idinscrito;
	}

	public void setIdinscrito(Integer idinscrito) {
		this.idinscrito = idinscrito;
	}

	public Integer getNroDias() {
		return this.nroDias;
	}

	public void setNroDias(Integer nroDias) {
		this.nroDias = nroDias;
	}

	public Integer getNrorecibo() {
		return this.nrorecibo;
	}

	public void setNrorecibo(Integer nrorecibo) {
		this.nrorecibo = nrorecibo;
	}

	public Integer getParticipanteIdparticipante() {
		return this.participanteIdparticipante;
	}

	public void setParticipanteIdparticipante(Integer participanteIdparticipante) {
		this.participanteIdparticipante = participanteIdparticipante;
	}

	public Integer getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioPago() {
		return this.usuarioPago;
	}

	public void setUsuarioPago(Integer usuarioPago) {
		this.usuarioPago = usuarioPago;
	}

	public Long getValor() {
		return this.valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public TblacaPeriodo getTblacaPeriodo() {
		return this.tblacaPeriodo;
	}

	public void setTblacaPeriodo(TblacaPeriodo tblacaPeriodo) {
		this.tblacaPeriodo = tblacaPeriodo;
	}

	public TblfinConceptosRecibosParticipante getTblfinConceptosRecibosParticipante() {
		return this.tblfinConceptosRecibosParticipante;
	}

	public void setTblfinConceptosRecibosParticipante(TblfinConceptosRecibosParticipante tblfinConceptosRecibosParticipante) {
		this.tblfinConceptosRecibosParticipante = tblfinConceptosRecibosParticipante;
	}

	public TblestEstudiantePrograma getTblestEstudiantePrograma() {
		return this.tblestEstudiantePrograma;
	}

	public void setTblestEstudiantePrograma(TblestEstudiantePrograma tblestEstudiantePrograma) {
		this.tblestEstudiantePrograma = tblestEstudiantePrograma;
	}
}