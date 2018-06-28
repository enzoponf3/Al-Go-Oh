package algo3.fiuba.vista;


import algo3.fiuba.controladores.ControladorCarta;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCarta extends Label {

    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;

    public VistaCarta(String imageUrl, Jugador jugador) {

        ImageView imagenCarta = new ImageView(new Image(imageUrl, ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA,
                false, false));
        this.setGraphic(imagenCarta);
        this.setContentDisplay(ContentDisplay.CENTER);
        this.setOnMouseClicked(new ControladorCarta(jugador, this));
    }

    public void deshabilitarCarta() {

        this.setDisable(true);
    }

}
