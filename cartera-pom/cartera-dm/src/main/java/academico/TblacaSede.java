package academico;

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
 * The persistent class for the tblaca_sede database table.
 * 
 */
@Entity
@Table(name = "tblaca_sede", schema = "academico")
@NamedQuery(name = "TblacaSede.findAll", query = "SELECT t FROM TblacaSede t ORDER BY t.oid")
public class TblacaSede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TBLACA_SEDE_OID_GENERATOR", sequenceName = "ACADEMICO.TBLACA_SEDE_OID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBLACA_SEDE_OID_GENERATOR")
	private Integer oid;

	@Column(name = "area_tel")
	private String areaTel;

	private String codsnies;

	@Column(name = "depto_code")
	private String deptoCode;

	private String direccion;

	private Integer estado;

	private String informes;

	@Column(name = "mun_code")
	private String munCode;

	private String nombre;

	private String telefono;

	// bi-directional many-to-one association to TblacaSedePrograma
	@OneToMany(mappedBy = "tblacaSede")
	private List<TblacaSedePrograma> tblacaSedeProgramas;
	

	public TblacaSede() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getAreaTel() {
		return this.areaTel;
	}

	public void setAreaTel(String areaTel) {
		this.areaTel = areaTel;
	}

	public String getCodsnies() {
		return this.codsnies;
	}

	public void setCodsnies(String codsnies) {
		this.codsnies = codsnies;
	}

	public String getDeptoCode() {
		return this.deptoCode;
	}

	public void setDeptoCode(String deptoCode) {
		this.deptoCode = deptoCode;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getInformes() {
		return this.informes;
	}

	public void setInformes(String informes) {
		this.informes = informes;
	}

	public String getMunCode() {
		return this.munCode;
	}

	public void setMunCode(String munCode) {
		this.munCode = munCode;
	}

	public String getNombre() {
		return this.nombre.toUpperCase();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<TblacaSedePrograma> getTblacaSedeProgramas() {
		return this.tblacaSedeProgramas;
	}

	public void setTblacaSedeProgramas(
			List<TblacaSedePrograma> tblacaSedeProgramas) {
		this.tblacaSedeProgramas = tblacaSedeProgramas;
	}

	public TblacaSedePrograma addTblacaSedePrograma(
			TblacaSedePrograma tblacaSedePrograma) {
		getTblacaSedeProgramas().add(tblacaSedePrograma);
		tblacaSedePrograma.setTblacaSede(this);

		return tblacaSedePrograma;
	}

	public TblacaSedePrograma removeTblacaSedePrograma(
			TblacaSedePrograma tblacaSedePrograma) {
		getTblacaSedeProgramas().remove(tblacaSedePrograma);
		tblacaSedePrograma.setTblacaSede(null);

		return tblacaSedePrograma;
	}


//	public TblestEstudiante getTblestEstudiante() {
//		return this.tblestEstudiante;
//	}
//
//	public void setTblestEstudiante(TblestEstudiante tblestEstudiante) {
//		this.tblestEstudiante = tblestEstudiante;
//	}

}