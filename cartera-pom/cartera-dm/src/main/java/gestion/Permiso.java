package gestion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permisos database table.
 * 
 */
@Entity
@Table(name="permisos",schema="gestion")
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERMISOS_OID_GENERATOR", sequenceName="GESTION.PERMISOS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISOS_OID_GENERATOR")
	private Integer oid;

	private String accion;

	private String descripcion;

	private Integer estado;

	//bi-directional many-to-one association to MenuUserGruPer
	@OneToMany(mappedBy="permiso")
	private List<MenuUserGruPer> menuUserGruPers;

	public Permiso() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<MenuUserGruPer> getMenuUserGruPers() {
		return this.menuUserGruPers;
	}

	public void setMenuUserGruPers(List<MenuUserGruPer> menuUserGruPers) {
		this.menuUserGruPers = menuUserGruPers;
	}

	public MenuUserGruPer addMenuUserGruPer(MenuUserGruPer menuUserGruPer) {
		getMenuUserGruPers().add(menuUserGruPer);
		menuUserGruPer.setPermiso(this);

		return menuUserGruPer;
	}

	public MenuUserGruPer removeMenuUserGruPer(MenuUserGruPer menuUserGruPer) {
		getMenuUserGruPers().remove(menuUserGruPer);
		menuUserGruPer.setPermiso(null);

		return menuUserGruPer;
	}

}