package com.academico.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import academico.TblacaCalendarioAcademico;

import com.academico.CalendarioDAO;

import exceptions.DAOException;

@SuppressWarnings("unchecked")
public class CalendarioDAOImpl implements CalendarioDAO {

	static final Logger LOG = Logger
			.getLogger(CalendarioDAOImpl.class.getSimpleName());

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@Override
	public List<TblacaCalendarioAcademico> listar()
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c FROM ");
		jpql.append(TblacaCalendarioAcademico.class.getSimpleName());
		jpql.append(" c ");
		jpql.append(" JOIN FETCH c.tblacaPeriodo p ");
		jpql.append(" JOIN FETCH c.actCalendario ac ");
		jpql.append(" JOIN FETCH c.tblacaSede s ");
		
		jpql.append(" ORDER BY p.oid DESC, ac.idactividad DESC ");

		List<TblacaCalendarioAcademico> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		listaEntidad = (List<TblacaCalendarioAcademico>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public void crear(TblacaCalendarioAcademico entity, boolean actualizarFuenteDatos) {
		em.persist(entity);
		if (actualizarFuenteDatos) {
			em.flush();
		}
	}
	
	public TblacaCalendarioAcademico  editar(TblacaCalendarioAcademico selected)
			throws DAOException {
		return em.merge(selected);
	}

}
