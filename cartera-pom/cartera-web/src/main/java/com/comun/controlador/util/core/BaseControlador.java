package com.comun.controlador.util.core;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comun.controlador.util.Utilidad;

/**
 * @author Eduar Troyano Velasuqez
 * 
 */
public abstract class BaseControlador implements Serializable {

	public Log LOGGER;
	// private static String MSJ_INPUT_ID = "hidemMessageContactCenter";
	private static String MSJ_INPUT_ID = null;

	private static String GROWL_MSJ_ID = "messages";
	public static final String COMUN = "comun";
	public static final String AUTOEVAL = "autoevaluacion";
	public static final String ENCUESTA = "encuestas";
	public static final String CARTERA = "configurar";
	public static final Integer ACTIVO=1;
	public static final Integer INACTIVO=0;
	
	private static final long serialVersionUID = 1L;

	

	// private CorreoElectronicoBO correoElectronicoBO;

	public BaseControlador() {
		LOGGER = LogFactory.getLog(getClass());
	}

	public void init(Object obj) {

		LOGGER.debug(" llamado al init " + obj.getClass().getSimpleName());
		LOGGER.debug(obj);

	}

	/**
	 * Solicita actualizar un componente de GUI de usuario.
	 * 
	 * @param parentId
	 *            El id del contenedor del componenete a actualizar, sirve para
	 *            especificar la busqueda a un grupo de terminado. Ejemplo
	 *            fromUsuario
	 * @param componentId
	 *            El id del componenete a actualizar
	 */
	public void ejecutarUpdate(String parentId, String componentId) {
		com.comun.controlador.util.Utilidad.ejecutarUpdate(Utilidad
				.buscarHtmlComponete(Utilidad.buscarHtmlComponete(parentId),
						componentId).getClientId());
	}

	/**
	 * @param parentId
	 * @param componentId
	 */
	public UIComponent buscarHtmlComponete(String parentId, String componentId) {
		return Utilidad.buscarHtmlComponete(
				Utilidad.buscarHtmlComponete(parentId), componentId);
	}

	/**
	 * Solicita actualizar un componente de GUI de usuario.
	 * 
	 * @param componentId
	 *            El id del componenete a actualizar, se busca en todo el
	 *            facelet
	 */
	public void ejecutarUpdate(String componentId) {
		com.comun.controlador.util.Utilidad.ejecutarUpdate(Utilidad
				.buscarHtmlComponete(componentId).getClientId());
	}

	public <T> T evaluateExpressionGet(String expression,
			Class<? extends T> expectedType) {
		return FacesContext
				.getCurrentInstance()
				.getApplication()
				.evaluateExpressionGet(FacesContext.getCurrentInstance(),
						expression, expectedType);
	}

	/**
	 * Metodo llamado al momento de cargar la vista
	 */
	public final void onViewLoad() throws FaceletException {
		inicializar();
	}

	/**
	 * Este metodo es parecido al init de los controladores de scope de vista,
	 * solo que este permite lanzar mensajes al usuario ya que si se utiliza
	 * dentro del metodo post construct no se desplegan los mensajes al usuario
	 * ya que el tiempo de vidad de los faces mensajes es requesScope
	 */
	public abstract void inicializar();

	/**
	 * Lanza un mensaje de error para que se lo visualize el usuario
	 * 
	 * @param mensajeCliente
	 *            Mensaje que se mostrara al usuario
	 * @param ex
	 *            Errores graves del sistemas
	 */
	public void lanzarMensajeError(String mensajeCliente, Throwable ex) {
		lanzarMensaje(mensajeCliente, null, FacesMessage.SEVERITY_ERROR, ex);
	}

	/**
	 * Lanza un mensaje de error para que se lo visualize el usuario
	 * 
	 * @param mensajeCliente
	 */
	public void lanzarMensajeError(String mensajeCliente) {
		lanzarMensaje(mensajeCliente, null, FacesMessage.SEVERITY_ERROR, null);
	}
	
	/**
	 * Lanza un mensaje de error Fatal para que se lo visualize el usuario
	 * 
	 * @param mensajeCliente
	 */
	public void lanzarMensajeFatal(String mensajeCliente) {
		lanzarMensaje(mensajeCliente, null, FacesMessage.SEVERITY_FATAL, null);
	}

	/**
	 * Lanza un mensaje de informacion para que se lo visualize el usuario
	 * 
	 * @param mensajeCliente
	 */
	public void lanzarMensajeInfo(String mensajeCliente) {
		lanzarMensaje(mensajeCliente, null, FacesMessage.SEVERITY_INFO, null);
	}

	/**
	 * Lanza un mensaje de Warning para que se lo visualize el usuario
	 * 
	 * @param mensajeCliente
	 */
	public void lanzarMensajeWarn(String mensajeCliente) {
		lanzarMensaje(mensajeCliente, null, FacesMessage.SEVERITY_WARN, null);
	}

	private void lanzarMensaje(String mensajeCliente, String detalles,
			FacesMessage.Severity nivel, Throwable ex) {
		// muestra el mensaje al cliente
		FacesContext.getCurrentInstance().addMessage(MSJ_INPUT_ID,
				new FacesMessage(nivel, mensajeCliente, detalles));
		Utilidad.ejecutarUpdate(GROWL_MSJ_ID);
		// si los mensajes son de error se muestra en el log
		if (ex != null) {
			// registra el error en
			// (exception-handler-factory) para realizar
			// seguimiento cuando el proyecto esta en la etapa de desarrolloo
			// se puede omitir el almacenado de estos errores configurando
			// javax.faces.PROJECT_STAGE
			// http://www.java-tutorial.ch/java-server-faces/jsf-project-stage
			throw new FacesException(mensajeCliente, ex);
		}
	}

	public void redireccionar(String path) {
		if (FacesContext.getCurrentInstance() == null) {
			return;
		}
		FacesContext
				.getCurrentInstance()
				.getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						path.concat("?faces-redirect=true"));
	}

	public ResourceBundle obtenerResourceBundle(String varName) {

		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(context, varName);
		return bundle;
	}
	
	/**
	 * Mensaje que se lanza cuiando no se ha seleccionado ningún item del
	 * listado y se pretende realizar algúna acción
	 */
	public void msgNoSeleccionado() {
		lanzarMensajeWarn(obtenerResourceBundle(COMUN).getString(
				"global.msg.alerta.no.seleccionado"));
	}

	/*
	 * public boolean enviarCorreo(String codigoCorreo, String
	 * nuevosDestinatarios, List<ArchivoAdjunto> archivosAdjuntos, Map<String,
	 * Object> parametros) { return correoElectronicoBO.enviar(codigoCorreo,
	 * nuevosDestinatarios, archivosAdjuntos, parametros); }
	 * 
	 * public boolean enviarCorreoVpm(String asunto, String mensaje, String
	 * destinatarios, List<ArchivoAdjunto> adjuntos) { return
	 * correoElectronicoBO.enviarCorreoVPM(asunto, mensaje, destinatarios,
	 * adjuntos); }
	 */

}
