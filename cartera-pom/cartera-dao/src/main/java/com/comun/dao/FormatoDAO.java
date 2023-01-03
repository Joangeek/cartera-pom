package com.comun.dao;

import java.util.List;

import comun.TblcalFormato;

import exceptions.DAOException;

public interface FormatoDAO {

	public List<TblcalFormato> listar() throws DAOException;

	public void crear(TblcalFormato entity, boolean actualizarFuenteDatos)
			throws DAOException;

	public TblcalFormato editar(TblcalFormato entity) throws DAOException;
}
