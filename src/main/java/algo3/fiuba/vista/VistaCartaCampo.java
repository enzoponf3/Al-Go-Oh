package algo3.fiuba.vista;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCartaCampo extends Label {

    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;


    public VistaCartaCampo(ImageView fondo) {

        this.setGraphic(fondo);
    }

    public void colocarImagenCartaCampo(/*RecibirImagen*/) {
        //campo = new ImageView(/*imagen*/);

    }
}
