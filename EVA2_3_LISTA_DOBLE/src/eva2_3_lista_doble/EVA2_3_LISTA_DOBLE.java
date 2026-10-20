/*
Santiago Morquecho Bañuelos #24550835
14/10/2026
 */
package eva2_3_lista_doble;
public class EVA2_3_LISTA_DOBLE {

    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();
        
        //Nodos Agregados
        lista.agregar(100);
        lista.agregar(200);
        lista.agregar(300);
        lista.agregar(400);
        lista.agregar(500);
        
        //Impresion de los Nodos
        lista.imprimir();
        System.out.println(" ");
        
        //Impresion Inversa
        lista.imprimirInv();
        System.out.println(" ");
    }
    
}
