package com.gestion;

import exceptions.DAOException;
import gestion.Parametros;


public interface ParametrosDAO {

	public Parametros buscarCodigo(String codigo)
			throws DAOException;
}
