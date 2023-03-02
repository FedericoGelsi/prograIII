package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.api.GrafoTDA;

public class Dijkstra {
    public Integer[] search(GrafoTDA grafo, int origen) {
        int cantVertices = grafo.vertices().size();
        boolean[] visitado = new boolean[cantVertices];
        Integer[] distancia = new Integer[cantVertices];
        for (int i = 0; i < cantVertices; i++) {
            distancia[i] = Integer.MAX_VALUE;
        }

        distancia[origen] = 0;
        for (int i = 0; i < cantVertices; i++) {

            int u = extraerMinimo(distancia, visitado);
            visitado[u] = true;

            for (int v = 0; v < cantVertices; v++) {
                if (!visitado[v] && grafo.existeArista(u, v) && (distancia[u] + grafo.pesoArista(u, v) < distancia[v])) {
                    distancia[v] = distancia[u] + grafo.pesoArista(u, v);
                }
            }
        }
        return distancia;
    }

    private int extraerMinimo(Integer[] distancia, boolean[] visitado) {
        int distanciaMin = Integer.MAX_VALUE;
        int verticeDistanciaMin = -1;
        for (int i = 0; i < distancia.length; i++) {
            if (!visitado[i] && distancia[i] < distanciaMin) {
                distanciaMin = distancia[i];
                verticeDistanciaMin = i;
            }
        }
        return verticeDistanciaMin;
    }
}
