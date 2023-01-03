package cartera;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_estrato database table.
 * 
 */
@Entity
@Table(name="tbl_estrato", schema="academico")
@NamedQuery(name="TblEstrato.findAll", query="SELECT t FROM TblEstrato t")
public class TblEstrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_ESTRATO_IDESTRATO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_ESTRATO_IDESTRATO_GENERATOR")
	@Column(unique=true, nullable=false, length=3)
	private String idestrato;

	@Column(nullable=false, length=1)
	private String alias;

	@Column(nullable=false, length=60)
	private String descripcion;

	@Column(nullable=false, length=1)
	private String estado;

	public TblEstrato() {
	}

	public String getIdestrato() {
		return this.idestrato;
	}

	public void setIdestrato(String idestrato) {
		this.idestrato = idestrato;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}