package com.comun.controlador.util;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class UtilidadArchivo extends UtilidadFile {

	private static final Log LOGGER = LogFactory.getLog(UtilidadArchivo.class);

	/**
	 * Permite descargar un archivo por el navegador
	 * 
	 * @param tipoMIME
	 * @param nombreYExtensionArchivo
	 * @param imagen
	 * @return booleano que indica si el archivo fue descargado o no, true en
	 *         caso de exito, false en caso contrario
	 */
	public static boolean descargarArchivo(String tipoMIME,
			String nombreYExtensionArchivo, byte[] imagen) {
		final HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType(tipoMIME);// "text/csv"
		response.addHeader("Content-disposition", "attachment; filename=\""
				+ nombreYExtensionArchivo + "\"");// "miCSV.csv"
		boolean validador = false;
		try {
			final ServletOutputStream os = response.getOutputStream();
			os.write(imagen);
			os.flush();
			os.close();
			FacesContext.getCurrentInstance().responseComplete();
			validador = true;
		} catch (IOException e) {
			LOGGER.info("EXCEPTION EN DESCARGAARCHIVO 2", e);
			validador = false;
		}
		return validador;
	}

}
