package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorMazo;
import algo3.fiuba.controladores.ControladorTurnos;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class VistaMazo extends Label {

    private ControladorTurnos controladorTurnos;
    private Jugador jugador;
    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    private int cantidad;
    private ImageView fondoMazo;

    // LE PODEMOS PASAR CON EL CONTROLADOR EL NUMERO DE CARTAS
    public VistaMazo(ImageView fondoMazo, Jugador jugador) {
        this.cantidad = 40;
        this.fondoMazo = fondoMazo;
        this.jugador = jugador;
        this.controladorTurnos = ControladorTurnos.getInstancia();
    }

    public void dibujar() {
        this.setText(String.valueOf(cantidad));
        this.setTextFill(Color.WHITE);
        this.setGraphic(fondoMazo);
        this.setContentDisplay(ContentDisplay.CENTER);
        Jugador jugadorActual = controladorTurnos.getJugador();
        if(jugadorActual == jugador) {
            this.habilitarMazo();
        }
        else {
            this.deshabilitarMazo();
        }
    }

    public void update() {
        cantidad--;
        this.dibujar();
    }

    public void habilitarMazo() {
        this.setDisable(false);
    }

    public void deshabilitarMazo() {
        this.setDisable(true);
    }

}
