package talentoHumano;

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


/**
 * The persistent class for the tblth_tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="tblth_tipo_identificacion",schema="academico")
@NamedQuery(name="TblthTipoIdentificacion.findAll", query="SELECT t FROM TblthTipoIdentificacion t")
public class TblthTipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLTH_TIPO_IDENTIFICACION_TIIDCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLTH_TIPO_IDENTIFICACION_TIIDCODE_GENERATOR")
	@Column(name="tiid_code")
	private String tiidCode;

	@Column(name="tiid_descripcion")
	private String tiidDescripcion;


	//bi-directional many-to-one association to TblthParticipante
	@OneToMany(mappedBy="tblthTipoIdentificacion")
	private List<TblthParticipante> tblthParticipantes;

	public TblthTipoIdentificacion() {
	}

	public String getTiidCode() {
		return this.tiidCode;
	}

	public void setTiidCode(String tiidCode) {
		this.tiidCode = tiidCode;
	}

	public String getTiidDescripcion() {
		return this.tiidDescripcion;
	}

	public void setTiidDescripcion(String tiidDescripcion) {
		this.tiidDescripcion = tiidDescripcion;
	}

	public List<TblthParticipante> getTblthParticipantes() {
		return this.tblthParticipantes;
	}

	public void setTblthParticipantes(List<TblthParticipante> tblthParticipantes) {
		this.tblthParticipantes = tblthParticipantes;
	}

	public TblthParticipante addTblthParticipante(TblthParticipante tblthParticipante) {
		getTblthParticipantes().add(tblthParticipante);
		tblthParticipante.setTblthTipoIdentificacion(this);

		return tblthParticipante;
	}

	public TblthParticipante removeTblthParticipante(TblthParticipante tblthParticipante) {
		getTblthParticipantes().remove(tblthParticipante);
		tblthParticipante.setTblthTipoIdentificacion(null);

		return tblthParticipante;
	}

}