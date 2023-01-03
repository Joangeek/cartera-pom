package com.gestion;

import exceptions.DAOException;
import gestion.Menu;
import gestion.MenuUsuarioGrupo;

import java.util.List;


public interface MenuDAO {

	public List<Menu> buscarMenu(String codigo)
			throws DAOException;

	public List<MenuUsuarioGrupo> buscarSub(Integer oid, String userGrup) throws DAOException;
}
