package algo3.fiuba.vista;

import algo3.fiuba.controladores.*;
import algo3.fiuba.controladores.botones.*;
import algo3.fiuba.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class BarraLateral extends StackPane {

    private Juego juego;
    private VistaVida vistaVidaJugador1;
    private VistaVida vistaVidaJugador2;
    private VistaProyeccionCarta vistaProyeccionCarta;

    public BarraLateral(Juego juego) {

        ControladorTurnos controladorTurnos = ControladorTurnos.getInstancia();

        // BOTONERA
        Boton botonAyuda = new Boton("Ayuda", new BotonAyuda());
        Boton botonSalir = new Boton("Salir", new BotonSalida());
        Boton botonFase = new Boton("Cambiar de fase", new BotonCambiarDeFase());
        Boton botonFinTurno = new Boton("Terminar turno", new BotonTerminarTurno());
        Boton mute = new Boton("Play/Stop music", ControladorMusica.getInstancia());

        // Consolas de puntos
        vistaVidaJugador1 = new VistaVida(juego.getJugador1());
        vistaVidaJugador2 = new VistaVida(juego.getJugador2());
        controladorTurnos.setVistaVida(vistaVidaJugador1, vistaVidaJugador2);

        // Nombres jugadores
        Label nombreJ1 = new Label(controladorTurnos.getNombreJ1());
        Label nombreJ2 = new Label(controladorTurnos.getNombreJ2());

        // Visor carta
        vistaProyeccionCarta = VistaProyeccionCarta.getInstancia();

        // CONTENEDORES LATERALES
        HBox boxBtnsAyudaSalir = new HBox(botonAyuda, botonSalir);
        boxBtnsAyudaSalir.setAlignment(Pos.CENTER);
        boxBtnsAyudaSalir.setSpacing(20);

        VBox boxBtnsFaseTurno = new VBox(boxBtnsAyudaSalir, botonFase, botonFinTurno);
        boxBtnsFaseTurno.setAlignment(Pos.CENTER);
        boxBtnsFaseTurno.setSpacing(10);

        VBox vbox = new VBox(nombreJ1, vistaVidaJugador1, boxBtnsFaseTurno, vistaProyeccionCarta, vistaVidaJugador2, nombreJ2, mute);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        vbox.getStyleClass().add("vbox");
        this.getChildren().add(vbox);
    }

    public void update() {
        this.vistaVidaJugador1.update();
        this.vistaVidaJugador2.update();
        //this.vistaProyeccionCarta.update();
    }
}
