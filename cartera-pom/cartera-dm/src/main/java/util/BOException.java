package util;

public class BOException extends Exception {

    /**
     * Atributo para la serialización.
     */
    private static final long serialVersionUID = -6783113206562545448L;

    /**
     * Constructor de la clase.
     */
    public BOException() {
        super();
    }

    /**
     * Constructor de la clase.
     * 
     * @param mensaje
     *            el mensaje de la excepci&oacute;n
     */
    public BOException(String message) {
        super(message);
    }

    /**
     * Constructor de la clase.
     * 
     * @param mensaje
     *            el mensaje de la excepci&oacute;n
     * @param causa
     *            la causa de la excepci&oacute;n
     */
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

}

