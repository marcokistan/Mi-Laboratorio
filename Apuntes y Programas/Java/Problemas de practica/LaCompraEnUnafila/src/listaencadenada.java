public class listaencadenada {

    private elemento primerelemento = null;
    private elemento ultimoelemento = null;
    private elemento objeto_actual = null;

    public listaencadenada(){

        this.primerelemento = primerelemento;
        this.ultimoelemento = ultimoelemento;

    }

    public void setter_primerelemento(elemento elemento){
        this.primerelemento = elemento;
    }
    public void setter_ultimoelemento(elemento elemento){
        this.ultimoelemento = elemento;
    }
    public elemento getter_primerelemento(){
        return this.primerelemento;
    }
    public elemento getter_ultimoelemento(){
        return this.ultimoelemento;
    }

    // metodo de instancia

    public void cambiar_orden(elemento elemento, int casilla){
        Boolean accion_completada = false;
        this.objeto_actual = this.primerelemento;
        int contador = 1;
        // primero hay que eliminarlo
        if (elemento.getter_previous() == null){
            this.setter_primerelemento(elemento.getter_next());
            elemento.getter_next().setter_previous(null);
            elemento.setter_next(null);
            accion_completada = true;
        }
        if (elemento.getter_next() == null && accion_completada == false){
            this.setter_ultimoelemento(elemento.getter_previous());
            elemento.getter_previous().setter_next(null);
            elemento.setter_previous(null);
            accion_completada = true;
        }
        if (accion_completada == false){
            elemento.getter_previous().setter_next(elemento.getter_next());
            elemento.getter_next().setter_previous(elemento.getter_previous());
            elemento.setter_next(null);
            elemento.setter_previous(null);
            accion_completada = true;
        }
        // ahora hay que moverlo, requerimos de un contador.
        // hay que reiniciar, actual object y accion_completada.
        accion_completada = false;
        this.objeto_actual = this.primerelemento;
        if (contador == casilla){
            elemento.setter_next(getter_primerelemento());
            this.getter_primerelemento().setter_previous(elemento);
            this.setter_primerelemento(elemento);
            accion_completada = true;
            }
        else{
            while (contador != casilla){
                contador = contador + 1;
                this.objeto_actual = this.objeto_actual.getter_next();
                if (contador == casilla){
                    if (contador == 10){
                        this.getter_ultimoelemento().setter_next(elemento);
                        this.setter_ultimoelemento(elemento);
                        elemento.setter_next(null);
                        accion_completada = true;
                    }
                    else{
                        elemento.setter_next(this.objeto_actual.getter_previous().getter_next());
                        this.objeto_actual.getter_previous().setter_next(elemento);
                        this.objeto_actual.setter_previous(elemento);
                        accion_completada = true;
                        

                    }
                }
            
            }
            
        }
        if (accion_completada == true){
            System.out.println("Se ha movido el objeto a la posición: " + casilla + ".");
        }

    }
    
}
