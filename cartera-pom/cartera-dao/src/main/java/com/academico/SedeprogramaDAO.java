package com.academico;

import java.util.List;

import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;
import exceptions.DAOException;

public interface SedeprogramaDAO {

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

}
