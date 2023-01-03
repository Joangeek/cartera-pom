package academico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblaca_autorizacion_programa database table.
 * 
 */
@Entity
@Table(name="tblaca_autorizacion_programa", schema="academico")
@NamedQuery(name="TblacaAutorizacionPrograma.findAll", query="SELECT t FROM TblacaAutorizacionPrograma t")
public class TblacaAutorizacionPrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_AUTORIZACION_PROGRAMA_IDAUTORIZACION_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_AUTORIZACION_PROGRAMA_IDAUTORIZACION_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idautorizacion;

	private Integer autorizado;

	@Column(nullable=false)
	private Integer idperiodo;

	@Column(nullable=false)
	private Integer idsede;

	@Column(name="pro_consecutivo", length=50)
	private String proConsecutivo;

	@Column(name="tipo_autorizacion", length=1)
	private String tipoAutorizacion;

	//bi-directional many-to-one association to TblacaJornada
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idjornada", nullable=false)
	private TblacaJornada tblacaJornada;

	public TblacaAutorizacionPrograma() {
	}

	public Integer getIdautorizacion() {
		return this.idautorizacion;
	}

	public void setIdautorizacion(Integer idautorizacion) {
		this.idautorizacion = idautorizacion;
	}

	public Integer getAutorizado() {
		return this.autorizado;
	}

	public void setAutorizado(Integer autorizado) {
		this.autorizado = autorizado;
	}

	public Integer getIdperiodo() {
		return this.idperiodo;
	}

	public void setIdperiodo(Integer idperiodo) {
		this.idperiodo = idperiodo;
	}

	public Integer getIdsede() {
		return this.idsede;
	}

	public void setIdsede(Integer idsede) {
		this.idsede = idsede;
	}

	public String getProConsecutivo() {
		return this.proConsecutivo;
	}

	public void setProConsecutivo(String proConsecutivo) {
		this.proConsecutivo = proConsecutivo;
	}

	public String getTipoAutorizacion() {
		return this.tipoAutorizacion;
	}

	public void setTipoAutorizacion(String tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
	}

	public TblacaJornada getTblacaJornada() {
		return this.tblacaJornada;
	}

	public void setTblacaJornada(TblacaJornada tblacaJornada) {
		this.tblacaJornada = tblacaJornada;
	}

}