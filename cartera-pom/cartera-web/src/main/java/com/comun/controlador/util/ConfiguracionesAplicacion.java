package com.comun.controlador.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


/**
 * @author 
 * 
 */
@ManagedBean
@ApplicationScoped
public class ConfiguracionesAplicacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String tipoArchivoPlano = ConfiguracionGlobal.TIPO_ARCHIVO_PLANO;

    private final String tipoArchivo = ConfiguracionGlobal.TIPO_ARCHIVO;

    private final String tipoArchivoImagen = ConfiguracionGlobal.TIPO_ARCHIVO_IMAGEN;

    private final String tipoArchivoSoporte = ConfiguracionGlobal.TIPO_ARCHIVO_SOPORTE;

    private final String tipoArchivoImagenMensaje = ConfiguracionGlobal.TIPO_ARCHIVO_IMAGEN_MENSAJE;

    private final String tipoArchivoSoporteMensaje = ConfiguracionGlobal.TIPO_ARCHIVO_SOPORTE_MENSAJE;

    private final String tipoArchivosSoporte = ConfiguracionGlobal.TIPO_ARCHIVOS_SOPORTE_MENSAJE;

    private final String directorioImagenes = ConfiguracionGlobal.DIRECTORIO_IMAGENES;

    private final int tamanoMaximoArchivoFirmaBytes = ConfiguracionGlobal.TAMANO_MAXIMO_ARCHIVO_FIRMA_BYTES;

    private final String tamanoMaximoArchivoFirma = ConfiguracionGlobal.TAMANO_MAXIMO_ARCHIVO_FIRMA;

    private final int tamanoMaximoIconoRecursoBytes = ConfiguracionGlobal.TAMANO_MAXIMO_ICONO_RECURSO_BYTES;

    private final String tamanoMaximoIconoRecurso = ConfiguracionGlobal.TAMANO_MAXIMO_ICONO_RECURSO;

    private final int tamanoMaximoSoporteBytes = ConfiguracionGlobal.TAMANO_MAXIMO_SOPORTE_BYTES;

    private final String tamanoMaximoSoporte = ConfiguracionGlobal.TAMANO_MAXIMO_SOPORTE;

    private final String caracteresEspeciales = ConfiguracionGlobal.CARACTERES_ESPECIALES;

    // funciones
    /**
     * 
     * @param fecha
     * @return
     */
    public static String obtenerFechaEnFormatoTexto(Date fecha) {
        if (fecha == null) {
            return "";
        }
        final String formato = "dd/MM/yyyy";
        final SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);
        return formatoFecha.format(fecha);
    }

   
    /**
     * 
     * @param url
     * @return
     */
    public static String getUrlRelativa(String url) {
        if (url != null && !url.isEmpty()) {
            if (url.startsWith("/")) {
                return url;
            } else {
                return "/" + url;
            }
        }
        return url;
    }



    // setters y getters

    public String getTipoArchivoImagen() {
        return tipoArchivoImagen;
    }

    public String getTipoArchivosSoporte() {
        return tipoArchivosSoporte;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public String getTipoArchivoPlano() {
        return tipoArchivoPlano;
    }

    public String getTipoArchivoImagenMensaje() {
        return tipoArchivoImagenMensaje;
    }

    public int getTamanoMaximoArchivoFirmaBytes() {
        return tamanoMaximoArchivoFirmaBytes;
    }

    public String getTamanoMaximoArchivoFirma() {
        return tamanoMaximoArchivoFirma;
    }

    public String getDirectorioImagenes() {
        return directorioImagenes;
    }

    public int getTamanoMaximoIconoRecursoBytes() {
        return tamanoMaximoIconoRecursoBytes;
    }

    public String getTamanoMaximoIconoRecurso() {
        return tamanoMaximoIconoRecurso;
    }

    public String getCaracteresEspeciales() {
        return caracteresEspeciales;
    }

    public String getTipoArchivoSoporte() {
        return tipoArchivoSoporte;
    }

    public String getTipoArchivoSoporteMensaje() {
        return tipoArchivoSoporteMensaje;
    }

    public int getTamanoMaximoSoporteBytes() {
        return tamanoMaximoSoporteBytes;
    }

    public String getTamanoMaximoSoporte() {
        return tamanoMaximoSoporte;
    }

}
