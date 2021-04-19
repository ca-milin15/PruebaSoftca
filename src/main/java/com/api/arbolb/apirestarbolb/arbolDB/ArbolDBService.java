package com.api.arbolb.apirestarbolb.arbolDB;

import com.api.arbolb.apirestarbolb.arbolDB.beans.Arbol;
import com.api.arbolb.apirestarbolb.utilidades.beans.excepciones.ObjetoNoEncontradoException;

public interface ArbolDBService {

	void persistirArbolEnDisco(Arbol arbol);

	Object buscarObjeto(Integer id) throws ObjetoNoEncontradoException;
	
	<T> Object almacenarObjeto(Object objetoAAlmacenar, Class<T> entidad);
}
