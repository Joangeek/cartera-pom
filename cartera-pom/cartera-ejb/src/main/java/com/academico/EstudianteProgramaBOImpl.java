package com.academico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import academico.TblacaMatriculado;
import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;
import academico.TblestEstudiante;
import academico.TblestEstudiantePrograma;
import cartera.TblfinEstudianteProgramaRecibo;
import commons.util.UtilidadBean;
import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "estudianteProgramaBO")
public class EstudianteProgramaBOImpl implements EstudianteProgramaBO {

	@Inject
	private EstudianteProgramaDAO estudianteProgramaDAO;

	@Override
	public List<TblacaSede> buscarSedes() throws BOException {
		try {
			return estudianteProgramaDAO.buscarSedes();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaPrograma> buscarProgramas() throws BOException {
		try {
			return estudianteProgramaDAO.buscarProgramas();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaPrograma> buscarProgramasActivos(boolean estado)
			throws BOException {
		try {
			return estudianteProgramaDAO.buscarProgramasActivos(estado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSede> buscarSedesActivas(boolean estado)
			throws BOException {
		try {
			return estudianteProgramaDAO.buscarSedesActivas(estado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSedePrograma> buscarPorSede(byte[] serialize)
			throws BOException {
		try {
			TblacaSede entity = UtilidadBean.deserialize(serialize);
			return estudianteProgramaDAO.buscarPorSede(entity);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSede> buscarSedesEstadoPorSp(boolean estado)
			throws BOException {
		try {
			return estudianteProgramaDAO.buscarSedesEstadoPorSp(estado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaSedePrograma> buscarProgramasEstadoSp(Integer serialize,
			boolean estado, boolean ofertado) throws BOException {
		try {
			// TblacaSede entity = UtilidadBean.deserialize(serialize);
			return estudianteProgramaDAO.buscarProgramasEstadoSp(serialize,
					estado, ofertado);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblestEstudiantePrograma> buscarPorEstudiante(byte[] serialize)
			throws BOException {
		try {
			TblestEstudiante entity = UtilidadBean.deserialize(serialize);
			return estudianteProgramaDAO.buscarPorEstudiante(entity);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblfinEstudianteProgramaRecibo> buscarPorEp(byte[] serialize)
			throws BOException {
		try {
			TblestEstudiantePrograma entity = UtilidadBean
					.deserialize(serialize);
			return estudianteProgramaDAO.buscarPorEp(entity);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<TblacaMatriculado> buscarPorPeriodoSede(Integer periodoDefault,
			Integer sedeDefault) throws BOException {
		try {

			return estudianteProgramaDAO.buscarPorPeriodoSede(periodoDefault,
					sedeDefault);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

}