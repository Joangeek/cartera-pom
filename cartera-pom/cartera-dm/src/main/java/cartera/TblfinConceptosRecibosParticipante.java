package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblfin_conceptos_recibos_participantes database table.
 * 
 */
@Entity
@Table(name="tblfin_conceptos_recibos_participantes", schema="academico")
@NamedQuery(name="TblfinConceptosRecibosParticipante.findAll", query="SELECT t FROM TblfinConceptosRecibosParticipante t")
public class TblfinConceptosRecibosParticipante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TblfinConceptosRecibosParticipantePK id;

	//bi-directional many-to-one association to TblfinConceptosRecibo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idconcepto", nullable=false, insertable=false, updatable=false)
	private TblfinConceptosRecibo tblfinConceptosRecibo;

	//bi-directional many-to-one association to TblfinEstudianteProgramaRecibo
	@OneToMany(mappedBy="tblfinConceptosRecibosParticipante")
	private List<TblfinEstudianteProgramaRecibo> tblfinEstudianteProgramaRecibos;

	public TblfinConceptosRecibosParticipante() {
	}

	public TblfinConceptosRecibosParticipantePK getId() {
		return this.id;
	}

	public void setId(TblfinConceptosRecibosParticipantePK id) {
		this.id = id;
	}

	public TblfinConceptosRecibo getTblfinConceptosRecibo() {
		return this.tblfinConceptosRecibo;
	}

	public void setTblfinConceptosRecibo(TblfinConceptosRecibo tblfinConceptosRecibo) {
		this.tblfinConceptosRecibo = tblfinConceptosRecibo;
	}

	public List<TblfinEstudianteProgramaRecibo> getTblfinEstudianteProgramaRecibos() {
		return this.tblfinEstudianteProgramaRecibos;
	}

	public void setTblfinEstudianteProgramaRecibos(List<TblfinEstudianteProgramaRecibo> tblfinEstudianteProgramaRecibos) {
		this.tblfinEstudianteProgramaRecibos = tblfinEstudianteProgramaRecibos;
	}

	public TblfinEstudianteProgramaRecibo addTblfinEstudianteProgramaRecibo(TblfinEstudianteProgramaRecibo tblfinEstudianteProgramaRecibo) {
		getTblfinEstudianteProgramaRecibos().add(tblfinEstudianteProgramaRecibo);
		tblfinEstudianteProgramaRecibo.setTblfinConceptosRecibosParticipante(this);

		return tblfinEstudianteProgramaRecibo;
	}

	public TblfinEstudianteProgramaRecibo removeTblfinEstudianteProgramaRecibo(TblfinEstudianteProgramaRecibo tblfinEstudianteProgramaRecibo) {
		getTblfinEstudianteProgramaRecibos().remove(tblfinEstudianteProgramaRecibo);
		tblfinEstudianteProgramaRecibo.setTblfinConceptosRecibosParticipante(null);

		return tblfinEstudianteProgramaRecibo;
	}

}