package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorCartaCampo;
import algo3.fiuba.controladores.ControladorCementerio;
import algo3.fiuba.controladores.ControladorMazo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class Tablero extends GridPane {

    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    protected Jugador jugador;
    protected VistaMazo zonaMazo;
    protected VistaMano zonaMano;
    protected VistaZonaCartas zonaNoMonstruos;
    protected VistaZonaCartas zonaMonstruos;
    protected VistaCartaCampo zonaCartaDeCampo;

    public void setMano(Integer colIndex, Integer rowIndex) {
        VistaZonaCartas vistaZonaMonstruos = new VistaZonaMonstruos(jugador);
        VistaZonaCartas vistaZonaNoMonstruos = new VistaZonaNoMonstruos(jugador);
        this.zonaMano = new VistaMano(jugador, vistaZonaMonstruos, vistaZonaNoMonstruos);
        this.zonaMano.dibujar();
        this.add(zonaMano, colIndex, rowIndex);
    }

    public void setMazo(Integer colIndex, Integer rowIndex, VistaMano zonaMano) {

        ImageView fondoMazo = new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.zonaMazo = new VistaMazo(fondoMazo);
        this.zonaMazo.setOnMouseClicked(new ControladorMazo(zonaMazo, jugador, zonaMano));
        this.add(zonaMazo, colIndex, colIndex);
    }

    public void setCampo(Integer colIndex, Integer rowIndex, Integer colIndex2, Integer rowIndex2) {

        this.zonaNoMonstruos = new VistaZonaNoMonstruos(jugador);
        this.zonaMonstruos = new VistaZonaMonstruos(jugador);

        for (int i = 0; i < 5; i++) {

            ImageView imagen =new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            zonaNoMonstruos.agregarCarta(imagen);

            ImageView imagen2 =new ImageView(new Image("algo3/fiuba/resources/img/cartavacia.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            zonaMonstruos.agregarCarta(imagen2);
        }
        //this.zonaMonstruos.dibujar();
        //this.zonaNoMonstruos.dibujar();

        this.add(zonaNoMonstruos, colIndex, rowIndex);
        this.add(zonaMonstruos, colIndex2, rowIndex2);
    }

    public void setCementerio(Integer colIndex, Integer rowIndex) {

        ImageView fondoCementerio = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        Label cementerio = new Label("CEMENTERIO", fondoCementerio);
        cementerio.setTextFill(Color.WHITE);
        cementerio.setContentDisplay(ContentDisplay.CENTER);
        cementerio.setOnMouseClicked(new ControladorCementerio());
        this.add(cementerio, colIndex, rowIndex);
    }

    public void setCartaCampo(Integer colIndex, Integer rowIndex) {
        ImageView cartaCampoFondo = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.zonaCartaDeCampo = new VistaCartaCampo(jugador, zonaMano, zonaMonstruos, zonaNoMonstruos);
        this.zonaCartaDeCampo.setOnMouseClicked(new ControladorCartaCampo(zonaCartaDeCampo, jugador, zonaMano));
        this.add(zonaCartaDeCampo, colIndex, rowIndex);
    }

}
