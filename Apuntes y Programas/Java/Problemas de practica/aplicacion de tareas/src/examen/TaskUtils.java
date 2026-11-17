package examen;

public class TaskUtils {

    public static int id = 0;

    public TaskUtils(){

    }

    public static int getUniqueId(){
        id++;
        return id;
    }

    
}
