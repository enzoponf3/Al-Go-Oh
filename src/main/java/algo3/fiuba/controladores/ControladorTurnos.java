package algo3.fiuba.controladores;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.jugador.*;
import algo3.fiuba.vista.ContenedorPrincipal;
import algo3.fiuba.vista.VistaVida;
import javafx.scene.control.Alert;

public class ControladorTurnos {

    private static ControladorTurnos INSTANCIA;
    private Jugador jugador1, jugador2;
    private ContenedorPrincipal contenedorPrincipal;
    private VistaVida vistaVidaJ1, vistaVidaJ2; // !!! SACAR
    private String nombreJugador1, nombreJugador2;
    private Turno turno;

    public static ControladorTurnos getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new ControladorTurnos();

        return INSTANCIA;
    }


    private ControladorTurnos() {
        turno = Turno.getInstancia();
    }

    public void setJugadores(Jugador J1, Jugador J2) {
        this.jugador1 = J1;
        this.jugador2 = J2;
    }

    public void setContenedorPrincipal(ContenedorPrincipal contenedorPrincipal) {
        this.contenedorPrincipal = contenedorPrincipal;
    }

    public void setVistaVida(VistaVida vidaJ1, VistaVida vidaJ2) {
        vistaVidaJ1 = vidaJ1;
        vistaVidaJ1 = vidaJ2;
    }

    public Jugador getJugador() {
        return jugador1.getEstadoJugador() instanceof TurnoDelOponente ? jugador2 : jugador1;
    }

    public void terminarDuelo() {

        // !!!! ponerle el nombre!
        if (ganadorDuelo() != null) {
            Alert win = new Alert(Alert.AlertType.INFORMATION);
            win.setHeaderText("Ha perdido!");
            contenedorPrincipal.setDisable(true);
            win.show();
        }
    }

    /* !!!! ESTO LO HACE EL MODELO AUTOMÁTICAMENTE
    public void cambiarDeFase() {
        if (jugadorActual.getEstadoJugador() instanceof PostInvocacion) {
            this.terminarTurno();
        }
        else {
            jugador1.setEstadoJugador(jugador1.getEstadoJugador().cambioDeFase());
            jugador2.setEstadoJugador(jugador2.getEstadoJugador().cambioDeFase());
        }
        contenedorPrincipal.update();
    }
*/
    public void terminarTurno() {
        turno.pasarTurno();
        /* !!!! ESTO LO HACE EL MODELO AUTOMÁTICAMENTE
        jugador1.setEstadoJugador(jugador1.getEstadoJugador().cambioDeTurno());
        jugador2.setEstadoJugador(jugador2.getEstadoJugador().cambioDeTurno());
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
        */
        actualizarTablero();
    }

    public Jugador ganadorDuelo() {
       return Juego.getInstancia().ganadorPartida();
    }

    public void actualizarTablero() {
        terminarDuelo();
        contenedorPrincipal.update();
    }

    public void setNombresJugadores(String nombre1, String nombre2) {
        this.nombreJugador1 = nombre1;
        this.nombreJugador2 = nombre2;
    }

    public String getNombreJugador1() { return this.nombreJugador1; }

    public String getNombreJugador2() { return this.nombreJugador2; }

}
