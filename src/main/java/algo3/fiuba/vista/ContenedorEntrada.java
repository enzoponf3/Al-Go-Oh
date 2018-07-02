package algo3.fiuba.vista;

import algo3.fiuba.controladores.botones.ControladorEntrar;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorEntrada extends VBox {

    Stage stage;

    public ContenedorEntrada(Stage stage, Scene pantallaJuego, Jugador jugador1, Jugador jugador2) {

        super();

        this.stage = stage;

        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorEntrada.css");
        this.getStyleClass().add("fondo");

        Label nombres = new Label("Duelistas! \nIngresen sus nombres");
        this.getChildren().addAll(nombres);

        Text nombre1 = new Text("Duelista 1:");
        TextField entradaNombreJ1 = new TextField();
        VBox boxJugador1 = new VBox(nombre1, entradaNombreJ1);
        this.getChildren().addAll(boxJugador1);

        Text nombre2 = new Text("Duelista 2:");
        TextField entradaNombreJ2 = new TextField();
        VBox boxJugador2 = new VBox(nombre2, entradaNombreJ2);
        this.getChildren().addAll(boxJugador2);

        jugador1.setNombre(entradaNombreJ1.getText());
        jugador2.setNombre(entradaNombreJ2.getText());

        Boton botonJugar = new Boton("Duelo!", new ControladorEntrar(stage, pantallaJuego));
        this.getChildren().addAll(botonJugar);

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                stage.setScene(pantallaJuego);
                stage.setResizable(true);
                stage.centerOnScreen();
                stage.setTitle("Al-Go-Oh!");
            }
        });

        stage.setTitle("Inicio");
        stage.centerOnScreen();
        stage.setResizable(false);
    }

}
