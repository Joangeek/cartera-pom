package academico;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblaca_actividad_calendario database table.
 * 
 */
@Entity
@Table(name="tblaca_actividad_calendario" , schema="academico")
@NamedQuery(name="TblacaActividadCalendario.findAll", query="SELECT t FROM TblacaActividadCalendario t")
public class TblacaActividadCalendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_ACTIVIDAD_CALENDARIO_IDACTIVIDAD_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_ACTIVIDAD_CALENDARIO_IDACTIVIDAD_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idactividad;

	@Column(nullable=false, length=500)
	private String nombre;

	@Column(length=2147483647)
	private String resumen;

	//bi-directional many-to-one association to TblacaCalendarioAcademico
	@OneToMany(mappedBy="actCalendario")
	private List<TblacaCalendarioAcademico> tblacaCalendarioAcademicos;
   

	

	public TblacaActividadCalendario() {
	}

	public Integer getIdactividad() {
		return this.idactividad;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResumen() {
		return this.resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public List<TblacaCalendarioAcademico> getTblacaCalendarioAcademicos() {
		return tblacaCalendarioAcademicos;
	}

	public void setTblacaCalendarioAcademicos(
			List<TblacaCalendarioAcademico> tblacaCalendarioAcademicos) {
		this.tblacaCalendarioAcademicos = tblacaCalendarioAcademicos;
	}

	



}