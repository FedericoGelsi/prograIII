package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.api.GrafoTDA;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


public class DFS {


    public int[] search(GrafoTDA grafo, int origen) {

        Stack<Integer> pila = new Stack<>();
        int cantVertices = grafo.vertices().size();
        int[] predecesor = new int[cantVertices];
        boolean[] visitado = new boolean[cantVertices];
        pila.push(origen);
        visitado[origen] = true;
        while (!pila.isEmpty()) {
            int u = pila.pop();
            for (int v = 0; v < cantVertices; v++) {
                if (grafo.existeArista(u, v) && !visitado[v]) {
                    predecesor[v] = u;
                    visitado[v] = true;
                    pila.push(v);
                }
            }
        }
        return predecesor;
    }
}

