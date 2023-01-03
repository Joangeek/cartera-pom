package talentoHumano;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblth_entidades database table.
 * 
 */
@Entity
@Table(name="tblth_entidades",schema="academico")
@NamedQuery(name="TblthEntidade.findAll", query="SELECT t FROM TblthEntidade t")
public class TblthEntidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLTH_ENTIDADES_IDENTIDAD_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLTH_ENTIDADES_IDENTIDAD_GENERATOR")
	private Integer identidad;

	private String ciudad;

	private String descripcion;

	private String direccion;

	private String email;

	private String nit;

	private String nombre;

	@Column(name="representante_legal")
	private String representanteLegal;

	private String telefono;

	private Integer tipo;

	//bi-directional many-to-one association to TblthTipoEntidad
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="oid")
//	private TblthTipoEntidad tblthTipoEntidad;

	//bi-directional many-to-one association to TblthParticipante
	@OneToMany(mappedBy="tblthEntidade1")
	private List<TblthParticipante> tblthParticipantes1;

	//bi-directional many-to-one association to TblthParticipante
	@OneToMany(mappedBy="tblthEntidade2")
	private List<TblthParticipante> tblthParticipantes2;

	public TblthEntidade() {
	}

	public Integer getIdentidad() {
		return this.identidad;
	}

	public void setIdentidad(Integer identidad) {
		this.identidad = identidad;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRepresentanteLegal() {
		return this.representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

//	public TblthTipoEntidad getTblthTipoEntidad() {
//		return this.tblthTipoEntidad;
//	}
//
//	public void setTblthTipoEntidad(TblthTipoEntidad tblthTipoEntidad) {
//		this.tblthTipoEntidad = tblthTipoEntidad;
//	}

	public List<TblthParticipante> getTblthParticipantes1() {
		return this.tblthParticipantes1;
	}

	public void setTblthParticipantes1(List<TblthParticipante> tblthParticipantes1) {
		this.tblthParticipantes1 = tblthParticipantes1;
	}

	public TblthParticipante addTblthParticipantes1(TblthParticipante tblthParticipantes1) {
		getTblthParticipantes1().add(tblthParticipantes1);
		tblthParticipantes1.setTblthEntidade1(this);

		return tblthParticipantes1;
	}

	public TblthParticipante removeTblthParticipantes1(TblthParticipante tblthParticipantes1) {
		getTblthParticipantes1().remove(tblthParticipantes1);
		tblthParticipantes1.setTblthEntidade1(null);

		return tblthParticipantes1;
	}

	public List<TblthParticipante> getTblthParticipantes2() {
		return this.tblthParticipantes2;
	}

	public void setTblthParticipantes2(List<TblthParticipante> tblthParticipantes2) {
		this.tblthParticipantes2 = tblthParticipantes2;
	}

	public TblthParticipante addTblthParticipantes2(TblthParticipante tblthParticipantes2) {
		getTblthParticipantes2().add(tblthParticipantes2);
		tblthParticipantes2.setTblthEntidade2(this);

		return tblthParticipantes2;
	}

	public TblthParticipante removeTblthParticipantes2(TblthParticipante tblthParticipantes2) {
		getTblthParticipantes2().remove(tblthParticipantes2);
		tblthParticipantes2.setTblthEntidade2(null);

		return tblthParticipantes2;
	}

}