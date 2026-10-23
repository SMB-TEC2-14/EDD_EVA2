/*
Santiago Morquecho Bañuelos #24550835
20/10/2026
 */
package eva2_7_grafo;

public class EVA2_7_GRAFO {

    public static void main(String[] args) {
        ListaGrafo<Integer>lista = new ListaGrafo<>();
        
        //DATOS AGREGADOS
        lista.agregar(100);
        lista.agregar(200);
        lista.agregar(300);
        lista.agregar(400);
        lista.agregar(500);
        
        //METODOS PARA IMPRIMIR
        System.out.println("El orden actual de la lista es:" + " ");
        lista.imprimir();
        System.out.println("");
        System.out.println("El orden inverso de la lista es:" + " ");
        lista.imprimirInv();
        System.out.println("");
        
        //
        
        
        
        
        
    }
    
}
