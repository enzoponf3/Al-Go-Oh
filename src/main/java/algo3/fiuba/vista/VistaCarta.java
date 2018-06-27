package algo3.fiuba.vista;


import algo3.fiuba.controladores.ControladorCarta;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;


public class VistaCarta extends VBox {

    private double ANCHO_MAXIMO_CARTA = 50.0;
    private double ALTURA_MAXIMA_CARTA = 50.0;

    ImageView imagenCarta;
    ControladorCarta controladorCarta;

    public VistaCarta() {

        imagenCarta = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));

        Boton ataque = new Boton("1200", null);
        Boton defensa = new Boton("1000", null);
        HBox puntos = new HBox(ataque, defensa);
        puntos.setSpacing(2);
        VBox carta = new VBox(imagenCarta, puntos);

        controladorCarta = new ControladorCarta();
        //setOnAction(controladorCarta);
    }

}
