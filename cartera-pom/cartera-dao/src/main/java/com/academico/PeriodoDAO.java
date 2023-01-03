package com.academico;

import java.util.List;

import academico.TblacaPeriodo;
import exceptions.DAOException;

public interface PeriodoDAO {

	public void eliminar(TblacaPeriodo entity) throws DAOException;

	public void editar(TblacaPeriodo entity) throws DAOException;

	public void crear(TblacaPeriodo entity) throws DAOException;

	public List<TblacaPeriodo> buscarTodos() throws DAOException;

	public TblacaPeriodo buscarEstado(boolean estado) throws DAOException;

	List<TblacaPeriodo> buscarTodosLimite(Integer limit, Integer offfSet)
			throws DAOException;

	public List<Integer> buscarAnios() throws DAOException;

	public void buscar();

	public TblacaPeriodo buscarperiodoPreincripcion() throws DAOException;

}
