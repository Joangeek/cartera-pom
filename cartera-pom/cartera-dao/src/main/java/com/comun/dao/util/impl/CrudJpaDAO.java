package com.comun.dao.util.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.academico.impl.SedeProgramaDAOImpl;

/**
 * 
 * Implementa las operaciones comunes realizadas sobre entidades del sistema
 * 
 * @author Eduar Troyano
 * 
 * @param <T>
 * 
 */

@Stateless
@Named("crudDAO")
public class CrudJpaDAO<T> implements CrudDAO<T> {

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	private static final Logger LOG = Logger
			.getLogger(SedeProgramaDAOImpl.class.getSimpleName());

	public CrudJpaDAO() {

	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(Class<T> entityClass) {
		StringBuilder jpql = new StringBuilder();
		// System.out.println("Entre al CRRUD JpaDAO Todos");

		jpql.append("SELECT miEntidad FROM ");
		jpql.append(entityClass.getSimpleName());
		jpql.append(" miEntidad ");
		jpql.append(" ORDER BY ");
		jpql.append(" 1 ");
		List<T> listaEntidad = null;

		Query query = em.createQuery(jpql.toString());
		listaEntidad = (List<T>) query.getResultList();

		return listaEntidad;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(Class<T> entityClass,
			boolean actualizarFuenteDatos) {
		StringBuilder jpql = new StringBuilder();
		// System.out.println("Entre al CRRUD JpaDAO Todos");
		if (actualizarFuenteDatos) {
			em.flush();
			System.out.println("========== buscarTodos Flush");
		}
		jpql.append("SELECT miEntidad FROM ");
		jpql.append(entityClass.getSimpleName());
		jpql.append(" miEntidad ");

		List<T> listaEntidad = null;

		Query query = em.createQuery(jpql.toString());
		listaEntidad = (List<T>) query.getResultList();
		System.out.println("========== buscarTodos listaEntidad");
		return listaEntidad;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarLista(Class<T> entityClass, String alias,		
		String camposWhere, String camposOrderBy)
		{
		String aliasTmp = null;
		String camposOrderByTmp = null;
		if (alias == null) {
			aliasTmp = "miEntidad";
		} else {
			aliasTmp = alias;
		}
		if (camposOrderBy == null) {
			camposOrderByTmp = camposOrderBy;
		} else {
			camposOrderByTmp = " 1 ";
		}
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT");
		jpql.append(" ");
		jpql.append(aliasTmp);
		jpql.append(" ");
		jpql.append("FROM ");
		jpql.append(entityClass.getSimpleName());
		jpql.append(" ");
		jpql.append(aliasTmp);
		jpql.append(" ");
		if (camposWhere != null) {
			jpql.append("WHERE ");
			jpql.append(camposWhere);
		}
		if (camposOrderBy != null) {
			jpql.append(" ORDER BY ");
			jpql.append(camposOrderByTmp);
		}
		List<T> listaEntidad = null;
		Query query = em.createQuery(jpql.toString());
		listaEntidad = ((List<T>) query.getResultList());

		return listaEntidad;

	}

	@Override
	public void editar(T entity) {

		if (entity != null) {
			em.merge(entity);

		} else {
			LOG.info("========JpaDAO editar **");
		}

	}

	@Override
	public void refrescar(T entity) {
		em.refresh(entity);
	}

	public void crear(T entity, boolean actualizarFuenteDatos) {
		em.persist(entity);
		if (actualizarFuenteDatos) {
			em.flush();
		}
	}

	@Override
	public void remover(T entity) {
		em.remove(em.merge(entity));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public long removerEntidades(Class entidad, String alias,
			String condicionWhere) {

		if (alias == null) {
			alias = "ent";
		}

		StringBuilder jpql = new StringBuilder();
		jpql.append("DELETE FROM ");
		jpql.append(entidad.getSimpleName());
		jpql.append(" ");
		jpql.append(alias);
		jpql.append(" ");
		if (condicionWhere != null) {
			jpql.append(" WHERE ");
			jpql.append(condicionWhere);
		}
		Query query = em.createQuery(jpql.toString());
		return query.executeUpdate();

	}

	@Override
	public T buscar(Class<T> entityClass, Object id) {
		return em.find(entityClass, id);
	}

	@Override
	public T buscar(Class<T> entityClass, Long id) {
		return em.find(entityClass, id);
	}

	@Override
	public Long contarTodos(Class<T> entityClass) {
		Long resultado = null;
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT count(miEntidad) FROM ");
		jpql.append(entityClass.getSimpleName());
		jpql.append(" miEntidad ");
		Query query = em.createQuery(jpql.toString());
		resultado = (Long) query.getSingleResult();
		return resultado;
	}

	@Override
	public void crear(T entity) {
		// TODO Auto-generated method stub

	}

}
