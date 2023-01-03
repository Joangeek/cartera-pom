package com.comun.dao;

import exceptions.DAOException;
import gestion.Usuario;
import gestion.UsuarioGrupo;
import academico.TblestEstudiante;



public interface UsuarioDAO {

	public Usuario buscarCodigo(String codigo)
			throws DAOException;

	public UsuarioGrupo validarAcceso(String uname, String password)
			throws DAOException;

	public TblestEstudiante validarAcceso(String trim)
			throws DAOException;

	public TblestEstudiante validarAcceso(String trim, Integer estado)
			throws DAOException;



}
