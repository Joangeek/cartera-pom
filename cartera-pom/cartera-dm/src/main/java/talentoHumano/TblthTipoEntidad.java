package talentoHumano;

import java.io.Serializable;
import javax.persistence.*;
//import java.util.List;


/**
 * The persistent class for the tblth_tipo_entidad database table.
 * 
 */
@Entity
@Table(name="tblth_tipo_entidad",schema="academico")
@NamedQuery(name="TblthTipoEntidad.findAll", query="SELECT t FROM TblthTipoEntidad t")
public class TblthTipoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLTH_TIPO_ENTIDAD_OID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLTH_TIPO_ENTIDAD_OID_GENERATOR")
	private Integer oid;

	private Integer estado;

	private String nombre;

	//bi-directional many-to-one association to TblthEntidade
//	@OneToMany(mappedBy="tblthTipoEntidad")
//	private List<TblthEntidade> tblthEntidades;

	public TblthTipoEntidad() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public List<TblthEntidade> getTblthEntidades() {
//		return this.tblthEntidades;
//	}
//
//	public void setTblthEntidades(List<TblthEntidade> tblthEntidades) {
//		this.tblthEntidades = tblthEntidades;
//	}

//	public TblthEntidade addTblthEntidade(TblthEntidade tblthEntidade) {
//		getTblthEntidades().add(tblthEntidade);
//		tblthEntidade.setTblthTipoEntidad(this);
//
//		return tblthEntidade;
//	}
//
//	public TblthEntidade removeTblthEntidade(TblthEntidade tblthEntidade) {
//		getTblthEntidades().remove(tblthEntidade);
//		tblthEntidade.setTblthTipoEntidad(null);
//
//		return tblthEntidade;
//	}

}