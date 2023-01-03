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
 * The persistent class for the tblgenero database table.
 * 
 */
@Entity
@Table(name="Tbl_genero", schema="academico")
@NamedQuery(name="Tblgenero.findAll", query="SELECT t FROM Tblgenero t")
public class Tblgenero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLGENERO_GENEROCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLGENERO_GENEROCODE_GENERATOR")
	@Column(name="genero_code")
	private String generoCode;

	@Column(name="genero_descr")
	private String generoDescr;

	public Tblgenero() {
	}

	public String getGeneroCode() {
		return this.generoCode;
	}

	public void setGeneroCode(String generoCode) {
		this.generoCode = generoCode;
	}

	public String getGeneroDescr() {
		return this.generoDescr;
	}

	public void setGeneroDescr(String generoDescr) {
		this.generoDescr = generoDescr;
	}

}