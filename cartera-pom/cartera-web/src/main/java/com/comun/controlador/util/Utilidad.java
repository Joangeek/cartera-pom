package com.comun.controlador.util;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletException;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.primefaces.context.RequestContext;

import com.comun.controlador.util.JsfMessageService.SourceBundle;

public class Utilidad {
	private final static String JS_TRY = "try{";
	private final static String JS_CATH = " }catch(err){console.info('ERROR [comun.controlador.util.Utilidad] '+err)}";
	// private static final String ERROR = "ERROR";
	// private static final String OBTENIENDO = " obteniendo Ejb ";

	private final static Logger LOG = Logger
			.getLogger(Utilidad.class.getName());

	public static void buscarHtmlComponente() {

	}

	public static MethodExpression crear_MethodExpression(
			String valueExpression, Class<?> valueType,
			Class<?>[] expectedParamTypes) {
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext
				.getApplication()
				.getExpressionFactory()
				.createMethodExpression(facesContext.getELContext(),
						valueExpression, valueType, expectedParamTypes);
	}

	/**
	 * 
	 * @param fecha
	 * @return
	 */
	public static String convertirFecha(Object fecha) {
		final DateFormat formato = DateFormat.getDateInstance();
		return formato.format(fecha);

	}

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
			LOG.log(Level.INFO, e.getMessage(), e);
			nombreTabla = null;
		}

		return nombreTabla;
	}

	/**
	 * Se encasula un nuemro de cuenta y se deja los tres ultimos digitos
	 * visibles
	 * 
	 * @param nuemerocuenta
	 * @return
	 */
	public static String encasuladodeNumeroCuenta(String nuemerocuenta) {
		StringBuilder var = new StringBuilder();
		StringBuilder resultado = new StringBuilder();
		if (Utilidad.cadenaVacia(nuemerocuenta)) {
			nuemerocuenta.split(nuemerocuenta);
			int cont = nuemerocuenta.length() - 3;
			for (int i = cont; i < nuemerocuenta.length(); i++) {
				var.append(nuemerocuenta.charAt(i));
			}
			resultado.append("*****").append(var.toString());
		}
		return resultado.toString();
	}

	// Modificacion sonar, los nombres de metodos no pueden tener caracteres
	// Especiales
	// por: Victor Sevilla
	public static MethodExpression crearMethodExpression(
			String valueExpression, Class<?> valueType,
			Class<?>[] expectedParamTypes) {
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext
				.getApplication()
				.getExpressionFactory()
				.createMethodExpression(facesContext.getELContext(),
						valueExpression, valueType, expectedParamTypes);
	}

	/**
	 * 
	 * @param listaMapa
	 * @return
	 */
	public static boolean validarMap(Map<String, String> listaMapa) {
		if (listaMapa == null) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que permite a una fecha especifica agragarle dias.
	 * 
	 * @param date
	 *            , Fecha original
	 * @param days
	 *            , dias a agregar, con signo menos se resta.
	 * @return retorna la fecha modificada.
	 */
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date addMonth(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	// Modificacion sonar, los nombres de metodos no pueden tener caracteres
	// Especiales
	// por: Victor Sevilla
	public static ValueExpression crearValueExpression(String valueExpression,
			Class<?> expectedParamTypes) {
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext
				.getApplication()
				.getExpressionFactory()
				.createValueExpression(facesContext.getELContext(),
						valueExpression, expectedParamTypes);
	}

	public static void ejecutarJavaScript(String js) {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.execute(JS_TRY + js + JS_CATH);
	}

	public static void ejecutarUpdate(String id) {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.update(id);
	}

	public static void reset(String id) {
		final RequestContext context = RequestContext.getCurrentInstance();
		context.reset(id);
	}

	public static UIComponent buscarHtmlComponete(String idComponete) {
		final FacesContext context = FacesContext.getCurrentInstance();
		if (null != context) {
			return buscarHtmlComponete(context.getViewRoot(), idComponete);
		}
		return null;
	}

	public static UIComponent buscarHtmlComponete(UIComponent parent,
			String idComponete) {
		if (idComponete.equals(parent.getId())) {
			return parent;
		}
		final Iterator<UIComponent> kids = parent.getFacetsAndChildren();
		while (kids.hasNext()) {
			final UIComponent kid = kids.next();
			final UIComponent found = buscarHtmlComponete(kid, idComponete);
			if (found != null) {
				return found;
			}
		}
		return null;
	}

	public static void redireccionar(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(url);
		} catch (IOException e) {
			LOG.log(Level.INFO, "ERROR al redireccionar()" + e.getMessage(), e);
		}
	}
	/**
	 * @autor Eduar troyano
	 * @param url
	 */
	public static void redireccionarDir(String url) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext ext = ctx.getExternalContext();
		
		String ruta = ext.encodeActionURL(ctx.getApplication().getViewHandler()
				.getActionURL(ctx, url));
		//LOG.info("-------------------------------- > "+ruta);
		try {
			ext.redirect(ruta);
		} catch (IOException e) {
			LOG.log(Level.INFO, "ERROR al redireccionar()" + e.getMessage(), e);
			throw new FaceletException(e);
		}
	
		
	}

	public static void mensajeError(String... mensajes) {
		final FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				mensajes[0], mensajes[1]));
	}

	public static void mensajeWarnning(SourceBundle bundle, String... mensajes) {
		JsfMessageService.displayStaticMessage(bundle,
				JsfMessageService.MessageSeverity.SEVERITY_WARN, mensajes[0],
				mensajes[1]);
	}

	public static void mensajeWarnningBundle(SourceBundle bundle,
			String mensajes, String component) {
		JsfMessageService.displayStaticMessage(bundle,
				JsfMessageService.MessageSeverity.SEVERITY_WARN, mensajes,
				mensajes, component);
	}

	// jdni base este puede cambiar segun jboss o la vercion de la aplicacion
	// java:global/global-vpm-ear/global-vpm-web-1.0-SNAPSHOT/genericoBO!com.hds.vpm.business.GenericoBO
	public static String getJndi(Class<?> clase) {
		final StringBuilder jndi = new StringBuilder();
		jndi.append("java:global/global-vpm-ear/global-vpm-web-1.0-SNAPSHOT/");
		jndi.append(upCapitalize(clase.getSimpleName()));
		jndi.append("!");
		jndi.append(clase.getName());
		return jndi.toString();
	}

	// Metodo sin utilizar por eso se comenta
	// public static <T> T getEjb(Class<?> claseBO) {
	// try {
	// final Context jndiContext;
	// jndiContext = new InitialContext();
	// final String jndiNombe = Utilidad.getJndi(claseBO);
	// return (T) jndiContext.lookup(jndiNombe);
	// } catch (NamingException e) {
	// LOG.info("\t\tERROR Ejb " + e.getMessage());
	// } catch (RuntimeException e) {
	// LOG.info("\t\tERROR Ejbs " + e.getMessage());
	// } catch (Exception e) {
	// LOG.info("\t\tERROR obteniendo Ejb " + e.getMessage());
	// }
	// return null;
	// }

	public static String capitalize(String cadena) {
		final String primera = cadena.substring(0, 1);
		// correcion sonar por Victor Sevilla
		// cadena = cadena.substring(1);
		return primera.toUpperCase() + cadena.substring(1);
	}

	public static String upCapitalize(String cadena) {
		final String primera = cadena.substring(0, 1);
		// correcion sonar por Victor Sevilla
		// cadena = cadena.substring(1);
		return primera.toLowerCase() + cadena.substring(1);
	}

	/**
	 * Crea un identificador &uacute;nico universal con un tamaño fijo de 36
	 * caracteres
	 * 
	 * @return cadena con el identificar &uacute;nico universal
	 * 
	 * @author Fredy Dorado
	 */
	public static String obtenerUUID() {
		return java.util.UUID.randomUUID().toString();
	}

	public static void permitirEjecutarJavaScript(Object obj) {
		final RequestContext requestContext = RequestContext
				.getCurrentInstance();
		requestContext.addCallbackParam("isValid", obj);
	}

	public static void fijarPropiedad(Object bean, String pro, Object value) {
		try {
			BeanUtilsBean.getInstance().setProperty(bean, pro, value);
		} catch (IllegalArgumentException e) {
			LOG.log(Level.SEVERE, "catch permitirEjecutar " + e.getMessage(), e);
		} catch (RuntimeException e) {
			LOG.log(Level.SEVERE, "catch " + e.getMessage(), e);
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					"catch permitirEjecutarJavaScript " + e.getMessage(), e);
		}
	}

	public static String obtenerPropiedad(Object entidad, String propiedad) {
		try {
			return BeanUtilsBean.getInstance().getProperty(entidad, propiedad);
		} catch (IllegalArgumentException e) {
			LOG.log(Level.SEVERE, e.getMessage(), e);
		} catch (RuntimeException e) {
			LOG.log(Level.SEVERE, e.getMessage(), e);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	public static <T> Object getValueMethodExpression(String expression,
			Class<? extends T> expectedType) {
		return FacesContext
				.getCurrentInstance()
				.getApplication()
				.evaluateExpressionGet(FacesContext.getCurrentInstance(),
						expression, expectedType);
	}

	public static Object obtenerPropiedadAsObject(Object entidad,
			String propiedad) {
		try {
			return BeanUtilsBean.getInstance().getPropertyUtils()
					.getNestedProperty(entidad, propiedad);
		} catch (IllegalArgumentException e) {
			LOG.log(Level.SEVERE,
					"ERROR catch 1 " + propiedad + " " + e.getMessage(), e);
		} catch (RuntimeException e) {
			LOG.log(Level.SEVERE,
					"ERROR catch 2 " + propiedad + " " + e.getMessage(), e);
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					"ERROR catch 3 " + propiedad + " " + e.getMessage(), e);
		}
		return null;
	}

	public static <T> T obtenerEntidadPorID(long id, List<T> listaEntidad,
			String nombreIdIn) {
		long idBuscado;
		String nombreId = nombreIdIn;
		if (null == nombreId) {
			nombreId = "id";
		}
		try {
			for (T entidadTemp : listaEntidad) {
				idBuscado = Long.parseLong(BeanUtils.getProperty(entidadTemp,
						nombreId));
				if (idBuscado == id) {
					return entidadTemp;
				}
			}
		} catch (NumberFormatException numberFormatException) {
			LOG.log(Level.SEVERE,
					"ERROR 1" + numberFormatException.getMessage(),
					numberFormatException);
		} catch (IllegalAccessException illegalAccessException) {
			LOG.log(Level.SEVERE,
					"ERROR 2" + illegalAccessException.getMessage(),
					illegalAccessException);
		} catch (InvocationTargetException invocationTargetException) {
			LOG.log(Level.SEVERE,
					"ERROR 3" + invocationTargetException.getMessage(),
					invocationTargetException);
		} catch (NoSuchMethodException noSuchMethodException) {
			LOG.log(Level.SEVERE,
					"ERROR 4" + noSuchMethodException.getMessage(),
					noSuchMethodException);
		}
		return null;
	}

	public static boolean cadenaVacia(String cadena) {
		boolean cadenaVacia = false;
		if (cadena == null || cadena.trim().isEmpty()) {
			cadenaVacia = true;
		}
		return cadenaVacia;
	}

	public static boolean cadenaConDatos(String cadena) {
		if (cadena == null || cadena.trim().isEmpty()) {
			return false;
		}
		return true;

	}

	public static void actualizarComponente(String id) {
		final UIComponent component = Utilidad.buscarHtmlComponete(id);
		if (isNull(component)) {
			LOG.log(Level.SEVERE, String.format(
					"Componente con id \"%s\" no existe en la vista", id));
			return;
		}
		Utilidad.ejecutarUpdate(component.getClientId());
	}

	public static void actualizarComponentes(String... idComponentes) {
		for (String id : idComponentes) {
			actualizarComponente(id);
		}
	}

	/**
	 * Función que elimina todos os espacios vacios o en blanco de una cadena de
	 * texto, entre sus funciones esta validar si la cadena pasada como
	 * parámetro se encuentra vacia, si es asi retorna nul.
	 * 
	 * @param cadena
	 *            cadena de texto a eliminar los espacios vacios
	 * 
	 * @return la cadena sin los espacios vacios, o <b>null</b> si la cadena no
	 *         es valida.
	 * 
	 */
	public static String eliminarEspaciosEnBlanco(String cadena) {
		if (cadenaVacia(cadena)) {
			return null;
		} else {
			cadena = cadena.replace(" ", "");
			return cadena.trim();
		}
	}

	/**
	 * Función que convierte a String el objeto pasado como parámetro, pueden
	 * ser objetos tipo Long, Integer, BigDecimal. Si el objeto se encuentra
	 * nulo retorna una cadena vacia.
	 * 
	 * @param obj
	 *            Objeto a convertir.
	 * 
	 * @return El objeto convertido en cadena (String). Si el objeto parámetro
	 *         esta nulo retorna una cadena vacia.
	 */
	public static String aString(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	/**
	 * Funcion que permite validar nulos
	 * 
	 * @param <T>
	 * @return boolean
	 */
	public static <T> boolean validaNulos(T entidad) {
		if (null == entidad) {
			return false;
		}
		return true;
	}

	public static boolean validarFechas(Date fecha) {
		if (fecha == null) {
			return true;
		}
		return false;
	}

	/**
	 * Funcion que permite validar si una lista esta vacia
	 * 
	 * @author
	 * @param List
	 *            <E>
	 * @return boolean
	 */
	public static <E> boolean validaVacios(List<E> lista) {
		if (validaNulos(lista) && lista.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo para validar si el tamaño de la lista es cero
	 * 
	 * @param lista
	 * @return
	 */
	public static <E> boolean listaVacia(List<E> lista) {
		if (validaNulos(lista)) {
			if (lista.size() == 0) {
				return true;
			}
			return false;
		}
		return true;
	}

	/**
	 * Funcion que retorna true si un objeto es nulo
	 * 
	 * @param obj
	 * @return boolean
	 */
	public static <T> boolean isNull(T obj) {
		return (null == obj);
	}

	public static <T> boolean isNotNull(T obj) {
		return (null != obj);
	}

	public static boolean isFalse(boolean sentencia) {
		return !sentencia;
	}

	public static void mensajeError(String mensaje) {
		final FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				mensaje, mensaje));
	}

	public static void mensajeWarnning(String mensaje) {
		final FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				mensaje, mensaje));
	}

	public static void mensajeInfo(String mensaje) {
		final FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				mensaje, mensaje));
	}

	public static void lanzaMensaje() {
		RequestContext.getCurrentInstance().update(
				Utilidad.buscarHtmlComponete("mensajes").getClientId(
						FacesContext.getCurrentInstance()));
	}

	public static void lanzaMensaje(String component) {
		RequestContext.getCurrentInstance().update(
				Utilidad.buscarHtmlComponete(component).getClientId(
						FacesContext.getCurrentInstance()));
	}

	public static void lanzaMensajeInfo(String mensaje) {
		JsfMessageService.displayStaticMessage(
				JsfMessageService.SourceBundle.COMUN,
				JsfMessageService.MessageSeverity.SEVERITY_INFO, mensaje,
				mensaje);
	}

	public static void lanzaMensajeInfoToolbar(String mensaje) {
		JsfMessageService.displayStaticMessage(
				JsfMessageService.SourceBundle.TOOLBAR,
				JsfMessageService.MessageSeverity.SEVERITY_INFO, mensaje,
				mensaje);
	}

	public static void lanzaMensajeInfo(SourceBundle bundle, String... mensaje) {
		JsfMessageService.displayStaticMessage(bundle,
				JsfMessageService.MessageSeverity.SEVERITY_INFO, mensaje[0],
				mensaje[1]);
	}

	/**
	 * Calcula la edad
	 * 
	 * @param fechaNacimiento
	 *            el la fecha que se va a convertir al formato edad definido
	 * @return (numero de años)A o (numero de meses)M o (numero de dias)D
	 *         ejemplo 15A o 10M o 15D, depende de la edad de la persona
	 */
	public static String calcularEdad(Date fechaNacimiento) {
		return obtenerEdad(fechaNacimiento, false);
	}

	/**
	 * Calcula la edad corrdio
	 * 
	 * @param fechaNacimiento
	 *            el la fecha que se va a convertir al formato edad definido
	 * @return (numero de años)A o (numero de meses)M o (numero de dias)D
	 *         ejemplo 15A o 10M o 15D, depende de la edad de la persona
	 */
	public static String calcularEdadcorrido(Date fechaNacimiento,
			Date fechacorrido) {
		return obtenerEdadcorrido(fechaNacimiento, false, fechacorrido);
	}

	public static String calcularEdad(Date fechaNacimiento,
			boolean textoCompleto) {
		return obtenerEdad(fechaNacimiento, textoCompleto);
	}

	@SuppressWarnings("deprecation")
	private static String obtenerEdad(Date fechaNacimiento,
			boolean textoCompleto) {
		Date fechaActual = new Date();
		int anios = 0;
		int meses = 0;
		int dias = 0;
		if (fechaNacimiento != null) {
			anios = fechaActual.getYear() - fechaNacimiento.getYear();
			meses = fechaActual.getMonth() - fechaNacimiento.getMonth();
			dias = fechaActual.getDate() - fechaNacimiento.getDate();

			if (dias < 0) {
				meses = meses - 1;
				// valida cada mes para sumarle los días
				// meses en los que hay 30 días
				if (fechaNacimiento.getMonth() == 4
						|| fechaNacimiento.getMonth() == 5
						|| fechaNacimiento.getMonth() == 8
						|| fechaNacimiento.getMonth() == 10) {
					dias = 30 + dias;
				} // febrero
				else if (fechaNacimiento.getMonth() == 1) {
					if ((fechaActual.getYear() % 4 == 0)
							&& ((fechaActual.getYear() % 100 != 0) || (fechaActual
									.getYear() % 400 == 0))) {
						dias = 29 + dias;
					} else {
						dias = 28 + dias;
					}
				} // meses en los que hay 31 dias
				else {
					dias = 31 + dias;
				}
			}
			if (meses < 0) {
				anios = anios - 1;
				meses = meses + 12;
			}
		}

		if (textoCompleto == false) {
			if (anios > 0) {
				return anios + "A";
			} else if (meses > 0) {
				return meses + "M";
			} else if (dias > 0) {
				return dias + "D";
			} else {
				return "";
			}
		} else {
			return anios + "A," + meses + "M," + dias + "D";
		}
	}

	@SuppressWarnings("deprecation")
	private static String obtenerEdadcorrido(Date fechaNacimiento,
			boolean textoCompleto, Date fechacorrido) {
		Date fechaActual = fechacorrido;
		int anios = 0;
		int meses = 0;
		int dias = 0;
		if (fechaNacimiento != null) {
			anios = fechaActual.getYear() - fechaNacimiento.getYear();
			meses = fechaActual.getMonth() - fechaNacimiento.getMonth();
			dias = fechaActual.getDate() - fechaNacimiento.getDate();

			if (dias < 0) {
				meses = meses - 1;
				// valida cada mes para sumarle los días
				// meses en los que hay 30 días
				if (fechaNacimiento.getMonth() == 4
						|| fechaNacimiento.getMonth() == 5
						|| fechaNacimiento.getMonth() == 8
						|| fechaNacimiento.getMonth() == 10) {
					dias = 30 + dias;
				} // febrero
				else if (fechaNacimiento.getMonth() == 1) {
					if ((fechaActual.getYear() % 4 == 0)
							&& ((fechaActual.getYear() % 100 != 0) || (fechaActual
									.getYear() % 400 == 0))) {
						dias = 29 + dias;
					} else {
						dias = 28 + dias;
					}
				} // meses en los que hay 31 dias
				else {
					dias = 31 + dias;
				}
			}
			if (meses < 0) {
				anios = anios - 1;
				meses = meses + 12;
			}
		}

		if (textoCompleto == false) {
			if (anios > 0) {
				return anios + "A";
			} else if (meses > 0) {
				return meses + "M";
			} else if (dias > 0) {
				return dias + "D";
			} else {
				return "";
			}
		} else {
			return anios + "A," + meses + "M," + dias + "D";
		}
	}

	public static <T> boolean noEsNulo(T objeto) {

		return !(objeto == null);

	}

	public static Date primerDiaDelMes(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.getActualMinimum(Calendar.DAY_OF_MONTH),
				cal.getMinimum(Calendar.HOUR_OF_DAY),
				cal.getMinimum(Calendar.MINUTE),
				cal.getMinimum(Calendar.SECOND));
		return cal.getTime();
	}

	public static Date ultimoDiaDelMes(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.getActualMaximum(Calendar.DAY_OF_MONTH),
				cal.getMaximum(Calendar.HOUR_OF_DAY),
				cal.getMaximum(Calendar.MINUTE),
				cal.getMaximum(Calendar.SECOND));
		return cal.getTime();
	}

	public static Date addMinutesToDate(Date date, int minutes) {
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.setTime(date);
		calendarDate.add(Calendar.MINUTE, minutes);
		return calendarDate.getTime();
	}

	public static Date addMonthToDate(Date date, int month) {
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.setTime(date);
		calendarDate.add(Calendar.MONTH, month);
		return calendarDate.getTime();
	}

	/**
	 * Agrega o disminuye semanas a la fecha dada
	 * 
	 * @param date
	 *            , fecha inicial.
	 * @param week
	 *            , semanas a sumar o restar
	 * @return retorna la nueva fecha
	 */
	public static Date addWeekToDate(Date date, int week) {
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.setTime(date);
		calendarDate.add(Calendar.WEEK_OF_MONTH, week);
		return calendarDate.getTime();
	}

	public static String formatDate(Date fecha, String format) {
		final SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(fecha);
	}

	/**
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean validarString(String cadena) {
		if (cadena != null && !cadena.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Valida un cadena de texto es un correo electronico
	 * 
	 * @param correo
	 * @return
	 */
	public static boolean esUnCorreoElectronico(String correo) {
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern
				.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		matcher = pattern.matcher(correo);
		return matcher.matches();
	}

	/**
	 * metodo que saca el porcentaje de un numero determinado
	 * 
	 * @param numero
	 *            numero al cual se le va a sacar el porcentaje
	 * @param porcentaje
	 *            porcentaje a aplicar
	 * @return numero resultante
	 */
	public static BigDecimal obtenerPorcentajeNumero(BigDecimal numero,
			BigDecimal porcentaje) {
		BigDecimal numeroResultante = BigDecimal.ZERO;
		if (BigDecimal.ZERO.compareTo(numero) != 0
				&& BigDecimal.ZERO.compareTo(porcentaje) != 0) {
			numeroResultante = (numero.multiply(porcentaje)).divide(BigDecimal
					.valueOf(100));
		} else {
			return numeroResultante;
		}
		return numeroResultante;
	}

	public static String getRoot() {
		final ExternalContext ctx = FacesContext.getCurrentInstance()
				.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest) ctx
				.getRequest();
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + "/";
	}

}
