package auditoria;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * The persistent class for the tblingreso database table.
 * 
 */
@Entity
@Table(name = "Tblingreso", schema = "auditoria")
@NamedQuery(name = "Tblingreso.findAll", query = "SELECT t FROM Tblingreso t")
public class Tblingreso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TBLINGRESO_IDINGRESO_GENERATOR", sequenceName = "AUDITORIA.INGRESO_IDINGRESO_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBLINGRESO_IDINGRESO_GENERATOR")
	private Integer idingreso;

	private Timestamp fecha;

	private String usuario;

	public Tblingreso() {
		Date date = new Date();
		fecha = new Timestamp(date.getTime());
	}

	public Integer getIdingreso() {
		return this.idingreso;
	}

	public void setIdingreso(Integer idingreso) {
		this.idingreso = idingreso;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}