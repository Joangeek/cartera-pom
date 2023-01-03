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
 * The persistent class for the tblaca_periodicidad database table.
 * 
 */
@Entity
@Table(name="tblaca_periodicidad",schema="academico")
@NamedQuery(name="TblacaPeriodicidad.findAll", query="SELECT t FROM TblacaPeriodicidad t")
public class TblacaPeriodicidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_PERIODICIDAD_PERIODICIDADCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_PERIODICIDAD_PERIODICIDADCODE_GENERATOR")
	@Column(name="periodicidad_code")
	private String periodicidadCode;

	@Column(name="periodicidad_nombre")
	private String periodicidadNombre;


	public TblacaPeriodicidad() {
	}

	public String getPeriodicidadCode() {
		return this.periodicidadCode;
	}

	public void setPeriodicidadCode(String periodicidadCode) {
		this.periodicidadCode = periodicidadCode;
	}

	public String getPeriodicidadNombre() {
		return this.periodicidadNombre;
	}

	public void setPeriodicidadNombre(String periodicidadNombre) {
		this.periodicidadNombre = periodicidadNombre;
	}

}