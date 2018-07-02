package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class VistaMazo extends Label {

    private ControladorDeTurnos controladorTurnos;
    private Jugador jugador;
    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;
    private int cantidad;
    private ImageView fondoMazo;

    // !!!! LE PODEMOS PASAR CON EL CONTROLADOR EL NUMERO DE CARTAS
    public VistaMazo(ImageView fondoMazo, Jugador jugador) {
        this.cantidad = jugador.cantidadCartasEnMazo();
        this.fondoMazo = fondoMazo;
        this.jugador = jugador;
        this.controladorTurnos = ControladorDeTurnos.getInstancia();
    }

    public void dibujar() {
        this.setText(String.valueOf(cantidad));
        this.setTextFill(Color.WHITE);
        this.setGraphic(fondoMazo);
        this.setContentDisplay(ContentDisplay.CENTER);
        Jugador jugadorActual = controladorTurnos.getJugadorActual();
        if(jugadorActual == jugador && jugadorActual.getEstadoJugador() instanceof PreInvocacion) {
            this.habilitarMazo();
        }
        else {
            this.deshabilitarMazo();
        }
    }

    public void update() {
        cantidad--;

        this.dibujar();
        this.setText(String.valueOf(cantidad));
        this.setDisable(true);
        this.setTextFill(Color.WHITE);
        this.setGraphic(fondoMazo);
        this.setContentDisplay(ContentDisplay.CENTER);
    }

    public void habilitarMazo() {
        this.setDisable(false);
    }

    public void deshabilitarMazo() {
        this.setDisable(true);

    }

}
