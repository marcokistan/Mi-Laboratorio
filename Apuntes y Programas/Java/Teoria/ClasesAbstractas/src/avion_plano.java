// Una clase abstracta es una clase que no se instancia. 
// Es una clase que sirve como molde para que otras clases hereden sus metodos.
// LAS OBLIGA A IMPLEMENTAR SUS METODOS ABSTRACTOS, si o si, deben tener una
// implementacion unica.

abstract class avion_plano {

    // las clases abstractas no necesitan constructor

    abstract void establecer_modelo(String modelo);

    abstract void comentar_cual_es_el_modelo();
    
}
