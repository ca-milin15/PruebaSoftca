package com.api.arbolb.apirestarbolb.arbolDB;

import com.api.arbolb.apirestarbolb.arbolDB.beans.Arbol;

public interface ArbolDBService {

	void persistirArbolEnDisco(Arbol arbol);

	Arbol buscarObjeto(Integer id);
	
	<T> Object almacenarObjeto(Integer indice, Object objetoAAlmacenar, Class<T> entidad);
}
