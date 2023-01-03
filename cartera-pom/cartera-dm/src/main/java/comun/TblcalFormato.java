package comun;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tblcal_formato database table.
 * 
 */
@Entity
@Table(name="tblcal_formato", schema="academico")
@NamedQuery(name="TblcalFormato.findAll", query="SELECT t FROM TblcalFormato t")
public class TblcalFormato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLCAL_FORMATO_IDFOTRMATO_GENERATOR", sequenceName="ACADEMICO.TBLCAL_FORMATO_ID_FOTRMATO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLCAL_FORMATO_IDFOTRMATO_GENERATOR")
	@Column(name="id_fotrmato")
	private Integer idFotrmato; 

	private Integer codigo;

	private String footer;

	
	//bi-directional many-to-one association to TblacaPeriodo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idempresa", nullable=false)
	private TblEmpresa tblEmpresa; 

	private String logo;

	private String nombre;

	private Integer version;

	@Temporal(TemporalType.DATE)
	private Date vigencia;

	public TblcalFormato() {
	}

	public Integer getIdFotrmato() {
		return this.idFotrmato;
	}

	public void setIdFotrmato(Integer idFotrmato) {
		this.idFotrmato = idFotrmato;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getFooter() {
		return this.footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public TblEmpresa getTblEmpresa() {
		return tblEmpresa;
	}

	public void setTblEmpresa(TblEmpresa tblEmpresa) {
		this.tblEmpresa = tblEmpresa;
	}

	
}