/**
 * 
 */
package com.academico;

import java.util.List;

import javax.ejb.Remote;

import academico.TblacaMatriculado;
import academico.TblacaPrograma;
import academico.TblacaSede;
import academico.TblacaSedePrograma;
import academico.TblestEstudiantePrograma;
import cartera.TblfinEstudianteProgramaRecibo;
import exceptions.BOException;

/**
 * @author EDUAR
 * 
 */
@Remote
public interface EstudianteProgramaBO {

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

	public List<TblestEstudiantePrograma> buscarPorEstudiante(byte[] serialize)
			throws BOException;
	
	public List<TblfinEstudianteProgramaRecibo> buscarPorEp(byte[] serialize)
			throws BOException;

	public List<TblacaMatriculado> buscarPorPeriodoSede(Integer periodoDefault,
			Integer sedeDefault)throws BOException;

}
