package algo3.fiuba.controladores.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class ControladorEntrar implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene pantallaJuego;

    public ControladorEntrar(Stage stage, Scene proximaPantalla) {
        this.stage = stage;
        this.pantallaJuego = proximaPantalla;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setScene(pantallaJuego);
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.setTitle("Al-Go-Oh!");
    }

}
