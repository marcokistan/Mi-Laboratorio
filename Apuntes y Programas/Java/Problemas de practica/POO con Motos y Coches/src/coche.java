public class coche extends Vehiculo {

    private int numero_puertas = 0;


    
    public coche(String matricula,String marca,String modelo, double precioDiario, boolean disponible){
        super(matricula, marca, modelo, precioDiario, disponible);
        this.numero_puertas = numero_puertas;
    }


    // metodo setter de puertas
    public void set_puertas(int puertas){
        this.numero_puertas = puertas;
    }

    // NOTA, java requiere que siempre devuelvas algo, si dices que vas a devolver un tipo pero despues no lo haces
    // o solo lo devuelves en un condicional, añadiendo la posibilidad de NO devolver, te va a dar error.
    @Override
    public double calcularPrecio(int dias){
        double precioobtenido = super.get_precioDiario();
        int precioredondeado = (int) Math.round(precioobtenido);
        if (this.numero_puertas > 4){
            int preciofinal = precioredondeado * dias;
            preciofinal = preciofinal + 10;
            double preciodoblado = (double) Math.round(preciofinal);
            return preciodoblado;
        }
        else{
            int preciofinal = precioredondeado * dias;
            double preciodoblado = (double) Math.round(preciofinal);
            return preciodoblado;
        }
    }
    
    
}
