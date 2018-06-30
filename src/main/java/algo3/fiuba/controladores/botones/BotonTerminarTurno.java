package algo3.fiuba.controladores.botones;

import algo3.fiuba.controladores.ControladorTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BotonTerminarTurno implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        ControladorTurnos ct = ControladorTurnos.getInstancia();
        ct.terminarTurno();
    }
}
