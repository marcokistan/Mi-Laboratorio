class Cancion {
    String titulo;
    String artista;
    Cancion siguiente;


    public Cancion(String titulo_rec){
        this.titulo = titulo_rec;
        this.artista = "Desconocido";
        this.siguiente = null;
    }

    public Cancion(String titulo_rec, String artista_rec){
        this.titulo = titulo_rec;
        this.artista = artista_rec;
        this.siguiente = null;
    }

    public Cancion(String titulo_rec, String artista_rec, Cancion siguiente_rec){
        this.titulo = titulo_rec;
        this.artista = artista_rec;
        this.siguiente = siguiente_rec;
    }

    
}