package algo3.fiuba.vista;

import algo3.fiuba.controladores.BotonAyuda;
import algo3.fiuba.controladores.BotonSalida;
import algo3.fiuba.controladores.ControladorTurnos;
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
    ControladorTurnos ct = ControladorTurnos.getInstancia();

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

        tableroJ1 = new TableroLado1(ct.getJugador());
        tableroJ2 = new TableroLado2(ct.getJugador());

        VBox tableroCompleto = new VBox(tableroJ1, tableroJ2);
        tableroCompleto.getStyleClass().add("tablero");
        this.setCenter(tableroCompleto);
    }

    public void setPlayers(){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        juego.inicializar(jugador1, jugador2);
    }

}
