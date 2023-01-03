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
 * The persistent class for the tblaca_areas_conocimiento database table.
 * 
 */
@Entity
@Table(name="tblaca_areas_conocimiento",schema="academico")
@NamedQuery(name="TblacaAreasConocimiento.findAll", query="SELECT t FROM TblacaAreasConocimiento t")
public class TblacaAreasConocimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_AREAS_CONOCIMIENTO_ARCOCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_AREAS_CONOCIMIENTO_ARCOCODE_GENERATOR")
	@Column(name="arco_code")
	private long arcoCode;

	@Column(name="arco_descripcion")
	private String arcoDescripcion;

	public TblacaAreasConocimiento() {
	}

	public long getArcoCode() {
		return this.arcoCode;
	}

	public void setArcoCode(long arcoCode) {
		this.arcoCode = arcoCode;
	}

	public String getArcoDescripcion() {
		return this.arcoDescripcion;
	}

	public void setArcoDescripcion(String arcoDescripcion) {
		this.arcoDescripcion = arcoDescripcion;
	}
	

}