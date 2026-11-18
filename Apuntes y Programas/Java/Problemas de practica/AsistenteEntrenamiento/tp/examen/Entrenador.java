package tp.examen;

import java.util.ArrayList;
import java.util.List;

public class Entrenador extends Empleado {

    private Empleado[] lista_jugadores = new Empleado[1];

    public Entrenador(String nombre_pasado, int id_pasado){
        super(nombre_pasado, id_pasado);
    }

    public boolean isMember(Empleado objeto_pasado){
        // caso null
        if (objeto_pasado == null){
            return false;
        }
        // caso no esta en el grupo
        for (int i = 0; i < lista_jugadores.length - 1; i++){
            if (lista_jugadores[i] == objeto_pasado){
                return true;
            }
        }
        return false;

    }

    public boolean add(Empleado objeto_pasado){
        // caso que sea el mismo empleado
        if (objeto_pasado == this){
            return false;
        }
        // caso jugador ya esta en su grupo
        for (int i = 0; i < lista_jugadores.length - 1; i++){
            if (lista_jugadores[i] == objeto_pasado){
                return false;
            }
        }
        // caso jugador ya este con un entrenador
        if (!(objeto_pasado.entrenador_asignado == null)){
            return false;
        }
        // caso normal
        extensor_lista_jugadores(lista_jugadores);
        lista_jugadores[lista_jugadores.length - 1] = objeto_pasado;
        return true;

    }

    public boolean remove(int id_pasado){
        boolean encontrado = false;
        for (int i = 0; i < lista_jugadores.length - 1; i++){
            if (lista_jugadores[i].get_Id() == id_pasado){
                encontrado = true;
            }
        }
        if (encontrado == false){
            return false;
        }
        else{
            Empleado[] copia_lista = new Empleado[lista_jugadores.length - 1];
            int contador_lista_nueva = 0;
            for(int i = 0; i < lista_jugadores.length - 1; i++){
                if (lista_jugadores[i].get_Id() == id_pasado){

                }
                else{
                    copia_lista[contador_lista_nueva] = lista_jugadores[i];
                    contador_lista_nueva++;
                }
            }
            return true;
        }
    }

    // metodo extensor de lista jugadores

    public void extensor_lista_jugadores(Empleado[] lista_pasada){
        Empleado[] copia_lista = new Empleado[lista_pasada.length + 1];
        for (int i = 0; i < lista_pasada.length - 1; i++){
            copia_lista[i] = lista_pasada[i];
        }
        lista_jugadores = copia_lista;

    }

    
}