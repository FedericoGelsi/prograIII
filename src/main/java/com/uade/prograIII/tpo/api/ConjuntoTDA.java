package api;

public interface ConjuntoTDA {
	public void inicializarConjunto();
	public boolean pertenece(int elemento);
	public void agregarElemento(int elemento);
	public void sacarElemento(int elemento);
	public int elegir();
	public boolean conjuntoVacio();
}
