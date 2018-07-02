package algo3.fiuba.vista;

import algo3.fiuba.controladores.controladores_de_carta.ControladorCarta;
import algo3.fiuba.controladores.controladores_de_carta.ControladorZoomCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estado_en_turno.NoUsadaEnTurno;
import algo3.fiuba.modelo.cartas.estado_en_turno.TurnoRival;
import algo3.fiuba.modelo.cartas.estados_cartas.*;
import algo3.fiuba.modelo.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.TurnoDelOponente;
import algo3.fiuba.utils.CartaVistaUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaCarta extends StackPane {

    private Label labelPuntosDeAtaque;
    private Label labelPuntosDeDefensa;
    private Carta carta;
    private Jugador jugador;
    private ImageView imagenCarta;
    private ImageView imagenCartaBocaAbajo;
    private String imageUrl;
    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;

    private CartaVistaUtils cartaVistaUtils;

    public VistaCarta(String imageUrl, Jugador jugador, Carta carta) {
        cartaVistaUtils = new CartaVistaUtils();

        this.imageUrl = imageUrl;
        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.imagenCartaBocaAbajo =  new ImageView(new Image(cartaVistaUtils.getImagenCartaBocaAbajo(), ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.dibujar();
    }

    public void dibujar() {

        Rectangle rectanguloFondo = new Rectangle(73,21, Color.LIGHTGOLDENRODYELLOW);
        StackPane.setMargin(rectanguloFondo, new Insets(71, 0, 0, 0));

        if (carta instanceof Monstruo) {
            labelPuntosDeAtaque = new Label("" + ((Monstruo) carta).getAtaque());
            labelPuntosDeAtaque.setStyle("-fx-border-color: brown" );
            StackPane.setMargin(labelPuntosDeAtaque, new Insets(70, 30, 0, 0));

            labelPuntosDeDefensa = new Label("" + ((Monstruo) carta).getDefensa());
            labelPuntosDeDefensa.setStyle("-fx-border-color: brown");
            StackPane.setMargin(labelPuntosDeDefensa, new Insets(70, 0, 0, 35));
        }

        try{
            if (carta.getEstadoCarta() instanceof BocaAbajo || carta.getEstadoCarta() instanceof EnMazo) {
                this.getChildren().add(imagenCartaBocaAbajo);
            } else {
                this.getChildren().add(imagenCarta);
                if (carta instanceof Monstruo) {
                    this.getChildren().addAll(rectanguloFondo,labelPuntosDeAtaque,labelPuntosDeDefensa);
                }
            }

            if (carta instanceof Monstruo) {
                if(((Monstruo)carta).getModo() instanceof ModoDeDefensa) {
                    this.setRotate(90);
                    //Chequear visualmente
                }
            }

        } catch (Exception e) {
            //TE APILO TODOS LOS NODOS QUE SE EM CANTAN NO ME ROMPAS LOS HUEVOS, calmate broh!
        }
        this.setOnMouseClicked(new ControladorCarta(this, jugador, carta));
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

}
