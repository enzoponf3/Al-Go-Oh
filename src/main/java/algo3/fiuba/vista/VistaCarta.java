package algo3.fiuba.vista;


import algo3.fiuba.controladores.ControladorCarta;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;


public class VistaCarta extends Label {

    private double ANCHO_MAXIMO_CARTA = 50.0;
    private double ALTURA_MAXIMA_CARTA = 50.0;

    public VistaCarta() {

        ImageView imagenCarta = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.setGraphic(imagenCarta);
        this.setContentDisplay(ContentDisplay.CENTER);
        this.setOnMouseClicked(new ControladorCarta());
    }

    public void deshabilitarCarta() {

        this.setDisable(true);
    }

}
