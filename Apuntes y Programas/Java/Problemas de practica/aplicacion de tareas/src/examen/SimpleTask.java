package examen;

public class SimpleTask extends GenericTask {

    public SimpleTask(String nombre_tarea){
        super(nombre_tarea);
    }

    public void printStatus(){
        String estado_completado;
        if (this.completada_tarea == true){
            estado_completado = "COMPLETADA";
        }
        else{
            estado_completado = "INCOMPLETA";
        }
        System.out.println("[" + getId() + "], " + "[" + getName() + "], " + "[" + estado_completado + "], " + "Simple");
    }
    
}
