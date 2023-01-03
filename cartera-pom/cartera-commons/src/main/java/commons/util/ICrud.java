package commons.util;

import java.util.List;

/**
 * @author Eduar Troyano
 * 
 */
public interface ICrud<T> {

	/**
	 * Crea un registro en la base de datos
	 * 
	 * @param entity
	 *            objeto a almacenar
	 */
	public void crear(T entity);

	/**
	 * Actualiza los datos de la entidad con los encontrados en la fuente de datos
	 * 
	 * @param entity
	 *            objeto a almacenar
	 */
	public void refrescar(T entity);
	
	/**
	 * Crea un registro en la base de datos
	 * 
	 * @param entity
	 *            objeto a almacenar
	 * 
	 * @param actualizarFuenteDatos actualiza la fuente de datos
	 */
	public void crear(T entity,boolean actualizarFuenteDatos);
	
	/**
	 * Modifica un registro en la base de datos
	 * 
	 * @param entity
	 *            objeto a modificar
	 */
	public void editar(T entity);

	/**
	 * Eliminar un registro de la base de datos
	 * 
	 * @param entity
	 *            objeto a eliminar
	 */
	public void remover(T entity);

	/**
	 * Eliminar registros de la base de datos en base a una condicion
	 * 
	 * @param entidad
	 *            objeto a eliminar
	 * 
	 * @param alias
	 *            sobre nombre puesta a la entidad en la consulta
	 * 
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public long removerEntidades(Class entidad, String alias,
			String condicionWhere);

	/**
	 * Buscar un objeto a partir del id
	 * 
	 * @param id
	 *            llave primaria del registro a buscar
	 * @return objeto buscado
	 */
	public T buscar(Class<T> entityClass, Object id);
	
	public T buscar(Class<T> entityClass, Long id);

	/**
	 * Buscar un objeto a partir del id
	 * 
	 * @param entityClass
	 *            tipo de clase {@link Class} perteneciente a una entidad a
	 *            buscar
	 * 
	 * @return objeto buscado
	 * 
	 */
	public List<T> buscarTodos(Class<T> entityClass);

	public List<T> buscarTodos(Class<T> entityClass, boolean actualizarFuenteDatos);

	/**
	 * Permite consultar una lista de entidades adicionando opcionalmente
	 * filtros en Where o campos de orden en el Order By
	 * 
	 * @param entityClass
	 *            tipo de entidad a buscar
	 * 
	 * @param alias
	 *            Coloca un sobre Nombre a la entidad que se consulta por
	 *            ejemplo para la entidad Persona podria ser "per"
	 * 
	 * @param Where
	 *            Campos que sirven como filtro en la consulta. Por ejemplo, si
	 *            la entidad Persona con alias "per" tiene un campo
	 *            identificacion, el campo seria "per.identificacion". Pero si
	 *            la misma entidad tiene una relacion con otra entidad, ejemplo
	 *            telefono, el campo seria "per.telefono.id".
	 * @param camposOrderBy
	 *            Campos usandos para ordenar los resultados.
	 * 
	 * @return lista de entidades <T>
	 * 
	 */

	public List<T> buscarLista(Class<T> claseEntidad, String alias,
			String where, String orden);
	
	/**
	 * 
	 * Cuenta todos los registros existente para la entidad dada
	 * 
	 * @return numero de registros existentes
	 * 
	 */
	public Long contarTodos(Class<T> entityClass);


}
