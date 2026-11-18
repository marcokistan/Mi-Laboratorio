package tp.examen;

public class Jugador extends Empleado {
    
    private String posicion_campo;
    
    public Jugador(String nombre_pasado, int id_pasado, String posicion_pasada){
        super(nombre_pasado, id_pasado);
        this.posicion_campo = posicion_pasada;
        this.entrenador_asignado = null;

    }

    public String toString(){
        return getName() + ": " + this.posicion_campo;
    }

    public void EstadoActual(){
        if (entrenador_asignado == null){
            System.out.println("No tiene un entrenador asignado");
        }
        else{
            System.out.println("El jugador esta entrenando con: " + entrenador_asignado.getName());
        }
    }
   


}
