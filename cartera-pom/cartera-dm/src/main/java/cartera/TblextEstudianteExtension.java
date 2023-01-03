package cartera;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblext_estudiante_extension database table.
 * 
 */
@Entity
@Table(name="tblext_estudiante_extension", schema="academico")
@NamedQuery(name="TblextEstudianteExtension.findAll", query="SELECT t FROM TblextEstudianteExtension t")
public class TblextEstudianteExtension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEXT_ESTUDIANTE_EXTENSION_IDESTUDIANTEEXTENSION_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEXT_ESTUDIANTE_EXTENSION_IDESTUDIANTEEXTENSION_GENERATOR")
	@Column(name="idestudiante_extension", unique=true, nullable=false)
	private Integer idestudianteExtension;

	@Column(length=100)
	private String celular;

	@Column(length=100)
	private String direccion;

	@Column(nullable=false, length=15)
	private String documento;

	@Column(nullable=false)
	private Integer egresado;

	@Column(length=100)
	private String email;

	@Column(nullable=false, length=100)
	private String nombres;

	@Column(name="primer_apellido", nullable=false, length=100)
	private String primerApellido;

	@Column(name="primer_nombre", nullable=false, length=100)
	private String primerNombre;

	@Column(name="segundo_apellido", length=100)
	private String segundoApellido;

	@Column(name="segundo_nombre", length=100)
	private String segundoNombre;

	@Column(length=100)
	private String telefono;

	public TblextEstudianteExtension() {
	}

	public Integer getIdestudianteExtension() {
		return this.idestudianteExtension;
	}

	public void setIdestudianteExtension(Integer idestudianteExtension) {
		this.idestudianteExtension = idestudianteExtension;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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

}