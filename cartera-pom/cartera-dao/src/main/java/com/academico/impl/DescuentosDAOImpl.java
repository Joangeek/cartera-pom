package com.academico.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cartera.TblfinTarifaMatricula;

import com.academico.DescuentosDAO;

import exceptions.DAOException;

public class DescuentosDAOImpl implements DescuentosDAO {

	static final Logger LOG = Logger.getLogger(DescuentosDAOImpl.class
			.getSimpleName());

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<TblfinTarifaMatricula> listar() throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT D FROM ");
		jpql.append(TblfinTarifaMatricula.class.getSimpleName());
		jpql.append(" D ");
		jpql.append(" JOIN FETCH 	  D.tblfinTarifa t ");
		jpql.append(" LEFT JOIN D.tblmerCategoriaComfacauca c ");
		jpql.append(" LEFT JOIN D.tblEstrato p ");
		jpql.append(" LEFT JOIN D.tblacaPrograma pr ");
		jpql.append(" LEFT JOIN D.tblacaSede se ");

		jpql.append(" ORDER BY se.oid ASC, pr.oid DESC, c.idcateComfa ASC, p.idestrato ASc ");

		List<TblfinTarifaMatricula> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		listaEntidad = ((List<TblfinTarifaMatricula>) q.getResultList());
		return listaEntidad;
	}

	@Override
	public void crear(TblfinTarifaMatricula entity,
			boolean actualizarFuenteDatos) {
		em.persist(entity);
		if (actualizarFuenteDatos) {
			em.flush();
		}
	}

	public TblfinTarifaMatricula editar(TblfinTarifaMatricula selected)
			throws DAOException {
		return em.merge(selected);
	}

	@Override
	public void eliminar(TblfinTarifaMatricula entity) throws DAOException {
		em.remove(em.merge(entity));

	}

}
