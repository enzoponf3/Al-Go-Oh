package algo3.fiuba.vista.vista_cartas;

import algo3.fiuba.controladores.controladores_de_carta.ControladorCarta;
import algo3.fiuba.controladores.controladores_de_carta.ControladorZoomCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.*;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.vista_cartas.estado_carta_vista.EstadoCartaVista;
import algo3.fiuba.vista.vista_cartas.estado_carta_vista.EstadoCartaVistaFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CartaVista extends StackPane {

    protected Carta carta;
    protected Jugador jugador;
    private ImageView imagenCarta;
    private ImageView imagenCartaBocaAbajo;
    private String imageUrl;
    protected EstadoCartaVista estadoCartaVista;

    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;

    private CartaVistaUtils cartaVistaUtils;

    public CartaVista(String imageUrl, Jugador jugador, Carta carta) {
        cartaVistaUtils = new CartaVistaUtils();

        this.imageUrl = imageUrl;
        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.imagenCartaBocaAbajo =  new ImageView(new Image(cartaVistaUtils.getImagenCartaBocaAbajo(), ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.estadoCartaVista = EstadoCartaVistaFactory.getEstadoCartaVista(jugador, carta);
    }

    public void dibujar() {
        super.getChildren().clear();

        if (carta.estaBocaAbajo() || carta.estaEnMazo()) {
            super.getChildren().add(imagenCartaBocaAbajo);
        } else {
            super.getChildren().add(imagenCarta);
        }

        estadoCartaVista.aniadirFuncionalidad(this);

        this.setOnMouseClicked(new ControladorCarta(this, jugador, carta));
        this.setOnMouseEntered(new ControladorZoomCarta(imageUrl));
        this.setOnMouseExited(new ControladorZoomCarta());
    }

    public void deshabilitarCarta() {
        super.setDisable(true);
    }

    public void update() {
        this.dibujar();
    }

    public String getImageUrl() {
        return imageUrl;
    }


}
