package algo3.fiuba.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class BotonTerminarTurno implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        ControladorTurnos ct = ControladorTurnos.getInstancia();
        /*Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setHeaderText("Quieres terminar el turno?");
        confirmacion.show();
        if (confirmacion.getResult() == ButtonType.OK) {*/
            ct.terminarTurno();
        //}
    }
}
