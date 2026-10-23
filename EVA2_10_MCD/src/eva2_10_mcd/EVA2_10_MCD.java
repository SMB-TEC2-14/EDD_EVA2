/*
Santiago Morquecho Bañuelos #24550835
22/10/2026
 */
package eva2_10_mcd;

public class EVA2_10_MCD {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("El maximo comun divisor de 180, 48 es: " + maximoDiviRecu(180, 48));
        System.out.println("El mcd de");
    }
    
    public static int maximoDiviRecu(int valor1, int valor2) {

        // CASO BASE:
        // SI EL RESIDUO YA LLEGO A 0,
        // TERMINA LA RECURSIVIDAD
        if (valor2 == 0) {
            return valor1;
        } else {
            // SE LLAMA A SI MISMO
            return maximoDiviRecu(
                    valor2,
                    valor1 % valor2
            );
        }
    }
    //Ejemplo del profe
    public static int mcd(int dividendo,int divisor){
        int resu = dividendo/divisor;
        int residuo = dividendo%divisor;
        System.out.println(residuo);
        if (residuo == 0) {
            return divisor;
        }else{
            return mcd(divisor,residuo);
        }
    }
    
}
