package com.auditoria.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import auditoria.Tblingreso;

import com.auditoria.IngresoDAO;

import exceptions.DAOException;

public class IngresoDAOImpl implements IngresoDAO {

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@Override
	public void ingreso(Tblingreso ingreso) throws DAOException {
		em.persist(ingreso);
	}

}
