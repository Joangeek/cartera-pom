package exceptions;

import java.io.Serializable;

/**
 * @author Eduar Troyano
 * 
 *         Excepciones a nivel de DAO
 * 
 */
public class DAOException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

}
