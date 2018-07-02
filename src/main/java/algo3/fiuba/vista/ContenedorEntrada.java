package algo3.fiuba.vista;

import algo3.fiuba.controladores.botones.ControladorEntrar;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorEntrada extends VBox {

    private Stage stage;
    private TextField entradaNombreJ1;
    private TextField entradaNombreJ2;

    public ContenedorEntrada(Stage stage, Scene pantallaJuego, Jugador jugador1, Jugador jugador2) {

        super();

        this.stage = stage;

        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorEntrada.css");
        this.getStyleClass().add("fondo");

        Label nombres = new Label("Duelistas! \nIngresen sus nombres");
        super.getChildren().addAll(nombres);

        Text nombre1 = new Text("Duelista 1:");
        entradaNombreJ1 = new TextField();
        entradaNombreJ1.setPromptText("Nombre");
        VBox boxJugador1 = new VBox(nombre1, entradaNombreJ1);
        super.getChildren().addAll(boxJugador1);

        Text nombre2 = new Text("Duelista 2:");
        entradaNombreJ2 = new TextField();
        entradaNombreJ2.setPromptText("Nombre");
        VBox boxJugador2 = new VBox(nombre2, entradaNombreJ2);
        super.getChildren().addAll(boxJugador2);



        Boton botonJugar = new Boton("Duelo!", new ControladorEntrar(stage, pantallaJuego,this, jugador1,jugador2));
        super.getChildren().addAll(botonJugar);
        
        stage.setTitle("Inicio");
        stage.centerOnScreen();
        stage.setResizable(false);
    }

    public String getNombreJugador1() {
        return entradaNombreJ1.getText();
    }

    public String getNombreJugador2() {
        return entradaNombreJ2.getText();
    }

}
