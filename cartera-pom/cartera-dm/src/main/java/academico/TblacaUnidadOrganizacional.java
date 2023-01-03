package academico;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tblaca_unidad_organizacional database table.
 * 
 */
@Entity
@Table(name="tblaca_unidad_organizacional",schema="academico")
@NamedQuery(name="TblacaUnidadOrganizacional.findAll", query="SELECT t FROM TblacaUnidadOrganizacional t")
public class TblacaUnidadOrganizacional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_UNIDAD_ORGANIZACIONAL_OID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_UNIDAD_ORGANIZACIONAL_OID_GENERATOR")
	private Integer oid;

	private String apartado;

	@Column(name="aut_cargo")
	private String autCargo;

	@Column(name="aut_documento")
	private String autDocumento;

	@Column(name="aut_tip_ident")
	private String autTipIdent;

	@Column(name="cod_dependiente")
	private String codDependiente;

	@Column(name="cod_unidad")
	private String codUnidad;

	private String departamento;

	private String direccion;

	private String email;

	private Integer estado;

	@Column(name="fax_cod_area")
	private BigDecimal faxCodArea;

	@Column(name="fax_cod_pais")
	private BigDecimal faxCodPais;

	@Column(name="fax_numero")
	private String faxNumero;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private Integer idprograma;

	private Integer idsede;

	@Column(name="ies_code")
	private String iesCode;

	private String municipio;

	@Column(name="nombre_unidad")
	private String nombreUnidad;

	private String pais;

	@Column(name="programa_academico")
	private Integer programaAcademico;

	private Integer reportarsnies;

	@Column(name="tel_cod_area")
	private BigDecimal telCodArea;

	@Column(name="tel_cod_pais")
	private BigDecimal telCodPais;

	@Column(name="tel_ext")
	private BigDecimal telExt;

	@Column(name="tel_numero")
	private String telNumero;

	@Column(name="tipo_unidad_code")
	private String tipoUnidadCode;

	private String url;

	public TblacaUnidadOrganizacional() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getApartado() {
		return this.apartado;
	}

	public void setApartado(String apartado) {
		this.apartado = apartado;
	}

	public String getAutCargo() {
		return this.autCargo;
	}

	public void setAutCargo(String autCargo) {
		this.autCargo = autCargo;
	}

	public String getAutDocumento() {
		return this.autDocumento;
	}

	public void setAutDocumento(String autDocumento) {
		this.autDocumento = autDocumento;
	}

	public String getAutTipIdent() {
		return this.autTipIdent;
	}

	public void setAutTipIdent(String autTipIdent) {
		this.autTipIdent = autTipIdent;
	}

	public String getCodDependiente() {
		return this.codDependiente;
	}

	public void setCodDependiente(String codDependiente) {
		this.codDependiente = codDependiente;
	}

	public String getCodUnidad() {
		return this.codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public BigDecimal getFaxCodArea() {
		return this.faxCodArea;
	}

	public void setFaxCodArea(BigDecimal faxCodArea) {
		this.faxCodArea = faxCodArea;
	}

	public BigDecimal getFaxCodPais() {
		return this.faxCodPais;
	}

	public void setFaxCodPais(BigDecimal faxCodPais) {
		this.faxCodPais = faxCodPais;
	}

	public String getFaxNumero() {
		return this.faxNumero;
	}

	public void setFaxNumero(String faxNumero) {
		this.faxNumero = faxNumero;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIdprograma() {
		return this.idprograma;
	}

	public void setIdprograma(Integer idprograma) {
		this.idprograma = idprograma;
	}

	public Integer getIdsede() {
		return this.idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
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

	public String getNombreUnidad() {
		return this.nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getProgramaAcademico() {
		return this.programaAcademico;
	}

	public void setProgramaAcademico(Integer programaAcademico) {
		this.programaAcademico = programaAcademico;
	}

	public Integer getReportarsnies() {
		return this.reportarsnies;
	}

	public void setReportarsnies(Integer reportarsnies) {
		this.reportarsnies = reportarsnies;
	}

	public BigDecimal getTelCodArea() {
		return this.telCodArea;
	}

	public void setTelCodArea(BigDecimal telCodArea) {
		this.telCodArea = telCodArea;
	}

	public BigDecimal getTelCodPais() {
		return this.telCodPais;
	}

	public void setTelCodPais(BigDecimal telCodPais) {
		this.telCodPais = telCodPais;
	}

	public BigDecimal getTelExt() {
		return this.telExt;
	}

	public void setTelExt(BigDecimal telExt) {
		this.telExt = telExt;
	}

	public String getTelNumero() {
		return this.telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public String getTipoUnidadCode() {
		return this.tipoUnidadCode;
	}

	public void setTipoUnidadCode(String tipoUnidadCode) {
		this.tipoUnidadCode = tipoUnidadCode;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}