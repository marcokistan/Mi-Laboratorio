package examen;

public class TaskGroup extends GenericTask {

    private GenericTask[] coleccion_tareas = new GenericTask[1];

    public TaskGroup(String nombre_tarea){
        super(nombre_tarea);
    }

    public boolean isMember(GenericTask objeto_pasado){

        // caso null (por si acaso)

        if (objeto_pasado == null){
            return false;
        }

        if (objeto_pasado instanceof GenericTask){
            // caso vacio
            if (coleccion_tareas.length == 0){
                return false;
            }
            else{
                for (int i = 0; i < coleccion_tareas.length; i++){
                    // comprobamos si son el mismo objeto en memoria.
                    if (coleccion_tareas[i] == objeto_pasado){
                        return true;
                    }
                }
                // busqueda fallida
                return false;
            }
        }
        else{
            return false;
        }

    }

    public boolean addMember(GenericTask objeto_pasado){
        // caso null
        if (objeto_pasado == null){
            return false;
        }
        // si no es SimpleTask o UrgentTask
        if (!(objeto_pasado instanceof SimpleTask) && !(objeto_pasado instanceof UrgentTask)){
            return false;
        }
        // si ya esta la tarea en el grupo 
        for (int i = 0; i < coleccion_tareas.length; i++){
            // comprobamos si son el mismo objeto en memoria.
            if (coleccion_tareas[i] == objeto_pasado){
                return false;
            }
        }
        // ahora si añadimos
        int valor_para_add = expandArray(coleccion_tareas);
        coleccion_tareas[valor_para_add] = objeto_pasado;
        return true;

    }

    public boolean remove(int identificador_pasado){
        // id negativo
        if (identificador_pasado < 0){
            return false;
        }
        boolean proceed = false;
        boolean deleted = false;
        for (int i = 0; i < coleccion_tareas.length; i++){
            if (coleccion_tareas[i].getId() == identificador_pasado){
                proceed = true;
            }
        }
        if (proceed == false){
            return false;
        }
        else{
            int contador_copy = 0;
            // esto solo funciona por que es una variable local, no se puede declarar dos veces
            // un array de esta manera...
            GenericTask[] copy_coleccion_tareas = new GenericTask[coleccion_tareas.length - 1];
            // buscar identificador
            for (int i = 0; i <= coleccion_tareas.length; i++){
                // comprobamos si son el mismo objeto en memoria.
                if (coleccion_tareas[i].getId() == identificador_pasado){
                    deleted = true;
                }
                else{
                    copy_coleccion_tareas[contador_copy] = coleccion_tareas[i];
                    contador_copy++;
                }

            }

            coleccion_tareas = copy_coleccion_tareas;
            if (deleted == true){
                return true;
            }
            else{
                return false;
            }

        }


    }


    public GenericTask[] getTasks(){
        // podemos comparar cadenas de texto usando CompareTo.
        // la sintaxis es "esta cadena va despues de esta?"
        // devuelve un numero negativo si no, numero positivo si si, 0 si es igual.
        
        // caso vacio
        if (coleccion_tareas.length == 0){
            GenericTask[] devolucion = new GenericTask[1];
            devolucion[0] = this;
            return devolucion;
        }

        // caso normal
        GenericTask[] devolucion = new GenericTask[coleccion_tareas.length + 1];
        devolucion[0] = this;
        for (int i = 1; i < coleccion_tareas.length; i++){
            devolucion[i] = coleccion_tareas[i];
        }
        // ordenar
        for (int i = 1; i < devolucion.length - 1; i++) {
            for (int j = i + 1; j < devolucion.length; j++) {
                if (devolucion[i].getName().compareTo(devolucion[j].getName()) > 0) {
                    GenericTask aux = devolucion[i];
                    devolucion[i] = devolucion[j];
                    devolucion[j] = aux;
                    }
                else{
                    if (devolucion[i].getName().compareTo(devolucion[j].getName()) == 0){
                        if(devolucion[i].getId() > devolucion[j].getId()){
                            GenericTask aux = devolucion[i];
                            devolucion[i] = devolucion[j];
                            devolucion[j] = aux;
                        }
                    }
                }
                }
            }

        

        return devolucion;

    }

    public void printStatus(){
        System.out.println("TAREAS DEL GRUPO" + "[" + getName() + "]: ");
        if (coleccion_tareas.length == 0){
            System.out.println("sin tareas");
        }
        else{
            GenericTask[] array_devolucion = sorting_identifier();
            for (int i = 0; i < array_devolucion.length; i++){
                array_devolucion[i].printStatus();
            }
        }
    }
        

    public GenericTask[] sorting_identifier(){

        GenericTask[] devolucion = new GenericTask[coleccion_tareas.length + 1];
        for (int i = 0; i < coleccion_tareas.length; i++){
            devolucion[i] = coleccion_tareas[i];
        }
        // ordenar
        for (int i = 0; i < devolucion.length - 1; i++) {
            for (int j = i + 1; j < devolucion.length; j++) {
                if (devolucion[i].getId() > devolucion[j].getId()) {
                    GenericTask aux = devolucion[i];
                    devolucion[i] = devolucion[j];
                    devolucion[j] = aux;
                    }
                
                }
            }

        return devolucion;

    }

    // metodo extra que expande el array, y devuelve la posicion a llenar
    private int expandArray(GenericTask[] arraypasado){

        int ultima_posicion = 0;
        // esto solo funciona por que es una variable local, no se puede declarar dos veces
        // un array de esta manera...
        GenericTask[] copy_coleccion_tareas = new GenericTask[arraypasado.length + 1];
        for (int i = 0; i < arraypasado.length; i++){
            copy_coleccion_tareas[i] = arraypasado[i];
            ultima_posicion = i;
        }
        coleccion_tareas = copy_coleccion_tareas;
        return ultima_posicion;

    }



    
}
