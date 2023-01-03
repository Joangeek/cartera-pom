package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tblfin_pagos_credito database table.
 * 
 */
@Entity
@Table(name="tblfin_pagos_credito", schema="academico")
@NamedQuery(name="TblfinPagosCredito.findAll", query="SELECT t FROM TblfinPagosCredito t")
public class TblfinPagosCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_PAGOS_CREDITO_IDPAGOCREDITO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_PAGOS_CREDITO_IDPAGOCREDITO_GENERATOR")
	@Column(name="idpago_credito", unique=true, nullable=false)
	private Integer idpagoCredito;

	@Column(precision=10, scale=3)
	private BigDecimal abono1;

	@Column(precision=10, scale=3)
	private BigDecimal abono2;

	@Column(precision=10, scale=3)
	private BigDecimal abono3;

	@Column(precision=10, scale=3)
	private BigDecimal abono4;

	@Column(precision=10, scale=3)
	private BigDecimal abono5;

	private Integer cuota;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion")
	private Date fechaExpedicion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion1")
	private Date fechaExpedicion1;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion2")
	private Date fechaExpedicion2;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion3")
	private Date fechaExpedicion3;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion4")
	private Date fechaExpedicion4;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion5")
	private Date fechaExpedicion5;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_limite")
	private Date fechaLimite;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Temporal(TemporalType.DATE)
	private Date fechaabono1;

	@Temporal(TemporalType.DATE)
	private Date fechaabono2;

	@Temporal(TemporalType.DATE)
	private Date fechaabono3;

	@Temporal(TemporalType.DATE)
	private Date fechaabono4;

	@Temporal(TemporalType.DATE)
	private Date fechaabono5;

	@Column(name="hora_pago")
	private Integer horaPago;

	@Column(precision=11, scale=3)
	private BigDecimal interes;

	@Column(name="min_pago")
	private Integer minPago;

	@Column(length=2)
	private String pago;

	private Integer porcentaje;

	@Column(length=10)
	private String recibocaja;

	@Column(length=10)
	private String recibocaja1;

	@Column(length=10)
	private String recibocaja2;

	@Column(length=10)
	private String recibocaja3;

	@Column(length=10)
	private String recibocaja4;

	@Column(length=10)
	private String recibocaja5;

	@Column(precision=10, scale=3)
	private BigDecimal saldo;

	private Integer tipopago;

	@Column(precision=11, scale=3)
	private BigDecimal valor;

	//bi-directional many-to-one association to TblfinCreditoMatricula
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcredito", nullable=false)
	private TblfinCreditoMatricula tblfinCreditoMatricula;

	public TblfinPagosCredito() {
	}

	public Integer getIdpagoCredito() {
		return this.idpagoCredito;
	}

	public void setIdpagoCredito(Integer idpagoCredito) {
		this.idpagoCredito = idpagoCredito;
	}

	public BigDecimal getAbono1() {
		return this.abono1;
	}

	public void setAbono1(BigDecimal abono1) {
		this.abono1 = abono1;
	}

	public BigDecimal getAbono2() {
		return this.abono2;
	}

	public void setAbono2(BigDecimal abono2) {
		this.abono2 = abono2;
	}

	public BigDecimal getAbono3() {
		return this.abono3;
	}

	public void setAbono3(BigDecimal abono3) {
		this.abono3 = abono3;
	}

	public BigDecimal getAbono4() {
		return this.abono4;
	}

	public void setAbono4(BigDecimal abono4) {
		this.abono4 = abono4;
	}

	public BigDecimal getAbono5() {
		return this.abono5;
	}

	public void setAbono5(BigDecimal abono5) {
		this.abono5 = abono5;
	}

	public Integer getCuota() {
		return this.cuota;
	}

	public void setCuota(Integer cuota) {
		this.cuota = cuota;
	}

	public Date getFechaExpedicion() {
		return this.fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Date getFechaExpedicion1() {
		return this.fechaExpedicion1;
	}

	public void setFechaExpedicion1(Date fechaExpedicion1) {
		this.fechaExpedicion1 = fechaExpedicion1;
	}

	public Date getFechaExpedicion2() {
		return this.fechaExpedicion2;
	}

	public void setFechaExpedicion2(Date fechaExpedicion2) {
		this.fechaExpedicion2 = fechaExpedicion2;
	}

	public Date getFechaExpedicion3() {
		return this.fechaExpedicion3;
	}

	public void setFechaExpedicion3(Date fechaExpedicion3) {
		this.fechaExpedicion3 = fechaExpedicion3;
	}

	public Date getFechaExpedicion4() {
		return this.fechaExpedicion4;
	}

	public void setFechaExpedicion4(Date fechaExpedicion4) {
		this.fechaExpedicion4 = fechaExpedicion4;
	}

	public Date getFechaExpedicion5() {
		return this.fechaExpedicion5;
	}

	public void setFechaExpedicion5(Date fechaExpedicion5) {
		this.fechaExpedicion5 = fechaExpedicion5;
	}

	public Date getFechaLimite() {
		return this.fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaabono1() {
		return this.fechaabono1;
	}

	public void setFechaabono1(Date fechaabono1) {
		this.fechaabono1 = fechaabono1;
	}

	public Date getFechaabono2() {
		return this.fechaabono2;
	}

	public void setFechaabono2(Date fechaabono2) {
		this.fechaabono2 = fechaabono2;
	}

	public Date getFechaabono3() {
		return this.fechaabono3;
	}

	public void setFechaabono3(Date fechaabono3) {
		this.fechaabono3 = fechaabono3;
	}

	public Date getFechaabono4() {
		return this.fechaabono4;
	}

	public void setFechaabono4(Date fechaabono4) {
		this.fechaabono4 = fechaabono4;
	}

	public Date getFechaabono5() {
		return this.fechaabono5;
	}

	public void setFechaabono5(Date fechaabono5) {
		this.fechaabono5 = fechaabono5;
	}

	public Integer getHoraPago() {
		return this.horaPago;
	}

	public void setHoraPago(Integer horaPago) {
		this.horaPago = horaPago;
	}

	public BigDecimal getInteres() {
		return this.interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public Integer getMinPago() {
		return this.minPago;
	}

	public void setMinPago(Integer minPago) {
		this.minPago = minPago;
	}

	public String getPago() {
		return this.pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public Integer getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getRecibocaja() {
		return this.recibocaja;
	}

	public void setRecibocaja(String recibocaja) {
		this.recibocaja = recibocaja;
	}

	public String getRecibocaja1() {
		return this.recibocaja1;
	}

	public void setRecibocaja1(String recibocaja1) {
		this.recibocaja1 = recibocaja1;
	}

	public String getRecibocaja2() {
		return this.recibocaja2;
	}

	public void setRecibocaja2(String recibocaja2) {
		this.recibocaja2 = recibocaja2;
	}

	public String getRecibocaja3() {
		return this.recibocaja3;
	}

	public void setRecibocaja3(String recibocaja3) {
		this.recibocaja3 = recibocaja3;
	}

	public String getRecibocaja4() {
		return this.recibocaja4;
	}

	public void setRecibocaja4(String recibocaja4) {
		this.recibocaja4 = recibocaja4;
	}

	public String getRecibocaja5() {
		return this.recibocaja5;
	}

	public void setRecibocaja5(String recibocaja5) {
		this.recibocaja5 = recibocaja5;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Integer getTipopago() {
		return this.tipopago;
	}

	public void setTipopago(Integer tipopago) {
		this.tipopago = tipopago;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TblfinCreditoMatricula getTblfinCreditoMatricula() {
		return this.tblfinCreditoMatricula;
	}

	public void setTblfinCreditoMatricula(TblfinCreditoMatricula tblfinCreditoMatricula) {
		this.tblfinCreditoMatricula = tblfinCreditoMatricula;
	}

}