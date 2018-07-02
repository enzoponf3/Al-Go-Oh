package algo3.fiuba.vista;

import algo3.fiuba.controladores.*;
import algo3.fiuba.controladores.botones.*;
import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class BarraLateral extends StackPane {

    private Juego juego;
    private VistaVida vistaVidaJugador1;
    private VistaVida vistaVidaJugador2;
    private VistaProyeccionCarta vistaProyeccionCarta;

    public BarraLateral(Juego juego) {

        ControladorDeTurnos controladorTurnos = ControladorDeTurnos.getInstancia();

        Jugador jugador1 = juego.getJugador1();
        Jugador jugador2 = juego.getJugador2();

        // BOTONERA
        Boton botonAyuda = new Boton("Ayuda", new BotonAyuda());
        Boton botonSalir = new Boton("Salir", new BotonSalida());
        Boton botonFinTurno = new Boton("Terminar turno", new BotonTerminarTurno());
        Boton mute = new Boton("Play/Stop music", ControladorMusica.getInstancia());

        // Consolas de puntos
        vistaVidaJugador1 = new VistaVida(juego.getJugador1());
        vistaVidaJugador2 = new VistaVida(juego.getJugador2());
        controladorTurnos.setVistaVida(vistaVidaJugador1, vistaVidaJugador2);

        // Nombres jugadores
        Label nombreJ1 = new Label(juego.getJugador1().getNombre());
        Label nombreJ2 = new Label(juego.getJugador2().getNombre());
        nombreJ1.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        nombreJ1.setTextFill(Color.WHITE);
        nombreJ2.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        nombreJ2.setTextFill(Color.WHITE);

        // Visor carta
        vistaProyeccionCarta = VistaProyeccionCarta.getInstancia();

        // CONTENEDORES LATERALES
        HBox boxBtnsAyudaSalir = new HBox(botonAyuda, botonSalir);
        boxBtnsAyudaSalir.setAlignment(Pos.CENTER);
        boxBtnsAyudaSalir.setSpacing(20);

        VBox boxBtnsFaseTurno = new VBox(boxBtnsAyudaSalir, botonFinTurno);
        boxBtnsFaseTurno.setAlignment(Pos.CENTER);
        boxBtnsFaseTurno.setSpacing(10);

        VBox vbox = new VBox(nombreJ1, vistaVidaJugador1, boxBtnsFaseTurno, vistaProyeccionCarta, vistaVidaJugador2, nombreJ2, mute);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        vbox.getStyleClass().add("vbox");
        super.getChildren().add(vbox);
    }

    public void update() {
        this.vistaVidaJugador1.update();
        this.vistaVidaJugador2.update();
    }
}
