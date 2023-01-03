package com.gestion;

import gestion.MenuUserGruPer;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gestion.MenuUserGruPerBO;
import com.gestion.MenuUserGruPerDAO;

import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "menuUserGruPerBO")
public class MenuUserGruPerBOImpl implements MenuUserGruPerBO {

	@Inject
	private MenuUserGruPerDAO menuUserGruPerDAO;

	@Override
	public List<MenuUserGruPer> buscaPerfiles(Integer codigo)
			throws BOException {
		try {
			return menuUserGruPerDAO.buscarPerfiles(codigo);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public List<MenuUserGruPer> buscaPerfiles(List<Integer> listMenuUsuGrupo,
			Integer codmenu) throws BOException {
		try {
			return menuUserGruPerDAO.buscarPerfiles(listMenuUsuGrupo,codmenu);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}
}
