package algo3.fiuba.controladores;

import algo3.fiuba.modelo.jugador.Jugador;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;


public class ControladorMazo implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {

        //if jugador.mazohabilitado
        //Jugador jugador = controladorTurno.getJugador();
        //jugador.tomarCartaDelMazo();
        //else
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.show();
    }
}
