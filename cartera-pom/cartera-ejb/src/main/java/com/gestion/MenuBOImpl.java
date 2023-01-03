package com.gestion;

import gestion.Menu;
import gestion.MenuUsuarioGrupo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gestion.MenuBO;
import com.gestion.MenuDAO;

import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "menuBO")
public class MenuBOImpl implements MenuBO {

	@Inject
	private MenuDAO menuDAO;

	@Override
	public List<Menu> buscarMenu(String codigo)
			throws BOException {
		try {
			return menuDAO.buscarMenu(codigo);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<MenuUsuarioGrupo> buscarSub(Integer oid, String userGrup) throws BOException {
		try {
			return menuDAO.buscarSub(oid,userGrup);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

}
