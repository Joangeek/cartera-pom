package com.comun.controlador.util;

/**
 * @author Freymam Vallejo
 * 
 */
public final class ConfiguracionGlobal {

	public static final String TIPO_ARCHIVO_PLANO = "txt|csv";
	public static final String TIPO_ARCHIVO = "pdf|doc|ppt";
	public static final String TIPO_ARCHIVOS_SOPORTE_MENSAJE = "*.pdf, *.ppt, *.doc";
	
    public static final String TIPO_ARCHIVO_IMAGEN = "tif|tiff";
    public static final String TIPO_ARCHIVO_SOPORTE = "tif|tiff|pdf";

    public static final String TIPO_ARCHIVO_IMAGEN_MENSAJE = "*.tif, *.tiff";
    public static final String TIPO_ARCHIVO_SOPORTE_MENSAJE = "*.tif, *.tiff, *.pdf";

    public static final String DIRECTORIO_IMAGENES = "/opt/imagenesACS/";
    public static final String DIRECTORIO_SOPORTE = "/opt/soporteACS/";

    // para la firma del usuario

    public static final int TAMANO_MAXIMO_ARCHIVO_FIRMA_BYTES = 50000;
    public static final String TAMANO_MAXIMO_ARCHIVO_FIRMA = "50 KB";

    // para el icono del recurso

    public static final int TAMANO_MAXIMO_ICONO_RECURSO_BYTES = 50000;
    public static final String TAMANO_MAXIMO_ICONO_RECURSO = "50 KB";

    // para el soporte de bitacora

    public static final int TAMANO_MAXIMO_SOPORTE_BYTES = 2048000;
    public static final String TAMANO_MAXIMO_SOPORTE = "2 MB";

    public static final String NOMBRE_PRODUCTO_ACS = "ACS";

    // expresion regular contraseña

    public static final String CARACTERES_ESPECIALES = "\\!\\”\\#\\$\\%\\/\\(\\)\\=\\?\\¡\\¿\\¨\\+\\[\\*\\]\\,\\-\\<\\>";

    //
    public static final String RUTA_PROVEEDORES = "/commons-app/toolbar/generarPeticion.xhtml";
    // para integracion con Encuestas

    public static final String RUTA_ENCUESTAS = "/encuestas/encuestas/resolverEncuesta.seam?idIns=";
    public static final String RUTA_SOLUCION_ENCUESTA = "/encuestas/encuestas/encuestaResuelta.seam?idIns=";
    public static final String CONCATENAR_PARAMETROS = "&";
    public static final String CODIGO_ORIGEN = "idOrg";
    public static final String CODIGO_REFERENCIA = "idRef";
    public static final String CODIGO_AUDITORIA = "actAud";
    public static final String CODIGO_EXTERNA = "encExt";

    // cfg Operativa

    public static final String VPM_CODIGO_PRODUCTO = "VPM";
    public static final String URL_VPM_SUFIX = "seam";
    public static final String URL_VPM = "/vpm";
    public static final String URL_VPM_HOME = URL_VPM + "/home."
            + URL_VPM_SUFIX;
    public static final String URL_VPM_LOGOUT = URL_VPM + "/logout."
            + URL_VPM_SUFIX;
    public static final String URL_VPM_LOGIN = URL_VPM + "/home."
            + URL_VPM_SUFIX;
    public static final String URL_VPM_INDEX = URL_VPM + "/index."
            + URL_VPM_SUFIX;
	    
    // PERSISTENCE
    public static final String SELECT = "SELECT ";
    public static final String FROM = "FROM ";
    public static final String WHERE = "WHERE ";
    public static final String ORDERBY = "ORDER BY ";
    public static final String ESPACIO = " ";
    public static final String DISTINCT = "DISCTINCT ";
    public static final String DESC = "DESC ";
    public static final String AND = "AND ";
    public static final String JOIN_FETCH = "JOIN FETCH ";
    public static final String LEFT_JOIN_FETCH = "LEFT JOIN FETCH ";
    public static final String MAX = "MAX";
    
    /**
     * Parametros y constantes para autorizacion de folios (ABIN-06)
     */
    public static final long PARAM_ESATUS_SOLICITUD_FOLIO_PENDIENTE = 170001;
    public static final long PARAM_ESATUS_SOLICITUD_FOLIO_AUTORIZADA = 170002;
    public static final long PARAM_ESATUS_SOLICITUD_FOLIO_RECHAZADA = 170003;
    public static final long PARAM_ESATUS_SOLICITUD_FOLIO_ATENDIDA = 180001;
    public static final String AUTORIZAR_MENSAJE_GUARDAR_EXITO = "mensajes.info.guardarExito";
    public static final String GROWL_MENSAJES = "mensajes";
    public static final String NUMERO_SOLICITUD_ALMACEN = "numeroSolicitudAlmacen";
    public static final String CANTIDAD = "cantidad";
    public static final String GROUP_FORMATO_IPS = "groupFormatoIps";
    public static final String PIEZAS = "piezas";
    public static final int UNO = 1;
    public static final int DOS = 2;
    public static final int TRES = 3;
    
    /**
     * MENSAJES COMUN
     */
    public static final String MENSAJE_USUARIO_SIN_OFICINA = "comun.mensaje.usuario.sin.oficina";    
    public static final String MENSAJE_DATOS_EXITO="comun.menage.exito";
    public static final String MENSAJE_RANGO_REPETIDO = "comun.mensaje.error.intervalo.translapado";

}
