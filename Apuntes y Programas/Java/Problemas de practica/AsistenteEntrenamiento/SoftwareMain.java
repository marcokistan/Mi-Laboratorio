import  tp.examen.*; 

/**
 * Clase SoftwareMain que representa la
 * aplicación principal del software.
 */
public class SoftwareMain {

    /**
     * Método main
     */
    public static void main(String[] args){
         Jugador nacho = new Jugador("Nacho",5555380, "defensa");
         Jugador alaba = new Jugador("Alaba",55541501, "defensa");
         Jugador valverde = new Jugador("Valverde",5556380, "mediocentro");
         Jugador joselu = new Jugador("Joselu",5557780, "delantero");
         Jugador vini = new Jugador("Vinicius",5557781, "delantero");

         Entrenador ancelotti = new Entrenador("Ancelotti",7557781);
         Entrenador pintus = new Entrenador("Pintus",7757781);
         Entrenador llopis = new Entrenador("Llopis",7759781);
         Entrenador parrales =  new Entrenador("Parrales",7757788);

         ancelotti.add(joselu);
         ancelotti.add(alaba);
         pintus.add(vini);
         pintus.add(vini);
         llopis.add(valverde);
         llopis.add(nacho);
        
        
         ancelotti.EstadoActual();
         vini.EstadoActual();
         ancelotti.remove(joselu.getId()); 
    }
}