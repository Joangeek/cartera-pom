package comun;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the tblestado_civil database table.
 * 
 */
@Entity
@Table(name="tbl_estado_civil",schema="academico")
@NamedQuery(name="TblestadoCivil.findAll", query="SELECT t FROM TblestadoCivil t")
public class TblestadoCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLESTADO_CIVIL_ESTCIVILCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLESTADO_CIVIL_ESTCIVILCODE_GENERATOR")
	@Column(name="est_civil_code")
	private String estCivilCode;

	@Column(name="est_civil_descr")
	private String estCivilDescr;

	public TblestadoCivil() {
	}

	public String getEstCivilCode() {
		return this.estCivilCode;
	}

	public void setEstCivilCode(String estCivilCode) {
		this.estCivilCode = estCivilCode;
	}

	public String getEstCivilDescr() {
		return this.estCivilDescr;
	}

	public void setEstCivilDescr(String estCivilDescr) {
		this.estCivilDescr = estCivilDescr;
	}

}