package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tblext_inscripcion_extension database table.
 * 
 */
@Entity
@Table(name="tblext_inscripcion_extension", schema="academico")
@NamedQuery(name="TblextInscripcionExtension.findAll", query="SELECT t FROM TblextInscripcionExtension t")
public class TblextInscripcionExtension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEXT_INSCRIPCION_EXTENSION_IDINSCRIPCION_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEXT_INSCRIPCION_EXTENSION_IDINSCRIPCION_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idinscripcion;

	@Column(nullable=false)
	private Integer ap;

	@Column(nullable=false, length=100)
	private String barrio;

	@Column(nullable=false, length=20)
	private String celular;

	@Column(name="departamento_ln", nullable=false)
	private Integer departamentoLn;

	@Column(name="descuento_aplicado")
	private Integer descuentoAplicado;

	@Column(nullable=false, length=100)
	private String direccion;

	@Column(nullable=false, length=30)
	private String documento;

	@Column(nullable=false)
	private Integer egresado;

	@Column(nullable=false, length=100)
	private String email;

	@Column(name="email_empresa", length=200)
	private String emailEmpresa;

	@Column(name="empresa_antiguedadlaboral", length=100)
	private String empresaAntiguedadlaboral;

	@Column(name="empresa_cargoactual", length=100)
	private String empresaCargoactual;

	@Column(name="empresa_celular", length=20)
	private String empresaCelular;

	@Column(name="empresa_departamento")
	private Integer empresaDepartamento;

	@Column(name="empresa_direccion", length=500)
	private String empresaDireccion;

	@Column(name="empresa_financiacion", nullable=false, length=20)
	private String empresaFinanciacion;

	@Column(name="empresa_municipio")
	private Integer empresaMunicipio;

	@Column(name="empresa_nombre", length=200)
	private String empresaNombre;

	@Column(name="empresa_telefono")
	private Integer empresaTelefono;

	@Column(name="empresa_trabaja", nullable=false, length=10)
	private String empresaTrabaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_graduacion", nullable=false)
	private Date fechaGraduacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inscripcion", nullable=false)
	private Date fechaInscripcion;

	@Column(nullable=false, length=25)
	private String genero;

	@Column(nullable=false, length=500)
	private String idaviso;

	@Column(name="idcaja_compensacion_familiar", nullable=false)
	private Integer idcajaCompensacionFamiliar;

	@Column(name="idcategoria_comfa", nullable=false)
	private Integer idcategoriaComfa;

	@Column(name="idtipo_beneficiario_edcontinuada", nullable=false)
	private Integer idtipoBeneficiarioEdcontinuada;

	@Column(name="lugar_expedicion", nullable=false, length=35)
	private String lugarExpedicion;

	@Column(name="medio_publicidad", nullable=false, length=50)
	private String medioPublicidad;

	@Column(name="municipio_ln", nullable=false)
	private Integer municipioLn;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date nacimiento;

	@Column(name="nivel_escolar", nullable=false)
	private Integer nivelEscolar;

	@Column(name="nombre_universidad", nullable=false, length=500)
	private String nombreUniversidad;

	@Column(nullable=false, length=100)
	private String nombres;

	@Column(length=500)
	private String observaciones;

	@Column(name="otro_medio", length=100)
	private String otroMedio;

	@Column(name="otros_estudios", length=2000)
	private String otrosEstudios;

	@Column(name="primer_apellido", nullable=false, length=100)
	private String primerApellido;

	@Column(name="primer_nombre", nullable=false, length=100)
	private String primerNombre;

	@Column(name="segundo_apellido", length=100)
	private String segundoApellido;

	@Column(name="segundo_nombre", length=100)
	private String segundoNombre;

	@Column(nullable=false, length=100)
	private String telefono;

	@Column(name="tipo_cliente", nullable=false)
	private Integer tipoCliente;

	@Column(name="tipo_ident_code", nullable=false, length=10)
	private String tipoIdentCode;

	@Column(name="titulo_profesional", nullable=false, length=500)
	private String tituloProfesional;

	//bi-directional many-to-one association to TblextCursosExtensionH
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcurso_h", nullable=false)
	private TblextCursosExtensionH tblextCursosExtensionH;

	//bi-directional many-to-one association to TblmerEstrato
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estrato", nullable=false)
	private TblmerEstrato tblmerEstrato;

	public TblextInscripcionExtension() {
	}

	public Integer getIdinscripcion() {
		return this.idinscripcion;
	}

	public void setIdinscripcion(Integer idinscripcion) {
		this.idinscripcion = idinscripcion;
	}

	public Integer getAp() {
		return this.ap;
	}

	public void setAp(Integer ap) {
		this.ap = ap;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getDepartamentoLn() {
		return this.departamentoLn;
	}

	public void setDepartamentoLn(Integer departamentoLn) {
		this.departamentoLn = departamentoLn;
	}

	public Integer getDescuentoAplicado() {
		return this.descuentoAplicado;
	}

	public void setDescuentoAplicado(Integer descuentoAplicado) {
		this.descuentoAplicado = descuentoAplicado;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getEgresado() {
		return this.egresado;
	}

	public void setEgresado(Integer egresado) {
		this.egresado = egresado;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailEmpresa() {
		return this.emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public String getEmpresaAntiguedadlaboral() {
		return this.empresaAntiguedadlaboral;
	}

	public void setEmpresaAntiguedadlaboral(String empresaAntiguedadlaboral) {
		this.empresaAntiguedadlaboral = empresaAntiguedadlaboral;
	}

	public String getEmpresaCargoactual() {
		return this.empresaCargoactual;
	}

	public void setEmpresaCargoactual(String empresaCargoactual) {
		this.empresaCargoactual = empresaCargoactual;
	}

	public String getEmpresaCelular() {
		return this.empresaCelular;
	}

	public void setEmpresaCelular(String empresaCelular) {
		this.empresaCelular = empresaCelular;
	}

	public Integer getEmpresaDepartamento() {
		return this.empresaDepartamento;
	}

	public void setEmpresaDepartamento(Integer empresaDepartamento) {
		this.empresaDepartamento = empresaDepartamento;
	}

	public String getEmpresaDireccion() {
		return this.empresaDireccion;
	}

	public void setEmpresaDireccion(String empresaDireccion) {
		this.empresaDireccion = empresaDireccion;
	}

	public String getEmpresaFinanciacion() {
		return this.empresaFinanciacion;
	}

	public void setEmpresaFinanciacion(String empresaFinanciacion) {
		this.empresaFinanciacion = empresaFinanciacion;
	}

	public Integer getEmpresaMunicipio() {
		return this.empresaMunicipio;
	}

	public void setEmpresaMunicipio(Integer empresaMunicipio) {
		this.empresaMunicipio = empresaMunicipio;
	}

	public String getEmpresaNombre() {
		return this.empresaNombre;
	}

	public void setEmpresaNombre(String empresaNombre) {
		this.empresaNombre = empresaNombre;
	}

	public Integer getEmpresaTelefono() {
		return this.empresaTelefono;
	}

	public void setEmpresaTelefono(Integer empresaTelefono) {
		this.empresaTelefono = empresaTelefono;
	}

	public String getEmpresaTrabaja() {
		return this.empresaTrabaja;
	}

	public void setEmpresaTrabaja(String empresaTrabaja) {
		this.empresaTrabaja = empresaTrabaja;
	}

	public Date getFechaGraduacion() {
		return this.fechaGraduacion;
	}

	public void setFechaGraduacion(Date fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}

	public Date getFechaInscripcion() {
		return this.fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdaviso() {
		return this.idaviso;
	}

	public void setIdaviso(String idaviso) {
		this.idaviso = idaviso;
	}

	public Integer getIdcajaCompensacionFamiliar() {
		return this.idcajaCompensacionFamiliar;
	}

	public void setIdcajaCompensacionFamiliar(Integer idcajaCompensacionFamiliar) {
		this.idcajaCompensacionFamiliar = idcajaCompensacionFamiliar;
	}

	public Integer getIdcategoriaComfa() {
		return this.idcategoriaComfa;
	}

	public void setIdcategoriaComfa(Integer idcategoriaComfa) {
		this.idcategoriaComfa = idcategoriaComfa;
	}

	public Integer getIdtipoBeneficiarioEdcontinuada() {
		return this.idtipoBeneficiarioEdcontinuada;
	}

	public void setIdtipoBeneficiarioEdcontinuada(Integer idtipoBeneficiarioEdcontinuada) {
		this.idtipoBeneficiarioEdcontinuada = idtipoBeneficiarioEdcontinuada;
	}

	public String getLugarExpedicion() {
		return this.lugarExpedicion;
	}

	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}

	public String getMedioPublicidad() {
		return this.medioPublicidad;
	}

	public void setMedioPublicidad(String medioPublicidad) {
		this.medioPublicidad = medioPublicidad;
	}

	public Integer getMunicipioLn() {
		return this.municipioLn;
	}

	public void setMunicipioLn(Integer municipioLn) {
		this.municipioLn = municipioLn;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Integer getNivelEscolar() {
		return this.nivelEscolar;
	}

	public void setNivelEscolar(Integer nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}

	public String getNombreUniversidad() {
		return this.nombreUniversidad;
	}

	public void setNombreUniversidad(String nombreUniversidad) {
		this.nombreUniversidad = nombreUniversidad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOtroMedio() {
		return this.otroMedio;
	}

	public void setOtroMedio(String otroMedio) {
		this.otroMedio = otroMedio;
	}

	public String getOtrosEstudios() {
		return this.otrosEstudios;
	}

	public void setOtrosEstudios(String otrosEstudios) {
		this.otrosEstudios = otrosEstudios;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTipoIdentCode() {
		return this.tipoIdentCode;
	}

	public void setTipoIdentCode(String tipoIdentCode) {
		this.tipoIdentCode = tipoIdentCode;
	}

	public String getTituloProfesional() {
		return this.tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public TblextCursosExtensionH getTblextCursosExtensionH() {
		return this.tblextCursosExtensionH;
	}

	public void setTblextCursosExtensionH(TblextCursosExtensionH tblextCursosExtensionH) {
		this.tblextCursosExtensionH = tblextCursosExtensionH;
	}

	public TblmerEstrato getTblmerEstrato() {
		return this.tblmerEstrato;
	}

	public void setTblmerEstrato(TblmerEstrato tblmerEstrato) {
		this.tblmerEstrato = tblmerEstrato;
	}

}