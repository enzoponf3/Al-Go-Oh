package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorCantidadDeSacrificios;
import algo3.fiuba.controladores.botones.checkboxs.CheckBoxSacrificio;
import algo3.fiuba.controladores.controladores_de_carta.ControladorCarta;
import algo3.fiuba.controladores.controladores_de_carta.ControladorZoomCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estado_en_turno.NoUsadaEnTurno;
import algo3.fiuba.modelo.cartas.estado_en_turno.TurnoRival;
import algo3.fiuba.modelo.cartas.estados_cartas.*;
import algo3.fiuba.modelo.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PostInvocacion;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.modelo.jugador.TurnoDelOponente;
import algo3.fiuba.utils.CartaVistaUtils;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
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

        if (carta.getEstadoCarta() instanceof BocaAbajo || carta.getEstadoCarta() instanceof EnMazo) {
            super.getChildren().add(imagenCartaBocaAbajo);
        } else {
            super.getChildren().add(imagenCarta);

        }
        if (carta instanceof Monstruo) {
            Rectangle rectanguloFondo = new Rectangle(76, 21, Color.LIGHTGOLDENRODYELLOW);
            StackPane.setMargin(rectanguloFondo, new Insets(76, 0, 0, 0));

            labelPuntosDeAtaque = new Label("" + ((Monstruo) carta).getAtaque());
            labelPuntosDeAtaque.setStyle("-fx-border-color: brown" );
            StackPane.setMargin(labelPuntosDeAtaque, new Insets(75, 35, 0, 0));

            labelPuntosDeDefensa = new Label("" + ((Monstruo) carta).getDefensa());
            labelPuntosDeDefensa.setStyle("-fx-border-color: brown");
            StackPane.setMargin(labelPuntosDeDefensa, new Insets(75, 0, 0, 40));

            super.getChildren().addAll(rectanguloFondo,labelPuntosDeAtaque,labelPuntosDeDefensa);

            if ((jugador.getEstadoJugador() instanceof TurnoDelOponente &&
                    (!carta.estaEnJuego() || carta.getEstadoCarta() instanceof BocaAbajo))g
                    || (jugador.getEstadoJugador() instanceof PostInvocacion && !carta.estaEnJuego())) {
                rectanguloFondo.setVisible(false);
                labelPuntosDeAtaque.setVisible(false);
                labelPuntosDeDefensa.setVisible(false);
            }

            if ((jugador.getEstadoJugador() instanceof PreInvocacion) && carta.estaEnJuego()) {
                CheckBoxSacrificio checkBoxParaSacrificio = new CheckBoxSacrificio((Monstruo) carta);
                checkBoxParaSacrificio.setOnAction(new ControladorCantidadDeSacrificios());

                super.getChildren().add(checkBoxParaSacrificio);
            }

            if(((Monstruo) carta).getModo() instanceof ModoDeDefensa) {
                    this.setRotate(90);
            }
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
