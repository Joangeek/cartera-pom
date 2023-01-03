package cartera;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblfin_tipo_cuenta database table.
 * 
 */
@Entity
@Table(name="tblfin_tipo_cuenta", schema="academico")
@NamedQuery(name="TblfinTipoCuenta.findAll", query="SELECT t FROM TblfinTipoCuenta t")
public class TblfinTipoCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLFIN_TIPO_CUENTA_OID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLFIN_TIPO_CUENTA_OID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer oid;

	private Integer estado;

	@Column(length=40)
	private String tipo;

	@Column(length=20)
	private String usuario;

	//bi-directional many-to-one association to TblfinBanco
	@OneToMany(mappedBy="tblfinTipoCuenta")
	private List<TblfinBanco> tblfinBancos;

	public TblfinTipoCuenta() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<TblfinBanco> getTblfinBancos() {
		return this.tblfinBancos;
	}

	public void setTblfinBancos(List<TblfinBanco> tblfinBancos) {
		this.tblfinBancos = tblfinBancos;
	}

	public TblfinBanco addTblfinBanco(TblfinBanco tblfinBanco) {
		getTblfinBancos().add(tblfinBanco);
		tblfinBanco.setTblfinTipoCuenta(this);

		return tblfinBanco;
	}

	public TblfinBanco removeTblfinBanco(TblfinBanco tblfinBanco) {
		getTblfinBancos().remove(tblfinBanco);
		tblfinBanco.setTblfinTipoCuenta(null);

		return tblfinBanco;
	}

}