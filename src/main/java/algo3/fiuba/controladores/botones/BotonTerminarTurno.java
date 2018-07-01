package algo3.fiuba.controladores.botones;

import algo3.fiuba.controladores.ControladorDeTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTerminarTurno implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        ControladorDeTurnos ct = ControladorDeTurnos.getInstancia();
        ct.terminarTurno();
    }
}
