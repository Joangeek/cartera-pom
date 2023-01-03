package com.comun.util;

import javax.ejb.Remote;

import commons.util.ICrud;

/**
 * Permite realizar las operaciones CRUD(crear modificar eliminar consultar)
 * sobre la entidad <T> definida
 * 
 * @author Eduar Troyano
 * 
 * @param <T>
 */
@Remote
public interface CrudBO<T> extends ICrud<T> {

}
