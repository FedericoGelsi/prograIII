package impl;

import api.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {
    
	  class Nodo {
	        int info;
	        Nodo sig;
	    }
	
	Nodo c;
	  



@Override
public void inicializarConjunto() {
	// TODO Auto-generated method stub
	c=null;
}


@Override
public boolean pertenece(int elemento) {
	Nodo aux = c;
	while ((aux != null) && (aux. info != elemento)) {
	aux = aux. sig;
	}
	return (aux != null);

}


@Override
public void agregarElemento(int elemento) {

	// Verifica que x no este en el conjunto 
	if (this. pertenece (elemento)) {
	Nodo aux = new Nodo ();
	aux. info = elemento;
	aux. sig = c;
	c=aux;
	}
}
	
	

@Override
public void sacarElemento(int elemento) {
	// TODO Auto-generated method stub
	if (c!=null) {
		// si es el primer elemento de la lista
		if (c.info == elemento) {
		c = c.sig;
		}else {
			Nodo aux = c;
			while (aux. sig!=null && aux.sig.info!=elemento)
				aux = aux. sig;
			if (aux.sig != null)
				aux. sig = aux. sig. sig;
			}
	}
}
	


@Override
public int elegir() {
	return c.info;
}


@Override
public boolean conjuntoVacio() {
	return (c == null);
}

}
