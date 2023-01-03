package com.comun;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.comun.dao.FormatoDAO;
import commons.util.UtilidadBean;
import comun.TblcalFormato;

import exceptions.BOException;
import exceptions.DAOException;

@Stateless(mappedName = "formatoBO")
public class FormatoBOImpl implements FormatoBO {

	@Inject
	private FormatoDAO formatoDAO;

	@Override
	public List<TblcalFormato> listar() throws BOException {
		try {
			return formatoDAO.listar();
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}

	}

	@Override
	public void crear(byte[] serialize, boolean actualizarFuenteDatos)
			throws BOException {
		try {
			TblcalFormato entity = UtilidadBean.deserialize(serialize);
			formatoDAO.crear(entity, actualizarFuenteDatos);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}

	@Override
	public byte[] editar(byte[] serialize) throws BOException {
		try {
			TblcalFormato entity = UtilidadBean.deserialize(serialize);
			TblcalFormato entityReturn = new TblcalFormato();

			entityReturn = formatoDAO.editar(entity);
			return UtilidadBean.serialize(entityReturn);
		} catch (DAOException e) {
			throw new BOException(e.getMessage(), e);
		}
	}
}