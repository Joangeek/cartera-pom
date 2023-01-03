package com.academico;

import java.util.List;

import javax.ejb.Remote;



import academico.TblacaPeriodo;
import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface PeriodoBO {

	public TblacaPeriodo buscarEstado(boolean estado) throws BOException;

	public List<TblacaPeriodo> buscarTodos() throws BOException;

	public List<TblacaPeriodo> buscarTodosLimite(Integer limit, Integer offSet)
			throws BOException;

	public List<Integer> buscarAnios() throws BOException;

	public void buscar() throws BOException;

	public TblacaPeriodo buscarperiodoPreincripcion() throws BOException;

}
