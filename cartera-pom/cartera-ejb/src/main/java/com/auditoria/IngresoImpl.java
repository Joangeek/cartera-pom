package com.auditoria;

import javax.ejb.Stateless;
import javax.inject.Inject;

import auditoria.Tblingreso;

import com.auditoria.IngresoDAO;
import com.gestion.IngresoBO;

import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "ingresoBO")
public class IngresoImpl implements IngresoBO {

	@Inject
	private IngresoDAO ingresoDAO;

	@Override
	public void ingreso(Tblingreso ingreso) throws BOException {
		try {
			ingresoDAO.ingreso(ingreso);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

}
