class Playlist {
    Cancion cabeza = null;

    public void agregarAlInicio(String titulo){

        Cancion nueva = new Cancion(titulo);
        nueva.siguiente = this.cabeza;
        this.cabeza = nueva;

    }

    public void agregarAlInicio(String titulo, String artista){

        Cancion nueva = new Cancion(titulo, artista);
        nueva.siguiente = this.cabeza;
        this.cabeza = nueva;

    }

    public void reproducir(){
        Cancion inicio; // al inicializar esta variable, lo estamos haciendo de forma local
        inicio = this.cabeza; // las variables locales, no pueden tener el .this, ya que .this busca a nivel de clase
        while (inicio != null){
            System.out.println(inicio.titulo);
            inicio = inicio.siguiente;
        }

    }


}