package com.academico;

import java.util.List;

import academico.TblacaCalendarioAcademico;
import exceptions.DAOException;

public interface CalendarioDAO {

	public List<TblacaCalendarioAcademico> listar() throws DAOException;

	public void crear(TblacaCalendarioAcademico entity, boolean actualizarFuenteDatos)
			throws DAOException;

	public TblacaCalendarioAcademico editar(TblacaCalendarioAcademico entity) throws DAOException;
}
