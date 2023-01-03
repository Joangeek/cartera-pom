package com.comun.util;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.inject.Named;

import com.academico.impl.SedeProgramaDAOImpl;
import com.comun.dao.util.impl.CrudDAO;

/**
 * Permite realizar las operaciones CRUD(crear modificar eliminar consultar)
 * sobre la entidad generica <T>
 * 
 * @author Eduar Troyano
 * 
 * @param <T>
 */
@Stateless
@Named("crudBO")
public class CrudBOImpl<T> implements CrudBO<T> {

	// propiedades
	@Inject
	private CrudDAO<T> crudDAO;

	private static final Logger LOG = Logger
			.getLogger(SedeProgramaDAOImpl.class.getSimpleName());

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> buscarTodos(Class<T> entityClass) {
		List<T> lista = null;
		try {

			lista = crudDAO.buscarTodos(entityClass);

		} catch (NullPointerException e) {
			LOG.info("BUSCAR TODOS ** CrudBOImpl =========" + e);
		}

		return lista;

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> buscarTodos(Class<T> entityClass,
			boolean actualizarFuenteDatos) {
		List<T> lista = null;
		try {

			lista = crudDAO.buscarTodos(entityClass);

		} catch (NullPointerException e) {
			LOG.info("BUSCAR TODOS ** CrudBOImpl =========" + e);
		}

		return lista;

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> buscarLista(Class<T> entityClass, String alias,
			String camposWhere, String camposOrderBy) {

		return crudDAO.buscarLista(entityClass, alias, camposWhere,
				camposOrderBy);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editar(T entity) {
		crudDAO.editar(entity);

	}

	@Override
	public void crear(T entity) {
		crudDAO.crear(entity);
	}

	@Override
	public void refrescar(T entity) {
		crudDAO.refrescar(entity);
	}

	@Override
	public void crear(T entity, boolean actualizarFuenteDatos) {
		crudDAO.crear(entity, actualizarFuenteDatos);
	}

	@Override
	public void remover(T entity) {
		crudDAO.remover(entity);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public long removerEntidades(Class entidad, String alias,
			String condicionWhere) {
		return crudDAO.removerEntidades(entidad, alias, condicionWhere);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public T buscar(Class<T> entityClass, Object id) {
		return crudDAO.buscar(entityClass, id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Long contarTodos(Class<T> entityClass) {
		return crudDAO.contarTodos(entityClass);
	}

	@Override
	public T buscar(Class<T> entityClass, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
