package com.academico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import cartera.TblfinTarifaMatricula;

import commons.util.UtilidadBean;

import exceptions.BOException;
import exceptions.DAOException;


@Stateless(mappedName = "descuentosBO")
public class DescuentosBOImpl implements DescuentosBO { 

	@Inject
	private DescuentosDAO descuentosDAO;

	@Override
	public List<TblfinTarifaMatricula> listar() throws BOException {
		try {
			return descuentosDAO.listar();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public void crear(byte[] serialize, boolean actualizarFuenteDatos)
			throws BOException {
		try {
			TblfinTarifaMatricula entity = UtilidadBean.deserialize(serialize);
			descuentosDAO.crear(entity, actualizarFuenteDatos);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public byte[] editar(byte[] serialize) throws BOException {
		try {
			TblfinTarifaMatricula entity = UtilidadBean.deserialize(serialize);
			TblfinTarifaMatricula entityReturn = new TblfinTarifaMatricula();
			entityReturn = descuentosDAO.editar(entity);
			return UtilidadBean.serialize(entityReturn);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public void eliminar(byte[] serialize) throws BOException {
		try {
			TblfinTarifaMatricula entity = UtilidadBean.deserialize(serialize);
			descuentosDAO.eliminar(entity);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

}
