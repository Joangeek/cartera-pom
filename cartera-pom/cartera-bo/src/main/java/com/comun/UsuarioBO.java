package com.comun;

import exceptions.BOException;
import gestion.Usuario;
import gestion.UsuarioGrupo;

import javax.ejb.Remote;


/**
 * @author EDUAR
 * 
 */
@Remote
public interface UsuarioBO {
	/**
	 * Método que lista todos los registros
	 * 
	 * @return
	 * @throws BOException
	 */
	public Usuario buscarCodigo(String codigo) throws BOException;

	public UsuarioGrupo validarAcceso(String uname, String tipoU)
			throws BOException;



}
