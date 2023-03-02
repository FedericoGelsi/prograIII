package com.uade.prograIII.tpo.impl;


import com.uade.prograIII.tpo.api.GrafoTDA;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Grafo ma.
 */
public class GrafoMA implements GrafoTDA {

	private final int[][] matrizAdyacencia;
	private List<Integer> vertices;

	// Constructor
	public GrafoMA(int numVertices) {
		matrizAdyacencia = new int[numVertices][numVertices];
		vertices = new ArrayList<>();
		// Inicializar todas las entradas de la matriz a cero
		for (int i = 0; i < numVertices; i++) {
			vertices.add(i);
			for (int j = 0; j < numVertices; j++) {
				matrizAdyacencia[i][j] = 0;
			}
		}
	}

	@Override
	public void agregarArista(int origen, int destino, int peso) {
		matrizAdyacencia[origen][destino] = peso;
	}

	@Override
	public void eliminarArista(int origen, int destino) {
		if (matrizAdyacencia[origen][destino] == matrizAdyacencia[destino][origen]) {
			matrizAdyacencia[destino][origen] = 0;
		}
		matrizAdyacencia[origen][destino] = 0;
	}

	@Override
	public List<Integer> vertices() {
		return vertices;
	}

	@Override
	public boolean existeArista(int origen, int destino) {
		return matrizAdyacencia[origen][destino] != 0;
	}

	@Override
	public int pesoArista(int origen, int destino) {
		return matrizAdyacencia[origen][destino];
	}

}
