package cartera;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tblfin_entidades_credito database table.
 * 
 */
@Entity
@Table(name="tblfin_entidades_credito", schema="academico")
@NamedQuery(name="TblfinEntidadesCredito.findAll", query="SELECT t FROM TblfinEntidadesCredito t")
public class TblfinEntidadesCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="entidad_code", unique=true, nullable=false, length=2)
	private String entidadCode;

	@Column(name="entidad_descr", length=25)
	private String entidadDescr;

	//bi-directional many-to-one association to TblfinCreditoMatricula
	@OneToMany(mappedBy="tblfinEntidadesCredito")
	private List<TblfinCreditoMatricula> tblfinCreditoMatriculas; 
	
	@Column(length=20)
	private String usuario;           
	
	private Integer estado;

	public TblfinEntidadesCredito() {
	}

	public String getEntidadCode() {
		return this.entidadCode;
	}

	public void setEntidadCode(String entidadCode) {
		this.entidadCode = entidadCode;
	}

	public String getEntidadDescr() {
		return this.entidadDescr;
	}

	public void setEntidadDescr(String entidadDescr) {
		this.entidadDescr = entidadDescr;
	}

	public List<TblfinCreditoMatricula> getTblfinCreditoMatriculas() {
		return this.tblfinCreditoMatriculas;
	}

	public void setTblfinCreditoMatriculas(List<TblfinCreditoMatricula> tblfinCreditoMatriculas) {
		this.tblfinCreditoMatriculas = tblfinCreditoMatriculas;
	}

	public TblfinCreditoMatricula addTblfinCreditoMatricula(TblfinCreditoMatricula tblfinCreditoMatricula) {
		getTblfinCreditoMatriculas().add(tblfinCreditoMatricula);
		tblfinCreditoMatricula.setTblfinEntidadesCredito(this);

		return tblfinCreditoMatricula;
	}

	public TblfinCreditoMatricula removeTblfinCreditoMatricula(TblfinCreditoMatricula tblfinCreditoMatricula) {
		getTblfinCreditoMatriculas().remove(tblfinCreditoMatricula);
		tblfinCreditoMatricula.setTblfinEntidadesCredito(null);

		return tblfinCreditoMatricula;
	}

	public String getUsuario() { 
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}