package academico;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblaca_planestudio database table.
 * 
 */
@Entity
@Table(name="tblaca_planestudio", schema = "academico")
@NamedQuery(name="TblacaPlanestudio.findAll", query="SELECT t FROM TblacaPlanestudio t")
public class TblacaPlanestudio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_PLANESTUDIO_IDPLAN_GENERATOR", sequenceName="ACADEMICO.TBLACA_PLANESTUDIO_IDPLAN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_PLANESTUDIO_IDPLAN_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idplan;

	@Column(name="cod_ies", nullable=false, length=10)
	private String codIes;

	@Column(nullable=false)
	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechacreacion;

	@Column(nullable=false)
	private Integer idprograma;

	@Column(name="min_cred", nullable=false)
	private Integer minCred;

	@Column(name="min_cred_el", nullable=false)
	private Integer minCredEl;

	@Column(nullable=false, length=40)
	private String nombre;

	@Column(nullable=false, length=20)
	private String proconsecutivo;

	@Column(name="url_plan", nullable=false, length=250)
	private String urlPlan;

	//bi-directional many-to-one association to TblestEstudiantePrograma
	@OneToMany(mappedBy="tblacaPlanestudio")
	private List<TblestEstudiantePrograma> tblestEstudianteProgramas;	
	
	public int anioPlan(){
		
		Date date = getFechacreacion();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
		
	}

	public TblacaPlanestudio() {
	}

	public Integer getIdplan() {
		return this.idplan;
	}

	public void setIdplan(Integer idplan) {
		this.idplan = idplan;
	}

	public String getCodIes() {
		return this.codIes;
	}

	public void setCodIes(String codIes) {
		this.codIes = codIes;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Integer getIdprograma() {
		return this.idprograma;
	}

	public void setIdprograma(Integer idprograma) {
		this.idprograma = idprograma;
	}

	public Integer getMinCred() {
		return this.minCred;
	}

	public void setMinCred(Integer minCred) {
		this.minCred = minCred;
	}

	public Integer getMinCredEl() {
		return this.minCredEl;
	}

	public void setMinCredEl(Integer minCredEl) {
		this.minCredEl = minCredEl;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProconsecutivo() {
		return this.proconsecutivo;
	}

	public void setProconsecutivo(String proconsecutivo) {
		this.proconsecutivo = proconsecutivo;
	}

	public String getUrlPlan() {
		return this.urlPlan;
	}

	public void setUrlPlan(String urlPlan) {
		this.urlPlan = urlPlan;
	}

	public List<TblestEstudiantePrograma> getTblestEstudianteProgramas() {
		return this.tblestEstudianteProgramas;
	}

	public void setTblestEstudianteProgramas(List<TblestEstudiantePrograma> tblestEstudianteProgramas) {
		this.tblestEstudianteProgramas = tblestEstudianteProgramas;
	}

	public TblestEstudiantePrograma addTblestEstudiantePrograma(TblestEstudiantePrograma tblestEstudiantePrograma) {
		getTblestEstudianteProgramas().add(tblestEstudiantePrograma);
		tblestEstudiantePrograma.setTblacaPlanestudio(this);

		return tblestEstudiantePrograma;
	}

	public TblestEstudiantePrograma removeTblestEstudiantePrograma(TblestEstudiantePrograma tblestEstudiantePrograma) {
		getTblestEstudianteProgramas().remove(tblestEstudiantePrograma);
		tblestEstudiantePrograma.setTblacaPlanestudio(null);

		return tblestEstudiantePrograma;
	}

}