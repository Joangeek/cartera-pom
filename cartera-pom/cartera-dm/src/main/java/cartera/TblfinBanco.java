package cartera;

import java.io.Serializable;

import javax.persistence.*;

import academico.TblacaSedePrograma;

/**
 * The persistent class for the tblfin_bancos database table.
 * 
 */
@Entity
@Table(name = "tblfin_bancos", schema = "academico")
@NamedQuery(name = "TblfinBanco.findAll", query = "SELECT t FROM TblfinBanco t")
public class TblfinBanco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TBLFIN_BANCOS_OID_GENERATOR", sequenceName = "academico.tblfin_bancos_oid_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBLFIN_BANCOS_OID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer oid;

	@Column(nullable = false, length = 60)
	private String banco;

	private Integer estado;

	// @Column(nullable=false)
	// private Integer idsedeprograma;

	// bi-directional many-to-one association to TblestEstudiantePrograma
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsedeprograma")
	private TblacaSedePrograma tblacaSedePrograma;

	@Column(name = "numero_cuenta", length = 40)
	private String numeroCuenta;

	@Column(length = 20)
	private String usuario;

	// bi-directional many-to-one association to TblfinTipoCuenta
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_cuenta", nullable = false)
	private TblfinTipoCuenta tblfinTipoCuenta;

	public TblfinBanco() {
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public TblacaSedePrograma getTblacaSedePrograma() {
		return tblacaSedePrograma;
	}

	public void setTblacaSedePrograma(TblacaSedePrograma tblacaSedePrograma) {
		this.tblacaSedePrograma = tblacaSedePrograma;
	}

	public String getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public TblfinTipoCuenta getTblfinTipoCuenta() {
		return this.tblfinTipoCuenta;
	}

	public void setTblfinTipoCuenta(TblfinTipoCuenta tblfinTipoCuenta) {
		this.tblfinTipoCuenta = tblfinTipoCuenta;
	}

}