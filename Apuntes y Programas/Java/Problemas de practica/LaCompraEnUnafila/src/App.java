// La idea es, vamos a tener al usuario escribiendo su lista de la compra
// hasta 10 elementos. 

// cada elemento se unirá uno detras de otro en orden, sin embargo el usuario
// tendrá la oportunidad de eliminar o editar el orden de los elementos.

import java.util.Scanner;

public class App {

    // Si creamos variables fuera de un void static, y se usaran en un metodo static, debemos especificar
    // que son static.

    // Public, private y protected son cosas que solo se pueden escribir FUERA de un metodo.

    public static Boolean editing_mode = true;
    public static int elements_gotten = 0;
    public static listaencadenada lista_compra;

    public static void editing_loop(){
        elemento objeto_actual = lista_compra.getter_primerelemento();
        elemento objeto_seleccionado = lista_compra.getter_primerelemento();
        String solicitud = "";
        Boolean accion_conseguida = false;
        int parsed_solicitud = 0;
        // creamos el scanner
        Scanner scanner2 = new Scanner(System.in);
        while (solicitud.equals("")){
            solicitud = scanner2.nextLine();
        }
        // llamamos al metodo al final para repetir bucle
        if (solicitud.equals("/borrar")){
            System.out.print("Di el nombre del objeto que quieras quitar de la caja: ");
            solicitud = scanner2.nextLine();
            // para extremos
            if (lista_compra.getter_primerelemento().getter_nombre().equals(solicitud)){
                objeto_actual.getter_next().setter_previous(null);
                // actualizamos atributos de lista encadenada
                lista_compra.setter_primerelemento(objeto_actual.getter_next());
                // finalizamos condición
                accion_conseguida = true;
            }
            if (lista_compra.getter_ultimoelemento().getter_nombre().equals(solicitud)){
                lista_compra.getter_ultimoelemento().getter_previous().setter_next(null);
                // actualizamos atributos de lista encadenada
                lista_compra.setter_ultimoelemento(objeto_actual.getter_previous());
                accion_conseguida = true;
            }
            // para mitades.
            while (objeto_actual.getter_next() != null && accion_conseguida == false){
                if(objeto_actual.getter_nombre().equals(solicitud)){
                    
                    objeto_actual.getter_previous().setter_next(objeto_actual.getter_next());
                    objeto_actual.getter_next().setter_previous(objeto_actual.getter_previous());
                    accion_conseguida = true;
                }
                objeto_actual = objeto_actual.getter_next();
            }
            if (accion_conseguida == false){
                System.out.println("El nombre de ese objeto no existe...");
            }
        }

        if (solicitud.equals("/list")){
            while (objeto_actual.getter_next() != null){
                System.out.println(objeto_actual.getter_nombre());
                objeto_actual = objeto_actual.getter_next();
            }
            System.out.println(objeto_actual.getter_nombre());
        }

        if (solicitud.equals("/mover")){
            System.out.print("Que elemento quieres mover de posición: ");
            solicitud = scanner2.nextLine();
            if (objeto_actual.getter_nombre().equals(solicitud)){
                accion_conseguida = true;
                objeto_seleccionado = objeto_actual;
            }
            if (lista_compra.getter_ultimoelemento().getter_nombre().equals(solicitud)){
                objeto_seleccionado = lista_compra.getter_ultimoelemento();
                accion_conseguida = true;
            }
            while (objeto_actual.getter_next() != null && accion_conseguida == false){
                if (objeto_actual.getter_nombre().equals(solicitud)){
                    accion_conseguida = true;
                    objeto_seleccionado = objeto_actual;
                }
                objeto_actual = objeto_actual.getter_next();
            }

            if (accion_conseguida == false){
                System.out.println("El nombre de ese objeto no existe...");
            }
            else{
                accion_conseguida = false;
            while (accion_conseguida == false){
                System.out.print("A que posición quieres mover el objeto (1/10): ");
                solicitud = scanner2.nextLine();
                try{
                    parsed_solicitud = Integer.parseInt(solicitud);
                    if (parsed_solicitud < 1 || parsed_solicitud > 10){
                        System.out.println("Por favor introduce un número valido ");
                    }
                    else{
                        accion_conseguida = true;
                    }
                }
                catch(Exception e){
                    System.out.println("Por favor introduce un número valido ");
                }
                finally{

                }
                
            }
            
            // finalmente enviamos los datos al metodo.

            lista_compra.cambiar_orden(objeto_seleccionado, parsed_solicitud);

            }

           
        }

        editing_loop();
        
    }

    public static void main(String[] args) throws Exception {
        // creamos la lista encadenada
        lista_compra = new listaencadenada();
        // creamos el scanner
        Scanner scanner = new Scanner(System.in);
        while (elements_gotten < 10){
            elements_gotten = elements_gotten + 1;
            System.out.print("Introduzca el objeto " + elements_gotten +  " en la caja: ");
            String objeto_encaja = scanner.nextLine();
            // el parametro anterior es tipo objeto ELEMENTO, pero java acepta NULL como todo tipo de parametro
            // incluso si no es un objeto de ese tipo especifico, es una excepción...
            elemento objeto_para_lista = new elemento(objeto_encaja, null);
            if (lista_compra.getter_ultimoelemento() == null){
            }
            else{
                objeto_para_lista.setter_previous(lista_compra.getter_ultimoelemento());
                lista_compra.getter_ultimoelemento().setter_next(objeto_para_lista);
            }
            lista_compra.setter_ultimoelemento(objeto_para_lista);
            if (lista_compra.getter_primerelemento() == null){
                lista_compra.setter_primerelemento(objeto_para_lista);
            }

        }
        System.out.println("---------------------------------\nAhora podrás modificar la compra...\nPuedes quitar objetos escribiendo /borrar y seleccionar un objeto\npara moverlo de posición escribiendo /mover, se moverá el primer objeto con\nel nombre definido, en el caso de que hubiesen varios objetos con el mismo nombre.\nEscribir /list muestra los nombres de los objetos");
        editing_loop();
    }
}
