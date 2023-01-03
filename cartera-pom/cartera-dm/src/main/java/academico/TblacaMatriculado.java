package academico;

import java.io.Serializable;

import javax.persistence.*;

import cartera.TblfinCreditoMatricula;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblaca_matriculado database table.
 * 
 */
@Entity
@Table(name="tblaca_matriculado", schema="academico")
@NamedQuery(name="TblacaMatriculado.findAll", query="SELECT t FROM TblacaMatriculado t")
public class TblacaMatriculado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TBLACA_MATRICULADO_OID_GENERATOR", sequenceName = "ACADEMICO.TBLACA_MATRICULADO_IDMATRICULADO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBLACA_MATRICULADO_OID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer oid;

	@Column(length=2)
	private String articulacion;

	@Column(name="bloqueo_encuesta")
	private Integer bloqueoEncuesta;

	@Column(name="bloqueo_financiero")
	private Integer bloqueoFinanciero;

	@Column(length=10)
	private String ceres;

	@Column(name="codigo_unico", length=30)
	private String codigoUnico;

	@Column(length=3)
	private String departamento;

	@Column(name="des_dtoadicional", length=100)
	private String desDtoadicional;

	@Column(name="dto_adicional")
	private float dtoAdicional;

	@Column(name="est_annio", nullable=false, precision=4)
	private BigDecimal estAnnio;

	@Column(name="est_semestre", nullable=false, length=2)
	private String estSemestre;

	@Column(name="estado_cancelacion")
	private Integer estadoCancelacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_bloqueoencuesta")
	private Date fechaBloqueoencuesta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_bloqueofinanciero")
	private Date fechaBloqueofinanciero;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expedicion")
	private Date fechaExpedicion;

	@Temporal(TemporalType.DATE)
	@Column(name="fpago_ext1")
	private Date fpagoExt1;

	@Temporal(TemporalType.DATE)
	@Column(name="fpago_ext2")
	private Date fpagoExt2;

	@Temporal(TemporalType.DATE)
	@Column(name="fpago_real")
	private Date fpagoReal;

	@Column(name="horario_code", nullable=false, length=2)
	private String horarioCode;

	private Integer idadmitido;

	private Integer iddescuento;

	@Column(name="ies_code", nullable=false, length=10)
	private String iesCode;

	@Column(length=5)
	private String municipio;

	@Column(name="nro_recibo")
	private Integer nroRecibo;

	private Integer numcreditos;

	@Column(length=2)
	private String pago;

	@Column(name="porc_beca")
	private Integer porcBeca;

	private float porcentaje;

	@Column(name="pro_consecutivo", nullable=false, precision=10)
	private BigDecimal proConsecutivo;

	@Column(length=50)
	private String resolucionbeca;

	@Column(nullable=false, length=3)
	private String retirado;

	private Integer seguro;

	@Column(name="tipo_doc_unico", length=3)
	private String tipoDocUnico;

	@Column(name="tipo_recibo", length=2)
	private String tipoRecibo;

	@Column(nullable=false)
	private Integer tipomatricula;

	@Column(length=20)
	private String usuario;

	@Column(name="vr_ext1")
	private float vrExt1;

	@Column(name="vr_ext2")
	private float vrExt2;

	@Column(name="vr_pago", precision=10, scale=2)
	private BigDecimal vrPago;

	//bi-directional many-to-one association to TblacaJornada
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idjornada")
	private TblacaJornada tblacaJornada;

	//bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idperiodo", nullable=false)
	private TblacaPeriodo tblacaPeriodo;

	//bi-directional many-to-one association to TblacaPrograma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idprograma")
	private TblacaPrograma tblacaPrograma;

	//bi-directional many-to-one association to TblestEstudiante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idestudiante")
	private TblestEstudiante tblestEstudiante;

	//bi-directional many-to-one association to TblestEstudiantePrograma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ep")
	private TblestEstudiantePrograma tblestEstudiantePrograma;


	//bi-directional many-to-one association to TblfinCreditoMatricula
	@OneToMany(mappedBy="tblacaMatriculado")
	private List<TblfinCreditoMatricula> tblfinCreditoMatriculas;

	public TblacaMatriculado() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getArticulacion() {
		return this.articulacion;
	}

	public void setArticulacion(String articulacion) {
		this.articulacion = articulacion;
	}

	public Integer getBloqueoEncuesta() {
		return this.bloqueoEncuesta;
	}

	public void setBloqueoEncuesta(Integer bloqueoEncuesta) {
		this.bloqueoEncuesta = bloqueoEncuesta;
	}

	public Integer getBloqueoFinanciero() {
		return this.bloqueoFinanciero;
	}

	public void setBloqueoFinanciero(Integer bloqueoFinanciero) {
		this.bloqueoFinanciero = bloqueoFinanciero;
	}

	public String getCeres() {
		return this.ceres;
	}

	public void setCeres(String ceres) {
		this.ceres = ceres;
	}

	public String getCodigoUnico() {
		return this.codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDesDtoadicional() {
		return this.desDtoadicional;
	}

	public void setDesDtoadicional(String desDtoadicional) {
		this.desDtoadicional = desDtoadicional;
	}

	public float getDtoAdicional() {
		return this.dtoAdicional;
	}

	public void setDtoAdicional(float dtoAdicional) {
		this.dtoAdicional = dtoAdicional;
	}

	public BigDecimal getEstAnnio() {
		return this.estAnnio;
	}

	public void setEstAnnio(BigDecimal estAnnio) {
		this.estAnnio = estAnnio;
	}

	public String getEstSemestre() {
		return this.estSemestre;
	}

	public void setEstSemestre(String estSemestre) {
		this.estSemestre = estSemestre;
	}

	public Integer getEstadoCancelacion() {
		return this.estadoCancelacion;
	}

	public void setEstadoCancelacion(Integer estadoCancelacion) {
		this.estadoCancelacion = estadoCancelacion;
	}

	public Date getFechaBloqueoencuesta() {
		return this.fechaBloqueoencuesta;
	}

	public void setFechaBloqueoencuesta(Date fechaBloqueoencuesta) {
		this.fechaBloqueoencuesta = fechaBloqueoencuesta;
	}

	public Date getFechaBloqueofinanciero() {
		return this.fechaBloqueofinanciero;
	}

	public void setFechaBloqueofinanciero(Date fechaBloqueofinanciero) {
		this.fechaBloqueofinanciero = fechaBloqueofinanciero;
	}

	public Date getFechaExpedicion() {
		return this.fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Date getFpagoExt1() {
		return this.fpagoExt1;
	}

	public void setFpagoExt1(Date fpagoExt1) {
		this.fpagoExt1 = fpagoExt1;
	}

	public Date getFpagoExt2() {
		return this.fpagoExt2;
	}

	public void setFpagoExt2(Date fpagoExt2) {
		this.fpagoExt2 = fpagoExt2;
	}

	public Date getFpagoReal() {
		return this.fpagoReal;
	}

	public void setFpagoReal(Date fpagoReal) {
		this.fpagoReal = fpagoReal;
	}

	public String getHorarioCode() {
		return this.horarioCode;
	}

	public void setHorarioCode(String horarioCode) {
		this.horarioCode = horarioCode;
	}

	public Integer getIdadmitido() {
		return this.idadmitido;
	}

	public void setIdadmitido(Integer idadmitido) {
		this.idadmitido = idadmitido;
	}

	public Integer getIddescuento() {
		return this.iddescuento;
	}

	public void setIddescuento(Integer iddescuento) {
		this.iddescuento = iddescuento;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getNroRecibo() {
		return this.nroRecibo;
	}

	public void setNroRecibo(Integer nroRecibo) {
		this.nroRecibo = nroRecibo;
	}

	public Integer getNumcreditos() {
		return this.numcreditos;
	}

	public void setNumcreditos(Integer numcreditos) {
		this.numcreditos = numcreditos;
	}

	public String getPago() {
		return this.pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public Integer getPorcBeca() {
		return this.porcBeca;
	}

	public void setPorcBeca(Integer porcBeca) {
		this.porcBeca = porcBeca;
	}

	public float getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public BigDecimal getProConsecutivo() {
		return this.proConsecutivo;
	}

	public void setProConsecutivo(BigDecimal proConsecutivo) {
		this.proConsecutivo = proConsecutivo;
	}

	public String getResolucionbeca() {
		return this.resolucionbeca;
	}

	public void setResolucionbeca(String resolucionbeca) {
		this.resolucionbeca = resolucionbeca;
	}

	public String getRetirado() {
		return this.retirado;
	}

	public void setRetirado(String retirado) {
		this.retirado = retirado;
	}

	public Integer getSeguro() {
		return this.seguro;
	}

	public void setSeguro(Integer seguro) {
		this.seguro = seguro;
	}

	public String getTipoDocUnico() {
		return this.tipoDocUnico;
	}

	public void setTipoDocUnico(String tipoDocUnico) {
		this.tipoDocUnico = tipoDocUnico;
	}

	public String getTipoRecibo() {
		return this.tipoRecibo;
	}

	public void setTipoRecibo(String tipoRecibo) {
		this.tipoRecibo = tipoRecibo;
	}

	public Integer getTipomatricula() {
		return this.tipomatricula;
	}

	public void setTipomatricula(Integer tipomatricula) {
		this.tipomatricula = tipomatricula;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public float getVrExt1() {
		return this.vrExt1;
	}

	public void setVrExt1(float vrExt1) {
		this.vrExt1 = vrExt1;
	}

	public float getVrExt2() {
		return this.vrExt2;
	}

	public void setVrExt2(float vrExt2) {
		this.vrExt2 = vrExt2;
	}

	public BigDecimal getVrPago() {
		return this.vrPago;
	}

	public void setVrPago(BigDecimal vrPago) {
		this.vrPago = vrPago;
	}

	public TblacaJornada getTblacaJornada() {
		return this.tblacaJornada;
	}

	public void setTblacaJornada(TblacaJornada tblacaJornada) {
		this.tblacaJornada = tblacaJornada;
	}

	public TblacaPeriodo getTblacaPeriodo() {
		return this.tblacaPeriodo;
	}

	public void setTblacaPeriodo(TblacaPeriodo tblacaPeriodo) {
		this.tblacaPeriodo = tblacaPeriodo;
	}

	public TblacaPrograma getTblacaPrograma() {
		return this.tblacaPrograma;
	}

	public void setTblacaPrograma(TblacaPrograma tblacaPrograma) {
		this.tblacaPrograma = tblacaPrograma;
	}

	public TblestEstudiante getTblestEstudiante() {
		return this.tblestEstudiante;
	}

	public void setTblestEstudiante(TblestEstudiante tblestEstudiante) {
		this.tblestEstudiante = tblestEstudiante;
	}

public TblestEstudiantePrograma getTblestEstudiantePrograma() {
		return this.tblestEstudiantePrograma;
	}

	public void setTblestEstudiantePrograma(TblestEstudiantePrograma tblestEstudiantePrograma) {
		this.tblestEstudiantePrograma = tblestEstudiantePrograma;
	}


	public List<TblfinCreditoMatricula> getTblfinCreditoMatriculas() {
		return this.tblfinCreditoMatriculas;
	}

	public void setTblfinCreditoMatriculas(List<TblfinCreditoMatricula> tblfinCreditoMatriculas) {
		this.tblfinCreditoMatriculas = tblfinCreditoMatriculas;
	}

	public TblfinCreditoMatricula addTblfinCreditoMatricula(TblfinCreditoMatricula tblfinCreditoMatricula) {
		getTblfinCreditoMatriculas().add(tblfinCreditoMatricula);
		tblfinCreditoMatricula.setTblacaMatriculado(this);

		return tblfinCreditoMatricula;
	}

	public TblfinCreditoMatricula removeTblfinCreditoMatricula(TblfinCreditoMatricula tblfinCreditoMatricula) {
		getTblfinCreditoMatriculas().remove(tblfinCreditoMatricula);
		tblfinCreditoMatricula.setTblacaMatriculado(null);

		return tblfinCreditoMatricula;
	}

}