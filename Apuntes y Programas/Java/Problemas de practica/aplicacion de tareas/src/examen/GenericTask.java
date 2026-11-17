package examen;

abstract class GenericTask {


    // atributos
    private String nombre_tarea;
    public boolean completada_tarea;
    private int id_tarea;
    
    public GenericTask(String nombre_tarea){

        // pillamos el identificador
        this.id_tarea = TaskUtils.getUniqueId();
        this.nombre_tarea = nombre_tarea;
        this.completada_tarea = false;

    }

    public int getId(){

        return this.id_tarea;

    }

    public String getName(){

        return this.nombre_tarea;
    }

    public void setCompleted(boolean valor_nuevo){
        this.completada_tarea = valor_nuevo;
    }

    abstract void printStatus();

}
