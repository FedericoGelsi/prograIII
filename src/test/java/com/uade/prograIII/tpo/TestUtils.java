package com.uade.prograIII.tpo;

import com.uade.prograIII.tpo.api.GrafoTDA;
import com.uade.prograIII.tpo.impl.GrafoMA;

public class TestUtils {
    public GrafoTDA setupGrafo() {
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
        return grafo;
    }
}
