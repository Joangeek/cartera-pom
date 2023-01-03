package com.academico;

import java.util.List;


import cartera.TblfinTarifaMatricula;
import exceptions.DAOException;

public interface DescuentosDAO {


	public List<TblfinTarifaMatricula> listar() throws DAOException;

	public void crear(TblfinTarifaMatricula entity, boolean actualizarFuenteDatos)
			throws DAOException;

	public TblfinTarifaMatricula editar(TblfinTarifaMatricula entity) throws DAOException;

	public void eliminar(TblfinTarifaMatricula entity) throws DAOException;

}
