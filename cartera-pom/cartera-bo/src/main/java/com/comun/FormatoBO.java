/**
 * 
 */
package com.comun;

import java.util.List;

import javax.ejb.Remote;

import comun.TblcalFormato;

import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface FormatoBO {

	public List<TblcalFormato> listar() throws BOException;

	public void crear(byte[] serialize, boolean b) throws BOException;
	
	public byte[] editar(byte[] serialize) throws BOException;

}
