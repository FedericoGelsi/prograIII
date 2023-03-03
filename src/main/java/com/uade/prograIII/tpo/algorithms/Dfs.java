package com.uade.prograIII.tpo.algorithms;

import com.uade.prograIII.tpo.api.GrafoTDA;


public class Dfs {

    public int[] search(GrafoTDA grafo, int origen){
        int cantVertices = grafo.vertices().size();
        int[] predecesor = new int[cantVertices];
        boolean[] visitado = new boolean[cantVertices];
        return search(grafo, origen, visitado, predecesor);
    }

    public int[] search(GrafoTDA grafo, int origen, boolean[] visitado, int[] predecesor) {
        visitado[origen] = true;
        for (int v = 0; v < grafo.vertices().size(); v++) {
            if (grafo.existeArista(origen, v) && !visitado[v]) {
                predecesor[v] = origen;
                search(grafo, v, visitado, predecesor);
            }
        }
        return predecesor;
    }
}

