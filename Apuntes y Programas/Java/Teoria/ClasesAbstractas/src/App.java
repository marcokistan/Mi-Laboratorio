public class App {
    public static void main(String[] args) throws Exception {
        avion_clase avion1 = new avion_clase("f18");
        avion1.comentar_cual_es_el_modelo();
        avion1.establecer_modelo("f16");
        avion1.comentar_cual_es_el_modelo();
        avion_clase avion2 = new avion_clase("f22");
        avion2.comentar_cual_es_el_modelo();
        avion2.establecer_modelo("f35");
        avion2.comentar_cual_es_el_modelo();
    }
}
