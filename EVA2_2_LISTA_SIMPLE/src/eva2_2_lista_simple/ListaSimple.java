/*
Santiago Morquecho Bañuelos #24550835
21/09/2026
 */
package eva2_2_lista_simple;

public class ListaSimple {
    // ATRIBUTOS PRINCIPALES
    private Nodo inicio; // Cabeza de la lista
    private Nodo fin; // Rastreador del último eslabón para hacer inserciones en O(1)
    private int tamañoActual; // Atributo para llevar el conteo O(1) de los elementos
    
    public ListaSimple() {
        inicio = null; // Al crear la lista, se instancia vacía
        fin = null;
        tamañoActual = 0;
    }
    
    /*
     * agregar - O(1)
     *
     * PRE: Recibe un número entero como parámetro
     * POST: Crea dinámicamente un nodo y lo conecta forzosamente al final de la cadena
     */
    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor); // Crea dinámicamente el nodo para el valor a insertar
        
        if (inicio == null) { // ¿La lista está vacía?
            inicio = nuevo; // El nuevo es el primer nodo de la cadena
            fin = nuevo;
        } else { // Si la lista ya contiene eslabones
            fin.setSiguiente(nuevo); // Enganchamos el nuevo dato al último conocido
            fin = nuevo; // Actualizamos el rastreador del final
        }
        tamañoActual++; // Aumentamos el tamaño instantáneamente
    }
    
    /*
     * imprimir - O(n)
     *
     * PRE: N/A
     * POST: Muestra todos los elementos en consola desde la cabeza hasta topar con null
     */
    public void imprimir() {
        Nodo temp = inicio; // Creamos la referencia temporal obligatoria para el recorrido
        while (temp != null) { // Mientras no lleguemos al final (null)
            System.out.print("[" + temp.getValor() + "] - "); // Imprimimos la carga útil
            temp = temp.getSiguiente(); // Saltamos al siguiente eslabón
        }
    }
    
    /*
     * longuitud - O(1)
     *
     * PRE: N/A
     * POST: Retorna de manera inmediata la cantidad de elementos en la cadena
     */
    public int longuitud() {
        return tamañoActual;
        /*int cont = 0;
            Nodo temp = inicio;
            while(temp != null){
                cont++;
                temp = temp.getSiguiente();
            }
            return cont;*/
    }
    
    /*
     * listaVacia - O(1)
     *
     * PRE: N/A
     * POST: Retorna true si la cabeza (inicio) no apunta a nada
     */
    public boolean listaVacia() {
        if(inicio == null) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * vaciarLista - O(1)
     *
     * PRE: N/A
     * POST: Desconecta los apuntadores, dejando la cadena inalcanzable para que el Garbage Collector la borre
     */
    public void vaciarLista() {
        inicio = null;
        fin = null;
        tamañoActual = 0;
    }
    
    /*
     * valorEn - O(n)
     *
     * PRE: El índice solicitado debe existir dentro de los límites (>= 0 y < tamaño)
     * POST: Devuelve la carga útil del eslabón ubicado en dicha posición
     */
    public int valorEn(int posicion) throws RuntimeException {
        int tama = longuitud();
        
        // Validación de seguridad para la posición
        if (posicion >= 0 && posicion < tama) { 
            Nodo temp = inicio;
            // Damos los saltos precisos para posicionarnos
            for(int i = 0; i < posicion; i++) {
                temp = temp.getSiguiente();
            }
            return temp.getValor();
        } else {
            // Excepción no comprobada para proteger el programa de un crasheo
            throw new RuntimeException("La posicion " + posicion + " no es valida");
        }
    }
    
    /*
     * encontrar - O(n)
     *
     * PRE: Un valor entero a buscar
     * POST: Retorna la posición de la primera coincidencia, o -1 si el valor no existe
     */
    public int encontrar(int valor) {
        Nodo temp = inicio; // Empezamos en la cabeza
        int posicion = 0;
        
        // Recorremos la cadena nodo por nodo
        while (temp != null) {
            if (temp.getValor() == valor) {
                return posicion; // Se encontró, regresamos su índice actual
            }
            temp = temp.getSiguiente();
            posicion++;
        }
        
        // Retorno bandera (-1) indica fallo seguro en la búsqueda
        return -1; 
    }
    
    /*
     * insertarEn - O(n)
     *
     * PRE: Una posición válida y un entero. Si es la última posición, debe usar el método agregar()
     * POST: Engancha el nuevo eslabón en medio de la cadena sin perder las referencias posteriores
     */
    public void insertarEn(int valor, int posicion) {
        int tama = longuitud();
        
        // 1. VALIDACIÓN DE LOS LÍMITES
        if (posicion < 0 || posicion > tama) { 
            throw new RuntimeException("La posicion " + posicion + " no es valida");
        }
        
        Nodo nuevo = new Nodo(valor);
        
        // 2. ESCENARIO A: Inserción al principio
        if (posicion == 0) {
            nuevo.setSiguiente(inicio); // El nuevo agarra a la cabeza antigua
            inicio = nuevo; // Cambia la cabeza
            if (fin == null) {
                fin = nuevo;
            }
        }
        // 3. ESCENARIO B: Inserción al final
        else if (posicion == tama) {
            agregar(valor); // Reutilizamos el método O(1) existente
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
            temp.setSiguiente(nuevo);
            
            if (posicion == tama) {
                fin = nuevo;
            }
        }
        tamañoActual++; // Aumenta el contador de la longitud
    }
    
    /*
     * borrarEn - O(n)
     *
     * PRE: Una posición válida menor al tamaño real de la lista
     * POST: Modifica el enganche del eslabón previo, obligándolo a saltarse al nodo destino para que sea destruido
     */
    public void borrarEn(int posicion) {
        int tama = longuitud();
        
        if (posicion < 0 || posicion >= tama) { 
            throw new RuntimeException("La posicion " + posicion + " no es valida");
        }
        
        // Escenario si se desea borrar la cabeza
        if (posicion == 0) {
            inicio = inicio.getSiguiente();
        }
        else {
            Nodo temp = inicio;
            // Viajamos un nodo antes del objetivo
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.getSiguiente();
            }
            // Desenganche: Forzamos a la referencia a saltarse un espacio
            temp.setSiguiente(temp.getSiguiente().getSiguiente());
        }
        tamañoActual--; // Reducimos el contador para mantener el O(1) exacto
    }
    
    /*
     * imprimirInverso - O(n cuadrado)
     *
     * PRE: N/A
     * POST: Extrae los datos a un arreglo estático y los imprime de fin a inicio
     */
    public void imprimirInverso() {
         for (int i = longuitud() - 1; i >= 0; i--) {
            System.out.print("[" + valorEn(i) + "]" + " - ");
    }
         }

}