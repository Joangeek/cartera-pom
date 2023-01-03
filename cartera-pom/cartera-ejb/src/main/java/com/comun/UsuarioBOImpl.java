package com.comun;

import gestion.Usuario;
import gestion.UsuarioGrupo;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.comun.dao.UsuarioDAO;

import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "UsuarioBO")
public class UsuarioBOImpl implements UsuarioBO {

	@Inject
	private UsuarioDAO usuarioDAO;

	@Override
	public Usuario buscarCodigo(String codigo) throws BOException {
		try {
			return usuarioDAO.buscarCodigo(codigo.trim());
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public UsuarioGrupo validarAcceso(String uname, String tipoU)
			throws BOException {
		try {
			return usuarioDAO.validarAcceso(uname.trim(), tipoU.trim());
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}


}
