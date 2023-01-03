package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblacaPrograma;
import academico.TblacaSede;


/**
 * The persistent class for the tblfin_tarifa_matricula database table.
 * 
 */
@Entity
@Table(name="tblfin_tarifa_matricula", schema="academico")
@NamedQuery(name="TblfinTarifaMatricula.findAll", query="SELECT t FROM TblfinTarifaMatricula t")
public class TblfinTarifaMatricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_TARIFA_MATRICULA_IDTARIFAMATRICULA_GENERATOR" , sequenceName="academico.tblfin_tarifa_matricula_idtarifa_matricula_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_TARIFA_MATRICULA_IDTARIFAMATRICULA_GENERATOR")
	@Column(name="idtarifa_matricula", unique=true, nullable=false)
	private Integer idtarifaMatricula;

	private Integer afiliacion;

	@Column(nullable=false, length=100)
	private String descripcion;

	@Column(name="idcategoria_comfa")
	private Integer idcategoriaComfa;

	// bi-directional many-to-one association to TblacaPrograma
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idestrato")
	private TblEstrato tblEstrato;
	
	

	// bi-directional many-to-one association to TblacaPrograma
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idprograma")
	private TblacaPrograma tblacaPrograma;

	// bi-directional many-to-one association to TblacaSede
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idsede")
	private TblacaSede tblacaSede;

	@Column(nullable=false)
	private double tarifa;

	@Column(name="tipo_descuento")
	private Integer tipoDescuento;

	@Column(name="tipo_estudiante")
	private Integer tipoEstudiante;

	//bi-directional many-to-one association to TblfinTarifa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtarifa", nullable=false)
	private TblfinTarifa tblfinTarifa;

	//bi-directional many-to-one association to TblmerCategoriaComfacauca
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idcate_comfa", nullable=false)
	private TblmerCategoriaComfacauca tblmerCategoriaComfacauca;

	public TblfinTarifaMatricula() {
	}

	public Integer getIdtarifaMatricula() {
		return this.idtarifaMatricula;
	}

	public void setIdtarifaMatricula(Integer idtarifaMatricula) {
		this.idtarifaMatricula = idtarifaMatricula;
	}

	public Integer getAfiliacion() {
		return this.afiliacion;
	}

	public void setAfiliacion(Integer afiliacion) {
		this.afiliacion = afiliacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdcategoriaComfa() {
		return this.idcategoriaComfa;
	}

	public void setIdcategoriaComfa(Integer idcategoriaComfa) {
		this.idcategoriaComfa = idcategoriaComfa;
	}

	public double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public Integer getTipoDescuento() {
		return this.tipoDescuento;
	}

	public void setTipoDescuento(Integer tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}

	public Integer getTipoEstudiante() {
		return this.tipoEstudiante;
	}

	public void setTipoEstudiante(Integer tipoEstudiante) {
		this.tipoEstudiante = tipoEstudiante;
	}

	public TblfinTarifa getTblfinTarifa() {
		return this.tblfinTarifa;
	}

	public void setTblfinTarifa(TblfinTarifa tblfinTarifa) {
		this.tblfinTarifa = tblfinTarifa;
	}

	public TblmerCategoriaComfacauca getTblmerCategoriaComfacauca() {
		return this.tblmerCategoriaComfacauca;
	}

	public void setTblmerCategoriaComfacauca(TblmerCategoriaComfacauca tblmerCategoriaComfacauca) {
		this.tblmerCategoriaComfacauca = tblmerCategoriaComfacauca;
	}

	public TblacaPrograma getTblacaPrograma() {
		return tblacaPrograma;
	}

	public void setTblacaPrograma(TblacaPrograma tblacaPrograma) {
		this.tblacaPrograma = tblacaPrograma;
	}

	public TblacaSede getTblacaSede() {
		return tblacaSede;
	}

	public void setTblacaSede(TblacaSede tblacaSede) {
		this.tblacaSede = tblacaSede;
	}

	public TblEstrato getTblEstrato() {
		return tblEstrato;
	}

	public void setTblEstrato(TblEstrato tblEstrato) {
		this.tblEstrato = tblEstrato;
	}
	
	

}