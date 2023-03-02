package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.api.GrafoTDA;

import java.util.ArrayDeque;
import java.util.Queue;

public class Bfs {

    private int[] marca;

    public int[] search(GrafoTDA grafo, int origen) {

        Queue<Integer> cola = new ArrayDeque<>();
        int cantVertices = grafo.vertices().size();
        int[] predecesor = new int[cantVertices];
        marca = new int[cantVertices];
        for (int u = 0; u < cantVertices; u++) {
            marcarBlanco(u);
        }
        marcarGris(origen);
        cola.add(origen);
        while (!cola.isEmpty()) {
            int u = cola.poll();
            for (int v = 0; v < cantVertices; v++) {
                if (grafo.existeArista(u, v)) {
                    if (esBlanco(v)) {
                        marcarGris(v);
                        predecesor[v] = u;
                        cola.add(v);
                    }
                }
            }
            marcarNegro(u);
        }
        return predecesor;
    }

    protected boolean esBlanco(int index) {
        return marca[index] == -1;
    }

    protected void marcarGris(int index) {
        marca[index] = 0;
    }

    protected void marcarNegro(int index) {
        marca[index] = 1;
    }

    protected void marcarBlanco(int index) {
        marca[index] = -1;
    }

}

