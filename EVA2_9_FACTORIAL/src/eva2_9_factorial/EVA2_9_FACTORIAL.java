/*
Santiago Morquecho Bañuelos #24550835
22/10/2026
 */
package eva2_9_factorial;

public class EVA2_9_FACTORIAL {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Metodo for");
        System.out.println("El factorial de 5 es: " + factorialCiclo(5));
        System.out.println("");
        System.out.println("Metodo Recursivo");
        System.out.println("El factorial de 5 es: " + factorialRecu(5));
        
    }
    
    public static int factorialCiclo(int valor){
        int resu = 1;
        for (int i = 1; i <= valor; i++) {
            resu *= i;
        }
        return resu;
    }
    
    public static int factorialRecu(int valor){
        if (valor == 0) {
            return 1;
        }
        return valor * factorialRecu(valor - 1);
    }
    
}
