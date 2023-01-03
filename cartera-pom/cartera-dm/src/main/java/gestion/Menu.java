package gestion;

import java.io.Serializable;

import javax.persistence.*;

;

/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name = "menu", schema = "gestion")
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MENU_OID_GENERATOR", sequenceName = "GESTION.MENU_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_OID_GENERATOR")
	private Integer oid;

	private String descripcion;

	private String icono;

	private String nombre;

	private String ruta;

	private String tipo;

	private Integer estado;

	private Integer orden;

	@ManyToOne
	@JoinColumn(name = "submenu")
	private Menu submenu;

	public Menu() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Menu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(Menu submenu) {
		this.submenu = submenu;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}