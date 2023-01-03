package academico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblaca_nivel_estudio database table.
 * 
 */
@Entity
@Table(name="tblaca_nivel_estudio", schema="academico")
@NamedQuery(name="TblacaNivelEstudio.findAll", query="SELECT t FROM TblacaNivelEstudio t")
public class TblacaNivelEstudio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_NIVEL_ESTUDIO_NIVELCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_NIVEL_ESTUDIO_NIVELCODE_GENERATOR")
	@Column(name="nivel_code", unique=true, nullable=false, length=2)
	private String nivelCode;

	@Column(name="nivel_descr", nullable=false, length=20)
	private String nivelDescr;

	public TblacaNivelEstudio() {
	}

	public String getNivelCode() {
		return this.nivelCode;
	}

	public void setNivelCode(String nivelCode) {
		this.nivelCode = nivelCode;
	}

	public String getNivelDescr() {
		return this.nivelDescr;
	}

	public void setNivelDescr(String nivelDescr) {
		this.nivelDescr = nivelDescr;
	}

}