public class App {
    public static void main(String[] args) throws Exception {
        // 1. Instanciamos la lista vacía
        ListaRuta miLista = new ListaRuta();

        System.out.println("--- Creando nodos al final de la lista ---");
        miLista.crear_al_final_de_la_lista(10);
        miLista.crear_al_final_de_la_lista(20);
        miLista.crear_al_final_de_la_lista(30);
        
        // Debería imprimir: 10, 20, 30
        miLista.recorrer_lista();

        System.out.println("\n--- Creando un nodo al inicio de la lista ---");
        miLista.crear_al_inicio_de_la_lista(5);
        
        // Debería imprimir: 5, 10, 20, 30
        miLista.recorrer_lista();

        System.out.println("--- 1. Probando el constructor extra de Node ---");
        // Creamos un nodo base (nodo A)
        Node nodoA = new Node(100);
        
        // Creamos un segundo nodo (nodo B) usando el constructor que recibe el nodo anterior
        // Aquí pasamos 'nodoA' como el parámetro 'previous_param'
        Node nodoB = new Node(200, nodoA);
        
        // Para que la estructura sea completamente bidireccional, 
        // hacemos que el nodoA apunte hacia adelante al nodoB
        nodoA.set_next(nodoB);
        
        // Comprobamos si el enlace "previous" del nodoB funciona correctamente
        System.out.println("Valor de nodoB: " + nodoB.get_valor());
        if (nodoB.get_previous() != null) {
            System.out.println("El nodo anterior de nodoB es: " + nodoB.get_previous().get_valor()); // Debería ser 100
        }

        System.out.println("\n--- 2. Probando el constructor extra de ListaRuta ---");
        // Creamos una lista directamente pasándole el 'nodoA' (que ya está enlazado al nodoB)
        ListaRuta listaEspecial = new ListaRuta(nodoA);
        
        // Al recorrer la lista, debería empezar en 100 y luego pasar a 200
        System.out.println("Contenido de la lista especial:");
        listaEspecial.recorrer_lista();
    }
}
