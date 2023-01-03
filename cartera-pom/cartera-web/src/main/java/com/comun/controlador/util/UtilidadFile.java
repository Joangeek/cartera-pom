package com.comun.controlador.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;


@SuppressWarnings("restriction")
public class UtilidadFile {

    public enum TipoFichero {
        TXT, CSV, ZIP, PDF, JRXML, TIFF, GIF, JPG, JPEG
    };

    public static final int BUFFER_SIZE = 1024;
    private static final Log LOGGER = LogFactory.getLog(UtilidadFile.class);

    // private static final String SALTO_LINEA_ARCHIVO_TEXTO = "\n";

    /**
     * Constructor privado para evitar instanciar objetos de esta clase
     */


    // res.setHeader("Content-Disposition","attachment;filename=test.csv");
    // res.setIntHeader("Content-length", chCsvData.length);

    /* crear */

    /**
     * Retorna el tipo mime para el tipo fichero dado
     * 
     * @return retorna una cadena con el tipo mime solicitado
     * 
     * @author Fredy Dorado
     */
    public static String obtenerTipoMIME(TipoFichero tipo) {
        String tipoMIME = null;
        switch (tipo) {
            case TXT:
                tipoMIME = "text/plain";
                break;
            case CSV:
                tipoMIME = "text/csv";
                break;
            case PDF:
                tipoMIME = "application/pdf";
                break;
            case ZIP:
                tipoMIME = "application/zip";
                break;
            case JRXML:
                tipoMIME = "application/xml";
                break;
            case TIFF:
                tipoMIME = "image/tiff";
                break;
            case GIF:
                tipoMIME = "image/gif";
                break;
            case JPG:
                tipoMIME = "image/jpg";
                break;
            case JPEG:
                tipoMIME = "image/jpeg";
                break;
            default:
                break;
        }
        return tipoMIME;
    }

    /**
     * Obtiene la extension del archivo para el tipo dado
     * 
     * @param tipoIn tipo del archivo
     * @return extencion para tipo de archivo
     * 
     * @author Fredy Dorado
     */
    public static String obtenerExtension(TipoFichero tipoIn) {
        String ext = null;
        switch (tipoIn) {
            case TXT:
                ext = ".txt";
                break;
            case CSV:
                ext = ".csv";
                break;
            case ZIP:
                ext = ".zip";
                break;
            case PDF:
                ext = ".pdf";
                break;
            case JRXML:
                ext = ".jrxml";
                break;
            case TIFF:
                ext = ".tiff";
                break;
            case GIF:
                ext = ".gif";
                break;
            case JPG:
                ext = ".jpg";
                break;
            case JPEG:
                ext = ".jpeg";
                break;
            default:
                break;
        }
        return ext;
    }

    /**
     * Retorna el tipo de fichero para la extension enviada.
     * 
     * @param extension extension a buscar, por ejemplo ".txt"
     * @return el tipo de fichero buscado. Si no es soportado el tipo, retorna
     *         null
     * @author Fredy Dorado
     */
    public static TipoFichero obtenerTipoFicheroParaExtension(String extension) {
        TipoFichero tipoFichero = null;

        if (extension != null) {
            if (obtenerExtension(TipoFichero.CSV).equalsIgnoreCase(extension)) {
                tipoFichero = TipoFichero.CSV;
            } else if (obtenerExtension(TipoFichero.JRXML).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.JRXML;
            } else if (obtenerExtension(TipoFichero.PDF).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.PDF;
            } else if (obtenerExtension(TipoFichero.TXT).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.TXT;
            } else if (obtenerExtension(TipoFichero.ZIP).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.ZIP;
            } else if (obtenerExtension(TipoFichero.TIFF).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.TIFF;
            } else if (obtenerExtension(TipoFichero.GIF).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.GIF;
            } else if (obtenerExtension(TipoFichero.JPG).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.JPG;
            } else if (obtenerExtension(TipoFichero.JPEG).equalsIgnoreCase(
                    extension)) {
                tipoFichero = TipoFichero.JPEG;
            }
        }

        return tipoFichero;
    }

    /**
     * Retorna el tipo de fichero para el tipo mime.
     * 
     * @param tipoMIME tipo mime por ejemplo "text/plain"
     * @return el tipo de fichero buscado. Si no es soportado el tipo, retorna
     *         null
     * @author Fredy Dorado
     */
    public static TipoFichero obtenerTipoFicheroParaTipoMIME(String tipoMIME) {
        TipoFichero tipoFichero = null;

        if (tipoMIME != null) {
            if (obtenerTipoMIME(TipoFichero.CSV).equalsIgnoreCase(tipoMIME)) {
                tipoFichero = TipoFichero.CSV;
            } else if (obtenerTipoMIME(TipoFichero.JRXML).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.JRXML;
            } else if (obtenerTipoMIME(TipoFichero.PDF).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.PDF;
            } else if (obtenerTipoMIME(TipoFichero.TXT).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.TXT;
            } else if (obtenerTipoMIME(TipoFichero.ZIP).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.ZIP;
            } else if (obtenerTipoMIME(TipoFichero.TIFF).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.TIFF;
            } else if (obtenerTipoMIME(TipoFichero.GIF).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.GIF;
            } else if (obtenerTipoMIME(TipoFichero.JPG).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.JPG;
            } else if (obtenerTipoMIME(TipoFichero.JPEG).equalsIgnoreCase(
                    tipoMIME)) {
                tipoFichero = TipoFichero.JPEG;
            }
        }

        return tipoFichero;
    }

    /**
     * Evalua si la extension del archivo para el nombre del archivo dado es
     * valida
     * 
     * @param nombreYExtensionArchivo nombre y extension del archivo
     * @return true si la extension es valida, false en caso contrario
     * 
     * @author Fredy Dorado
     */
    public static boolean validarExtension(String nombreYExtensionArchivo,
            TipoFichero tipoFicheroAValidar) {
        boolean valido = false;
        try {
            valido = nombreYExtensionArchivo.toLowerCase().endsWith(
                    obtenerExtension(tipoFicheroAValidar));
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
            valido = false;
        }
        return valido;
    }

    /**
     * Escribe los datos en el archivo dado en la ruta especificada
     * 
     * @param ruta ruta del archivo, ejemplo: /opt/
     * @param nombreExtensionArchivo nombre completo archivo, ejemplo:
     *        miarchivo.txt
     * @param datos representan los datos que se escribiran en el archivo de
     *        texto
     * @return true si todo ocurrio bien y false en caso contrario
     * 
     * @author Fredy Dorado
     * 
     */
    public static boolean escribirCadenaEnArchivoTexto(String ruta,
            String nombreExtensionArchivo, String datos) {
        boolean exito = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(ruta + nombreExtensionArchivo);
            writer.append(datos);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.info(e.getMessage(), e);
            exito = false;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOGGER.info(e.getMessage(), e);
                    writer = null;
                }
            }
        }
        return exito;
    }

    /**
     * Obtiene los bytes de un archivo
     * 
     * @param archivo archivo del cual se obtendran los bytes
     * @return array de bytes del archivo
     * @throws IOException si ocurreo un error
     * 
     * @author Fredy Dorado
     */
    public static byte[] getBytes(File archivo) throws IOException {
        FileInputStream fis = new FileInputStream(archivo);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[BUFFER_SIZE];
        byte[] datosEnBinario = null;
        try {
            int read = fis.read(buf);
            while (read != -1) {
                bos.write(buf, 0, read);
                read = fis.read(buf);
            }
            // for (int read; (read = fis.read(buf)) != -1;) {
            // bos.write(buf, 0, read);
            // }
            datosEnBinario = bos.toByteArray();
        } finally {
            // if (fis != null) {
            fis.close();
            // }
            // if (bos != null) {
            bos.close();
            // }
        }
        return datosEnBinario;
    }

    /**
     * Obtiene los bytes de un archivo
     * 
     * @param rutaYNombreArchivo ruta y nombre del archivo del cual se obtendran
     *        los bytes
     * @return array de bytes del archivo
     * @throws IOException si ocurreo un error
     * @author Fredy Dorado
     */
    public static byte[] getBytes(String rutaYNombreArchivo) throws IOException {
        File archivo = new File(rutaYNombreArchivo);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        if (archivo != null) {
            FileInputStream fis = null;

            byte[] buf = new byte[BUFFER_SIZE];
            fis = new FileInputStream(archivo);
            try {
                int read = fis.read(buf);
                while (read != -1) {
                    bos.write(buf, 0, read);
                    read = fis.read(buf);
                }
                // for (int read; (read = fis.read(buf)) != -1;) {
                // bos.write(buf, 0, read);
                // }
                // bos.close();
                // fis.close();
            } finally {
                bos.close();
                fis.close();
            }
        }

        return bos.toByteArray();
    }

    /**
     * Funcion que obtiene la extensión del archivo a partir del nombre completo
     * del archivo.
     * 
     * @param nomArchivo contiene el nombre completo del archivo, del cual solo
     *        se extraerá la extensión del archivo.
     * 
     * @return la extensión del archivo, ej : txt, png, tiff etc.
     */
    public static String obtenerExtensionArchivo(String nomArchivo) {

        int posicionPunto = 0;

        if (nomArchivo.contains(".")) {
            posicionPunto = nomArchivo.indexOf('.');
        }

        for (int i = posicionPunto; i < nomArchivo.length(); i++) {
            if ('.' == nomArchivo.charAt(i)) {
                posicionPunto = i;
            }
        }
        return nomArchivo.substring(posicionPunto, nomArchivo.length());
    }

    /**
     * Escribe los datos en un archivo dado
     * 
     * @param fichero archivo a escribir los datos
     * @param bytesArchivoExportado datos del archivo
     * @throws IOException error si no puede guardar la informacion en el
     *         archivo
     */
    public static void escribirDatosEnArchivo(File fichero,
            byte[] bytesArchivoExportado) throws IOException {
        FileOutputStream fos = new FileOutputStream(fichero);
        try {
            fos.write(bytesArchivoExportado);
            fos.flush();
        } finally {
            fos.close();
        }

    }

    public static String base64Encode(byte[] datos) {
        String respuesta;
        BASE64Encoder encoder = new BASE64Encoder();
        respuesta = encoder.encode(datos);
        return respuesta;
    }



    /**
     * @param contenidoArchivo Archivo seleccionado que se va leer
     * @return una lista, en cada posición se almacena una línea del archivo
     */
    public static List<String> cargarArchivoEnLista(byte[] contenidoArchivo) {
        final List<String> listaCadenas = new ArrayList<String>();

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
//            archivo = new File(System.getProperty("java.io.tmpdir"));
        	archivo=File.createTempFile("tmp", null);
            escribirDatosEnArchivo(archivo, contenidoArchivo);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                listaCadenas.add(linea);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage(), e);
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                LOGGER.info(e2.getMessage(), e2);
            }
        }

        return listaCadenas;
    }

}
