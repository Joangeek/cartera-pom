package com.cartera.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cartera.TblfinBanco;

import com.cartera.BancoDAO;

import exceptions.DAOException;

@SuppressWarnings("unchecked")
public class BancoDAOImpl implements BancoDAO {

	static final Logger LOG = Logger
			.getLogger(BancoDAOImpl.class.getSimpleName());

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@Override
	public List<TblfinBanco> buscarBancos()
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT b FROM ");
		jpql.append(TblfinBanco.class.getSimpleName());
		jpql.append(" b ");
		jpql.append(" JOIN FETCH b.tblfinTipoCuenta t ");
		jpql.append(" JOIN FETCH b.tblacaSedePrograma sp ");
		jpql.append(" JOIN FETCH sp.tblacaPrograma p ");
		jpql.append(" JOIN FETCH sp.tblacaSede s ");
		jpql.append(" ORDER BY s.oid ASC, p.oid DESC ");

		List<TblfinBanco> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		listaEntidad = (List<TblfinBanco>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public void crear(TblfinBanco entity, boolean actualizarFuenteDatos) {
		em.persist(entity);
		if (actualizarFuenteDatos) {
			em.flush();
		}
	}
	
	public TblfinBanco  editar(TblfinBanco selected)
			throws DAOException {
		return em.merge(selected);
	}

}
