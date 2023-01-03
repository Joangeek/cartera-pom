package com.cartera;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import commons.util.UtilidadBean;

import cartera.TblfinBanco;
import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "bancoBO")
public class BancoBOImpl implements BancoBO {

	@Inject
	private BancoDAO bancoDAO;

	@Override
	public List<TblfinBanco> buscarbancos() throws BOException {
		try {
			return bancoDAO.buscarBancos();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public void crear(byte[] serialize, boolean actualizarFuenteDatos)
			throws BOException {
		try {
			TblfinBanco entity = UtilidadBean.deserialize(serialize);
			bancoDAO.crear(entity, actualizarFuenteDatos);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public byte[] editar(byte[] serialize) throws BOException {
		try {
			TblfinBanco entity = UtilidadBean.deserialize(serialize);
			TblfinBanco entityReturn = new TblfinBanco();
			entityReturn = bancoDAO.editar(entity);
			return UtilidadBean.serialize(entityReturn);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}
}