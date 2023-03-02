package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.api.GrafoTDA;

import java.util.ArrayDeque;
import java.util.Queue;

public class Bfs {


    public int[] search(GrafoTDA grafo, int origen) {

        Queue<Integer> cola = new ArrayDeque<>();
        int cantVertices = grafo.vertices().size();
        int[] predecesor = new int[cantVertices];
        boolean[] visitado = new boolean[cantVertices];
        cola.add(origen);
        visitado[origen] = true;
        while (!cola.isEmpty()) {
            int u = cola.poll();
            for (int v = 0; v < cantVertices; v++) {
                if (grafo.existeArista(u, v) && !visitado[v]) {
                    predecesor[v] = u;
                    visitado[v] = true;
                    cola.add(v);
                }
            }
        }
        return predecesor;
    }
}

