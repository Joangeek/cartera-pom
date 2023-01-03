package com.gestion;

import exceptions.DAOException;
import gestion.MenuUserGruPer;

import java.util.List;


public interface MenuUserGruPerDAO {

	public List<MenuUserGruPer> buscarPerfiles(Integer oid)
			throws DAOException;

	public List<MenuUserGruPer> buscarPerfiles(List<Integer> listMenuUsuGrupo, Integer codmenu)
			throws DAOException;

}
