package gestion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu_user_gru_per database table.
 * 
 */
@Entity
@Table(name="menu_user_gru_per",schema = "gestion")
@NamedQuery(name="MenuUserGruPer.findAll", query="SELECT m FROM MenuUserGruPer m")
public class MenuUserGruPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MENU_USER_GRU_PER_OID_GENERATOR", sequenceName="MENU_USER_GRU_PER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MENU_USER_GRU_PER_OID_GENERATOR")
	private Integer oid;

//	@Column(name="iduser_grup")
//	private Integer iduserGrup;

	//bi-directional one-to-one association to MenuUsuarioGrupo
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iduser_grup")
	private MenuUsuarioGrupo menuUsuarioGrupo;

	//bi-directional many-to-one association to Permiso
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idpermiso")
	private Permiso permiso;

	public MenuUserGruPer() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

//	public Integer getIduserGrup() {
//		return this.iduserGrup;
//	}
//
//	public void setIduserGrup(Integer iduserGrup) {
//		this.iduserGrup = iduserGrup;
//	}

	public MenuUsuarioGrupo getMenuUsuarioGrupo() {
		return this.menuUsuarioGrupo;
	}

	public void setMenuUsuarioGrupo(MenuUsuarioGrupo menuUsuarioGrupo) {
		this.menuUsuarioGrupo = menuUsuarioGrupo;
	}

	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

}