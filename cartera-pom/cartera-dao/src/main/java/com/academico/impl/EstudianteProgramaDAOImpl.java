package com.academico.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import academico.TblacaMatriculado;
import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;
import academico.TblestEstudiante;
import academico.TblestEstudiantePrograma;
import cartera.TblfinEstudianteProgramaRecibo;

import com.academico.EstudianteProgramaDAO;

import commons.util.UtilidadBean;
import exceptions.DAOException;

@SuppressWarnings("unchecked")
public class EstudianteProgramaDAOImpl implements EstudianteProgramaDAO {

	private static final Logger LOG = Logger
			.getLogger(EstudianteProgramaDAOImpl.class.getSimpleName());

	@PersistenceContext(unitName = "cartera-dm")
	private EntityManager em;

	@Override
	public List<TblacaSede> buscarSedes() throws DAOException {
		try {
			LOG.info("---");
			Query q = null;
			q = em.createNamedQuery("TblacaSede.findAll");
			return q.getResultList();

		} catch (NoResultException nre) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void eliminarSede(TblacaSede entity) throws DAOException {
		em.remove(em.merge(entity));

	}

	@Override
	public void crearSede(TblacaSede entity) throws DAOException {
		em.persist(entity);

	}

	@Override
	public void editarSede(TblacaSede entity) throws DAOException {
		em.merge(entity);

	}

	@Override
	public List<TblacaPrograma> buscarProgramas() throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaPrograma.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" ORDER BY te.nombre, te.oid DESC ");

		List<TblacaPrograma> listaEntidad = null;

		Query query = em.createQuery(jpql.toString());
		listaEntidad = (List<TblacaPrograma>) query.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaPrograma> buscarProgramasActivos(boolean estado)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaPrograma.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" ORDER BY te.oid DESC ");

		List<TblacaPrograma> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());

		listaEntidad = (List<TblacaPrograma>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSede> buscarSedesActivas(boolean estado)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaSede.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" WHERE te.estado=:estado ");
		jpql.append(" ORDER BY te.oid ASC ");

		List<TblacaSede> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("estado", UtilidadBean.booleano(estado));

		listaEntidad = (List<TblacaSede>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSedePrograma> buscarPorSede(TblacaSede sede)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT te FROM ");
		jpql.append(TblacaSedePrograma.class.getSimpleName());
		jpql.append(" te ");
		jpql.append(" JOIN FETCH te.tblenc_dirigidoa d ");
		jpql.append(" JOIN FETCH te.tblenc_modulo_tipo_evaluacion m ");
		jpql.append(" ORDER BY te.oid DESC ");

		List<TblacaSedePrograma> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("sede", sede);
		listaEntidad = (List<TblacaSedePrograma>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSede> buscarSedesEstadoPorSp(boolean estado)
			throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT se FROM ");
		jpql.append(TblacaSede.class.getSimpleName());
		jpql.append(" se ");
		jpql.append(" WHERE  se IN ( ");
		jpql.append(" SELECT DISTINCT te.tblacaSede FROM ");
		jpql.append(TblacaSedePrograma.class.getSimpleName());
		jpql.append(" te )");
		jpql.append(" AND se.estado=:estado ORDER BY se.oid ASC ");

		List<TblacaSede> listaEntidad = null;

		Query query = em.createQuery(jpql.toString());
		query.setParameter("estado", UtilidadBean.booleano(estado));
		listaEntidad = (List<TblacaSede>) query.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblacaSedePrograma> buscarProgramasEstadoSp(Integer entity,
			boolean estado, boolean ofertado) throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT sp FROM ");
		jpql.append(TblacaSedePrograma.class.getSimpleName());
		jpql.append(" sp ");
		jpql.append(" JOIN FETCH sp.tblacaPrograma pr");
		jpql.append(" JOIN FETCH sp.tblacaSede se ");
		jpql.append(" WHERE  se.oid=:entity AND sp.estado=:estado AND sp.ofertado=:ofertado ");

		List<TblacaSedePrograma> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("entity", entity);
		q.setParameter("estado", UtilidadBean.booleano(estado));
		q.setParameter("ofertado", UtilidadBean.booleano(ofertado));
		listaEntidad = (List<TblacaSedePrograma>) q.getResultList();
		return listaEntidad;
	}

	@Override
	public List<TblestEstudiantePrograma> buscarPorEstudiante(
			TblestEstudiante entity) throws DAOException {

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT ep FROM ");
		jpql.append(TblestEstudiantePrograma.class.getSimpleName());
		jpql.append(" ep ");
		jpql.append(" JOIN FETCH ep.tblacaSede s ");
		jpql.append(" JOIN FETCH ep.tblacaPrograma p ");
		jpql.append(" JOIN FETCH ep.tblestEstudiante es ");
		jpql.append(" JOIN FETCH ep.tblacaPlanestudio pl ");
		jpql.append(" WHERE  es.oid=:estudiante ");
		jpql.append(" ORDER BY ep.idEp ASC ");

		List<TblestEstudiantePrograma> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("estudiante", entity.getOid());
		listaEntidad = (List<TblestEstudiantePrograma>) q.getResultList();
		LOG.info("----------: " + listaEntidad.size());
		return listaEntidad;
	}

	@Override
	public List<TblfinEstudianteProgramaRecibo> buscarPorEp(
			TblestEstudiantePrograma entity) throws DAOException {

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT r FROM ");
		jpql.append(TblfinEstudianteProgramaRecibo.class.getSimpleName());
		jpql.append(" r ");
		jpql.append(" JOIN FETCH r.tblestEstudiantePrograma ep ");
		jpql.append(" WHERE  ep.idEp=:ep ");
		jpql.append(" ORDER BY ep.fechaCreacion DESC ");

		List<TblfinEstudianteProgramaRecibo> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("ep", entity.getIdEp());
		listaEntidad = (List<TblfinEstudianteProgramaRecibo>) q.getResultList();
		LOG.info("----------: " + listaEntidad.size());
		return listaEntidad;
	}

	@Override
	public List<TblacaMatriculado> buscarPorPeriodoSede(Integer periodo,
			Integer sede) throws DAOException {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT m FROM ");
		jpql.append(TblacaMatriculado.class.getSimpleName());
		jpql.append(" m ");
		jpql.append(" JOIN FETCH m.tblacaPeriodo p ");
		jpql.append(" JOIN FETCH m.tblestEstudiantePrograma ep ");
		jpql.append(" JOIN FETCH ep.tblacaSede s ");
		jpql.append(" JOIN FETCH m.tblestEstudiante e ");
		jpql.append(" WHERE  s.oid=:sede ");
		jpql.append(" AND  p.oid=:periodo ");
		jpql.append(" AND  m.estadoCancelacion>0 ");
		jpql.append(" ORDER BY e.apellido1 ASC ");

		List<TblacaMatriculado> listaEntidad = null;

		Query q = em.createQuery(jpql.toString());
		q.setParameter("sede", sede);
		q.setParameter("periodo", periodo);
		listaEntidad = (List<TblacaMatriculado>) q.getResultList();
		return listaEntidad;
	}

}
