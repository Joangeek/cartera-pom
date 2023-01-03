/**
 * 
 */
package com.academico;

import java.util.List;

import javax.ejb.Remote;

import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;
import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface SedeProgramaBO {

	public List<TblacaSede> buscarSedes() throws BOException;

	public List<TblacaPrograma> buscarProgramas() throws BOException;

	public List<TblacaPrograma> buscarProgramasActivos(boolean estado)
			throws BOException;

	public List<TblacaSede> buscarSedesActivas(boolean estado)
			throws BOException;

	public List<TblacaSedePrograma> buscarPorSede(byte[] serialize)
			throws BOException;

	public List<TblacaSede> buscarSedesEstadoPorSp(boolean estado)
			throws BOException;

	public List<TblacaSedePrograma> buscarProgramasEstadoSp(Integer serialize,
			boolean bool, boolean ofertado) throws BOException;

}
