package com.academico;

import java.util.List;

import academico.TblacaMatriculado;
import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;
import academico.TblestEstudiante;
import academico.TblestEstudiantePrograma;
import cartera.TblfinEstudianteProgramaRecibo;
import exceptions.DAOException;

public interface EstudianteProgramaDAO {

	public List<TblacaSede> buscarSedes() throws DAOException;

	public void eliminarSede(TblacaSede entity) throws DAOException;

	public void crearSede(TblacaSede entity) throws DAOException;

	public void editarSede(TblacaSede entity) throws DAOException;

	public List<TblacaPrograma> buscarProgramas() throws DAOException;

	public List<TblacaPrograma> buscarProgramasActivos(boolean estado)
			throws DAOException;

	public List<TblacaSede> buscarSedesActivas(boolean estado)
			throws DAOException;

	public List<TblacaSedePrograma> buscarPorSede(TblacaSede entity)
			throws DAOException;

	public List<TblacaSede> buscarSedesEstadoPorSp(boolean estado)
			throws DAOException;

	public List<TblacaSedePrograma> buscarProgramasEstadoSp(Integer entity,
			boolean estado, boolean ofertado) throws DAOException;

	public List<TblestEstudiantePrograma> buscarPorEstudiante(
			TblestEstudiante entity) throws DAOException;

	public List<TblfinEstudianteProgramaRecibo> buscarPorEp(
			TblestEstudiantePrograma entity) throws DAOException;

	public List<TblacaMatriculado> buscarPorPeriodoSede(Integer periodoDefault,
			Integer sedeDefault) throws DAOException;

}
