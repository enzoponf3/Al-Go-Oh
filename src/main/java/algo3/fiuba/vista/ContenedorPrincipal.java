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

    private Tablero tableroJ1;
    private Tablero tableroJ2;
    private BarraLateral barraLateral;
    private Juego juego;
    private ControladorTurnos ct = ControladorTurnos.getInstancia();

    public ContenedorPrincipal(Stage stage, Juego juego) {

        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
        this.setBarraLateral(juego);
        this.setTablero();
    }

    private void setBarraLateral(Juego juego) {

        barraLateral = new BarraLateral(juego);
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
}
