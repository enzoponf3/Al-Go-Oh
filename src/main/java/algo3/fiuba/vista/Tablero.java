package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorCementerio;
import algo3.fiuba.controladores.ControladorMazo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Tablero extends GridPane {

    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    Jugador jugador;

    public void setMano(Integer colIndex, Integer rowIndex) {

        VistaMano mano = new VistaMano();
        this.add(mano, colIndex, rowIndex);
    }

    public void setMazo(Integer colIndex, Integer rowIndex) {

        ImageView fondoMazo = new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        VistaMazo mazo = new VistaMazo(fondoMazo);
        this.add(mazo, colIndex, colIndex);
    }

    public void setCampo(Integer colIndex, Integer rowIndex, Integer colIndex2, Integer rowIndex2) {

        VistaZonaCartas zonaNoMonstruos = new VistaZonaCartas();
        VistaZonaCartas zonaMonstruo = new VistaZonaCartas();

        for (int i = 0; i < 5; i++) {

            ImageView imagen =new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            zonaNoMonstruos.agregarCarta(imagen);

            ImageView imagen2 =new ImageView(new Image("algo3/fiuba/resources/img/cartavacia.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            zonaMonstruo.agregarCarta(imagen2);
        }

        this.add(zonaNoMonstruos, colIndex, rowIndex);
        this.add(zonaMonstruo, colIndex2, rowIndex2);
    }

    public void setCementerio(Integer colIndex, Integer rowIndex) {

        ImageView cementerio = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        cementerio.setOnMouseClicked(new ControladorCementerio());
        this.add(cementerio, colIndex, rowIndex);
    }

    public void setCartaCampo(Integer colIndex, Integer rowIndex) {

        ImageView cartaCampoFondo = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        VistaCartaCampo cartaCampo = new VistaCartaCampo(cartaCampoFondo);
        this.add(cartaCampo, colIndex, rowIndex);
    }

}
