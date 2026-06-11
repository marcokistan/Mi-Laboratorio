// Programa muy básico, en donde vamos a ordenar la lista de un usuario.
// la lista tendra 5 elementos.

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        // creamos el array
        ArrayList<Integer> mi_array = new ArrayList<>();
        // creamos la variable contadora
        int contador = 0;
        // creamos el objeto scanner
        Scanner lector = new Scanner(System.in);
        // creamos su variable lectora
        String solicitud;
        while (contador != 5){
            contador = contador + 1;
            System.out.print("Añade un número a la lista: ");
            solicitud = lector.nextLine();
            try{
                int parsed_solicitud;
                parsed_solicitud = Integer.parseInt(solicitud);
                mi_array.add(parsed_solicitud);

            }
            catch(Exception e){

                System.out.println("El objeto que has escrito no es un número");
                contador = contador - 1;

            }
            finally{

            }
        }
        System.out.println("\n" + "Lista normal: ");
        for (int elemento: mi_array){
            System.out.print(elemento + ",");
        }
        System.out.println("\n" + "Lista ordenada de menor a mayor: ");
        Collections.sort(mi_array);
        for (int elemento: mi_array){
            System.out.print(elemento + ",");
        }
        System.out.println("\n" + "Lista ordenada de mayor a menor: ");
        Collections.sort(mi_array, Collections.reverseOrder());
        for (int elemento: mi_array){
            System.out.print(elemento + ",");
        }
        lector.close();

    }
}
