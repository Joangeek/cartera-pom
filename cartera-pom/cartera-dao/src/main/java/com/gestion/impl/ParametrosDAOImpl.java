package com.gestion.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import com.gestion.ParametrosDAO;

import exceptions.DAOException;
import gestion.Parametros;

@SuppressWarnings("unused")
public class ParametrosDAOImpl implements ParametrosDAO {

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	public Parametros buscarCodigo(String codigo)
			throws DAOException {
		Query q = null;
		q = em.createNamedQuery("Parametros.findCodigo").setParameter("codigo",
				codigo);
		try {
			return (Parametros) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

}
