package gestion;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the menu_usuario_grupo database table.
 * 
 */
@Entity
@Table(name="menu_usuario_grupo", schema="gestion")
@NamedQuery(name="MenuUsuarioGrupo.findAll", query="SELECT m FROM MenuUsuarioGrupo m")
public class MenuUsuarioGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENU_USUARIO_GRUPO_OID_GENERATOR", sequenceName="GESTION.MENU_USUARIO_GRUPO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENU_USUARIO_GRUPO_OID_GENERATOR")
	private Integer oid;

	//bi-directional one-to-one association to MenuUserGruPer
	@OneToMany(mappedBy="menuUsuarioGrupo")
	private List<MenuUserGruPer> menuUserGruPers;

	//bi-directional many-to-one association to MenuUserGruPer
//		@OneToMany(mappedBy="permiso")
//		private List<MenuUserGruPer> menuUserGruPers;
	
	//bi-directional many-to-one association to Menu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idmenu")
	private Menu menu;

	//bi-directional many-to-one association to UsuarioGrupo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idgrupo_usuario")
	private UsuarioGrupo usuarioGrupo;

	public MenuUsuarioGrupo() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public List<MenuUserGruPer> getMenuUserGruPers() {
		return menuUserGruPers;
	}

	public void setMenuUserGruPers(List<MenuUserGruPer> menuUserGruPers) {
		this.menuUserGruPers = menuUserGruPers;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public UsuarioGrupo getUsuarioGrupo() {
		return this.usuarioGrupo;
	}

	public void setUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
		this.usuarioGrupo = usuarioGrupo;
	}

}