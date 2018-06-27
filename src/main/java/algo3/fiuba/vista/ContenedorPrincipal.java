package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorBotonAyuda;
import algo3.fiuba.controladores.ControladorBotonSalida;
import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ContenedorPrincipal extends BorderPane {

    Tablero tableroJ1;
    Tablero tableroJ2;
    BarraLateral barraLateral;
    Juego juego = Juego.getInstancia();

    public ContenedorPrincipal(Stage stage) {

        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
        this.setBarraLateral();
        this.setTablero();
        this.setPlayers();
    }

    private void setBarraLateral() {

        barraLateral = new BarraLateral();
        barraLateral.getStyleClass().add("barraLateral");
        this.setLeft(barraLateral);
    }

    private void setTablero() {

        tableroJ1 = new Tablero();

        //tableroJ2 = new Tablero();
        //tableroJ2.setRotate(180);
        //Translate j = new Translate();
        //tableroJ2.setAlignment(Pos.TOP_RIGHT);

        VBox tableroCompleto = new VBox(tableroJ1);
        tableroCompleto.getStyleClass().add("tablero");
        this.setCenter(tableroCompleto);
    }

    public void setPlayers(){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        juego.inicializar(jugador1, jugador2);
    }

}
