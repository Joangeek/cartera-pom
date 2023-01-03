package cartera;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblext_tipo_cliente_edu_con database table.
 * 
 */
@Entity
@Table(name="tblext_tipo_cliente_edu_con", schema="academico")
@NamedQuery(name="TblextTipoClienteEduCon.findAll", query="SELECT t FROM TblextTipoClienteEduCon t")
public class TblextTipoClienteEduCon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLEXT_TIPO_CLIENTE_EDU_CON_IDTIPOCLIENTE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLEXT_TIPO_CLIENTE_EDU_CON_IDTIPOCLIENTE_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idtipocliente;

	@Column(name="estado_tipocliente", nullable=false)
	private Integer estadoTipocliente;

	@Column(nullable=false)
	private Integer idtipo;

	@Column(name="nombre_tipocliente", nullable=false, length=25)
	private String nombreTipocliente;

	public TblextTipoClienteEduCon() {
	}

	public Integer getIdtipocliente() {
		return this.idtipocliente;
	}

	public void setIdtipocliente(Integer idtipocliente) {
		this.idtipocliente = idtipocliente;
	}

	public Integer getEstadoTipocliente() {
		return this.estadoTipocliente;
	}

	public void setEstadoTipocliente(Integer estadoTipocliente) {
		this.estadoTipocliente = estadoTipocliente;
	}

	public Integer getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
	}

	public String getNombreTipocliente() {
		return this.nombreTipocliente;
	}

	public void setNombreTipocliente(String nombreTipocliente) {
		this.nombreTipocliente = nombreTipocliente;
	}

}