package academico;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblaca_tipo_cubrimiento database table.
 * 
 */
@Entity
@Table(name="tblaca_tipo_cubrimiento",schema="academico")
@NamedQuery(name="TblacaTipoCubrimiento.findAll", query="SELECT t FROM TblacaTipoCubrimiento t")
public class TblacaTipoCubrimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLACA_TIPO_CUBRIMIENTO_TIPOCUBRIMCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLACA_TIPO_CUBRIMIENTO_TIPOCUBRIMCODE_GENERATOR")
	@Column(name="tipo_cubrim_code")
	private String tipoCubrimCode;

	@Column(name="tipo_cubrim_descr")
	private String tipoCubrimDescr;

	public TblacaTipoCubrimiento() {
	}

	public String getTipoCubrimCode() {
		return this.tipoCubrimCode;
	}

	public void setTipoCubrimCode(String tipoCubrimCode) {
		this.tipoCubrimCode = tipoCubrimCode;
	}

	public String getTipoCubrimDescr() {
		return this.tipoCubrimDescr;
	}

	public void setTipoCubrimDescr(String tipoCubrimDescr) {
		this.tipoCubrimDescr = tipoCubrimDescr;
	}

}