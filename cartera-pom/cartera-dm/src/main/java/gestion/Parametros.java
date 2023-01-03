package gestion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the tblenc_tipo_aspectos database table.
 * 
 */
@Entity
@Table(name = "parametros", schema = "gestion")
@NamedQueries({
		@NamedQuery(name = "Parametros.findCodigo", query = "SELECT t FROM Parametros t WHERE t.codigo=:codigo "),
		@NamedQuery(name = "Parametros.findVstring", query = "SELECT t FROM Parametros t WHERE t.valString=:val"),
		@NamedQuery(name = "Parametros.findVinteger", query = "SELECT t FROM Parametros t WHERE t.val_int=:val ") })
public class Parametros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PARAMETROS_OID_GENERATOR", sequenceName = "GESTION.PARAMETROS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARAMETROS_OID_GENERATOR")
	private Integer oid;
	
	private String codigo;

	private String descripcion;

	@Column(name = "val_string")
	private String valString;

	@Column(name = "val_int")
	private Integer val_int;
	
	private Integer estado;

	public Parametros() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValString() {
		return valString;
	}

	public void setValString(String valString) {
		this.valString = valString;
	}

	public Integer getVal_int() {
		return val_int;
	}

	public void setVal_int(Integer val_int) {
		this.val_int = val_int;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	
}