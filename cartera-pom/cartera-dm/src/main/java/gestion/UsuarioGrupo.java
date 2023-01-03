package gestion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario_grupo database table.
 * 
 */
@Entity
@Table(name="usuario_grupo",schema="gestion")
@NamedQuery(name="UsuarioGrupo.findAll", query="SELECT u FROM UsuarioGrupo u")
public class UsuarioGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_GRUPO_USGCODIGO_GENERATOR", sequenceName="GESTION.USUARIO_GRUPO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_GRUPO_USGCODIGO_GENERATOR")
	@Column(name="usg_codigo")
	private Integer usgCodigo;

	//bi-directional one-to-one association to Grupo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usg_grupo")
	private Grupo grupo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usg_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to MenuUsuarioGrupo
	@OneToMany(mappedBy="usuarioGrupo")
	private List<MenuUsuarioGrupo> menuUsuarioGrupos;

	public UsuarioGrupo() {
	}

	public Integer getUsgCodigo() {
		return this.usgCodigo;
	}

	public void setUsgCodigo(Integer usgCodigo) {
		this.usgCodigo = usgCodigo;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<MenuUsuarioGrupo> getMenuUsuarioGrupos() {
		return this.menuUsuarioGrupos;
	}

	public void setMenuUsuarioGrupos(List<MenuUsuarioGrupo> menuUsuarioGrupos) {
		this.menuUsuarioGrupos = menuUsuarioGrupos;
	}

	public MenuUsuarioGrupo addMenuUsuarioGrupo(MenuUsuarioGrupo menuUsuarioGrupo) {
		getMenuUsuarioGrupos().add(menuUsuarioGrupo);
		menuUsuarioGrupo.setUsuarioGrupo(this);

		return menuUsuarioGrupo;
	}

	public MenuUsuarioGrupo removeMenuUsuarioGrupo(MenuUsuarioGrupo menuUsuarioGrupo) {
		getMenuUsuarioGrupos().remove(menuUsuarioGrupo);
		menuUsuarioGrupo.setUsuarioGrupo(null);

		return menuUsuarioGrupo;
	}

}