package gestion;

import java.io.Serializable;

import javax.persistence.*;

import talentoHumano.TblthParticipante;

import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario", schema = "gestion")
@NamedQueries({
		@NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u JOIN u.idparticipante p WHERE u.usuLogin=:codigo AND u.estado=1 "),
		@NamedQuery(name = "Usuario.acceso", query = "SELECT u FROM Usuario u JOIN fetch  u.idparticipante WHERE u.usuLogin=:login AND u.usuPassword=:password AND u.estado=1 ") })
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USUARIO_USUCODIGO_GENERATOR", sequenceName = "GESTION.USUARIO_USU_CODIGO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_USUCODIGO_GENERATOR")
	@Column(name = "usu_codigo")
	private Integer usuCodigo;

	private Integer estado;

	// bi-directional many-to-one association to Tblpais
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idparticipante")
	private TblthParticipante idparticipante;

	@Column(name = "usu_login")
	private String usuLogin;

	@Column(name = "usu_password")
	private String usuPassword;

	// bi-directional many-to-one association to UsuarioGrupo
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioGrupo> usuarioGrupos;

	public Usuario() {
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getUsuLogin() {
		return this.usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public List<UsuarioGrupo> getUsuarioGrupos() {
		return this.usuarioGrupos;
	}

	public void setUsuarioGrupos(List<UsuarioGrupo> usuarioGrupos) {
		this.usuarioGrupos = usuarioGrupos;
	}

	public UsuarioGrupo addUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
		getUsuarioGrupos().add(usuarioGrupo);
		usuarioGrupo.setUsuario(this);

		return usuarioGrupo;
	}

	public UsuarioGrupo removeUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
		getUsuarioGrupos().remove(usuarioGrupo);
		usuarioGrupo.setUsuario(null);

		return usuarioGrupo;
	}

	public TblthParticipante getIdparticipante() {
		return idparticipante;
	}

	public void setIdparticipante(TblthParticipante idparticipante) {
		this.idparticipante = idparticipante;
	}

}