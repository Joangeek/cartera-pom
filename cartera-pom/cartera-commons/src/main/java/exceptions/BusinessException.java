package exceptions;

import java.io.Serializable;

/**
 * @author Euar Troyano
 * 
 *         Excepciones Generales
 * 
 */
public class BusinessException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
