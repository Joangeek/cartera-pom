package academico;

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
 * The persistent class for the tblaca_metodologia database table.
 * 
 */
@Entity
@Table(name="tblaca_metodologia",schema="academico")
@NamedQuery(name="TblacaMetodologia.findAll", query="SELECT t FROM TblacaMetodologia t")
public class TblacaMetodologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_METODOLOGIA_METODOLOGIACODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_METODOLOGIA_METODOLOGIACODE_GENERATOR")
	@Column(name="metodologia_code")
	private String metodologiaCode;

	@Column(name="metodologia_descr")
	private String metodologiaDescr;

	public TblacaMetodologia() {
	}

	public String getMetodologiaCode() {
		return this.metodologiaCode;
	}

	public void setMetodologiaCode(String metodologiaCode) {
		this.metodologiaCode = metodologiaCode;
	}

	public String getMetodologiaDescr() {
		return this.metodologiaDescr;
	}

	public void setMetodologiaDescr(String metodologiaDescr) {
		this.metodologiaDescr = metodologiaDescr;
	}

}