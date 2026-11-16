public class ListaRuta {

    private Node inicionode;
    private Node finalnode;
    

    public ListaRuta(){

        this.inicionode = null;
        this.finalnode = null;

    }

    public ListaRuta(Node inicionode_param){

        this.inicionode = inicionode_param;
        this.finalnode = null;

    }

    // metodos

    public void crear_al_inicio_de_la_lista(int dato){
        if (this.inicionode == null){
            Node new_node = new Node(dato);
            this.inicionode = new_node;
            this.finalnode = new_node;
        }
        else{
            Node new_node = new Node(dato);
            this.inicionode.set_previous(new_node);
            new_node.set_next(this.inicionode);
            this.inicionode = new_node;
        }
    }

    // no tiene mucho sentido ya que la lista seguirá empezando por este nodo...
    // pero hay que permitirlo de todos modos, para mantener consistencia con final
    // de lista

    public void crear_al_inicio_de_la_lista(int dato, Node param_previous){
        if (this.inicionode == null){
            Node new_node = new Node(dato, param_previous);
            this.inicionode = new_node;
            this.finalnode = new_node;
        }
        else{
            Node new_node = new Node(dato, param_previous);
            this.inicionode.set_previous(new_node);
            this.inicionode = new_node;
        }
    }

    public void crear_al_final_de_la_lista(int dato){
        if (this.finalnode == null){
            Node new_node = new Node(dato);
            this.finalnode = new_node;
            this.inicionode = new_node;
        }
        else{
            
            Node new_node = new Node(dato);
            this.finalnode.set_next(new_node);
            new_node.set_previous(this.finalnode);
            this.finalnode = new_node;
            
        }
    }

    // esto efectivamente va a cortar la lista

    public void crear_al_final_de_la_lista(int dato, Node param_previous){
        if (param_previous == null){
            Node new_node = new Node(dato, param_previous);
            this.inicionode = new_node;
            this.finalnode = new_node;
        }
        Node new_node = new Node(dato, param_previous);
        if (param_previous.get_next() == null){

        }
        else{
            param_previous.get_next().set_previous(null);

        }
        param_previous.set_next(new_node);
        this.finalnode = new_node;
    }

    // recorrer la lista

    public void recorrer_lista(){
        Node nodo_actual = this.inicionode;
        while (nodo_actual != null){
            System.out.println(nodo_actual.get_valor());
            nodo_actual = nodo_actual.get_next();
        }
    }

}
