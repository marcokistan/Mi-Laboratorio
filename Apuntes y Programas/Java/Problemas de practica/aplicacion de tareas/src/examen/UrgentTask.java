package examen;

public class UrgentTask extends GenericTask {

    public int frecuencia;

    public UrgentTask(String nombre_tarea, int numero_frecuencia){
        super(nombre_tarea);
        this.frecuencia = numero_frecuencia;
    }

    public int getFrecuency(){
        return frecuencia;
    }

    public void printStatus(){
        String estado_completado;
        if (this.completada_tarea == true){
            estado_completado = "COMPLETADA";
        }
        else{
            estado_completado = "INCOMPLETA";
        }
        System.out.println("[" + getId() + "], " + "[" + getName() + "], " + "[" + estado_completado + "], " + "Urgente, " + "[" + frecuencia + "]");
    }       
    
}
