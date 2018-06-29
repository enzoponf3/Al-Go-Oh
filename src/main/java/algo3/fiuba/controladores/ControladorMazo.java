package algo3.fiuba.controladores;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.vista.VistaMano;
import algo3.fiuba.vista.VistaMazo;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.util.Stack;


public class ControladorMazo implements EventHandler<MouseEvent> {

    private VistaMano vistaMano;
    private Jugador jugador;
    private VistaMazo vistaMazo;

    public ControladorMazo(VistaMazo vistaMazo, Jugador jugador, VistaMano vistaMano) {

        this.jugador = jugador;
        this.vistaMazo = vistaMazo;
        this.vistaMano = vistaMano;
    }

    @Override
    public void handle(MouseEvent event) {

        ControladorTurnos ct = ControladorTurnos.getInstancia();
        Jugador actual = ct.getJugador();
        if(actual.getEstadoJugador() instanceof PreInvocacion ) {
            jugador.tomarCartaDelMazo();
            vistaMazo.update();
            vistaMano.update();
        } else {
            Alert errorMazo = new Alert(Alert.AlertType.INFORMATION);
            errorMazo.setHeaderText("Ya no puedes levantar del mazo");
            errorMazo.show();
        }
    }

}
