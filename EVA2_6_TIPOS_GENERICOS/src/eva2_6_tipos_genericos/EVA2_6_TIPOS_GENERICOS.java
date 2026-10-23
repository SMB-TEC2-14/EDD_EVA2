/*
Santiago Morquecho Bañuelos #24550835
20/10/2026
 */
package eva2_6_tipos_genericos;

public class EVA2_6_TIPOS_GENERICOS {

    public static void main(String[] args) {
        //int --> Integer, double --> Double
        Ejemplo<Integer> prueba = new Ejemplo<Integer>();
        
        
    }
    class Ejemplo <T>{
        private T dato;
        
        public Ejemplo(){
        }
        
        public Ejemplo(T dato){
            this.dato = dato;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }
        
    }
    
}
