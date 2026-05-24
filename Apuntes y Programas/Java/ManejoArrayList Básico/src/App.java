// Vamos a aplicar flujos de control, y a aprender a usar arrays.
// La idea va a ser, el programa te va a pedir nombres hasta que llegues a
// 10, y si repites un nombre, el programa se para y te dice que has hecho
// trampa. 

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<String> nombres = new ArrayList<>();
        String añadida = "";
        Boolean trampa = false;
        Scanner lector = new Scanner(System.in);
        while (nombres.size() < 11 && trampa == false){
            System.out.print("Añade un nombre a la lista: ");
            añadida = lector.nextLine();
            for (String iterado : nombres){
                if (iterado.equals(añadida)){
                    trampa = true;
                    tramposo();
                    break;
                }
            }
            if (trampa == false){
                nombres.add(añadida);
            }
        }
        System.out.println("Estos son los 10 nombres que has añadido:");
        for (String iterado : nombres){
            System.out.print(iterado + ",");
        }
        lector.close();
        
    }

    public static void tramposo(){
        System.out.println("Has hecho trampas, ya no puedes seguir añadiendo.");
    }
}
