package algo3.fiuba.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

import java.util.Optional;

public class BotonSalida implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Salir?");
        alerta.initStyle(StageStyle.UTILITY);
        alerta.setHeaderText(null);
        alerta.setContentText("Está seguro que quiere salir?");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.get() == ButtonType.OK){
            System.exit(0);
        }

        alerta.show();
    }
}
