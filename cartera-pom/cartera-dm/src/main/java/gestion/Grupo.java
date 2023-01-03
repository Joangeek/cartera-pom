package gestion;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@Table(name="grupo",schema = "gestion")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRUPO_GRUCODIGO_GENERATOR", sequenceName="GESTION.GRUPO_GRU_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPO_GRUCODIGO_GENERATOR")
	@Column(name="gru_codigo")
	private Integer gruCodigo;

	@Column(name="gru_id")
	private String gruId;

	@Column(name="gru_nombre")
	private String gruNombre;

	// bi-directional many-to-one association to UsuarioGrupo
	@OneToMany(mappedBy = "grupo")
	private List<UsuarioGrupo> usuarioGrupos;

	public Grupo() {
	}

	public Integer getGruCodigo() {
		return this.gruCodigo;
	}

	public void setGruCodigo(Integer gruCodigo) {
		this.gruCodigo = gruCodigo;
	}

	public String getGruId() {
		return this.gruId;
	}

	public void setGruId(String gruId) {
		this.gruId = gruId;
	}

	public String getGruNombre() {
		return this.gruNombre;
	}

	public void setGruNombre(String gruNombre) {
		this.gruNombre = gruNombre;
	}

	public List<UsuarioGrupo> getUsuarioGrupos() {
		return usuarioGrupos;
	}

	public void setUsuarioGrupos(List<UsuarioGrupo> usuarioGrupos) {
		this.usuarioGrupos = usuarioGrupos;
	}

}