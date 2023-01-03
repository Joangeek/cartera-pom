package com.academico.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import academico.TblacaPeriodo;

import com.academico.PeriodoDAO;

import commons.util.UtilidadBean;

//import commons.util.UtilidadBean;
import exceptions.DAOException;

public class PeriodoDAOImpl implements PeriodoDAO {

	// private static final Logger LOG = Logger.getLogger(PeriodoDAOImpl.class
	// .getSimpleName());

	/**
	 * Default no-arg constructor
	 */
	public PeriodoDAOImpl() {

	}

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@Override
	public void eliminar(TblacaPeriodo entity) throws DAOException {
		em.remove(em.merge(entity));
	}

	@Override
	public void editar(TblacaPeriodo entity) throws DAOException {
		em.merge(entity);
	}

	@Override
	public void crear(TblacaPeriodo entity) throws DAOException {
		em.persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblacaPeriodo> buscarTodos() throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaPeriodo.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" ORDER BY te.oid DESC ");

		List<TblacaPeriodo> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		listaEntidad = (List<TblacaPeriodo>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public TblacaPeriodo buscarEstado(boolean estado) throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaPeriodo.class.getSimpleName());
		jpql.append(" te WHERE te.estado =:estado");
		jpql.append(" ORDER BY te.oid DESC ");
		Query q = em.createQuery(jpql.toString());
		q.setParameter("estado", UtilidadBean.booleano(estado));
		try {
			return (TblacaPeriodo) q.getSingleResult();
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TblacaPeriodo> buscarTodosLimite(Integer limit, Integer offSet)
			throws DAOException {

		List<TblacaPeriodo> listaEntidad = new ArrayList<TblacaPeriodo>();

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT p FROM ");
		jpql.append(TblacaPeriodo.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" ORDER BY p.anio DESC p.semestre DESC ");

		Query q = em.createQuery(jpql.toString());
		q.setFirstResult(offSet);
		q.setMaxResults(limit);

		listaEntidad = (List<TblacaPeriodo>) q.getResultList();

		return listaEntidad;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> buscarAnios() throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT p.anio FROM ");
		jpql.append(TblacaPeriodo.class.getSimpleName());
		jpql.append(" p ");
		jpql.append(" ORDER BY p.anio DESC ");

		Query q = em.createQuery(jpql.toString());

		return q.getResultList();
	}

	public void buscar() {

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT p.anio FROM ");
		jpql.append(TblacaPeriodo.class.getSimpleName());
		jpql.append(" p ");
		jpql.append(" ORDER BY p.anio DESC ");

		Query q = em.createQuery(jpql.toString());

		q.getResultList();
	}

	@Override
	public TblacaPeriodo buscarperiodoPreincripcion() throws DAOException {
		StringBuilder jpql = new StringBuilder();
		boolean estado = true;

		jpql.append("SELECT te FROM ");
		jpql.append(TblacaPeriodo.class.getSimpleName());
		jpql.append(" te WHERE te.preinscripcion =:estado ");
		Query q = em.createQuery(jpql.toString());
		q.setParameter("estado", UtilidadBean.booleano(estado));
		try {
			return (TblacaPeriodo) q.getSingleResult();
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

}
