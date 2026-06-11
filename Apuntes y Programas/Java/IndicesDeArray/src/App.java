// La idea es, creamos un array, y el usuario añade 10 items, le decimos al usuario
// que escoja un numero, se accederá a ese indice y se imprimirá, muy sencillo.

import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
       
        // creamos el array
        ArrayList<String> mi_array = new ArrayList<>();
        // creamos una variable contadora
        int contador = 0;
        // creamos un objeto scanner y su string lectora
        Scanner lector = new Scanner(System.in);
        String solicitud;
        // iteramos hasta añadir 10 datos.
        while (contador != 10){
            contador = contador + 1;
            System.out.print("Escribe algo: ");
            solicitud = lector.nextLine();
            mi_array.add(solicitud);
        }
        System.out.println("Estos son los objetos añadidos: ");
        for (String elemento: mi_array){
            System.out.print(elemento + ",");
        }
        // linea auxiliar para nueva linea.
        System.out.println(" ");
        boolean accion_completada = false;
        while (accion_completada == false){
            System.out.print("Ahora, del 0 al 9, que valor quieres imprimir?: ");
            solicitud = lector.nextLine();
            try{
                int parsed_solicitud;
                parsed_solicitud = Integer.parseInt(solicitud);
                System.out.println(mi_array.get(parsed_solicitud));
                accion_completada = true;
            }
            catch(Exception e){
                System.out.println("El número que has elegido no es valido...");
            }
            finally{

            }
        }
        lector.close();

    }
}