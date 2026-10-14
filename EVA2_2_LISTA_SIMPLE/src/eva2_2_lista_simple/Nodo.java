/*
Santiago Morquecho Bañuelos #24550835
21/09/2026
 */
package eva2_2_lista_simple;

public class Nodo {
    // DOS ATRIBUTOS
    private int valor; // Carga útil (información real a guardar)
    private Nodo siguiente; // Gancho o referencia hacia el próximo nodo
    
    // CONSTRUCTORES
    public Nodo() {
        siguiente = null; // ESTO ES MUY IMPORTANTE, MARCA EL FIN SEGURO DE LA LISTA
    }
    
    /*
     * Constructor con parámetros
     *
     * PRE: Recibe el dato entero que se desea almacenar
     * POST: Se crea el nodo con la carga útil asignada y el puntero al siguiente en null
     */
    public Nodo(int valor) { 
        this.valor = valor;
        siguiente = null;
    }
    
    // MÉTODOS GET Y SET
    public int getValor() {
        return valor;
    }

    public void setValor(int dato) {
        this.valor = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
