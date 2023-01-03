package com.academico.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;

import com.academico.SedeprogramaDAO;

import commons.util.UtilidadBean;
import exceptions.DAOException;

@SuppressWarnings("unchecked")
public class SedeProgramaDAOImpl implements SedeprogramaDAO {

	private static final Logger LOG = Logger
			.getLogger(SedeProgramaDAOImpl.class.getSimpleName());

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@Override
	public List<TblacaSede> buscarSedes() throws DAOException {
		try {

			Query q = null;
			q = em.createNamedQuery("TblacaSede.findAll");
			return q.getResultList();

		} catch (NoResultException nre) {
			LOG.info(nre.getMessage());
			return null;
		} catch (Exception e) {
			LOG.info(e.getMessage());
			return null;
		}
	}

	@Override
	public void eliminarSede(TblacaSede entity) throws DAOException {
		em.remove(em.merge(entity));

	}

	@Override
	public void crearSede(TblacaSede entity) throws DAOException {
		em.persist(entity);

	}

	@Override
	public void editarSede(TblacaSede entity) throws DAOException {
		em.merge(entity);

	}

	@Override
	public List<TblacaPrograma> buscarProgramas() throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaPrograma.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" ORDER BY te.nombre, te.oid DESC ");

		List<TblacaPrograma> listaEntidad = null;

		Query query = em.createQuery(jpql.toString());
		listaEntidad = (List<TblacaPrograma>) query.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaPrograma> buscarProgramasActivos(boolean estado)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaPrograma.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" ORDER BY te.oid DESC ");

		List<TblacaPrograma> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());

		listaEntidad = (List<TblacaPrograma>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSede> buscarSedesActivas(boolean estado)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaSede.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" WHERE te.estado=:estado ");
		jpql.append(" ORDER BY te.oid ASC ");

		List<TblacaSede> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("estado", UtilidadBean.booleano(estado));

		listaEntidad = (List<TblacaSede>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSedePrograma> buscarPorSede(TblacaSede sede)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();

		jpql.append("SELECT sp FROM ");
		jpql.append(TblacaSedePrograma.class.getSimpleName());
		jpql.append(" sp ");
		jpql.append(" JOIN FETCH sp.tblacaPrograma pr");
		jpql.append(" WHERE  sp.tblacaSede=:sede ");
		jpql.append(" ORDER BY pr.oid DESC ");

		List<TblacaSedePrograma> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("sede", sede);
		listaEntidad = (List<TblacaSedePrograma>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSede> buscarSedesEstadoPorSp(boolean estado)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" SELECT DISTINCT te.tblacaSede FROM ");
		jpql.append(TblacaSedePrograma.class.getSimpleName());
		jpql.append(" te )");
		jpql.append(" AND se.estado=:estado ORDER BY se.oid ASC ");

		List<TblacaSede> listaEntidad = null;

		Query query = em.createQuery(jpql.toString());
		query.setParameter("estado", UtilidadBean.booleano(estado));
		listaEntidad = (List<TblacaSede>) query.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSedePrograma> buscarProgramasEstadoSp(Integer entity,
			boolean estado, boolean ofertado) throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT sp FROM ");
		jpql.append(TblacaSedePrograma.class.getSimpleName());
		jpql.append(" sp ");
		jpql.append(" JOIN FETCH sp.tblacaPrograma pr");
		jpql.append(" JOIN FETCH sp.tblacaSede se ");
		jpql.append(" WHERE  se.oid=:entity AND sp.estado=:estado AND sp.ofertado=:ofertado ");

		List<TblacaSedePrograma> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("entity", entity);
		q.setParameter("estado", UtilidadBean.booleano(estado));
		q.setParameter("ofertado", UtilidadBean.booleano(ofertado));
		listaEntidad = (List<TblacaSedePrograma>) q.getResultList();
		return listaEntidad;
	}

}
