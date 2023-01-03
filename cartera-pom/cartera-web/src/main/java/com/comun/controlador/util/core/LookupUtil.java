package com.comun.controlador.util.core;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.comun.controlador.util.core.UtilidadJNDI;

/**
 * 
 */

/**
 * @author
 * 
 */
public final class LookupUtil {

	/**
	 * Retorna el objeto de negocio obtenido a travez del nombre JNDI
	 * 
	 * @param classBO
	 * 
	 * @return el objeto de negocio correspondiente al jndi
	 * 
	 * @throws NamingException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T lookupRemoteStateless(Class<T> classBO)
			throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext();
		final String nameJNDI = UtilidadJNDI.getJNDAutoevaluacion(classBO);
		return (T) context.lookup(nameJNDI);
	}

	@SuppressWarnings("unchecked")
	public static <T> T lookupRemoteStateless(String nameJNDI)
			throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext();
		return (T) context.lookup(nameJNDI);
	}

	@SuppressWarnings("unchecked")
	public static <T> T lookupRemoteStateless(Class<T> classBO, String modulo)
			throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		final Context context = new InitialContext();
		final String nameJNDI = UtilidadJNDI.getJND(classBO,modulo);
		return (T) context.lookup(nameJNDI);
	}

}
