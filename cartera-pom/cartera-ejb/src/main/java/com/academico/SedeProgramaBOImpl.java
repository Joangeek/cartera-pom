package com.academico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;

import commons.util.UtilidadBean;

import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "sedeProgramaBO")
public class SedeProgramaBOImpl implements SedeProgramaBO {

	@Inject
	private SedeprogramaDAO sedeProgramaDAO;

	@Override
	public List<TblacaSede> buscarSedes() throws BOException {
		try {
			return sedeProgramaDAO.buscarSedes();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaPrograma> buscarProgramas() throws BOException {
		try {
			return sedeProgramaDAO.buscarProgramas();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaPrograma> buscarProgramasActivos(boolean estado)
			throws BOException {
		try {
			return sedeProgramaDAO.buscarProgramasActivos(estado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSede> buscarSedesActivas(boolean estado)
			throws BOException {
		try {
			return sedeProgramaDAO.buscarSedesActivas(estado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSedePrograma> buscarPorSede(byte[] serialize)
			throws BOException {
		try {
			TblacaSede entity = UtilidadBean.deserialize(serialize);
			return sedeProgramaDAO.buscarPorSede(entity);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSede> buscarSedesEstadoPorSp(boolean estado)
			throws BOException {
		try {
			return sedeProgramaDAO.buscarSedesEstadoPorSp(estado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSedePrograma> buscarProgramasEstadoSp(Integer serialize,
			boolean estado, boolean ofertado) throws BOException {
		try {
			// TblacaSede entity = UtilidadBean.deserialize(serialize);
			return sedeProgramaDAO.buscarProgramasEstadoSp(serialize, estado,
					ofertado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}


}