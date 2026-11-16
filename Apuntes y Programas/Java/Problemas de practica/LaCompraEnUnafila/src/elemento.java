public class elemento{

    private String Nombre;
    private elemento Next = null;
    private elemento previous = null;

    public elemento(String Nombre, elemento anterior){

        this.Nombre = Nombre;
        this.Next = null;
        this.previous = anterior;


    }

    public String getter_nombre(){
        return this.Nombre;
    }

    public void setter_next(elemento elemento){
        this.Next = elemento;
        
    }

    public void setter_previous(elemento elemento){
        this.previous = elemento;
    }

    public elemento getter_next(){
        return this.Next;
    }

    public elemento getter_previous(){
        return this.previous;
    }
    
}
