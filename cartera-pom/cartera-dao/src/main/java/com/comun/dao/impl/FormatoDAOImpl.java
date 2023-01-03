package com.comun.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.comun.dao.FormatoDAO;

import comun.TblcalFormato;
import exceptions.DAOException;

@SuppressWarnings("unchecked")
public class FormatoDAOImpl implements FormatoDAO {

	static final Logger LOG = Logger
			.getLogger(FormatoDAOImpl.class.getSimpleName());

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@Override
	public List<TblcalFormato> listar()
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c FROM ");
		jpql.append(TblcalFormato.class.getSimpleName());
		jpql.append(" c ");
		jpql.append(" JOIN FETCH c.tblEmpresa p ");
		
		jpql.append(" ORDER BY c.idFotrmato DESC ");

		List<TblcalFormato> listaEntidad = new ArrayList<TblcalFormato>();

		Query q = em.createQuery(jpql.toString());
		listaEntidad = (List<TblcalFormato>) q.getResultList();
		LOG.info(listaEntidad.size()+"-------------------");
		return listaEntidad;
	}

	@Override
	public void crear(TblcalFormato entity, boolean actualizarFuenteDatos) {
		em.persist(entity);
		if (actualizarFuenteDatos) {
			em.flush();
		}
	}
	
	public TblcalFormato  editar(TblcalFormato selected)
			throws DAOException {
		return em.merge(selected);
	}

}
