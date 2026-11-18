package tp.examen;
import java.util.Objects;

public abstract class Empleado {
    
    private String name;
    private int id;
    public Empleado entrenador_asignado;


    public Empleado(String nombre_pasado, int id_pasado){

        this.name = nombre_pasado;
        this.id = id_pasado;

    }

    public int get_Id(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    abstract void EstadoActual();
    
}