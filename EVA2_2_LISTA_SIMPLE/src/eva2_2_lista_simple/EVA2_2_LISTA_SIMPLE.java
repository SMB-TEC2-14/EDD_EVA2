/*
Santiago Morquecho Bañuelos #24550835
21/09/2026 TERMINADO 14/10/2026
 */
package eva2_2_lista_simple;
public class EVA2_2_LISTA_SIMPLE {

    public static void main(String[] args) {
     ListaSimple lista = new ListaSimple();
     /*int [] arreglo = new int [1000000];
     long ini, fin, tiempo;
     ini = System.nanoTime();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random() * 100);
        }
     fin = System.nanoTime();
     tiempo = fin - ini;
     System.out.println("Tiempo arreglo =" + tiempo);
     
     ini= System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            lista.agregar((int)(Math.random() * 100));
        }
        fin = System.nanoTime();
        tiempo = fin - ini;
        System.out.println("Tiempo arreglo =" + tiempo);*/
        System.out.println("Tamano inicial de la lista: " + lista.longuitud());
        
        // Se agregan datos
        lista.agregar(100);
        lista.agregar(200);
        lista.agregar(300);
        lista.agregar(400);
        lista.agregar(500);
        
        // Pruebas de recorrido e impresión
        lista.imprimir();
        System.out.println(" ");
        System.out.println("Tamaño de la Lista: " + lista.longuitud());
        
        // Pruebas de búsqueda y obtención
        System.out.println("Valor numero 2 de la lista: " + lista.valorEn(1));
        System.out.println(" ");
        System.out.println("La posicion del valor 100 es: " + lista.encontrar(100));
        System.out.println("La posicion del valor 999 es: " + lista.encontrar(999));
        System.out.println("La posicion del valor 400 es: " + lista.encontrar(400));
        System.out.println(" ");
        
        // Pruebas de borrado
        lista.imprimir();
        System.out.println("");
        lista.borrarEn(2); // Se elimina el nodo en el índice 2 (el valor 300)
        System.out.println(" ");
        System.out.println("Se borro el elemento en el espacio numero 3 (Indice 2)");
        lista.imprimir();
        System.out.println(" ");
        
        // Pruebas de agregado adicional
        System.out.println(" ");
        System.out.println("Se agrega el valor de 800");
        lista.agregar(800);
        lista.imprimir();
        System.out.println(" ");
        
        // Pruebas de recursividad (Impresión en reversa)
        System.out.println(" ");
        System.out.println("Ahora se va a imprimir en orden inverso:");
        lista.imprimirInverso();
        System.out.println(" ");
        System.out.println("Tamaño final: " + lista.longuitud());
        /*System.out.println(" ");
        System.out.println("Tamano de la lista: " + lista.longuitud());
        lista.vaciarLista();
        lista.imprimir();
        System.out.println(" ");
        System.out.println("Tamano de la lista: " + lista.longuitud());*/
        
        
    }
    
}
