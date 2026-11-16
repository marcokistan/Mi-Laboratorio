

public class avion_clase extends avion_plano{

    private String modelo_avion;

    public avion_clase(String modelo){
        modelo_avion = modelo;
    }

    @Override
    void establecer_modelo(String modelo){
        modelo_avion = modelo;
    }

    @Override
    void comentar_cual_es_el_modelo(){
        System.out.println(modelo_avion);
    }
    
}
