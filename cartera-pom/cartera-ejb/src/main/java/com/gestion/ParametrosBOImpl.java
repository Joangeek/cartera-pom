package com.gestion;

import gestion.Parametros;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gestion.ParametrosBO;
import com.gestion.ParametrosDAO;

import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "parametrosBO")
public class ParametrosBOImpl implements ParametrosBO {

	@Inject
	private ParametrosDAO parametrosDAO;

	@Override
	public Parametros buscarCodigo(String codigo)
			throws BOException {
		try {
			return parametrosDAO.buscarCodigo(codigo);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

}
