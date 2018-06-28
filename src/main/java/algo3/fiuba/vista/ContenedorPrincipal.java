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
    private ControladorTurnos ct;

    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.juego = juego;
        this.ct = ControladorTurnos.getInstancia();
        this.barraLateral = new BarraLateral(juego);
        this.tableroJ1 = new TableroLado1(juego.getJugador1());
        this.tableroJ2 = new TableroLado2(juego.getJugador2());
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
    }

    public void dibujar() {
        this.dibujarBarraLateral();
        this.dibujarTablero();
    }

    public void update() {
        this.dibujarBarraLateral();
        this.tableroJ1.update();
        this.tableroJ2.update();
    }

    private void dibujarBarraLateral() {
        barraLateral.getStyleClass().add("barraLateral");
        this.setLeft(barraLateral);
    }

    private void dibujarTablero() {
        tableroJ1.dibujar();
        tableroJ2.dibujar();
        VBox tableroCompleto = new VBox(tableroJ1, tableroJ2);
        tableroCompleto.getStyleClass().add("tablero");
        this.setCenter(tableroCompleto);
    }
}
