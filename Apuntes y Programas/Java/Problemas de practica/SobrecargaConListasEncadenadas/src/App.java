public class App {public static void main(String[] args) {
        Playlist miPlaylist = new Playlist();

        // Agregamos canciones usando los diferentes métodos (que llamarán a diferentes constructores)
        miPlaylist.agregarAlInicio("Bohemian Rhapsody", "Queen");
        miPlaylist.agregarAlInicio("Lamento Boliviano", "Enanitos Verdes");
        miPlaylist.agregarAlInicio("Canción Callejera"); // Artista desconocido

        // Mostrar el resultado en consola
        System.out.println("--- REPRODUCIENDO PLAYLIST ---");
        miPlaylist.reproducir();
    }
}
