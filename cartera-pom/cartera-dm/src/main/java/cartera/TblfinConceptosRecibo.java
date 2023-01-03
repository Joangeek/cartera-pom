package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblfin_conceptos_recibos database table.
 * 
 */
@Entity
@Table(name="tblfin_conceptos_recibos", schema="academico")
@NamedQuery(name="TblfinConceptosRecibo.findAll", query="SELECT t FROM TblfinConceptosRecibo t")
public class TblfinConceptosRecibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_CONCEPTOS_RECIBOS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_CONCEPTOS_RECIBOS_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=80)
	private String descripcion;

	@Column(nullable=false)
	private Integer estado;

	//bi-directional many-to-one association to TblfinConceptosRecibosParticipante
	@OneToMany(mappedBy="tblfinConceptosRecibo")
	private List<TblfinConceptosRecibosParticipante> tblfinConceptosRecibosParticipantes;

	public TblfinConceptosRecibo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<TblfinConceptosRecibosParticipante> getTblfinConceptosRecibosParticipantes() {
		return this.tblfinConceptosRecibosParticipantes;
	}

	public void setTblfinConceptosRecibosParticipantes(List<TblfinConceptosRecibosParticipante> tblfinConceptosRecibosParticipantes) {
		this.tblfinConceptosRecibosParticipantes = tblfinConceptosRecibosParticipantes;
	}

	public TblfinConceptosRecibosParticipante addTblfinConceptosRecibosParticipante(TblfinConceptosRecibosParticipante tblfinConceptosRecibosParticipante) {
		getTblfinConceptosRecibosParticipantes().add(tblfinConceptosRecibosParticipante);
		tblfinConceptosRecibosParticipante.setTblfinConceptosRecibo(this);

		return tblfinConceptosRecibosParticipante;
	}

	public TblfinConceptosRecibosParticipante removeTblfinConceptosRecibosParticipante(TblfinConceptosRecibosParticipante tblfinConceptosRecibosParticipante) {
		getTblfinConceptosRecibosParticipantes().remove(tblfinConceptosRecibosParticipante);
		tblfinConceptosRecibosParticipante.setTblfinConceptosRecibo(null);

		return tblfinConceptosRecibosParticipante;
	}

}