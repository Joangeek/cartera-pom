package cartera;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tblfin_conceptos_recibos_participantes database table.
 * 
 */
@Embeddable
public class TblfinConceptosRecibosParticipantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idconcepto;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idparticipante;

	@Column(unique=true, nullable=false)
	private Integer estado;

	public TblfinConceptosRecibosParticipantePK() {
	}
	public Integer getIdconcepto() {
		return this.idconcepto;
	}
	public void setIdconcepto(Integer idconcepto) {
		this.idconcepto = idconcepto;
	}
	public Integer getIdparticipante() {
		return this.idparticipante;
	}
	public void setIdparticipante(Integer idparticipante) {
		this.idparticipante = idparticipante;
	}
	public Integer getEstado() {
		return this.estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TblfinConceptosRecibosParticipantePK)) {
			return false;
		}
		TblfinConceptosRecibosParticipantePK castOther = (TblfinConceptosRecibosParticipantePK)other;
		return 
			this.idconcepto.equals(castOther.idconcepto)
			&& this.idparticipante.equals(castOther.idparticipante)
			&& this.estado.equals(castOther.estado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idconcepto.hashCode();
		hash = hash * prime + this.idparticipante.hashCode();
		hash = hash * prime + this.estado.hashCode();
		
		return hash;
	}
}