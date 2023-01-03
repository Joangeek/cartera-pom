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
 * The persistent class for the tblmunicipios database table.
 * 
 */
@Entity
@Table(name="tbl_municipios",schema="academico")
@NamedQuery(name="Tblmunicipio.findAll", query="SELECT t FROM Tblmunicipio t")
public class Tblmunicipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLMUNICIPIOS_MUNICCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLMUNICIPIOS_MUNICCODE_GENERATOR")
	@Column(name="munic_code")
	private String municCode;

	@Column(name="depa_code")
	private String depaCode;

	@Column(name="munic_descr")
	private String municDescr;

	public Tblmunicipio() {
	}

	public String getMunicCode() {
		return this.municCode;
	}

	public void setMunicCode(String municCode) {
		this.municCode = municCode;
	}

	public String getDepaCode() {
		return this.depaCode;
	}

	public void setDepaCode(String depaCode) {
		this.depaCode = depaCode;
	}

	public String getMunicDescr() {
		return this.municDescr;
	}

	public void setMunicDescr(String municDescr) {
		this.municDescr = municDescr;
	}

}