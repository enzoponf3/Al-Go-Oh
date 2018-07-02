package algo3.fiuba.controladores;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.jugador.*;
import algo3.fiuba.vista.ContenedorPrincipal;
import algo3.fiuba.vista.VistaVida;
import javafx.scene.control.Alert;

public class ControladorDeTurnos {

    private static ControladorDeTurnos INSTANCIA;
    private Jugador jugador1, jugador2;
    private ContenedorPrincipal contenedorPrincipal;
    private VistaVida vistaVidaJ1, vistaVidaJ2;
    private Turno turno;

    public static ControladorDeTurnos getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new ControladorDeTurnos();

        return INSTANCIA;
    }


    private ControladorDeTurnos() {
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

    public Jugador getJugadorActual() {
        return jugador1.getEstadoJugador() instanceof TurnoDelOponente ? jugador2 : jugador1;
    }

    public void terminarDuelo() {
        if (ganadorDuelo() != null) {
            Alert win = new Alert(Alert.AlertType.INFORMATION);
            win.setHeaderText("Ha perdido el jugador: " + (jugador1.estaEnJuego() ? jugador2.getNombre() : jugador1.getNombre()) +"!" );
            contenedorPrincipal.setDisable(true);
            win.show();
        }
    }

    public void terminarTurno() {
        turno.pasarTurno();
        this.getJugadorActual().tomarCartaDelMazo();
        actualizarTablero();
    }

    public Jugador ganadorDuelo() {
       return Juego.getInstancia().ganadorPartida();
    }

    public void actualizarTablero() {
        terminarDuelo();
        contenedorPrincipal.update();
    }

    public boolean esElPrimerTurno() {
        return turno.esElPrimerTurno();
    }
}
