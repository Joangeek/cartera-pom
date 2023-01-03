/**
 * 
 */
package com.cartera;

import java.util.List;

import javax.ejb.Remote;

import cartera.TblfinBanco;
import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface BancoBO {

	public List<TblfinBanco> buscarbancos() throws BOException;

	public void crear(byte[] serialize, boolean b) throws BOException;
	
	public byte[] editar(byte[] serialize) throws BOException;

}
