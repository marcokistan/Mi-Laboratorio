public class moto extends Vehiculo {

    private int cilindrada = 0;

    public moto(String matricula,String marca,String modelo, double precioDiario, boolean disponible){
        super(matricula, marca, modelo, precioDiario, disponible);
        this.cilindrada = cilindrada;
    }

    // metodo setter de cilindrada
    public void set_cilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }

    // NOTA, java requiere que siempre devuelvas algo, si dices que vas a devolver un tipo pero despues no lo haces
    // o solo lo devuelves en un condicional, añadiendo la posibilidad de NO devolver, te va a dar error.
    @Override
    public double calcularPrecio(int dias){
        double precioobtenido = super.get_precioDiario();
        int precioredondeado = (int) Math.round(precioobtenido);
        if (this.cilindrada > 500){
            int preciofinal = precioredondeado * dias;
            int diezporcientoextra = preciofinal * 110 / 100;
            double preciodoblado = (double) Math.round(diezporcientoextra);
            return preciodoblado;
        }
        else{
            int preciofinal = precioredondeado * dias;
            double preciodoblado = (double) Math.round(preciofinal);
            return preciodoblado;
        }
    }
    
    
}
