package academico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblaca_parcial database table.
 * 
 */
@Entity
@Table(name="tblaca_parcial" , schema="academico")
@NamedQuery(name="TblacaParcial.findAll", query="SELECT t FROM TblacaParcial t")
public class TblacaParcial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_PARCIAL_IDPARCIAL_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_PARCIAL_IDPARCIAL_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idparcial;

	@Column(nullable=false, length=30)
	private String nombre;

	@Column(nullable=false)
	private Integer porcentaje;

	public TblacaParcial() {
	}

	public Integer getIdparcial() {
		return this.idparcial;
	}

	public void setIdparcial(Integer idparcial) {
		this.idparcial = idparcial;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

}