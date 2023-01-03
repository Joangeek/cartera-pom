package com.cartera;

import java.util.List;

import cartera.TblfinBanco;
import exceptions.DAOException;

public interface BancoDAO {

	public List<TblfinBanco> buscarBancos() throws DAOException;

	public void crear(TblfinBanco entity, boolean actualizarFuenteDatos)
			throws DAOException;

	public TblfinBanco editar(TblfinBanco entity) throws DAOException;
}
