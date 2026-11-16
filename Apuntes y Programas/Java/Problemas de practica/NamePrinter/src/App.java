import java.util.Scanner;


public class App {
    // En java todo es una clase, no hay programación fuera de POO.
    // por tanto las funciones se llaman metodos.
    // en java el tipado de variables es necesario, y todas las lineas acaban con
    // ";".

    // En java hay una clase principal, en este caso, es esta. La clase con el metodo
    // main empieza el flujo de ejecución, el resto de clases tienen sus propios
    // constructores.

    // Para este proyecto, vamos a crear tres personajes, y les daremos nombres
    // posteriormente diremos los nombres en pantalla.

    // ya que java no tiene función input, debemos usar la clase Scanner
    

    public static void main(String[] args) throws Exception {

        // cremos el objeto lector del scanner, especificamos que la entrada
        // es la consola (system).
        Scanner lector = new Scanner(System.in);
        System.out.print("Escribe el nombre del personaje 1: ");
        String nombre1 = lector.nextLine();
        character personaje1 = new character(nombre1);
        System.out.print("Escribe el nombre del personaje 2: ");
        String nombre2 = lector.nextLine();
        character personaje2 = new character(nombre2);
        System.out.print("Escribe el nombre del personaje 3: ");
        String nombre3 = lector.nextLine();
        character personaje3 = new character(nombre3);
        personaje1.decirNombre();
        personaje2.decirNombre();
        personaje3.decirNombre();
        lector.close();
    }
}
