package academico;

import java.io.Serializable;

import javax.persistence.*;

import cartera.TblfinEstadoFinanciacion;
import cartera.TblmerCategoriaComfacauca;
import cartera.TblmerEstrato;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tblest_estudiante_h database table.
 * 
 */
@Entity
@Table(name="tblest_estudiante_h", schema="academico")
@NamedQuery(name="TblestEstudianteH.findAll", query="SELECT t FROM TblestEstudianteH t")
public class TblestEstudianteH implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEST_ESTUDIANTE_H_IDESTUDIANTEH_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEST_ESTUDIANTE_H_IDESTUDIANTEH_GENERATOR")
	@Column(name="idestudiante_h", unique=true, nullable=false)
	private Integer idestudianteH;

	@Column(length=2)
	private String academico;

	@Column(name="actualizacion_historico", length=1)
	private String actualizacionHistorico;

	@Column(nullable=false, precision=4)
	private BigDecimal annio;

	@Column(length=2)
	private String ap;

	@Column(name="codigo_unico", nullable=false, length=20)
	private String codigoUnico;

	@Column(length=2)
	private String discapacidad;

	@Column(length=2)
	private String duracion;

	@Column(name="estado_civil", length=2)
	private String estadoCivil;

	@Column(name="estrato_sasde", length=2)
	private String estratoSasde;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion_sasde")
	private Date fechaActualizacionSasde;

	@Column(length=2)
	private String financiera;

	@Column(name="idcategoria_comfa_h")
	private Integer idcategoriaComfaH;

	@Column(name="ies_code", nullable=false, length=10)
	private String iesCode;

	@Column(name="nivel_satisfaccion_apoyo_acad", precision=7, scale=2)
	private BigDecimal nivelSatisfaccionApoyoAcad;

	@Column(name="nivel_satisfaccion_otros_apoy", precision=7, scale=2)
	private BigDecimal nivelSatisfaccionOtrosApoy;

	@Column(length=2)
	private String otros;

	@Column(name="personas_a_cargo", precision=2)
	private BigDecimal personasACargo;

	@Column(name="porcentaje_ayuda_financ_recib", precision=7, scale=2)
	private BigDecimal porcentajeAyudaFinancRecib;

	@Column(name="rango_de_ingreso", length=2)
	private String rangoDeIngreso;

	@Column(name="recibio_apoyo_academico", length=2)
	private String recibioApoyoAcademico;

	@Column(name="recibio_apoyo_financiero", length=2)
	private String recibioApoyoFinanciero;

	@Column(name="recibio_otros_apoy", length=2)
	private String recibioOtrosApoy;

	@Column(nullable=false)
	private Integer relacion;

	@Column(nullable=false, length=2)
	private String semestre;

	@Column(name="tipo_de_trabajo", length=2)
	private String tipoDeTrabajo;

	@Column(name="tipo_doc_unico", nullable=false, length=3)
	private String tipoDocUnico;

	@Column(name="trabajo_semestre", length=2)
	private String trabajoSemestre;

	@Column(name="valor_total_pagado", precision=10, scale=2)
	private BigDecimal valorTotalPagado;

	//bi-directional many-to-one association to TblestEstudiante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estudiante", nullable=false)
	private TblestEstudiante tblestEstudiante;

	//bi-directional many-to-one association to TblfinEstadoFinanciacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idestado_financiero", nullable=false)
	private TblfinEstadoFinanciacion tblfinEstadoFinanciacion;

	//bi-directional many-to-one association to TblmerCategoriaComfacauca
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcategoria_comfa", nullable=false)
	private TblmerCategoriaComfacauca tblmerCategoriaComfacauca;

	//bi-directional many-to-one association to TblmerEstrato
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estrato", nullable=false)
	private TblmerEstrato tblmerEstrato;

	public TblestEstudianteH() {
	}

	public Integer getIdestudianteH() {
		return this.idestudianteH;
	}

	public void setIdestudianteH(Integer idestudianteH) {
		this.idestudianteH = idestudianteH;
	}

	public String getAcademico() {
		return this.academico;
	}

	public void setAcademico(String academico) {
		this.academico = academico;
	}

	public String getActualizacionHistorico() {
		return this.actualizacionHistorico;
	}

	public void setActualizacionHistorico(String actualizacionHistorico) {
		this.actualizacionHistorico = actualizacionHistorico;
	}

	public BigDecimal getAnnio() {
		return this.annio;
	}

	public void setAnnio(BigDecimal annio) {
		this.annio = annio;
	}

	public String getAp() {
		return this.ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public String getCodigoUnico() {
		return this.codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public String getDiscapacidad() {
		return this.discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstratoSasde() {
		return this.estratoSasde;
	}

	public void setEstratoSasde(String estratoSasde) {
		this.estratoSasde = estratoSasde;
	}

	public Date getFechaActualizacionSasde() {
		return this.fechaActualizacionSasde;
	}

	public void setFechaActualizacionSasde(Date fechaActualizacionSasde) {
		this.fechaActualizacionSasde = fechaActualizacionSasde;
	}

	public String getFinanciera() {
		return this.financiera;
	}

	public void setFinanciera(String financiera) {
		this.financiera = financiera;
	}

	public Integer getIdcategoriaComfaH() {
		return this.idcategoriaComfaH;
	}

	public void setIdcategoriaComfaH(Integer idcategoriaComfaH) {
		this.idcategoriaComfaH = idcategoriaComfaH;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public BigDecimal getNivelSatisfaccionApoyoAcad() {
		return this.nivelSatisfaccionApoyoAcad;
	}

	public void setNivelSatisfaccionApoyoAcad(BigDecimal nivelSatisfaccionApoyoAcad) {
		this.nivelSatisfaccionApoyoAcad = nivelSatisfaccionApoyoAcad;
	}

	public BigDecimal getNivelSatisfaccionOtrosApoy() {
		return this.nivelSatisfaccionOtrosApoy;
	}

	public void setNivelSatisfaccionOtrosApoy(BigDecimal nivelSatisfaccionOtrosApoy) {
		this.nivelSatisfaccionOtrosApoy = nivelSatisfaccionOtrosApoy;
	}

	public String getOtros() {
		return this.otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public BigDecimal getPersonasACargo() {
		return this.personasACargo;
	}

	public void setPersonasACargo(BigDecimal personasACargo) {
		this.personasACargo = personasACargo;
	}

	public BigDecimal getPorcentajeAyudaFinancRecib() {
		return this.porcentajeAyudaFinancRecib;
	}

	public void setPorcentajeAyudaFinancRecib(BigDecimal porcentajeAyudaFinancRecib) {
		this.porcentajeAyudaFinancRecib = porcentajeAyudaFinancRecib;
	}

	public String getRangoDeIngreso() {
		return this.rangoDeIngreso;
	}

	public void setRangoDeIngreso(String rangoDeIngreso) {
		this.rangoDeIngreso = rangoDeIngreso;
	}

	public String getRecibioApoyoAcademico() {
		return this.recibioApoyoAcademico;
	}

	public void setRecibioApoyoAcademico(String recibioApoyoAcademico) {
		this.recibioApoyoAcademico = recibioApoyoAcademico;
	}

	public String getRecibioApoyoFinanciero() {
		return this.recibioApoyoFinanciero;
	}

	public void setRecibioApoyoFinanciero(String recibioApoyoFinanciero) {
		this.recibioApoyoFinanciero = recibioApoyoFinanciero;
	}

	public String getRecibioOtrosApoy() {
		return this.recibioOtrosApoy;
	}

	public void setRecibioOtrosApoy(String recibioOtrosApoy) {
		this.recibioOtrosApoy = recibioOtrosApoy;
	}

	public Integer getRelacion() {
		return this.relacion;
	}

	public void setRelacion(Integer relacion) {
		this.relacion = relacion;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTipoDeTrabajo() {
		return this.tipoDeTrabajo;
	}

	public void setTipoDeTrabajo(String tipoDeTrabajo) {
		this.tipoDeTrabajo = tipoDeTrabajo;
	}

	public String getTipoDocUnico() {
		return this.tipoDocUnico;
	}

	public void setTipoDocUnico(String tipoDocUnico) {
		this.tipoDocUnico = tipoDocUnico;
	}

	public String getTrabajoSemestre() {
		return this.trabajoSemestre;
	}

	public void setTrabajoSemestre(String trabajoSemestre) {
		this.trabajoSemestre = trabajoSemestre;
	}

	public BigDecimal getValorTotalPagado() {
		return this.valorTotalPagado;
	}

	public void setValorTotalPagado(BigDecimal valorTotalPagado) {
		this.valorTotalPagado = valorTotalPagado;
	}

	public TblestEstudiante getTblestEstudiante() {
		return this.tblestEstudiante;
	}

	public void setTblestEstudiante(TblestEstudiante tblestEstudiante) {
		this.tblestEstudiante = tblestEstudiante;
	}

	public TblfinEstadoFinanciacion getTblfinEstadoFinanciacion() {
		return this.tblfinEstadoFinanciacion;
	}

	public void setTblfinEstadoFinanciacion(TblfinEstadoFinanciacion tblfinEstadoFinanciacion) {
		this.tblfinEstadoFinanciacion = tblfinEstadoFinanciacion;
	}

	public TblmerCategoriaComfacauca getTblmerCategoriaComfacauca() {
		return this.tblmerCategoriaComfacauca;
	}

	public void setTblmerCategoriaComfacauca(TblmerCategoriaComfacauca tblmerCategoriaComfacauca) {
		this.tblmerCategoriaComfacauca = tblmerCategoriaComfacauca;
	}

	public TblmerEstrato getTblmerEstrato() {
		return this.tblmerEstrato;
	}

	public void setTblmerEstrato(TblmerEstrato tblmerEstrato) {
		this.tblmerEstrato = tblmerEstrato;
	}

}