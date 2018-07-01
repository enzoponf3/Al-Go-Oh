package algo3.fiuba.vista;

import algo3.fiuba.controladores.controladores_de_carta.ControladorCarta;
import algo3.fiuba.controladores.controladores_de_carta.ControladorZoomCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaCarta extends StackPane {

    private VistaCartaCampo vistaCartaCampo;
    private Label labelPuntosDeAtaque;
    private Label labelPuntosDeDefensa;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaMano vistaMano;
    private Carta carta;
    private Jugador jugador;
    private ImageView imagenCarta;
    private ImageView imagenCartaBocaAbajo;
    private String imageUrl;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;
    private boolean esVisible;
    private boolean estaEnModoAtaque;

    public VistaCarta(String imageUrl, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo) {
        this.imageUrl = imageUrl;
        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.imagenCartaBocaAbajo =  new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png", ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        esVisible = true;
        estaEnModoAtaque = true;
        this.dibujar();
    }

    public VistaCarta(String imageUrl, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo, boolean estadoVisibilidad, boolean estadoModo) {
        this.imageUrl = imageUrl;
        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.imagenCartaBocaAbajo =  new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png", ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        this.esVisible = estadoVisibilidad;
        this.estaEnModoAtaque = estadoModo;
        this.dibujar();
    }

    public void dibujar() {
        try{
            if (esVisible) {
                this.getChildren().add(imagenCarta);
                if (carta instanceof Monstruo) {
                    Rectangle rectanguloFondo = new Rectangle(73,21, Color.LIGHTGOLDENRODYELLOW);
                    StackPane.setMargin(rectanguloFondo, new Insets(71, 0, 0, 0));
                    this.getChildren().add(rectanguloFondo);

                    labelPuntosDeAtaque = new Label("" + ((Monstruo) carta).getAtaque());
                    labelPuntosDeAtaque.setStyle("-fx-border-color: brown" );
                    StackPane.setMargin(labelPuntosDeAtaque, new Insets(70, 30, 0, 0));
                    this.getChildren().add(labelPuntosDeAtaque);

                    labelPuntosDeDefensa = new Label("" + ((Monstruo) carta).getDefensa());
                    labelPuntosDeDefensa.setStyle("-fx-border-color: brown");
                    StackPane.setMargin(labelPuntosDeDefensa, new Insets(70, 0, 0, 35));
                    this.getChildren().add(labelPuntosDeDefensa);
                    if(!estaEnModoAtaque) {
                        this.setRotate(90);
                        //Chequear visualmente
                    }
                }
            } else {
                this.getChildren().add(imagenCartaBocaAbajo);
            }
        } catch (Exception e) {
            //TE APILO TODOS LOS NODOS QUE SE EM CANTAN NO ME ROMPAS LOS HUEVOS, calmate broh!
        }
        this.setOnMouseClicked(new ControladorCarta(this, jugador, carta, vistaMano, vistaZonaNoMonstruos, vistaZonaMonstruos, vistaCartaCampo));
        this.setOnMouseEntered(new ControladorZoomCarta(imageUrl));
        this.setOnMouseExited(new ControladorZoomCarta());
    }

    public void deshabilitarCarta() {
        this.setDisable(true);
    }

    public void update() {
        this.dibujar();
    }

    public double getAlturaCarta() {
        return ALTURA_MAXIMA_CARTA;
    }

    public double getAnchoCarta() {
        return ANCHO_MAXIMO_CARTA;
    }

    public void cambiarVision() {
        esVisible = !esVisible;
    }

    public boolean getEsVisible() {
        return esVisible;
    }

    public VistaCarta clonar() {
       VistaCarta vistaCartaClon = new VistaCarta(imageUrl,jugador,carta,vistaMano,vistaZonaMonstruos,vistaZonaNoMonstruos,vistaCartaCampo, esVisible, estaEnModoAtaque);
       return vistaCartaClon;
    }

    public void girar() {
        estaEnModoAtaque = !estaEnModoAtaque;
    }
}
