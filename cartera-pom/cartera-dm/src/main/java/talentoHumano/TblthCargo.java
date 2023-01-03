package talentoHumano;

import java.io.Serializable;

import javax.persistence.*;





/**
 * The persistent class for the tblth_cargo database table.
 * 
 */
@Entity
@Table(name="tblth_cargo", schema="academico")
@NamedQuery(name="TblthCargo.findAll", query="SELECT t FROM TblthCargo t")
public class TblthCargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLTH_CARGO_OID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLTH_CARGO_OID_GENERATOR")
	private Integer oid;

	private String cargo;

	private Integer estado;

	private String usuario;

	public TblthCargo() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}