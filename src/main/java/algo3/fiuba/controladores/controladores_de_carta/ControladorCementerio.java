package algo3.fiuba.controladores.controladores_de_carta;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class ControladorCementerio implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {

        Alert movInvalido= new Alert(Alert.AlertType.ERROR);
        movInvalido.setHeaderText(null);
        movInvalido.setContentText("No puedes robar del cementerio!");
        movInvalido.show();
    }
}
