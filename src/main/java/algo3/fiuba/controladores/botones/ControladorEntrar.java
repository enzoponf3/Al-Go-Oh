package algo3.fiuba.controladores.botones;

import algo3.fiuba.controladores.ControladorTurnos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class ControladorEntrar implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene pantallaJuego;
    private String n1, n2; // !!!! qué es??? sacar, n se usa


    public ControladorEntrar(Stage stage, Scene proximaPantalla, String n1, String n2) {

        this.stage = stage;
        this.pantallaJuego = proximaPantalla;
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setScene(pantallaJuego);
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.setTitle("Al-Go-Oh!");
    }

}
