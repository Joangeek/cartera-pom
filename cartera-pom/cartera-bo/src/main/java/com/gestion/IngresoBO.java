package com.gestion;

import javax.ejb.Remote;

import exceptions.BOException;
import auditoria.Tblingreso;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface IngresoBO {
	/**
	 * Método que de registro
	 * 
	 * @return
	 * @throws BOException
	 */
	public void ingreso(Tblingreso ingreso) throws BOException;

}
