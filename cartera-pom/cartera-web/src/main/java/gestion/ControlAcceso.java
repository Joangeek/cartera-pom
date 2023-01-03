package gestion;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.comun.controlador.util.Utilidad;
import com.comun.controlador.util.core.BaseControlador;

import util.BOException;


@ManagedBean(name = "controlAcceso")
@ViewScoped
public class ControlAcceso<T> extends BaseControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8434534413696267700L;

	/**
     * 
     */

	@PostConstruct
	public void init() throws BOException {
		try {
			LOGGER.debug("INIT CONTROLADOR");
			// lookup();

		} catch (Exception ex) {
			lanzarMensajeError(null, ex);
		}

	}

	/**
	 * Método que injecta los BO
	 */
	/*
	 * private void lookup() { try { //periodoBO =
	 * LookupUtil.lookupRemoteStateless(PeriodoBO.class); } catch
	 * (NamingException e) { // ... } }
	 */

	public void encuestaEstudiante() {
		String url = obtenerResourceBundle(ENCUESTA).getString(
				"url.encuestas.estudiantes");
		Utilidad.redireccionar(url);
	}

	public void encuestaEgresado() {
		String url = obtenerResourceBundle(ENCUESTA).getString(
				"url.encuestas.egresados");
		Utilidad.redireccionar(url);
	}
	
	public void encuestaEmpleador() {
		String url = obtenerResourceBundle(ENCUESTA).getString(
				"url.encuestas.empleadores");
		Utilidad.redireccionar(url);
	}

	@Override
	public void inicializar() {
	}

}
