public class Node {

    private Node next;
    private Node previous;
    private int valor;
    

    public Node(int dato){
        this.valor = dato;
        this.next = null;
    }
    public Node(int dato, Node previous_param){
        this.valor = dato;
        this.next = null;
        this.previous = previous_param;
    }
    // metodos
    public void set_next(Node next_param){
        this.next = next_param;
    }
    public void set_previous(Node previous_param){
        this.previous = previous_param;
    }
    public Node get_next(){
        return this.next;
    }
    public Node get_previous(){
        return this.previous;
    }
    public int get_valor(){
        return this.valor;
    }
    

}
