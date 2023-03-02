package com.uade.prograIII.tpo.ejercitacion;

import com.uade.prograIII.tpo.algorithms.Bfs;
import com.uade.prograIII.tpo.algorithms.Dijkstra;
import com.uade.prograIII.tpo.api.GrafoTDA;
import com.uade.prograIII.tpo.impl.GrafoMA;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        GrafoTDA grafo = new GrafoMA(6);
        grafo.agregarArista(0,5,5);
        grafo.agregarArista(0,4,10);
        grafo.agregarArista(0,2,40);
        grafo.agregarArista(5,4,10);
        grafo.agregarArista(5,1,20);
        grafo.agregarArista(4,3,20);
        grafo.agregarArista(3,2,5);
        grafo.agregarArista(2,4,5);
        grafo.agregarArista(2,1,10);
        grafo.agregarArista(1,3,5);

        Dijkstra dijkstra = new Dijkstra();
        Bfs bfs = new Bfs();

        System.out.println("Camino mas corto: ");
        System.out.println("Vertices:\t"+ grafo.vertices());
        System.out.println("BFS:\t\t"+ Arrays.toString(bfs.search(grafo,0)));
        System.out.println("Dijkstra:\t"+ Arrays.toString(dijkstra.search(grafo, 0)));
    }


}
