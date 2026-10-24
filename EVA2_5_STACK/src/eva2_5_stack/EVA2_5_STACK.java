/*
Santiago Morquecho Bañuelos #24550835
20/10/2026
 */
package eva2_5_stack;
public class EVA2_5_STACK {

    public static void main(String[] args) {
        // TODO code application logic here
        MyStack pila = new MyStack();
        System.out.println("=== STACK ===");
        // PROBAR PUSH
        pila.push(100);
        pila.push(200);
        pila.push(300);
        pila.push(400);
        System.out.println("Despues de hacer push:");
        pila.imprimir();
        // PROBAR PEEK
        System.out.println("Peek: " + pila.peek());
        System.out.println("La pila sigue igual despues de peek:");
        pila.imprimir();
        // PROBAR POP
        System.out.println("Pop: " + pila.pop());
        System.out.println("Pila despues del primer pop:");
        pila.imprimir();
        System.out.println("Pop: " + pila.pop());
        System.out.println("Pila despues del segundo pop:");
        pila.imprimir();
        // REVISAR NUEVO TOPE
        System.out.println("Nuevo peek: " + pila.peek());
        // REVISAR TAMAÑO
        System.out.println("Tamanio actual: " + pila.longuitud());
    }
    
}
