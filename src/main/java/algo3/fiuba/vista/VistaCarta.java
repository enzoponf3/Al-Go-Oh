package algo3.fiuba.vista;


import algo3.fiuba.controladores.ControladorCarta;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class VistaCarta extends Button {

    private double ANCHO_MAXIMO_CARTA = 100.0;
    private double ALTURA_MAXIMA_CARTA = 130.0;

    ImageView imagenCarta;
    ControladorCarta controladorCarta;

    public VistaCarta() {

        imagenCarta = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.setGraphic(imagenCarta);
        this.setBackground(null);

        controladorCarta = new ControladorCarta();
        setOnAction(controladorCarta);
    }

}
