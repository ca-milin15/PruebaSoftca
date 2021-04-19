package com.api.arbolb.apirestarbolb.arbolDB.beans;


import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clave implements Serializable{
	
	private static final long serialVersionUID = 7539952091070100274L;
	
	Integer valorClave;
	Object entidad;
	Nodo nodoIzquierda;
	Nodo nodoDerecha;
	
	public Clave(Integer valorClave, Object objetoAAlmacenar) {
		this.valorClave = valorClave;
		this.entidad = objetoAAlmacenar;
		this.nodoIzquierda = new Nodo();
		this.nodoDerecha = new Nodo();
	}
}
