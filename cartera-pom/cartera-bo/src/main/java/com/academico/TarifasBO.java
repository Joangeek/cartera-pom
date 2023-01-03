/**
 * 
 */
package com.academico;

import java.util.List;

import javax.ejb.Remote;

import cartera.TblfinTarifa;


import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface TarifasBO {

	public List<TblfinTarifa> listar() throws BOException;

	public void crear(byte[] serialize, boolean b) throws BOException;
	
	public byte[] editar(byte[] serialize) throws BOException;
	
	
	
}
