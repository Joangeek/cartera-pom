/**
 * 
 */
package com.comun.controlador.util.core;

/**
 * @author
 * 
 */
public final class UtilidadJNDI {

	/**
	 * 
	 * Retorna el jndi del ejb implementado para una interfaz en particular
	 * 
	 * @param classBO
	 * @return String representación del jndi
	 *         java:global/vpm-commons-app-ear/vpm
	 *         -commons-app-ejb-0.0.1-SNAPSHOT/
	 *         CategoriaBOEJB!com.business.CategoriaBO
	 */
	public static <T> String getJND(Class<T> classBO,String modulo) {
		final String jndiAutoevaluacion = "java:global/"+modulo+"-ear/"+modulo+"-ejb-0.0.1-SNAPSHOT/";
		 System
		 .getProperty("jboss.vpm.commons.app.jndi");
		final StringBuilder jndi = new StringBuilder();
		String statelessName = classBO.getSimpleName();
		jndi.append(jndiAutoevaluacion).append(statelessName).append("Impl")
				.append("!").append(classBO.getName());
		// System.out.println("---------------------------"+jndi.toString());
		return jndi.toString();
	}
	
	public static <T> String getJNDAutoevaluacion(Class<T> classBO) {
		final String jndiAutoevaluacion = "java:global/autoevaluacion-ear/autoevaluacion-ejb-0.0.1-SNAPSHOT/";
		 System
		 .getProperty("jboss.vpm.commons.app.jndi");
		final StringBuilder jndi = new StringBuilder();
		String statelessName = classBO.getSimpleName();
		jndi.append(jndiAutoevaluacion).append(statelessName).append("Impl")
				.append("!").append(classBO.getName());
		 System.out.println("---------------------------"+jndi.toString());
		return jndi.toString();
	}


}
