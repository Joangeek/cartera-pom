package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tblfin_credito_matricula_ext database table.
 * 
 */
@Entity
@Table(name="tblfin_credito_matricula_ext", schema="academico")
@NamedQuery(name="TblfinCreditoMatriculaExt.findAll", query="SELECT t FROM TblfinCreditoMatriculaExt t")
public class TblfinCreditoMatriculaExt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_CREDITO_MATRICULA_EXT_IDCREDITO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_CREDITO_MATRICULA_EXT_IDCREDITO_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idcredito;

	@Column(length=20)
	private String cedula;

	@Column(name="ciudad_expedicion", length=30)
	private String ciudadExpedicion;

	@Column(name="cuota_inicial")
	private double cuotaInicial;

	private Integer desembolso;

	@Column(length=70)
	private String deudor;

	@Column(length=30)
	private String direccion;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicial")
	private Date fechaInicial;

	@Column(name="fecha_solicitud")
	private Timestamp fechaSolicitud;

	@Column(name="identidad_credito", length=2)
	private String identidadCredito;

	@Column(name="idestudiante_extension", nullable=false)
	private Integer idestudianteExtension;

	private Integer ncuotas;

	@Column(length=2147483647)
	private String observaciones;

	private double pcredito;

	@Column(length=20)
	private String telefono;

	//bi-directional many-to-one association to TblfinEstadoFinanciacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idestado_financiero", nullable=false)
	private TblfinEstadoFinanciacion tblfinEstadoFinanciacion;

	public TblfinCreditoMatriculaExt() {
	}

	public Integer getIdcredito() {
		return this.idcredito;
	}

	public void setIdcredito(Integer idcredito) {
		this.idcredito = idcredito;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudadExpedicion() {
		return this.ciudadExpedicion;
	}

	public void setCiudadExpedicion(String ciudadExpedicion) {
		this.ciudadExpedicion = ciudadExpedicion;
	}

	public double getCuotaInicial() {
		return this.cuotaInicial;
	}

	public void setCuotaInicial(double cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}

	public Integer getDesembolso() {
		return this.desembolso;
	}

	public void setDesembolso(Integer desembolso) {
		this.desembolso = desembolso;
	}

	public String getDeudor() {
		return this.deudor;
	}

	public void setDeudor(String deudor) {
		this.deudor = deudor;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Timestamp getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Timestamp fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getIdentidadCredito() {
		return this.identidadCredito;
	}

	public void setIdentidadCredito(String identidadCredito) {
		this.identidadCredito = identidadCredito;
	}

	public Integer getIdestudianteExtension() {
		return this.idestudianteExtension;
	}

	public void setIdestudianteExtension(Integer idestudianteExtension) {
		this.idestudianteExtension = idestudianteExtension;
	}

	public Integer getNcuotas() {
		return this.ncuotas;
	}

	public void setNcuotas(Integer ncuotas) {
		this.ncuotas = ncuotas;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getPcredito() {
		return this.pcredito;
	}

	public void setPcredito(double pcredito) {
		this.pcredito = pcredito;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TblfinEstadoFinanciacion getTblfinEstadoFinanciacion() {
		return this.tblfinEstadoFinanciacion;
	}

	public void setTblfinEstadoFinanciacion(TblfinEstadoFinanciacion tblfinEstadoFinanciacion) {
		this.tblfinEstadoFinanciacion = tblfinEstadoFinanciacion;
	}

}