package com.api.arbolb.apirestarbolb.arbolDB;

import com.api.arbolb.apirestarbolb.arbolDB.beans.Arbol;

public interface ArbolDBService {

	void persistirArbolEnDisco(Arbol arbol);

	Object buscarObjeto(Integer id) throws Exception;
	
	<T> Object almacenarObjeto(Object objetoAAlmacenar, Class<T> entidad);
}
