package com.gestion.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestion.MenuDAO;
import com.gestion.ParametrosDAO;

import exceptions.DAOException;
import gestion.Menu;
import gestion.MenuUsuarioGrupo;
import gestion.Parametros;
import gestion.UsuarioGrupo;

@SuppressWarnings("unused")
public class MenuDAOImpl implements MenuDAO {

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Menu> buscarMenu(String codigo)
			throws DAOException {
		Query q = null;
		StringBuilder sql = new StringBuilder();
		String where = " WHERE ";
		String and = " AND ";
		String tipo = "P";

		sql.append("SELECT DISTINCT s FROM ");
		sql.append(MenuUsuarioGrupo.class.getSimpleName() + " mug ");
		sql.append(" join  mug.menu m join  m.submenu s join  mug.usuarioGrupo ug ");
		sql.append(where);
		sql.append(" ug.usgCodigo=:codigo ");
		sql.append(and);
		sql.append(" s.tipo=:tipo");
		sql.append(and);
		sql.append(" m.estado=1 ");
		sql.append(" ORDER BY s.oid ASC ");

		q = em.createQuery(sql.toString());
		q.setParameter("codigo", Integer.parseInt(codigo));
		q.setParameter("tipo", tipo);

		try {
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuUsuarioGrupo> buscarSub(Integer oid, String userGrup)
			throws DAOException {
		Query q = null;
		StringBuilder sql = new StringBuilder();
		String where = " WHERE ";
		String and = " AND ";
		String tipo = "S";

		sql.append("SELECT mug FROM ");
		sql.append(MenuUsuarioGrupo.class.getSimpleName() + " mug ");
		sql.append(" join fetch  mug.menu m join  m.submenu s join fetch  mug.usuarioGrupo ug");
		sql.append(where);
		sql.append(" s.oid=:codigo ");
		sql.append(and);
		sql.append(" m.tipo=:tipo ");
		sql.append(and);
		sql.append(" ug.usgCodigo=:userg ");
		sql.append(and);
		sql.append(" m.estado=1 ");
		sql.append(" ORDER BY m.orden ASC ");

		q = em.createQuery(sql.toString());
		q.setParameter("codigo", oid);
		q.setParameter("userg",  Integer.parseInt(userGrup));
		q.setParameter("tipo", tipo);
		try {
			return q.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
