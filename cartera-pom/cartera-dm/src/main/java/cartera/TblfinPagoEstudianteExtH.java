package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tblfin_pago_estudiante_ext_h database table.
 * 
 */
@Entity
@Table(name="tblfin_pago_estudiante_ext_h", schema="academico")
@NamedQuery(name="TblfinPagoEstudianteExtH.findAll", query="SELECT t FROM TblfinPagoEstudianteExtH t")
public class TblfinPagoEstudianteExtH implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_PAGO_ESTUDIANTE_EXT_H_IDPAGO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_PAGO_ESTUDIANTE_EXT_H_IDPAGO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idpago;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_programada", nullable=false)
	private Date fechaProgramada;

	@Column(name="idestudiante_ext_h", nullable=false)
	private Integer idestudianteExtH;

	@Column(nullable=false)
	private Integer intereses;

	@Column(nullable=false)
	private Integer nrocuota;

	@Column(name="vr_programado", nullable=false)
	private Integer vrProgramado;

	public TblfinPagoEstudianteExtH() {
	}

	public Integer getIdpago() {
		return this.idpago;
	}

	public void setIdpago(Integer idpago) {
		this.idpago = idpago;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaProgramada() {
		return this.fechaProgramada;
	}

	public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}

	public Integer getIdestudianteExtH() {
		return this.idestudianteExtH;
	}

	public void setIdestudianteExtH(Integer idestudianteExtH) {
		this.idestudianteExtH = idestudianteExtH;
	}

	public Integer getIntereses() {
		return this.intereses;
	}

	public void setIntereses(Integer intereses) {
		this.intereses = intereses;
	}

	public Integer getNrocuota() {
		return this.nrocuota;
	}

	public void setNrocuota(Integer nrocuota) {
		this.nrocuota = nrocuota;
	}

	public Integer getVrProgramado() {
		return this.vrProgramado;
	}

	public void setVrProgramado(Integer vrProgramado) {
		this.vrProgramado = vrProgramado;
	}

}