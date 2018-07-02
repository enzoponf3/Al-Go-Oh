package algo3.fiuba.controladores;

import algo3.fiuba.modelo.excepciones.CartasInsuficientesExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PostInvocacion;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaMazo;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;


public class ControladorMazo implements EventHandler<MouseEvent> {

    private VistaMano vistaMano;
    private Jugador jugador;
    private VistaMazo vistaMazo;

    private ControladorDeTurnos controladorDeTurnos;

    public ControladorMazo(VistaMazo vistaMazo, Jugador jugador, VistaMano vistaMano) {

        this.jugador = jugador;
        this.vistaMazo = vistaMazo;
        this.vistaMano = vistaMano;

        controladorDeTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(MouseEvent event) {
        // !!!! Decisión de negocio ;)
        jugador.setEstadoJugador(new PostInvocacion());
        controladorDeTurnos.actualizarTablero();
        // !!!! no tiene que hacer nada esto, se hace automáticamente cada vez que pasa el turno
        /*
        ControladorDeTurnos ct = ControladorDeTurnos.getInstancia();
        Jugador actual = ct.getJugadorActual();
        if(actual.getEstadoJugador() instanceof PreInvocacion ) {
            vistaMano.setDisable(true);
            try {
                jugador.tomarCartaDelMazo();
                vistaMazo.update();
                vistaMano.update();
            } catch (CartasInsuficientesExcepcion e) { }
        } else {
            Alert errorMazo = new Alert(Alert.AlertType.INFORMATION);
            errorMazo.setHeaderText("Ya no puedes levantar del mazo");
            errorMazo.show();
        }
        vistaMano.setDisable(false);
        */
    }

}
