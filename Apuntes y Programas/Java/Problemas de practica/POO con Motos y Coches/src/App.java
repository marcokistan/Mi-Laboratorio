/**
 SISTEMA DE ALQUILER DE VEHÍCULOS (EJERCICIO DE POO)
 Este programa gestiona el inventario y alquiler de vehículos mediante una clase abstracta 
 llamada Vehiculo, la cual encapsula atributos privados como matrícula, marca, modelo, precio 
 diario y un estado de disponibilidad (inicializado por defecto en verdadero), además de definir 
 métodos para alquilar, devolver y un método abstracto para calcular el precio del alquiler. 
 El sistema se extiende a través de la herencia con dos clases hijas específicas: Coche, que añade 
 el atributo de número de puertas y aplica un recargo fijo de $10 si posee más de cuatro puertas 
 al calcular su precio; y Moto, que añade el atributo de cilindrada y aplica un recargo del 10% 
 sobre el precio base si supera los 500cc. Finalmente, el sistema se ejecuta en una clase 
 principal donde se demuestra el polimorfismo mediante el almacenamiento de múltiples instancias 
 de coches y motos en una lista genérica, simulando procesos de alquiler y recorriendo la colección 
 para calcular y mostrar de forma dinámica los costes de alquiler proyectados a cinco días para 
 cada vehículo según sus reglas de negocio particulares.
 */

// HOY HE APRENDIDO QUE LAS VARIABLES EN JAVA NO PUEDEN CAMBIAR TIPO UNA VEZ CREADAS.

import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        //------------------------------------------------------------------------------------------
        // CREACIÓN DE OBJETOS
        coche lexus = new coche("324234", "lexus", "nuevo", 12, false);
        coche mercedes = new coche("234242", "mercedes", "viejo", 78, false);
        moto gp = new moto("4545", "gp", "nuevo", 78, false);
        moto gp2 = new moto("4234324", "gp2", "viejo", 72, false);
        // ADICIÓN DE OBJETOS A LA LISTA
        vehiculos.add(lexus);
        vehiculos.add(mercedes);
        vehiculos.add(gp);
        vehiculos.add(gp2);
        // ESPECIFICACIONES DE CADA CLASE.
        lexus.set_puertas(4);
        mercedes.set_puertas(2);
        gp.set_cilindrada(450);
        gp2.set_cilindrada(550);
        // ALQUILAMOS DOS (obligatorio)
        mercedes.alquilar();
        gp.alquilar();
        //------------------------------------------------------------------------------------------

        // el iterado debe ser del mismo tipo que los elementos de la lista.

        for (Vehiculo elemento: vehiculos){
            System.out.println("-----------------------");
            System.out.print("Matricula:  ");
            System.out.println(elemento.get_matricula());
            System.out.print("Modelo:  ");
            System.out.println(elemento.get_modelo());
            System.out.print("marca:  ");
            System.out.println(elemento.get_marca());
            System.out.print("precio diario:  ");
            System.out.println(elemento.get_precioDiario());
            System.out.print("precio a los 5 días:  ");
            System.out.println(elemento.calcularPrecio(5));
        }

    }
}
