package com.academico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import cartera.TblfinTarifa;

import commons.util.UtilidadBean;

import exceptions.BOException;
import exceptions.DAOException;


@Stateless(mappedName = "tarifasBO")
public class TarifasBOImpl implements TarifasBO {

	@Inject
	private TarifasDAO tarifasDAO;

	@Override
	public List<TblfinTarifa> listar() throws BOException {
		try {
			return tarifasDAO.listar();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public void crear(byte[] serialize, boolean actualizarFuenteDatos)
			throws BOException {
		try {
			TblfinTarifa entity = UtilidadBean.deserialize(serialize);
			tarifasDAO.crear(entity, actualizarFuenteDatos);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public byte[] editar(byte[] serialize) throws BOException {
		try {
			TblfinTarifa entity = UtilidadBean.deserialize(serialize);
			TblfinTarifa entityReturn = new TblfinTarifa();
			entityReturn = tarifasDAO.editar(entity);
			return UtilidadBean.serialize(entityReturn);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

}
