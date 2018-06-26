package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorEntrar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorEntrada extends VBox {

    Stage stage;

    public ContenedorEntrada(Stage stage, Scene pantallaJuego) {

        super();

        this.stage = stage;

        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorEntrada.css");
        this.getStyleClass().add("fondo");

        Label nombres = new Label("Ingresen sus nombres \nDuelistas!");
        this.getChildren().addAll(nombres);

        TextField entradaNombreJ1 = new TextField();
        Text nombre = new Text("Duelista 1:");
        String n1 = entradaNombreJ1.getText();
        VBox boxJugador1 = new VBox(nombre, entradaNombreJ1);
        this.getChildren().addAll(boxJugador1);

        TextField entradaNombreJ2 = new TextField();
        Text nombre2 = new Text("Duelista 2:");
        VBox boxJugador2 = new VBox(nombre2, entradaNombreJ2);
        this.getChildren().addAll(boxJugador2);

        String getNombreJ1 = nombre.getText();
        String getNombreJ2 = nombre2.getText();

        Boton botonJugar = new Boton("Duelo!", new ControladorEntrar(stage, pantallaJuego, getNombreJ1, getNombreJ2));

        this.getChildren().addAll(botonJugar);
        stage.setTitle("Inicio");
        stage.centerOnScreen();
        stage.setResizable(false);
    }


}
