package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblext_tipo_curso_edcont database table.
 * 
 */
@Entity
@Table(name="tblext_tipo_curso_edcont", schema="academico")
@NamedQuery(name="TblextTipoCursoEdcont.findAll", query="SELECT t FROM TblextTipoCursoEdcont t")
public class TblextTipoCursoEdcont implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEXT_TIPO_CURSO_EDCONT_IDCURSOEDCONTINUADA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEXT_TIPO_CURSO_EDCONT_IDCURSOEDCONTINUADA_GENERATOR")
	@Column(name="idcurso_edcontinuada", unique=true, nullable=false)
	private Integer idcursoEdcontinuada;

	@Column(nullable=false)
	private Integer estado;

	@Column(name="nombre_curso", nullable=false, length=100)
	private String nombreCurso;

	//bi-directional many-to-one association to TblextCursosExtensionH
	@OneToMany(mappedBy="tblextTipoCursoEdcont")
	private List<TblextCursosExtensionH> tblextCursosExtensionHs;

	public TblextTipoCursoEdcont() {
	}

	public Integer getIdcursoEdcontinuada() {
		return this.idcursoEdcontinuada;
	}

	public void setIdcursoEdcontinuada(Integer idcursoEdcontinuada) {
		this.idcursoEdcontinuada = idcursoEdcontinuada;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombreCurso() {
		return this.nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public List<TblextCursosExtensionH> getTblextCursosExtensionHs() {
		return this.tblextCursosExtensionHs;
	}

	public void setTblextCursosExtensionHs(List<TblextCursosExtensionH> tblextCursosExtensionHs) {
		this.tblextCursosExtensionHs = tblextCursosExtensionHs;
	}

	public TblextCursosExtensionH addTblextCursosExtensionH(TblextCursosExtensionH tblextCursosExtensionH) {
		getTblextCursosExtensionHs().add(tblextCursosExtensionH);
		tblextCursosExtensionH.setTblextTipoCursoEdcont(this);

		return tblextCursosExtensionH;
	}

	public TblextCursosExtensionH removeTblextCursosExtensionH(TblextCursosExtensionH tblextCursosExtensionH) {
		getTblextCursosExtensionHs().remove(tblextCursosExtensionH);
		tblextCursosExtensionH.setTblextTipoCursoEdcont(null);

		return tblextCursosExtensionH;
	}

}