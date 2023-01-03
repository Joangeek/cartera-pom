package com.gestion.impl;

import exceptions.DAOException;
import gestion.MenuUserGruPer;
import gestion.MenuUsuarioGrupo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestion.MenuUserGruPerDAO;



import commons.util.Cfg;

public class MenuUserGruPerDAOImpl implements MenuUserGruPerDAO {

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	static final String tipoP = "P";
	static final String tipoS = "S";

	@SuppressWarnings("unchecked")
	public List<MenuUserGruPer> buscarPerfiles(Integer oid)
			throws DAOException {
		Query q = null;
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT DISTINCT s FROM ");
		sql.append(MenuUsuarioGrupo.class.getSimpleName() + " mug ");
		sql.append(" join  mug.menu m join  m.submenu s join  mug.usuarioGrupo ug ");
		sql.append(Cfg.WHERE);
		sql.append(" ug.usgCodigo=:codigo ");
		sql.append(Cfg.AND);
		sql.append(" s.tipo=:tipo");
		sql.append(Cfg.AND);
		sql.append(" m.estado=1 ");

		q = em.createQuery(sql.toString());
		q.setParameter("codigo", oid);
		q.setParameter("tipo", tipoP);

		try {
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<MenuUserGruPer> buscarPerfiles(List<Integer> listMenuUsuGrupo,
			Integer codmenu) throws DAOException {
		Query q = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT x FROM ");
		sql.append(MenuUserGruPer.class.getSimpleName() + " x ");
		sql.append(" JOIN FETCH x.menuUsuarioGrupo ug JOIN FETCH ug.menu m JOIN FETCH x.permiso p ");
		sql.append(Cfg.WHERE);
		sql.append("ug.oid IN(:lista) ");
		sql.append(Cfg.AND);
		sql.append("m.oid =:codmenu ");

		q = em.createQuery(sql.toString());
		q.setParameter("lista", listMenuUsuGrupo);
		q.setParameter("codmenu", codmenu);

		try {
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
