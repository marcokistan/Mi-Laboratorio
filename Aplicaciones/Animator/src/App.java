import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import javax.imageio.ImageIO;
public class App extends Canvas implements Runnable {

    // AWT es la libreria de java que se encarga de dibujar ventanas (frame)
    // y el canvas (que es un lugar dedicado para pintar).

    // BufferedImage y io.File se encargan de cargar imagenes y rutas en el S.O

    // Usamos buffers para encargarnos de pintar las imagenes.

    // Usamos dos hilos.

    // App es objeto MAIN y despues creamos otro objeto app que sirve como nuestro
    // canvas.


    
    private BufferedImage imagen;
    private int indice = 0;
    ArrayList<BufferedImage> imagenes = new ArrayList<>();

    public App() {

        File carpeta = new File("images");

        // hacemos esto solo para obtener el tamaño de la carpeta
        File[] archivos = carpeta.listFiles();

        // necesitamos un contador
        int contador = 1;

        // string auxiliar

        String imagen_importada;

        if (archivos != null) {

            while (contador != archivos.length - 1){
                imagen_importada = String.valueOf(contador) + ".png";
                try {
                BufferedImage imagen = ImageIO.read(new File(carpeta, imagen_importada));
                imagenes.add(imagen);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                contador++;
                imagen_importada = "";
                


            }

        }

        imagen = imagenes.get(indice);
    }

    // run se ejecuta automaticamente tras crear el hilo

    @Override
    public void run() {

        // Esperamos a que el Canvas esté listo
         while (!isDisplayable()) {
            Thread.yield();
        }

        // Crea los 2 buffers
        createBufferStrategy(2);

        // Obtenemos la estrategia
        BufferStrategy buffer = getBufferStrategy();



        while (true){
            if (indice != imagenes.size() - 1){
            indice = indice + 1;
        }
        else{
            indice = 0;
        }
        
        imagen = imagenes.get(indice);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        // Obtenemos Graphics para dibujar
        Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

        // Dibujamos la imagen
        g.drawImage(imagen, 0, 0, 400, 300, null);

        // Liberamos Graphics
        g.dispose();

        // Mostramos el buffer que acabamos de preparar
        buffer.show();


        }

    }

    public static void main(String[] args) throws Exception {
        

        Frame ventana = new Frame("Animador");
        App canvas = new App();
        ventana.add(canvas);
        ventana.setSize(400, 300);
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        });

        // hay que pasarle un objeto que implemente el runnable (definido en la clase)
        // esta misma clase lo hace y encima usando el canvas, asi que usamos ese objeto.

        Thread hilo = new Thread(canvas);
        hilo.start();

    }
}
