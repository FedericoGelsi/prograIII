package com.uade.prograIII.tpo.api;

import java.util.List;

/**
 * The interface Grafo tda.
 */
public interface GrafoTDA {
	/**
	 * Agregar arista.
	 *
	 * @param origen  the origen
	 * @param destino the destino
	 * @param peso    the peso
	 */
	void agregarArista(int origen, int destino, int peso);

	/**
	 * Eliminar arista.
	 *
	 * @param origen  the origen
	 * @param destino the destino
	 */
	void eliminarArista(int origen, int destino);

	/**
	 * Vertices set.
	 *
	 * @return the set
	 */
	List<Integer> vertices();

	/**
	 * Existe arista boolean.
	 *
	 * @param origen  the origen
	 * @param destino the destino
	 * @return the boolean
	 */
	boolean existeArista(int origen, int destino);

	/**
	 * Peso arista int.
	 *
	 * @param origen  the origen
	 * @param destino the destino
	 * @return the int
	 */
	int pesoArista(int origen, int destino);

}
