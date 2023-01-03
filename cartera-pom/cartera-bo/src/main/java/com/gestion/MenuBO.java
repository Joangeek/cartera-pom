package com.gestion;

import exceptions.BOException;
import gestion.Menu;
import gestion.MenuUsuarioGrupo;

import java.util.List;

import javax.ejb.Remote;



/**
 * @author EDUAR
 * 
 */
@Remote
public interface MenuBO {
	/**
	 * Método que lista todos los registros
	 * 
	 * @return
	 * @throws BOException
	 */
	public List<Menu> buscarMenu(String codigo)
			throws BOException;

	public List<MenuUsuarioGrupo> buscarSub(Integer oid, String idGrupoUsuario) throws BOException;

}
