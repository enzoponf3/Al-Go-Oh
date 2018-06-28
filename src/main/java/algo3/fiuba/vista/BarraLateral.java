package algo3.fiuba.vista;

import algo3.fiuba.controladores.BotonCambiarDeFase;
import algo3.fiuba.controladores.BotonAyuda;
import algo3.fiuba.controladores.BotonSalida;
import algo3.fiuba.controladores.BotonTerminarTurno;
import algo3.fiuba.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BarraLateral extends StackPane {

    private Juego juego;
    private VistaVida vistaVidaJugador1;
    private VistaVida vistaVidaJugador2;

    public BarraLateral(Juego juego) {

        // BOTONERA
        Boton botonAyuda = new Boton("Ayuda", new BotonAyuda());
        Boton botonSalir = new Boton("Salir", new BotonSalida());
        Boton botonFase = new Boton("Cambiar de fase", new BotonCambiarDeFase()); // añadir funcion
        Boton botonFinTurno = new Boton("Terminar turno", new BotonTerminarTurno());  //añadir funcion

        // Consolas de puntos

        vistaVidaJugador1 = new VistaVida(juego.getJugador1());

        vistaVidaJugador2 = new VistaVida(juego.getJugador2());

        // CONTENEDORES LATERALES
        HBox boxBtnsAyudaSalir = new HBox(botonAyuda, botonSalir);
        boxBtnsAyudaSalir.setAlignment(Pos.CENTER);
        boxBtnsAyudaSalir.setSpacing(20);

        VBox boxBtnsFaseTurno = new VBox(boxBtnsAyudaSalir, botonFase, botonFinTurno);
        boxBtnsFaseTurno.setAlignment(Pos.CENTER);
        boxBtnsFaseTurno.setSpacing(10);

        VBox vbox = new VBox(vistaVidaJugador1, boxBtnsFaseTurno, vistaVidaJugador2);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        vbox.getStyleClass().add("vbox");
        this.getChildren().add(vbox);
    }
}
