package comun;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_empresa database table.
 * 
 */
@Entity
@Table(name="tbl_empresa", schema="academico")
@NamedQuery(name="TblEmpresa.findAll", query="SELECT t FROM TblEmpresa t")
public class TblEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_EMPRESA_ID_GENERATOR", sequenceName="ACADEMICO.TBL_EMPRESA_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_EMPRESA_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=40)
	private String email;

	@Column(name="ies_code", nullable=false, length=4)
	private String iesCode;

	@Column(nullable=false, length=35)
	private String nit;

	@Column(nullable=false, length=200)
	private String nombre;

	@Column(name="razon_social", nullable=false, length=200)
	private String razonSocial;

	@Column(nullable=false, length=10)
	private String telefono;

	@Column(name="url_pagina_web", nullable=false, length=60)
	private String urlPaginaWeb;

	public TblEmpresa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIesCode() {
		return this.iesCode;
	}

	public void setIesCode(String iesCode) {
		this.iesCode = iesCode;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUrlPaginaWeb() {
		return this.urlPaginaWeb;
	}

	public void setUrlPaginaWeb(String urlPaginaWeb) {
		this.urlPaginaWeb = urlPaginaWeb;
	}

}