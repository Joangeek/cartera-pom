package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblestEstudianteH;

import java.util.List;


/**
 * The persistent class for the tblmer_categoria_comfacauca database table.
 * 
 */
@Entity
@Table(name="tblmer_categoria_comfacauca", schema="academico")
@NamedQuery(name="TblmerCategoriaComfacauca.findAll", query="SELECT t FROM TblmerCategoriaComfacauca t")
public class TblmerCategoriaComfacauca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLMER_CATEGORIA_COMFACAUCA_IDCATECOMFA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLMER_CATEGORIA_COMFACAUCA_IDCATECOMFA_GENERATOR")
	@Column(name="idcate_comfa", unique=true, nullable=false)
	private Integer idcateComfa;

	@Column(nullable=false, length=20)
	private String codigo;

	@Column(nullable=false)
	private Integer estado;

	@Column(length=1)
	private String sigla;

	@Column(nullable=false, length=20)
	private String usuario;

	//bi-directional many-to-one association to TblestEstudianteH
	@OneToMany(mappedBy="tblmerCategoriaComfacauca")
	private List<TblestEstudianteH> tblestEstudianteHs;

	//bi-directional many-to-one association to TblfinTarifaMatricula
	@OneToMany(mappedBy="tblmerCategoriaComfacauca")
	private List<TblfinTarifaMatricula> tblfinTarifaMatriculas;

	public TblmerCategoriaComfacauca() {
	}

	public Integer getIdcateComfa() {
		return this.idcateComfa;
	}

	public void setIdcateComfa(Integer idcateComfa) {
		this.idcateComfa = idcateComfa;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<TblestEstudianteH> getTblestEstudianteHs() {
		return this.tblestEstudianteHs;
	}

	public void setTblestEstudianteHs(List<TblestEstudianteH> tblestEstudianteHs) {
		this.tblestEstudianteHs = tblestEstudianteHs;
	}

	public TblestEstudianteH addTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().add(tblestEstudianteH);
		tblestEstudianteH.setTblmerCategoriaComfacauca(this);

		return tblestEstudianteH;
	}

	public TblestEstudianteH removeTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().remove(tblestEstudianteH);
		tblestEstudianteH.setTblmerCategoriaComfacauca(null);

		return tblestEstudianteH;
	}

	public List<TblfinTarifaMatricula> getTblfinTarifaMatriculas() {
		return this.tblfinTarifaMatriculas;
	}

	public void setTblfinTarifaMatriculas(List<TblfinTarifaMatricula> tblfinTarifaMatriculas) {
		this.tblfinTarifaMatriculas = tblfinTarifaMatriculas;
	}

	public TblfinTarifaMatricula addTblfinTarifaMatricula(TblfinTarifaMatricula tblfinTarifaMatricula) {
		getTblfinTarifaMatriculas().add(tblfinTarifaMatricula);
		tblfinTarifaMatricula.setTblmerCategoriaComfacauca(this);

		return tblfinTarifaMatricula;
	}

	public TblfinTarifaMatricula removeTblfinTarifaMatricula(TblfinTarifaMatricula tblfinTarifaMatricula) {
		getTblfinTarifaMatriculas().remove(tblfinTarifaMatricula);
		tblfinTarifaMatricula.setTblmerCategoriaComfacauca(null);

		return tblfinTarifaMatricula;
	}

}