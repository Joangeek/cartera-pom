package exceptions;

import java.io.Serializable;

/**
 * @author Euar Troyano
 * 
 *         Excepciones a nivel de BO/EJB
 *  
 */
public class BOException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public BOException() {
        super();
    }

    public BOException(String message) {
        super(message);
    }

    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

    public BOException(Throwable cause) {
        super(cause);
    }

}
