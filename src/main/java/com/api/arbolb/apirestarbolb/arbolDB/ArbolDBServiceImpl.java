package com.api.arbolb.apirestarbolb.arbolDB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.arbolb.apirestarbolb.arbolDB.beans.Arbol;
import com.api.arbolb.apirestarbolb.arbolDB.beans.Clave;
import com.api.arbolb.apirestarbolb.arbolDB.beans.Nodo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArbolDBServiceImpl implements ArbolDBService {

	ObjectMapper objectMapper;

	@Override
	public void persistirArbolEnDisco(Arbol arbol) {
		try {
			var arbolComoString = objectMapper.writeValueAsString(arbol);
			var rutaArchivo = Paths.get(
					"C:\\Users\\camilo\\Documents\\Proyectos Software\\PruebaSoftCaBack\\src\\main\\resources\\arbolDB\\tbl_usuario.json");
			Files.write(rutaArchivo, arbolComoString.getBytes());
		} catch (IOException e) {
			// TODO Crear controller advice
			e.printStackTrace();
		}
	}

	@Override
	public Arbol buscarObjeto(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Class<T> almacenarObjeto(Integer indice, Object objetoAAlmacenar, Class<T> entidad) {
		var instanciaArbol = new Arbol();
		var arbolAlmacenado = instanciaArbol.obtenerArbol(objectMapper);
		var nodoRaiz = arbolAlmacenado.getNodo();
		arbolAlmacenado.setNodo(buscarUbicacionParaInsertar(nodoRaiz, arbolAlmacenado.getAutoincremental()));
		arbolAlmacenado.setAutoincremental(arbolAlmacenado.getAutoincremental() + 1);
		persistirArbolEnDisco(arbolAlmacenado);
		return null;
	}

	private Nodo buscarUbicacionParaInsertar(Nodo nodoRaiz, Integer valor) {
		if (!ObjectUtils.isEmpty(nodoRaiz)) {
			var listaClaves = nodoRaiz.getListaClave();
			if (listaClaves.stream().anyMatch(clave -> clave.getValorClave() == valor)) {
				throw new RuntimeException("El valor a insertar ya existe en el arbol");
			}
			var tamanoLista = listaClaves.size();
			for (int i = 0; i < tamanoLista; i++) {
				var siguienteClave = obtenerClaveSiguiente(listaClaves, i);
				Clave posibleClave = procesoCreacionClave(listaClaves.get(i), valor, nodoRaiz, siguienteClave,
						listaClaves, i);
				if (!ObjectUtils.isEmpty(posibleClave)) {
					listaClaves.add(posibleClave);
					nodoRaiz.setTamanoActual(nodoRaiz.getTamanoActual() + 1);
					Collections.sort(listaClaves, (ref1, ref2) -> ref1.getValorClave().compareTo(ref2.getValorClave()));
					validarDimensionHoja(nodoRaiz, null);
					break;
				}
			}
		} else {
			return new Nodo(valor);
		}
		return nodoRaiz;
	}

	private void iniciarProcesoEnSubarbol(List<Clave> listaClavesNodoDerecha, int listaClavesNodoDerechaTamano,
			Nodo nodoRaiz, Nodo nodoPadre, Integer valor) {
		for (int j = 0; j < listaClavesNodoDerechaTamano; j++) {
			var siguienteClaveSubArbol = obtenerClaveSiguiente(listaClavesNodoDerecha, j);
			var posiblClaveResProceso = procesoCreacionClave(listaClavesNodoDerecha.get(j), valor, nodoRaiz,
					siguienteClaveSubArbol, listaClavesNodoDerecha, j);
			if (!ObjectUtils.isEmpty(posiblClaveResProceso)) {
				listaClavesNodoDerecha.add(posiblClaveResProceso);
				nodoRaiz.setTamanoActual(nodoRaiz.getTamanoActual() + 1);
				Collections.sort(listaClavesNodoDerecha,
						(ref1, ref2) -> ref1.getValorClave().compareTo(ref2.getValorClave()));
				validarDimensionHoja(nodoRaiz, nodoPadre);
				break;
			}
		}
	}

	private void validarDimensionHoja(Nodo nodoRaiz, Nodo nodoPadre) {
		if (nodoRaiz.getTamanoActual() > 4) {
			var nodoAAscender = nodoRaiz.getListaClave().get(2);
			var nodoIzquierdo = crearNodo(nodoRaiz.getListaClave(), 0, 2);
			var nodoDerecho = crearNodo(nodoRaiz.getListaClave(), 2, 5);
			if (ObjectUtils.isEmpty(nodoPadre)) {
				nodoRaiz.setListaClave(new ArrayList<Clave>() {
					private static final long serialVersionUID = 7648394616362347399L;
					{
						add(new Clave(nodoAAscender.getValorClave(), nodoIzquierdo, nodoDerecho));
					}
				});
				nodoRaiz.setTipoNodoClave(false);
				nodoRaiz.setTamanoActual(nodoRaiz.getListaClave().size());
			} else {
				nodoPadre.getListaClave().add(new Clave(nodoAAscender.getValorClave(), nodoIzquierdo, nodoDerecho));
				nodoPadre.setTamanoActual(nodoPadre.getListaClave().size());
			}
			if (!ObjectUtils.isEmpty(nodoPadre))
				validarDimensionHoja(nodoPadre, null);
		}
	}

	private Nodo crearNodo(List<Clave> listaClave, int valorInicial, int valorFinal) {
		var nodo = new Nodo();
		for (var i = valorInicial; i < valorFinal; i++) {
			nodo.getListaClave().add(new Clave(listaClave.get(i).getValorClave()));
		}
		nodo.setTamanoActual(nodo.getListaClave().size());
		return nodo;
	}

	private Clave procesoCreacionClave(Clave claveArbol, Integer valor, Nodo nodoRaiz, Clave siguienteClave,
			List<Clave> listaClaves, int i) {
		if (claveArbol.getValorClave() > valor) {
			if (claveArbol.getNodoIzquierda().getTamanoActual() == 0) {
				return crearClave(nodoRaiz, listaClaves, valor, siguienteClave);
			} else {
				var listaClavesNodoDerecha = claveArbol.getNodoDerecha().getListaClave();
				iniciarProcesoEnSubarbol(claveArbol.getNodoDerecha().getListaClave(), listaClavesNodoDerecha.size(),
						nodoRaiz, nodoRaiz, valor);
			}
		} else if (valor > listaClaves.get(i).getValorClave()
				&& (!ObjectUtils.isEmpty(siguienteClave) && valor < siguienteClave.getValorClave())) {
			if (listaClaves.get(i).getNodoDerecha().getTamanoActual() == 0
					&& siguienteClave.getNodoIzquierda().getTamanoActual() == 0) {
				return crearClave(nodoRaiz, listaClaves, valor, siguienteClave);
			}
		} else if (valor > claveArbol.getValorClave() && ObjectUtils.isEmpty(siguienteClave)) {
			if (claveArbol.getNodoDerecha().getTamanoActual() == 0) {
				return crearClave(nodoRaiz, listaClaves, valor, siguienteClave);
			} else {
				var listaClavesNodoDerecha = claveArbol.getNodoDerecha().getListaClave();
				iniciarProcesoEnSubarbol(claveArbol.getNodoDerecha().getListaClave(), listaClavesNodoDerecha.size(),
						claveArbol.getNodoDerecha(), nodoRaiz, valor);
			}

		}
		return null;
	}

	private static Clave crearClave(Nodo nodoRaiz, List<Clave> listaClaves, Integer valor, Clave siguienteClave) {
		return new Clave(valor);
	}

	private Clave obtenerClaveSiguiente(List<Clave> listaClaves, int i) {
		try {
			return listaClaves.get(i + 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
