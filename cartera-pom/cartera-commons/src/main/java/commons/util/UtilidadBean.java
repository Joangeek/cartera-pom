package commons.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class UtilidadBean {

	// Log
	private static final Log LOG = LogFactory.getLog(UtilidadBean.class);

	public static <T> byte[] serialize(T obj) {
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ObjectOutput serialStream;
		try {
			serialStream = new ObjectOutputStream(stream);
			serialStream.writeObject(obj);
			return stream.toByteArray();
		} catch (IOException e) {
			LOG.info(
					"ERROR AL CARGAR  IOEXCEPTION " + e.getMessage()
							+ e.getCause(), e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T deserialize(byte[] bytes) {
		final InputStream stream = new ByteArrayInputStream(bytes);
		final ObjectInput serialStream;
		try {
			serialStream = new ObjectInputStream(stream);
			return (T) serialStream.readObject();
		} catch (ClassNotFoundException e) {
			LOG.info(
					"ERROR AL CARGAR  IOEXCEPTION " + e.getMessage()
							+ e.getCause(), e);
		} catch (IOException e) {
			LOG.info(
					"ERROR AL CARGAR  IOEXCEPTION " + e.getMessage()
							+ e.getCause(), e);
		}
		return null;
	}

	public static <T> T deserialize(byte[] bytes, Class<T> classT) {
		final InputStream stream = new ByteArrayInputStream(bytes);
		final ObjectInput serialStream;
		try {
			serialStream = new ObjectInputStream(stream);
			return classT.cast(serialStream.readObject());
		} catch (ClassNotFoundException e) {
			LOG.info(
					"ERROR AL CARGAR  IOEXCEPTION " + e.getMessage()
							+ e.getCause(), e);
		} catch (IOException e) {
			LOG.info(
					"ERROR AL CARGAR  IOEXCEPTION " + e.getMessage()
							+ e.getCause(), e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T clonarObjecto(T classT) {
		try {
			return (T) BeanUtils.cloneBean(classT);
		} catch (IllegalAccessException e) {
			Logger.getLogger(UtilidadBean.class.getSimpleName()).log(
					Level.WARNING, e.getLocalizedMessage(), e);
		} catch (InstantiationException e) {
			Logger.getLogger(UtilidadBean.class.getSimpleName()).log(
					Level.WARNING, e.getLocalizedMessage(), e);
		} catch (InvocationTargetException e) {
			Logger.getLogger(UtilidadBean.class.getSimpleName()).log(
					Level.WARNING, e.getLocalizedMessage(), e);
		} catch (NoSuchMethodException e) {
			Logger.getLogger(UtilidadBean.class.getSimpleName()).log(
					Level.WARNING, e.getLocalizedMessage(), e);
		}
		return null;
	}

	public static Integer booleano(boolean estado) {
		if (estado) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Funcion que permite validar nulos
	 * 
	 * @param <T>
	 * @return boolean
	 */
	public static <T> boolean validaNulos(T entidad) {
		if (null == entidad) {
			return false;
		}
		return true;
	}
}
