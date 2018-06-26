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
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ContenedorPrincipal extends BorderPane {

    Tablero tablero;
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

        tablero = new Tablero();
        Tablero t = new Tablero();
        t.setRotate(180);
        t.setAlignment(Pos.TOP_RIGHT);
        VBox tableroCompleto = new VBox(tablero, t);
        tableroCompleto.getStyleClass().add("tablero");
        this.setCenter(tableroCompleto);
    }

    public void setPlayers(){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        juego.inicializar(jugador1, jugador2);
    }

}
