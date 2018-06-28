package algo3.fiuba.vista;

import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCartaCampo extends Label {

    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    private Jugador jugador;

    public VistaCartaCampo(Jugador jugador) {

        this.jugador = jugador;
    }

    public void dibujar() {

        ImageView cartaCampoFondo = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        if (jugador.getCartaCampoActiva() != null) {
            String nombre = jugador.getCartaCampoActiva().getNombre();
            VistaCarta vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/" + nombre + ".gif", jugador);
            this.setGraphic(vistaCarta);
        } else {
            this.setGraphic(cartaCampoFondo);
        }
    }
}
