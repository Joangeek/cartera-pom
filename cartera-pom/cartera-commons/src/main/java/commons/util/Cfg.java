package commons.util;

/**
 * @author Eduar Troyano
 * 
 */
public final class Cfg {

	// expresion regular contraseña

	public static final String CARACTERES_ESPECIALES = "\\!\\”\\#\\$\\%\\/\\(\\)\\=\\?\\¡\\¿\\¨\\+\\[\\*\\]\\,\\-\\<\\>";

	public static final Object NULO = null;

	// PERSISTENCE

	public static final String SELECT = "SELECT ";
	public static final String FROM = "FROM ";
	public static final String WHERE = "WHERE ";
	public static final String ORDERBY = "ORDER BY ";
	public static final String ESPACIO = " ";
	public static final String DISTINCT = "DISCTINCT ";
	public static final String DESC = "DESC ";
	public static final String AND = "AND ";
	public static final String OR = "OR ";
	public static final String JOIN_FETCH = "JOIN FETCH ";
	public static final String LEFT_JOIN_FETCH = "LEFT JOIN FETCH ";
	public static final String MAX = "MAX";

	// EXCEPTIONS

	public static final String EXCEPCION_BASE_DATOS = "exceptions.baseDatos";
	public static final String EXCEPCION_NO_RESULTADOS = "exceptions.dao.noResultados";
	public static final String EXCEPCION_NO_UNICO_VALOR = "exceptions.dao.noUnicoValor";

	// Gestionar
	public static final String TERMINADA = "TERMINADO";
	public static final String EN_PROCESO = "EN PROCESO";
	public static final String RESPUESTA = "RESPUESTA ENTREGADA";

	// GENERALES

	public static final boolean TRUE = true;
	public static final boolean FALSE = false;

	// TIPO ASPECTOS

	/**
	 * BOTONES
	 */
	public static final String REGRESAR = "REGRESAR";
	public static final String CREAR = "CREAR";
	public static final String EDITAR = "EDITAR";
	public static final String ELIMINAR = "ELIMINAR";
	public static final String ESTADO = "ESTADO";
	public static final String CONFIGURAR = "CONFIGURAR";
	public static final Object ASPECTOS = "ASPECTOS";
	public static final Object PROGRAMAR = "PROGRAMAR";
	public static final Object PREVISUALIZAR = "PREVISUALIZAR";
	
	public static final String FACTORES = "FACTORES";
	public static final Object CARACTERISTICAS = "CARACTERISTICAS";
	public static final Object INDICADORES = "INDICADORS";
	public static final Object VIGENCIAS = "VIGENCIAS";
}
