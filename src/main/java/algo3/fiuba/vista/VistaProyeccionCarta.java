package algo3.fiuba.vista;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.concurrent.TimeUnit;

public class VistaProyeccionCarta extends StackPane {

    private ImageView imagenProyectada;
    private static VistaProyeccionCarta INSTANCIA;

    public static VistaProyeccionCarta getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new VistaProyeccionCarta();
        return INSTANCIA;
    }

    private VistaProyeccionCarta() {

        imagenProyectada = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg", 200, 300, false, false));
        super.getChildren().add(imagenProyectada);
    }

    public void zoomImg(String urlImg) {

        imagenProyectada = new ImageView(new Image(urlImg, 200, 300,
                false, false));
    }

    public void update() {
         super.getChildren().add(imagenProyectada);
    }

    public void zoomImgView(ImageView imagenProyectada) {
        this.imagenProyectada = imagenProyectada;
    }
}
