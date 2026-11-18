public class App {
    public static void main(String[] args) throws Exception {
        // compareto es capaz de comparar dos valores y devolver un int
        // en base de la siguiente sintaxis:
        //la sintaxis es "esta cadena va despues de esta?"
        // devuelve un numero negativo si no, numero positivo si si, 0 si es igual.

        String alfabeticamente_menor = "a";
        String alfabeticamente_mayor = "b";

        System.out.println(alfabeticamente_menor.compareTo(alfabeticamente_mayor)); // -1
        System.out.println(alfabeticamente_mayor.compareTo(alfabeticamente_menor)); // 1
        System.out.println(alfabeticamente_mayor.compareTo(alfabeticamente_mayor)); // 0

    }
}
