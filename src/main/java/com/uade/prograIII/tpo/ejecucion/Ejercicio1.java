package ejecucion;

import api.ConjuntoTDA;
import api.GrafoTDA;
import impl.ConjuntoTA;
import impl.GrafoMA;

public class Ejercicio1 {

	public static void main(String[] args) {
		GrafoTDA grafo = new GrafoMA();
		ConjuntoTDA aislados = new ConjuntoTA();
		ConjuntoTDA puentes = new ConjuntoTA();
		ConjuntoTDA adyacentesDobles= new ConjuntoTA();
		ConjuntoTDA conectados= new ConjuntoTA();
		
		int grado;
		int mayorcosto;
		
		grafo.InicializarGrafo();
		aislados.inicializarConjunto();
		puentes.inicializarConjunto();
		adyacentesDobles.inicializarConjunto();
		conectados.inicializarConjunto();
		
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(2);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(4);
		grafo.AgregarVertice(5);
		grafo.AgregarVertice(6);
		grafo.AgregarVertice(7);
		
		
		grafo.AgregarArista(1, 2, 5);
		grafo.AgregarArista(2, 3, 5);
		grafo.AgregarArista(2, 4, 5);
		grafo.AgregarArista(5, 6, 2);
		System.out.println("Arista saliente de 1: " + hayAristaSaliente(grafo, 1));
		System.out.println("Arista saliente de 3: " + hayAristaSaliente(grafo, 3));
		System.out.println("Arista entrante en 1: " + hayAristaEntrante(grafo, 1));
		System.out.println("Arista entrante en 3: " + hayAristaEntrante(grafo, 3));
		
		aislados = obtenerAislados(grafo);
		printConjunto(aislados,"Aislados");
		puentes = obtenerPuentes (grafo,1,3);
		printConjunto (puentes,"Puentes");
		System.out.println("El mayor costo es: " + MayorCosto(grafo,2));
		conectados = obtenerConectados(grafo,2);
		printConjunto (conectados,"Conjunto de Conectados");
		grado = obtenerGrado(grafo,2);	
		System.out.println("El grado del vertice elegido es: " +grado);

	}
	
	private static void printConjunto (ConjuntoTDA conjunto, String tipo) {
		
		if (conjunto.conjuntoVacio()) {
			System.out.println("Conjunto Vacio");}
		
		else
		
		while(!conjunto.conjuntoVacio()) {
			int vertice = conjunto.elegir();
			System.out.println(tipo+": "+ vertice);
			conjunto.sacarElemento(vertice);
		}
	}
		
	
	private static ConjuntoTDA copiarConjunto(ConjuntoTDA origen, ConjuntoTDA destino) {
		ConjuntoTDA aux = new ConjuntoTA();
		aux.inicializarConjunto();
		destino.inicializarConjunto();
		
		while(!origen.conjuntoVacio()) {
			int valor;
			valor = origen.elegir();
			aux.agregarElemento(valor);
			destino.agregarElemento(valor);
			origen.sacarElemento(valor);
		}
		
		return aux;
	}
	
	private static boolean hayAristaSaliente(GrafoTDA grafo, int vertice) {
		ConjuntoTDA vertices = new ConjuntoTA();
		vertices.inicializarConjunto();
		
		vertices = grafo.Vertices();
		vertices.sacarElemento(vertice);
		
		while(!vertices.conjuntoVacio()) {
			int vConjunto = vertices.elegir();
			if(grafo.ExisteArista(vertice, vConjunto)) {
				return true;
			}
			vertices.sacarElemento(vConjunto);
		}
		return false;
		
	}
	
	private static boolean hayAristaEntrante(GrafoTDA grafo, int vertice) {
		ConjuntoTDA vertices = new ConjuntoTA();
		vertices.inicializarConjunto();
		
		vertices = grafo.Vertices();
		vertices.sacarElemento(vertice);
		
		while(!vertices.conjuntoVacio()) {
			int vConjunto = vertices.elegir();
			if(grafo.ExisteArista(vConjunto, vertice)) {
				return true;
			}
			vertices.sacarElemento(vConjunto);
		}
		return false;
		
	}
	

	public static ConjuntoTDA AdyacentesDobles(GrafoTDA grafo, int v) {
        ConjuntoTDA conj_aux = new ConjuntoTA();
        ConjuntoTDA conj_aux2 = new ConjuntoTA();
        ConjuntoTDA c = new ConjuntoTA();    // crear conjuntos auxiliares y destino
        conj_aux.inicializarConjunto();
        conj_aux2.inicializarConjunto();
        c.inicializarConjunto();    

        conj_aux = grafo.Vertices(); // se obtiene el conjunto de vertices
        conj_aux2 = grafo.Vertices();
        conj_aux.sacarElemento(v);   // se saca el valor v de los conjuntos auxiliares
        conj_aux2.sacarElemento(v);
        int v2;
        int v3;

        while (!conj_aux.conjuntoVacio()) {  // aqui comparamos los vertices de los conjuntos auxiliares con el valor v
            v2 = conj_aux.elegir();  
            conj_aux2 = grafo.Vertices();    
            conj_aux2.sacarElemento(v);
            if (grafo.ExisteArista(v, v2)) {    // si existe arista entre v y v2, iterar sobre v2, para ver si llega a otro vertice
                while (!conj_aux2.conjuntoVacio()) {
                    v3 = conj_aux.elegir();
                    if (grafo.ExisteArista(v2, v3) && v2 != v3) {   // si existe arista entre v2 y v3, agregar v3 al conjunto destino
                        c.agregarElemento(v3);
                    }
                    conj_aux2.sacarElemento(v3);
                }
            }
            conj_aux.sacarElemento(v2);
        }
        return c;
    }
	
	
	public static int MayorCosto (GrafoTDA grafo, int v) {
		int mayor = 0; // creamos variable para el mayor e inicializamos en 0
		ConjuntoTDA vertices = new ConjuntoTA(); // creamos e inicializamos connjunto para almacenar los verticies del grafo
		vertices.inicializarConjunto();
		vertices = grafo.Vertices(); // obtenemos vertices del grafo
		ConjuntoTDA copiaV = new ConjuntoTA();
		copiaV= vertices;
		
		while (!copiaV.conjuntoVacio()) {
		int elemento = copiaV.elegir();
		if (grafo.ExisteArista(v, elemento)) {
			if (grafo.PesoArista(v, elemento) > mayor) {
				mayor = grafo.PesoArista(v, elemento );
			}
		}
		copiaV.sacarElemento(elemento);
		
		}
		return mayor;
	}
	
	
	public static ConjuntoTDA Predecesores (GrafoTDA grafo, int v) {
		int elemento ; // creamos variable para almacenar los vertices
		ConjuntoTDA conjuntoPre = new ConjuntoTA (); // creamos e inicializamos conjunto para almacenar los vertices y el resultado de predecesores
		ConjuntoTDA vertices =  new ConjuntoTA();
		vertices.inicializarConjunto();
		conjuntoPre.inicializarConjunto();
		vertices = grafo.Vertices(); // obtenemos vertices del grafo
		
		
		
		while (!vertices.conjuntoVacio()) { // recorremos los vertices para comprarar si cada vertice con el parametro en busca de alguna arista que ingrese a V.
			
			elemento = vertices.elegir();
			if (grafo.ExisteArista(elemento,v )) { // si es arista entrante, entonces esta antes de V.
				conjuntoPre.agregarElemento(elemento); // se agrega el vertice al conjunto de resultado.
				
			}
			vertices.sacarElemento(elemento);
		}
		return conjuntoPre;
	}
	
	
	private static ConjuntoTDA obtenerAislados(GrafoTDA grafo) {
		ConjuntoTDA vertices = new ConjuntoTA();
		ConjuntoTDA resultado = new ConjuntoTA();
		
		vertices.inicializarConjunto();
		resultado.inicializarConjunto();
		
		vertices = grafo.Vertices();
		
		while(!vertices.conjuntoVacio()) {
			int vConjunto = vertices.elegir();
			
			if(!hayAristaEntrante(grafo, vConjunto)&&!hayAristaSaliente(grafo, vConjunto))
				resultado.agregarElemento(vConjunto);
			
			vertices.sacarElemento(vConjunto);
		}
		
		return resultado;
	}
	
private static ConjuntoTDA obtenerPuentes(GrafoTDA grafo, int v1, int v2) {
		
		ConjuntoTDA vertices = new ConjuntoTA();
		ConjuntoTDA puentes = new ConjuntoTA();
		vertices.inicializarConjunto();
		puentes.inicializarConjunto();
		vertices= grafo.Vertices();
		
		while (!vertices.conjuntoVacio()) {
			
			int elemento = vertices.elegir();
			if (grafo.ExisteArista(v1,elemento) && grafo.ExisteArista(elemento, v2)&& (v1!=v2)){
				puentes.agregarElemento(elemento);
			}
			vertices.sacarElemento(elemento);
		}
		return puentes;
	} 



private static ConjuntoTDA obtenerConectados(GrafoTDA grafo, int vertice) {
	
	ConjuntoTDA vertices = new ConjuntoTA();
	ConjuntoTDA conectados = new ConjuntoTA();
	vertices.inicializarConjunto();
	conectados.inicializarConjunto();
	vertices= grafo.Vertices();
	
	while (!vertices.conjuntoVacio()) {
		
		int elemento = vertices.elegir();
		if (grafo.ExisteArista(vertice,elemento) || grafo.ExisteArista(elemento, vertice)){
			conectados.agregarElemento(elemento);
		}
		vertices.sacarElemento(elemento);
	}
	return conectados;
} 



private static int obtenerGrado(GrafoTDA grafo, int v) {
	
	ConjuntoTDA vertices = new ConjuntoTA();
	int grado = 0 ; 
	vertices.inicializarConjunto();

	vertices= grafo.Vertices();
	
	while (!vertices.conjuntoVacio()) {
		
		int elemento = vertices.elegir();
		if (grafo.ExisteArista(v,elemento)) {
			grado ++;
			
		}
		if (grafo.ExisteArista(elemento,v)) {
			grado --;
			
		}
		vertices.sacarElemento(elemento);
	}
	return grado;
} 
}
