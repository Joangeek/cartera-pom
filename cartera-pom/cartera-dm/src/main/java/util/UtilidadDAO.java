package util;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;

public class UtilidadDAO {

	private static final Logger LOGGER = Logger.getLogger(UtilidadDAO.class
			.getName());

	private UtilidadDAO() {
	}

	// Persistencia

	public static <T> Object persistirObject(EntityManager entityManager,
			Object object) throws DAOException {
		try {
			entityManager.persist(object);
			return object;
		} catch (RollbackException ex) {
			throw new EntityExistsException(ex);
		} catch (SecurityException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (IllegalStateException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (ConstraintViolationException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
	}

	// Mergers
	public static <T> Object mergeObject(EntityManager entityManager,
			Object object) throws DAOException {
		try {
			entityManager.merge(object);
			return object;
		} catch (RollbackException ex) {
			throw new EntityExistsException(ex);
		} catch (SecurityException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (IllegalStateException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (ConstraintViolationException e) {
			throw new DAOException(e.getMessage(), e);
		} catch (PersistenceException e) {
			throw new DAOException(e.getMessage(), e);
		}
	}

	// retornos

	public static <T> List<T> retornarLista(TypedQuery<T> tq)
			throws DAOException {
		try {
			return tq.getResultList();
		} catch (QueryTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_QUERY_TIMEOUT_EXCEPTION, ex);
		} catch (TransactionRequiredException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_TRANSACTION_REQUIRED_EXCEPTION,
					ex);
		} catch (PessimisticLockException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PESSIMISTIC_LOCK_EXCEPTION, ex);
		} catch (LockTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_LOCK_TIMEOUT_EXCEPTION, ex);
		} catch (PersistenceException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PERSISTENCE_EXCEPTION, ex);
		}
	}

	public static <T> List<T> retornarListaAutoservicio(TypedQuery<T> tq)
			throws DAOException {
		try {
			return tq.getResultList();
		} catch (QueryTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_QUERY_TIMEOUT_EXCEPTION, ex);
		} catch (TransactionRequiredException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_TRANSACTION_REQUIRED_EXCEPTION,
					ex);
		} catch (PessimisticLockException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PESSIMISTIC_LOCK_EXCEPTION, ex);
		} catch (LockTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_LOCK_TIMEOUT_EXCEPTION, ex);
		} catch (PersistenceException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PERSISTENCE_EXCEPTION, ex);
		}
	}

	public static <T> T retornarRegistro(TypedQuery<T> tq) throws DAOException {
		try {
			return tq.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		} catch (NonUniqueResultException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_NON_UNIQUE_RESULT_EXCEPTION, ex);
		} catch (QueryTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_QUERY_TIMEOUT_EXCEPTION, ex);
		} catch (TransactionRequiredException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_TRANSACTION_REQUIRED_EXCEPTION,
					ex);
		} catch (PessimisticLockException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PESSIMISTIC_LOCK_EXCEPTION, ex);
		} catch (LockTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_LOCK_TIMEOUT_EXCEPTION, ex);
		} catch (PersistenceException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PERSISTENCE_EXCEPTION, ex);
		}
	}

	public static <T> T retornarRegistroAutoservicio(TypedQuery<T> tq)
			throws DAOException {
		try {
			return tq.getSingleResult();
		} catch (NoResultException ex) {
			LOGGER.log(Level.INFO, ex.getMessage(), ex);
			return null;
		} catch (NonUniqueResultException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_NON_UNIQUE_RESULT_EXCEPTION, ex);
		} catch (QueryTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_QUERY_TIMEOUT_EXCEPTION, ex);
		} catch (TransactionRequiredException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_TRANSACTION_REQUIRED_EXCEPTION,
					ex);
		} catch (PessimisticLockException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PESSIMISTIC_LOCK_EXCEPTION, ex);
		} catch (LockTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_LOCK_TIMEOUT_EXCEPTION, ex);
		} catch (PersistenceException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PERSISTENCE_EXCEPTION, ex);
		}
	}

	public static Long retornarConteoAutoservicio(TypedQuery<Long> tq)
			throws DAOException {
		try {
			return tq.getSingleResult();
		} catch (NoResultException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_NO_RESULT_EXCEPTION, ex);
		} catch (NonUniqueResultException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_NON_UNIQUE_RESULT_EXCEPTION, ex);
		} catch (QueryTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_QUERY_TIMEOUT_EXCEPTION, ex);
		} catch (TransactionRequiredException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_TRANSACTION_REQUIRED_EXCEPTION,
					ex);
		} catch (PessimisticLockException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PESSIMISTIC_LOCK_EXCEPTION, ex);
		} catch (LockTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_LOCK_TIMEOUT_EXCEPTION, ex);
		} catch (PersistenceException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PERSISTENCE_EXCEPTION, ex);
		} catch (IllegalStateException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_ILLEGAL_STATE_EXCEPTION, ex);
		}
	}

	public static Long retornarConteo(TypedQuery<Long> tq) throws DAOException {
		try {
			return tq.getSingleResult();
		} catch (NoResultException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_NO_RESULT_EXCEPTION, ex);
		} catch (NonUniqueResultException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_NON_UNIQUE_RESULT_EXCEPTION, ex);
		} catch (QueryTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_QUERY_TIMEOUT_EXCEPTION, ex);
		} catch (TransactionRequiredException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_TRANSACTION_REQUIRED_EXCEPTION,
					ex);
		} catch (PessimisticLockException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PESSIMISTIC_LOCK_EXCEPTION, ex);
		} catch (LockTimeoutException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_LOCK_TIMEOUT_EXCEPTION, ex);
		} catch (PersistenceException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_PERSISTENCE_EXCEPTION, ex);
		} catch (IllegalStateException ex) {
			throw new DAOException(
					ConfiguracionesSQL.MENSAJE_ILLEGAL_STATE_EXCEPTION, ex);
		}
	}

	// filtros

	public static String adicionarOrdenamiento(String jpql,
			Map<String, String> filters, String alias, String sortField,
			String sortOrderS) {
		if (ConfiguracionesSQL.NULO != sortField && !sortField.isEmpty()) {
			return jpql + "ORDER BY " + alias + "." + sortField + " "
					+ sortOrderS + " ";
		}
		return jpql;
	}

	public static <T> TypedQuery<T> asignarValores(TypedQuery<T> tq,
			Map<String, String> filters) {
		if (ConfiguracionesSQL.NULO != tq && ConfiguracionesSQL.NULO != filters
				&& !filters.isEmpty()) {
			int i = 0;
			for (Entry<String, String> entry : filters.entrySet()) {
				if (ConfiguracionesSQL.NULO != entry.getValue()
						&& !entry.getValue().isEmpty()) {
					// tq.setParameter(entry.getKey(), "%" + entry.getValue() +
					// "%");
					tq.setParameter("var" + i, "%" + entry.getValue() + "%");
				}
				i++;
			}
		}
		return tq;
	}

	public static String adicionarFiltros(String jpql,
			Map<String, String> filters, String alias) {
		final StringBuilder wheres = new StringBuilder();
		if (ConfiguracionesSQL.NULO != filters && !filters.isEmpty()) {
			wheres.append(ConfiguracionesSQL.WHERE + "1=1 ");
			int i = 0;
			for (Entry<String, String> entry : filters.entrySet()) {
				if (ConfiguracionesSQL.NULO != entry.getValue()
						&& !entry.getValue().isEmpty()) {
					// wheres.append("AND UPPER(" + alias + "." + entry.getKey()
					// + ") LIKE UPPER(:" + entry.getKey() + ") ");
					wheres.append("AND UPPER(" + alias + "." + entry.getKey()
							+ ") LIKE UPPER(:var" + i + ") ");
				}
				i++;
			}
		}
		return jpql + wheres;
	}

	public static <T> boolean validaNulos(T entidad) {
		if (entidad == null) {
			return false;
		}
		return true;
	}

	public static <E> boolean validaVacios(List<E> lista) {
		if (validaNulos(lista)) {
			if (lista.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public static <E> boolean isNotEmpty(String cadena) {
		return validaNulos(cadena) && !cadena.isEmpty();
	}

	public static <T> boolean isNull(T obj) {
		return (null == obj);
	}

	public static boolean isFalse(boolean sentencia) {
		return !sentencia;
	}

	/**
	 * Metodo para validar si el valor del objeto es 0
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean valorDiferenteCero(Long obj) {
		if (obj.equals(0L)) {
			return false;
		}
		return true;
	}

	/**
	 * Recupera el nombre de la tabla a la cual esta asociada la entidad JPA
	 * 
	 * @param claseDeEntidad
	 *            de tipo class la cual se puede obtener por ejemplo a si
	 *            miEntidad.class
	 * @return Cadena con el nombre de la tabla
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String obtenerNombreTablaBD(Class claseDeEntidad) {
		String nombreTabla = null;
		Annotation annotation;
		try {
			annotation = claseDeEntidad
					.getAnnotation(javax.persistence.Table.class);
			Table tabla = (Table) annotation;
			nombreTabla = tabla.name();
		} catch (Exception e) {
			nombreTabla = null;
		}

		return nombreTabla;
	}

}
