public class character {
    private String nombre;

    public character(String nombre) {
        this.nombre = nombre;
    }

    public void decirNombre(){
        System.out.println("Me llamo "+ this.nombre);
    }
    
}
