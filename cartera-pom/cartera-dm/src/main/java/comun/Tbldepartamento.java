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
 * The persistent class for the tbldepartamentos database table.
 * 
 */
@Entity
@Table(name="tbl_departamentos",schema="academico")
@NamedQuery(name="Tbldepartamento.findAll", query="SELECT t FROM Tbldepartamento t")
public class Tbldepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLDEPARTAMENTOS_DEPTOCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLDEPARTAMENTOS_DEPTOCODE_GENERATOR")
	@Column(name="depto_code")
	private String deptoCode;

	@Column(name="depto_descr")
	private String deptoDescr;

	public Tbldepartamento() {
	}

	public String getDeptoCode() {
		return this.deptoCode;
	}

	public void setDeptoCode(String deptoCode) {
		this.deptoCode = deptoCode;
	}

	public String getDeptoDescr() {
		return this.deptoDescr;
	}

	public void setDeptoDescr(String deptoDescr) {
		this.deptoDescr = deptoDescr;
	}

}