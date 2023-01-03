package talentoHumano;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import comun.Tblpais;



/**
 * The persistent class for the tblth_participantes database table.
 * 
 */
@Entity
@Table(name="tblth_participantes",schema="academico")
@NamedQuery(name="TblthParticipante.findAll", query="SELECT t FROM TblthParticipante t")
public class TblthParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLTH_PARTICIPANTES_IDPARTICIPANTE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLTH_PARTICIPANTES_IDPARTICIPANTE_GENERATOR")
	private Integer idparticipante;

	@Column(name="area_tel")
	private String areaTel;

	private Integer autoridad;

	private String celular;

	@Column(name="ciudad_residencia")
	private String ciudadResidencia;

	@Column(name="codigo_id_ant")
	private String codigoIdAnt;

	@Column(name="codigo_unico")
	private String codigoUnico;

	private String direccion;

	private String direccioncasa;

	@Column(name="distrito_militar")
	private Integer distritoMilitar;

	private String email;

	@Column(name="email_inst")
	private String emailInst;

	@Column(name="est_civil_code")
	private String estCivilCode;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacim")
	private Date fechaNacim;

	@Column(name="genero_code")
	private String generoCode;

	@Column(name="ies_code")
	private String iesCode;

	@Column(name="lugar_ced_exp")
	private String lugarCedExp;

	@Column(name="municipio_ln")
	private String municipioLn;

	private String nombre;

	@Column(name="numero_libreta")
	private Integer numeroLibreta;

	@Column(name="numero_tel")
	private String numeroTel;

	@Column(name="pais_tel")
	private String paisTel;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	private Integer snies;

	private String tarjeta;

	@Column(name="tipo_id_ant")
	private String tipoIdAnt;

	@Column(name="tipo_libreta")
	private Integer tipoLibreta;


	//bi-directional many-to-one association to Tblpais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pais_ln")
	private Tblpais tblpais;

	//bi-directional many-to-one association to TblthEntidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ideps")
	private TblthEntidade tblthEntidade1;

	//bi-directional many-to-one association to TblthEntidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idpension")
	private TblthEntidade tblthEntidade2;

	//bi-directional many-to-one association to TblthTipoIdentificacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_doc_unico")
	private TblthTipoIdentificacion tblthTipoIdentificacion;


	public TblthParticipante() {
	}

	public Integer getIdparticipante() {
		return this.idparticipante;
	}

	public void setIdparticipante(Integer idparticipante) {
		this.idparticipante = idparticipante;
	}

	public String getAreaTel() {
		return this.areaTel;
	}

	public void setAreaTel(String areaTel) {
		this.areaTel = areaTel;
	}

	public Integer getAutoridad() {
		return this.autoridad;
	}

	public void setAutoridad(Integer autoridad) {
		this.autoridad = autoridad;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiudadResidencia() {
		return this.ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getCodigoIdAnt() {
		return this.codigoIdAnt;
	}

	public void setCodigoIdAnt(String codigoIdAnt) {
		this.codigoIdAnt = codigoIdAnt;
	}

	public String getCodigoUnico() {
		return this.codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}


	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccioncasa() {
		return this.direccioncasa;
	}

	public void setDireccioncasa(String direccioncasa) {
		this.direccioncasa = direccioncasa;
	}

	public Integer getDistritoMilitar() {
		return this.distritoMilitar;
	}

	public void setDistritoMilitar(Integer distritoMilitar) {
		this.distritoMilitar = distritoMilitar;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailInst() {
		return this.emailInst;
	}

	public void setEmailInst(String emailInst) {
		this.emailInst = emailInst;
	}

	public String getEstCivilCode() {
		return this.estCivilCode;
	}

	public void setEstCivilCode(String estCivilCode) {
		this.estCivilCode = estCivilCode;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaNacim() {
		return this.fechaNacim;
	}

	public void setFechaNacim(Date fechaNacim) {
		this.fechaNacim = fechaNacim;
	}

	public String getGeneroCode() {
		return this.generoCode;
	}

	public void setGeneroCode(String generoCode) {
		this.generoCode = generoCode;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public String getLugarCedExp() {
		return this.lugarCedExp;
	}

	public void setLugarCedExp(String lugarCedExp) {
		this.lugarCedExp = lugarCedExp;
	}

	public String getMunicipioLn() {
		return this.municipioLn;
	}

	public void setMunicipioLn(String municipioLn) {
		this.municipioLn = municipioLn;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroLibreta() {
		return this.numeroLibreta;
	}

	public void setNumeroLibreta(Integer numeroLibreta) {
		this.numeroLibreta = numeroLibreta;
	}

	public String getNumeroTel() {
		return this.numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getPaisTel() {
		return this.paisTel;
	}

	public void setPaisTel(String paisTel) {
		this.paisTel = paisTel;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public Integer getSnies() {
		return this.snies;
	}

	public void setSnies(Integer snies) {
		this.snies = snies;
	}

	public String getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getTipoIdAnt() {
		return this.tipoIdAnt;
	}

	public void setTipoIdAnt(String tipoIdAnt) {
		this.tipoIdAnt = tipoIdAnt;
	}

	public Integer getTipoLibreta() {
		return this.tipoLibreta;
	}

	public void setTipoLibreta(Integer tipoLibreta) {
		this.tipoLibreta = tipoLibreta;
	}

	public Tblpais getTblpais() {
		return this.tblpais;
	}

	public void setTblpais(Tblpais tblpais) {
		this.tblpais = tblpais;
	}

	public TblthEntidade getTblthEntidade1() {
		return this.tblthEntidade1;
	}

	public void setTblthEntidade1(TblthEntidade tblthEntidade1) {
		this.tblthEntidade1 = tblthEntidade1;
	}

	public TblthEntidade getTblthEntidade2() {
		return this.tblthEntidade2;
	}

	public void setTblthEntidade2(TblthEntidade tblthEntidade2) {
		this.tblthEntidade2 = tblthEntidade2;
	}

	public TblthTipoIdentificacion getTblthTipoIdentificacion() {
		return this.tblthTipoIdentificacion;
	}

	public void setTblthTipoIdentificacion(TblthTipoIdentificacion tblthTipoIdentificacion) {
		this.tblthTipoIdentificacion = tblthTipoIdentificacion;
	}

}