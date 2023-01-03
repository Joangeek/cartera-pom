package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblestEstudianteH;

import java.util.List;


/**
 * The persistent class for the tblmer_estrato database table.
 * 
 */
@Entity
@Table(name="tblmer_estrato", schema="academico")
@NamedQuery(name="TblmerEstrato.findAll", query="SELECT t FROM TblmerEstrato t")
public class TblmerEstrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLMER_ESTRATO_ESTRATOCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLMER_ESTRATO_ESTRATOCODE_GENERATOR")
	@Column(name="estrato_code", unique=true, nullable=false, length=2)
	private String estratoCode;

	@Column(name="estrato_descr", length=10)
	private String estratoDescr;

	//bi-directional many-to-one association to TblestEstudianteH
	@OneToMany(mappedBy="tblmerEstrato")
	private List<TblestEstudianteH> tblestEstudianteHs;

	//bi-directional many-to-one association to TblextInscripcionExtension
	@OneToMany(mappedBy="tblmerEstrato")
	private List<TblextInscripcionExtension> tblextInscripcionExtensions;

	public TblmerEstrato() {
	}

	public String getEstratoCode() {
		return this.estratoCode;
	}

	public void setEstratoCode(String estratoCode) {
		this.estratoCode = estratoCode;
	}

	public String getEstratoDescr() {
		return this.estratoDescr;
	}

	public void setEstratoDescr(String estratoDescr) {
		this.estratoDescr = estratoDescr;
	}

	public List<TblestEstudianteH> getTblestEstudianteHs() {
		return this.tblestEstudianteHs;
	}

	public void setTblestEstudianteHs(List<TblestEstudianteH> tblestEstudianteHs) {
		this.tblestEstudianteHs = tblestEstudianteHs;
	}

	public TblestEstudianteH addTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().add(tblestEstudianteH);
		tblestEstudianteH.setTblmerEstrato(this);

		return tblestEstudianteH;
	}

	public TblestEstudianteH removeTblestEstudianteH(TblestEstudianteH tblestEstudianteH) {
		getTblestEstudianteHs().remove(tblestEstudianteH);
		tblestEstudianteH.setTblmerEstrato(null);

		return tblestEstudianteH;
	}

	public List<TblextInscripcionExtension> getTblextInscripcionExtensions() {
		return this.tblextInscripcionExtensions;
	}

	public void setTblextInscripcionExtensions(List<TblextInscripcionExtension> tblextInscripcionExtensions) {
		this.tblextInscripcionExtensions = tblextInscripcionExtensions;
	}

	public TblextInscripcionExtension addTblextInscripcionExtension(TblextInscripcionExtension tblextInscripcionExtension) {
		getTblextInscripcionExtensions().add(tblextInscripcionExtension);
		tblextInscripcionExtension.setTblmerEstrato(this);

		return tblextInscripcionExtension;
	}

	public TblextInscripcionExtension removeTblextInscripcionExtension(TblextInscripcionExtension tblextInscripcionExtension) {
		getTblextInscripcionExtensions().remove(tblextInscripcionExtension);
		tblextInscripcionExtension.setTblmerEstrato(null);

		return tblextInscripcionExtension;
	}

}