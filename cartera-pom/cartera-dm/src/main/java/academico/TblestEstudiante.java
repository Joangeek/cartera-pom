package academico;

import java.io.Serializable;

import javax.persistence.*;

import cartera.TblDepartamento;
import cartera.TblMunicipio;
import cartera.TblPais;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblest_estudiante database table.
 * 
 */
@Entity
@Table(name="tblest_estudiante",schema="academico")
@NamedQuery(name="TblestEstudiante.findAll", query="SELECT t FROM TblestEstudiante t")
public class TblestEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEST_ESTUDIANTE_OID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEST_ESTUDIANTE_OID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer oid;

	@Column(nullable=false, length=1)
	private String ap;

	@Column(nullable=false, length=100)
	private String apellido1;

	@Column(name="area_tel", nullable=false, length=5)
	private String areaTel;

	private Integer autocontrol;

	@Column(name="bloqueo_encuesta")
	private Integer bloqueoEncuesta;

	@Column(name="bloqueo_financiero")
	private Integer bloqueoFinanciero;

	@Column(length=50)
	private String celular;

	@Column(nullable=false, length=00)
	private String clave;

	@Column(name="cod_ies", nullable=false, length=0)
	private String codIes;

	@Column(name="codigo_id_anterior", length=30)
	private String codigoIdAnterior;

	@Column(name="codigo_unico", nullable=false, length=0)
	private String codigoUnico;

	@Column(length=00)
	private String direccion;

	@Column(length=00)
	private String dirtrabajo;

	@Column(length=00)
	private String email;

	@Column(name="email_inst", length=00)
	private String emailInst;

	@Column(nullable=false)
	private Integer estado;

	@Column(nullable=false, length=1)
	private String estrato;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_bloqueofinanciero")
	private Date fechaBloqueofinanciero;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cambiodocumento")
	private Date fechaCambiodocumento;

	@Temporal(TemporalType.DATE)
	@Column(name="fehca_bloqueoencuesta")
	private Date fehcaBloqueoencuesta;

	@Column(nullable=false, length=1)
	private String idestadocivil;

	@Column(nullable=false)
	private Integer idsede;

	@Column(nullable=false, length=1)
	private String idsexo;

	@Column(name="idtipo_docuemnto", nullable=false, length=3)
	private String idtipoDocuemnto;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date inscripcion;

	@Column(name="lugar_espedicion", length=50)
	private String lugarEspedicion;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date nacimiento;

	@Column(name="nombre_", nullable=false, length=00)
	private String nombre1;

	@Column(length=00)
	private String nombre2;

	@Column(nullable=false, length=00)
	private String nombres;

	@Column(name="pais_tel", nullable=false, length=5)
	private String paisTel;

	@Column(nullable=false, length=00)
	private String telefono;

	@Column(name="tipo_id_anterior", length=3)
	private String tipoIdAnterior;

	//bi-directional many-to-one association to TblacaMatriculado
	@OneToMany(mappedBy="tblestEstudiante")
	private List<TblacaMatriculado> tblacaMatriculado;

	//bi-directional many-to-one association to TblacaMatriculado
	@OneToMany(mappedBy="tblestEstudiante")
	private List<TblacaMatriculado> tblacaMatriculados;

	//bi-directional many-to-one association to TblDepartamento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="departamento_ln")
	private TblDepartamento tblDepartamento;

	//bi-directional many-to-one association to TblMunicipio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="municipio_ln")
	private TblMunicipio tblMunicipio;

	//bi-directional many-to-one association to TblPais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pais_ln", nullable=false)
	private TblPais tblPais;

	//bi-directional many-to-one association to TblestEstudianteH
	@OneToMany(mappedBy="tblestEstudiante")
	private List<TblestEstudianteH> tblestEstudianteHs;

	//bi-directional many-to-one association to TblestEstudiantePrograma
	@OneToMany(mappedBy="tblestEstudiante")
	private List<TblestEstudiantePrograma> tblestEstudianteProgramas;

	public TblestEstudiante() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getAp() {
		return this.ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}
	
	public String getAreaTel() {
		return this.areaTel;
	}

	public void setAreaTel(String areaTel) {
		this.areaTel = areaTel;
	}

	public Integer getAutocontrol() {
		return this.autocontrol;
	}

	public void setAutocontrol(Integer autocontrol) {
		this.autocontrol = autocontrol;
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

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodIes() {
		return this.codIes;
	}

	public void setCodIes(String codIes) {
		this.codIes = codIes;
	}

	public String getCodigoIdAnterior() {
		return this.codigoIdAnterior;
	}

	public void setCodigoIdAnterior(String codigoIdAnterior) {
		this.codigoIdAnterior = codigoIdAnterior;
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

	public String getDirtrabajo() {
		return this.dirtrabajo;
	}

	public void setDirtrabajo(String dirtrabajo) {
		this.dirtrabajo = dirtrabajo;
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

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getEstrato() {
		return this.estrato;
	}

	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}

	public Date getFechaBloqueofinanciero() {
		return this.fechaBloqueofinanciero;
	}

	public void setFechaBloqueofinanciero(Date fechaBloqueofinanciero) {
		this.fechaBloqueofinanciero = fechaBloqueofinanciero;
	}

	public Date getFechaCambiodocumento() {
		return this.fechaCambiodocumento;
	}

	public void setFechaCambiodocumento(Date fechaCambiodocumento) {
		this.fechaCambiodocumento = fechaCambiodocumento;
	}

	public Date getFehcaBloqueoencuesta() {
		return this.fehcaBloqueoencuesta;
	}

	public void setFehcaBloqueoencuesta(Date fehcaBloqueoencuesta) {
		this.fehcaBloqueoencuesta = fehcaBloqueoencuesta;
	}

	public String getIdestadocivil() {
		return this.idestadocivil;
	}

	public void setIdestadocivil(String idestadocivil) {
		this.idestadocivil = idestadocivil;
	}

	public Integer getIdsede() {
		return this.idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
	}

	public String getIdsexo() {
		return this.idsexo;
	}

	public void setIdsexo(String idsexo) {
		this.idsexo = idsexo;
	}

	public String getIdtipoDocuemnto() {
		return this.idtipoDocuemnto;
	}

	public void setIdtipoDocuemnto(String idtipoDocuemnto) {
		this.idtipoDocuemnto = idtipoDocuemnto;
	}

	public Date getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Date inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getLugarEspedicion() {
		return this.lugarEspedicion;
	}

	public void setLugarEspedicion(String lugarEspedicion) {
		this.lugarEspedicion = lugarEspedicion;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaisTel() {
		return this.paisTel;
	}

	public void setPaisTel(String paisTel) {
		this.paisTel = paisTel;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoIdAnterior() {
		return this.tipoIdAnterior;
	}

	public void setTipoIdAnterior(String tipoIdAnterior) {
		this.tipoIdAnterior = tipoIdAnterior;
	}

	public List<TblacaMatriculado> getTblacaMatriculados() {
		return this.tblacaMatriculados;
	}

	public void setTblacaMatriculados(List<TblacaMatriculado> tblacaMatriculados) {
		this.tblacaMatriculados = tblacaMatriculados;
	}

	public TblacaMatriculado addTblacaMatriculados(TblacaMatriculado tblacaMatriculados) {
		getTblacaMatriculados().add(tblacaMatriculados);
		tblacaMatriculados.setTblestEstudiante(this);

		return tblacaMatriculados;
	}

	public TblacaMatriculado removeTblacaMatriculados(TblacaMatriculado tblacaMatriculados) {
		getTblacaMatriculados().remove(tblacaMatriculados);
		tblacaMatriculados.setTblestEstudiante(null);

		return tblacaMatriculados;
	}

	public TblDepartamento getTblDepartamento() {
		return this.tblDepartamento;
	}

	public void setTblDepartamento(TblDepartamento tblDepartamento) {
		this.tblDepartamento = tblDepartamento;
	}

	public TblMunicipio getTblMunicipio() {
		return this.tblMunicipio;
	}

	public void setTblMunicipio(TblMunicipio tblMunicipio) {
		this.tblMunicipio = tblMunicipio;
	}

	public TblPais getTblPais() {
		return this.tblPais;
	}

	public void setTblPais(TblPais tblPais) {
		this.tblPais = tblPais;
	}

	public List<TblestEstudianteH> getTblestEstudianteHs() {
		return this.tblestEstudianteHs;
	}

	public void setTblestEstudianteHs(List<TblestEstudianteH> tblestEstudianteHs) {
		this.tblestEstudianteHs = tblestEstudianteHs;
	}

	public TblestEstudianteH addTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().add(tblestEstudianteH);
		tblestEstudianteH.setTblestEstudiante(this);

		return tblestEstudianteH;
	}

	public TblestEstudianteH removeTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().remove(tblestEstudianteH);
		tblestEstudianteH.setTblestEstudiante(null);

		return tblestEstudianteH;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public List<TblacaMatriculado> getTblacaMatriculado() {
		return tblacaMatriculado;
	}

	public void setTblacaMatriculado(List<TblacaMatriculado> tblacaMatriculado) {
		this.tblacaMatriculado = tblacaMatriculado;
	}

	public List<TblestEstudiantePrograma> getTblestEstudianteProgramas() {
		return tblestEstudianteProgramas;
	}

	public void setTblestEstudianteProgramas(
			List<TblestEstudiantePrograma> tblestEstudianteProgramas) {
		this.tblestEstudianteProgramas = tblestEstudianteProgramas;
	}

}