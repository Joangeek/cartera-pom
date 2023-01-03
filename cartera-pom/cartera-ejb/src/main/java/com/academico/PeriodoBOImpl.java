package com.academico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.academico.PeriodoBO;
import com.academico.PeriodoDAO;

import academico.TblacaPeriodo;
import exceptions.BOException;
import exceptions.DAOException;


@Stateless(mappedName = "periodoBO")
public class PeriodoBOImpl implements PeriodoBO {

	@Inject
	private PeriodoDAO periodoDAO;

	@Override
	public List<TblacaPeriodo> buscarTodosLimite(Integer limit, Integer offSet)
			throws BOException {
		try {
			return periodoDAO.buscarTodosLimite(limit, offSet);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	public void buscar() throws BOException {
		try {

			System.out.println("--******//////////////////");
			periodoDAO.buscar();
			// return periodoDAO.buscarTodosLimite(limit, offSet);
		} catch (Exception e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public TblacaPeriodo buscarEstado(boolean estado) throws BOException {
		try {
			return periodoDAO.buscarEstado(estado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaPeriodo> buscarTodos() throws BOException {
		try {
			return periodoDAO.buscarTodos();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<Integer> buscarAnios() throws BOException {
		try {
			return periodoDAO.buscarAnios();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public TblacaPeriodo buscarperiodoPreincripcion() throws BOException {
		try {
			return periodoDAO.buscarperiodoPreincripcion();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

}
