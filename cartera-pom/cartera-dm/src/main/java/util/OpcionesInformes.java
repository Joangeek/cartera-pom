package util;

import java.io.Serializable;

public class OpcionesInformes implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7099895697084559443L;
	
	private Integer numero;
	private String descripcion;

	public OpcionesInformes() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
