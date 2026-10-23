/*
Santiago Morquecho Bañuelos #24550835
22/10/2026
 */
package eva2_8_recursividad;

public class EVA2_8_RECURSIVIDAD {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Impresión por metodo imprimirCiclo()");
        imprimirCiclo(5);
        System.out.println("");
        System.out.println("Impresión por metodo imprimirRecu()");
        imprimirRecu(5);
    }
    
    public static void imprimirCiclo(int numero){
        for (int i = numero; i >= 1; i--) {
            System.out.print( i + " - ");
        }
        System.out.println("");
    }
    
    public static void imprimirRecu(int numero){
        //RESUELVE UNA PARTE DEL PROBLEMA
        System.out.print(numero + " - ");
        //SE LLAME A SI MISMO
        if (numero > 1) {
            imprimirRecu(numero - 1);
        //DETENER LA RECURSIVIDAD
        }
            
        
        
    }
    
}
