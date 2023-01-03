package com.auditoria;




import exceptions.DAOException;
import auditoria.Tblingreso;

public interface IngresoDAO {

	public void ingreso(Tblingreso ingreso) throws DAOException;
}
