/*
Santiago Morquecho Bañuelos #24550835
20/10/2026
 */
package eva2_7_grafo;

public class ListaGrafo <TIPO>{
    
    private Nodo<TIPO> inicio;
    private Nodo<TIPO> fin;
    private int tama;
    
    public ListaGrafo(){
        inicio = null; // Al crear la lista, se instancia vacía
        fin = null;
        tama = 0;
    }
    
    public void imprimir() {
        Nodo<TIPO> temp = inicio; // Creamos la referencia temporal obligatoria para el recorrido
        while (temp != null) { // Mientras no lleguemos al final (null)
            System.out.print("[" + temp.getValor() + "] - "); // Imprimimos la carga útil
            temp = temp.getSiguiente(); // Saltamos al siguiente eslabón
        }
    }
    
    public void imprimirInv(){
        Nodo<TIPO> temp = fin;
        while(temp != null){
            System.out.print("[" + temp.getValor() + "] - ");
            temp = temp.getPrevio();
        }
    }
    
    public int longuitud() {
        return tama;
    }
    
    public boolean listaVacia() {
        if(inicio == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void vaciarLista() {
        inicio = null;
        fin = null;
        tama = 0;
    }
    
    public void agregar(TIPO valor) {
        Nodo<TIPO> nuevo = new Nodo<TIPO>(valor); // Crea dinámicamente el nodo para el valor a insertar
        
        if (inicio == null) { // ¿La lista está vacía?
            inicio = nuevo; // El nuevo es el primer nodo de la cadena
            fin = nuevo;
        } else { // Si la lista ya contiene eslabones
            fin.setSiguiente(nuevo); // Enganchamos el nuevo dato al último conocido
            //Conectar Previo
            nuevo.setPrevio(fin);
            fin = nuevo; // Actualizamos el rastreador del final
        }
        tama++; // Aumentamos el tamaño instantáneamente
    }
    
    public void insertarEn(TIPO valor, int posicion) {
        int tama = longuitud();
        
        // 1. VALIDACIÓN DE LOS LÍMITES
        if (posicion < 0 || posicion > tama) { 
            throw new RuntimeException("La posicion " + posicion + " no es valida");
        }
        
        Nodo nuevo = new Nodo(valor);
        
        // 2. ESCENARIO A: Inserción al principio
        if (posicion == 0) {
            nuevo.setSiguiente(inicio); // El nuevo agarra a la cabeza antigua
            
            if (inicio != null) { //El inicio anterior apunta a el nuevo inicio
                inicio.setPrevio(nuevo);
                
            }
            
            inicio = nuevo; // Cambia la cabeza
            if (fin == null) {
                fin = nuevo;
            }
        }
        // 3. ESCENARIO B: Inserción al final
        else if (posicion == tama) {
            agregar(valor); // Reutilizamos el método O(1) existente
            return; //Evita que tama++ no se ejecute 2 veces
        }
        // 4. ESCENARIO C: Inserción entre nodos
        else {
            Nodo temp = inicio;
            // Nos detenemos UN paso antes de la posición deseada
            for (int i = 0; i < posicion - 1; i++) { 
                temp = temp.getSiguiente();
            }
            // Cruce de conexiones: El nuevo agarra el resto de la cadena y el viejo agarra al nuevo
            nuevo.setSiguiente(temp.getSiguiente());
            temp.setPrevio(temp); //El nuevo apunte para atras
            
            if (temp.getSiguiente() != null) {
                temp.getSiguiente().setPrevio(nuevo);
            }
            temp.setSiguiente(nuevo);
        }
        tama++; // Aumenta el contador de la longitud
        
        
    }
    
        // O(N)
    public void borrarEn(int posicion) {

        // 1. VERIFICAR SI LA LISTA ESTA VACIA
        if (inicio == null) {
            throw new RuntimeException("No se puede borrar: la lista esta vacia");
        }

        int tama = longuitud();

        // 2. VALIDAR POSICION
        if (posicion < 0 || posicion >= tama) {
            throw new RuntimeException("La posicion " + posicion + " no es valida!!!");
        }

        // 3. SI SOLO HAY UN NODO
        if (inicio == fin) {

            inicio = null;
            fin = null;

        // 4. BORRAR EL PRIMER NODO
        } else if (posicion == 0) {

            inicio = inicio.getSiguiente();

            // El nuevo inicio ya no tiene nodo anterior
            inicio.setPrevio(null);

        // 5. BORRAR EL ULTIMO NODO
        } else if (posicion == tama - 1) {

            fin = fin.getPrevio();

            // El nuevo fin ya no tiene nodo siguiente
            fin.setSiguiente(null);

        // 6. BORRAR EN CUALQUIER OTRA POSICION
        } else {

            Nodo temp = inicio;
            int cont = 0;

            // Nos movemos hasta el nodo que queremos borrar
            while (cont < posicion) {
                temp = temp.getSiguiente();
                cont++;
            }

            // El nodo anterior se conecta con el siguiente
            temp.getPrevio().setSiguiente(temp.getSiguiente());

            // El nodo siguiente se conecta con el anterior
            temp.getSiguiente().setPrevio(temp.getPrevio());
        }

        // SE BORRO UN NODO
        tama--;
    }
}