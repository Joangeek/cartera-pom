package com.academico;

import java.util.List;

import cartera.TblfinTarifa;
import exceptions.DAOException;

public interface TarifasDAO {


	public List<TblfinTarifa> listar() throws DAOException;

	public void crear(TblfinTarifa entity, boolean actualizarFuenteDatos)
			throws DAOException;

	public TblfinTarifa editar(TblfinTarifa entity) throws DAOException;

}
