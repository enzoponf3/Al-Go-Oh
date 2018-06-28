package algo3.fiuba.controladores;

import algo3.fiuba.modelo.jugador.*;
import algo3.fiuba.vista.ContenedorPrincipal;
import javafx.scene.control.Alert;
import javafx.stage.Popup;

public class ControladorTurnos {

    private static ControladorTurnos INSTANCIA;
    private Jugador jugador1, jugador2;
    private Jugador jugadorActual;

    public static ControladorTurnos getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new ControladorTurnos();
        return INSTANCIA;
    }

    public ControladorTurnos(/*Jugador J1, Jugador J2*/) {

//        this.jugador1 = J1;
  //      this.jugador2 = J2;
    }

    public Jugador getJugador() {

       return jugadorActual;
    }

    public void duelo() {

        if (!ganadorDuelo()) {
            ControladorMazo mazo = new ControladorMazo();
            preInvocacion();
            postInvocacion();
        } else {
            Alert win = new Alert(Alert.AlertType.valueOf("Has ganado!"));
            win.show();
        }

    }

    public void cambiarDeFase() {

        // como que re feo no?
        if (jugadorActual.getEstadoJugador() instanceof PreInvocacion) {
            jugadorActual.setEstadoJugador(new PostInvocacion());
        } else if (jugadorActual.getEstadoJugador() instanceof PostInvocacion) {
            this.terminarTurno();
        }
    }

    public void postInvocacion(){

    }

    public void preInvocacion() {

        //if (jugadorActual.getEstadoJugador().getClass() == PreInvocacion)
          //  mazo.habilitarRobar
    }

    public void terminarTurno() {

        jugadorActual.getEstadoJugador().cambioDeTurno();
    }

    public boolean ganadorDuelo() {

       return jugadorActual.getOponente().getPuntosDeVida() == 0;
    }
}
