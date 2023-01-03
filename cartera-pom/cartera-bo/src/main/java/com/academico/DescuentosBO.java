/**
 * 
 */
package com.academico;

import java.util.List;

import javax.ejb.Remote;




import cartera.TblfinTarifaMatricula;
import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface DescuentosBO {

	public List<TblfinTarifaMatricula> listar() throws BOException;

	public void crear(byte[] serialize, boolean b) throws BOException;
	
	public byte[] editar(byte[] serialize) throws BOException;

	public void eliminar(byte[] serialize) throws BOException;
	
	
	
}
