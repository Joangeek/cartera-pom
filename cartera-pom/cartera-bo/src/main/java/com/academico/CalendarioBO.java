/**
 * 
 */
package com.academico;

import java.util.List;

import javax.ejb.Remote;

import academico.TblacaCalendarioAcademico;
import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface CalendarioBO {

	public List<TblacaCalendarioAcademico> listar() throws BOException;

	public void crear(byte[] serialize, boolean b) throws BOException;
	
	public byte[] editar(byte[] serialize) throws BOException;

}
