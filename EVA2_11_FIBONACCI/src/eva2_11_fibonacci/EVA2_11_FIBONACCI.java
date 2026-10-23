/*
Santiago Morquecho Bañuelos #24550835
23/10/2026
 */
package eva2_11_fibonacci;
public class EVA2_11_FIBONACCI {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("El numero Fibonacci de 4 es = " + fiboRecu(4));
        System.out.println("El numero Fibonacci de 7 es = " + fiboRecu(7));
    }
    
    public static int fiboRecu(int numero){
        if (numero == 0 || numero == 1) {
            return 1;
        }else{
            return fiboRecu(numero - 2) + fiboRecu(numero -1);
        }
    }
    
}
