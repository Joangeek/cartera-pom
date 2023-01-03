package comun;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import talentoHumano.TblthParticipante;


/**
 * The persistent class for the tblpaises database table.
 * 
 */
@Entity
@Table(name="tbl_paises",schema="academico")
@NamedQuery(name="Tblpais.findAll", query="SELECT t FROM Tblpais t")
public class Tblpais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLPAISES_PAISCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLPAISES_PAISCODE_GENERATOR")
	@Column(name="pais_code")
	private String paisCode;

	@Column(name="pais_descr")
	private String paisDescr;

	//bi-directional many-to-one association to TblthParticipante
	@OneToMany(mappedBy="tblpais")
	private List<TblthParticipante> tblthParticipantes;

	public Tblpais() {
	}

	public String getPaisCode() {
		return this.paisCode;
	}

	public void setPaisCode(String paisCode) {
		this.paisCode = paisCode;
	}

	public String getPaisDescr() {
		return this.paisDescr;
	}

	public void setPaisDescr(String paisDescr) {
		this.paisDescr = paisDescr;
	}

	public List<TblthParticipante> getTblthParticipantes() {
		return this.tblthParticipantes;
	}

	public void setTblthParticipantes(List<TblthParticipante> tblthParticipantes) {
		this.tblthParticipantes = tblthParticipantes;
	}

	public TblthParticipante addTblthParticipante(TblthParticipante tblthParticipante) {
		getTblthParticipantes().add(tblthParticipante);
		tblthParticipante.setTblpais(this);

		return tblthParticipante;
	}

	public TblthParticipante removeTblthParticipante(TblthParticipante tblthParticipante) {
		getTblthParticipantes().remove(tblthParticipante);
		tblthParticipante.setTblpais(null);

		return tblthParticipante;
	}

}