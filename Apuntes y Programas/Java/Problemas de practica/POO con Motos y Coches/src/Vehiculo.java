public abstract class Vehiculo {

    private String matricula = "";
    private String marca = "";
    private String modelo = "";
    private double precioDiario = 0.0;
    private boolean disponible = false;

    // Constructor

    public Vehiculo(String matricula,String marca,String modelo, double precioDiario, boolean disponible){

        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.precioDiario = precioDiario;
        this.disponible = disponible;

        this.disponible = true;

    }

    // Metodos getter

    public String get_matricula(){
        return this.matricula;
    }
    public String get_modelo(){
        return this.modelo;
    }
    public String get_marca(){
        return this.marca;
    }
    public double get_precioDiario(){
        return this.precioDiario;
    }
    public Boolean get_dispobible(){
        return this.disponible;
    }

    // Metodos Setter
    // No hay metodo setter de disponibilidad por que el problema nos dice que se hace de otra manera.

    public void set_matricula(String nuevo){
        this.matricula = nuevo;
    }
    public void set_modelo(String nuevo){
        this.modelo = nuevo;
    }
    public void set_marca(String nuevo){
        this.marca = nuevo;
    }
    public void set_precioDiario(double nuevo){
        this.precioDiario = nuevo;
    }
    
    // Metodos especificos

    public void alquilar(){
        if (this.disponible == false){
            System.out.println("El vehiculo ya está alquilado...");
        }
        else{
            this.disponible = false;
        }
        
    }

    public void devolver(){
        this.disponible = true;
    }

    public abstract double calcularPrecio(int dias);

    
}
