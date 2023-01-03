package com.academico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.academico.CalendarioBO;

import academico.TblacaCalendarioAcademico;
import commons.util.UtilidadBean;
import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "calendarioBO")
public class CalendarioBOImpl implements CalendarioBO {

	@Inject
	private CalendarioDAO calendarioDAO;

	@Override
	public List<TblacaCalendarioAcademico> listar() throws BOException {
		try {
			return calendarioDAO.listar();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public void crear(byte[] serialize, boolean actualizarFuenteDatos)
			throws BOException {
		try {
			TblacaCalendarioAcademico entity = UtilidadBean.deserialize(serialize);
			calendarioDAO.crear(entity, actualizarFuenteDatos);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public byte[] editar(byte[] serialize) throws BOException {
		try {
			TblacaCalendarioAcademico entity = UtilidadBean.deserialize(serialize);
			TblacaCalendarioAcademico entityReturn = new TblacaCalendarioAcademico();
			
			entityReturn = calendarioDAO.editar(entity);
			return UtilidadBean.serialize(entityReturn);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}
}