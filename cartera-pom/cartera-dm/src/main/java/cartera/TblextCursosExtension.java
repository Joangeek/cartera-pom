package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tblext_cursos_extension database table.
 * 
 */
@Entity
@Table(name="tblext_cursos_extension", schema="academico")
@NamedQuery(name="TblextCursosExtension.findAll", query="SELECT t FROM TblextCursosExtension t")
public class TblextCursosExtension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEXT_CURSOS_EXTENSION_IDCURSOEXT_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEXT_CURSOS_EXTENSION_IDCURSOEXT_GENERATOR")
	@Column(name="id_curso_ext", unique=true, nullable=false)
	private Integer idCursoExt;

	@Column(length=2)
	private String activo;

	@Column(name="curso_cod", nullable=false, length=10)
	private String cursoCod;

	@Column(name="curso_nombre", nullable=false, length=500)
	private String cursoNombre;

	@Column(name="es_extension", length=2)
	private String esExtension;

	@Column(name="id_tipo_nbc_snies", nullable=false)
	private Integer idTipoNbcSnies;

	@Column(length=2)
	private String idnivelestudio;

	@Column(name="ies_code", nullable=false, length=10)
	private String iesCode;

	@Column(name="nbc_code", nullable=false, precision=3)
	private BigDecimal nbcCode;

	@Column(length=2147483647)
	private String objetivos;

	@Column(name="observacion_curso_inactivo", nullable=false, length=500)
	private String observacionCursoInactivo;

	@Column(length=2147483647)
	private String perfil;

	//bi-directional many-to-one association to TblextCursosExtensionH
	@OneToMany(mappedBy="tblextCursosExtension")
	private List<TblextCursosExtensionH> tblextCursosExtensionHs;

	public TblextCursosExtension() {
	}

	public Integer getIdCursoExt() {
		return this.idCursoExt;
	}

	public void setIdCursoExt(Integer idCursoExt) {
		this.idCursoExt = idCursoExt;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCursoCod() {
		return this.cursoCod;
	}

	public void setCursoCod(String cursoCod) {
		this.cursoCod = cursoCod;
	}

	public String getCursoNombre() {
		return this.cursoNombre;
	}

	public void setCursoNombre(String cursoNombre) {
		this.cursoNombre = cursoNombre;
	}

	public String getEsExtension() {
		return this.esExtension;
	}

	public void setEsExtension(String esExtension) {
		this.esExtension = esExtension;
	}

	public Integer getIdTipoNbcSnies() {
		return this.idTipoNbcSnies;
	}

	public void setIdTipoNbcSnies(Integer idTipoNbcSnies) {
		this.idTipoNbcSnies = idTipoNbcSnies;
	}

	public String getIdnivelestudio() {
		return this.idnivelestudio;
	}

	public void setIdnivelestudio(String idnivelestudio) {
		this.idnivelestudio = idnivelestudio;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public BigDecimal getNbcCode() {
		return this.nbcCode;
	}

	public void setNbcCode(BigDecimal nbcCode) {
		this.nbcCode = nbcCode;
	}

	public String getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getObservacionCursoInactivo() {
		return this.observacionCursoInactivo;
	}

	public void setObservacionCursoInactivo(String observacionCursoInactivo) {
		this.observacionCursoInactivo = observacionCursoInactivo;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<TblextCursosExtensionH> getTblextCursosExtensionHs() {
		return this.tblextCursosExtensionHs;
	}

	public void setTblextCursosExtensionHs(List<TblextCursosExtensionH> tblextCursosExtensionHs) {
		this.tblextCursosExtensionHs = tblextCursosExtensionHs;
	}

	public TblextCursosExtensionH addTblextCursosExtensionH(TblextCursosExtensionH tblextCursosExtensionH) {
		getTblextCursosExtensionHs().add(tblextCursosExtensionH);
		tblextCursosExtensionH.setTblextCursosExtension(this);

		return tblextCursosExtensionH;
	}

	public TblextCursosExtensionH removeTblextCursosExtensionH(TblextCursosExtensionH tblextCursosExtensionH) {
		getTblextCursosExtensionHs().remove(tblextCursosExtensionH);
		tblextCursosExtensionH.setTblextCursosExtension(null);

		return tblextCursosExtensionH;
	}

}