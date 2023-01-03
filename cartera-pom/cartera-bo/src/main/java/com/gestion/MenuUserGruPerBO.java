package com.gestion;

import gestion.MenuUserGruPer;

import java.util.List;

import javax.ejb.Remote;

import exceptions.BOException;


/**
 * @author EDUAR
 * 
 */
@Remote
public interface MenuUserGruPerBO {
	/**
	 * Método que lista todos los registros
	 * 
	 * @return
	 * @throws BOException
	 */
	public List<MenuUserGruPer> buscaPerfiles(Integer oid)
			throws BOException;

	public List<MenuUserGruPer> buscaPerfiles(List<Integer> listMenuUsuGrupo, Integer integer)
			throws BOException;

}
