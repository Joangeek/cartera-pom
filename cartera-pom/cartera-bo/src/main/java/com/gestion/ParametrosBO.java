package com.gestion;

import gestion.Parametros;

import javax.ejb.Remote;

import exceptions.BOException;


/**
 * @author EDUAR
 * 
 */
@Remote
public interface ParametrosBO {
	/**
	 * Método que lista todos los registros
	 * 
	 * @return
	 * @throws BOException
	 */
	public Parametros buscarCodigo(String codigo)
			throws BOException;


}
