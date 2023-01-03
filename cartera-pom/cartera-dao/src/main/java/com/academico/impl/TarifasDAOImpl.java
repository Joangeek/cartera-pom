package com.academico.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cartera.TblfinTarifa;

import com.academico.TarifasDAO;


//import commons.util.UtilidadBean;
import exceptions.DAOException;

public class TarifasDAOImpl implements TarifasDAO {


	static final Logger LOG = Logger
			.getLogger(TarifasDAOImpl.class.getSimpleName());

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<TblfinTarifa> listar()
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT t FROM ");
		jpql.append(TblfinTarifa.class.getSimpleName());
		jpql.append(" t ");
		jpql.append(" JOIN FETCH t.tblacaPeriodo p ");
		jpql.append(" ORDER BY p.oid DESC ");

		List<TblfinTarifa> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		listaEntidad = ((List<TblfinTarifa>) q.getResultList());
		return listaEntidad;
	}

	@Override
	public void crear(TblfinTarifa entity, boolean actualizarFuenteDatos) {
		em.persist(entity);
		if (actualizarFuenteDatos) {
			em.flush();
		}
	}
	
	public TblfinTarifa  editar(TblfinTarifa selected)
			throws DAOException {
		return em.merge(selected);
	}

}
