// los paquetes permiten rapidamente acceder a todo el codigo escrito en una carpeta, sin necesidad de 
// estar importando cada script individualmente.

// la carpeta SRC tiene su propio paquete por lo que no se podran crear nuevos paquetes en ella directamente, tendra que
// ser en una subcarpeta...

// importamos nuestro paquete, usando .* importamos TODO.
import war.*;

public class App {
    public static void main(String[] args) throws Exception {
        aviones avion1 = new aviones();
        tanque tanque1 = new tanque();

        avion1.say_model();
        tanque1.say_model();

    }
}
