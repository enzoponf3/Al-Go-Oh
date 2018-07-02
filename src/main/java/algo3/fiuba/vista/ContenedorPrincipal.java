package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorMusica;
import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.Juego;
import algo3.fiuba.vista.vista_tablero.Tablero;
import algo3.fiuba.vista.vista_tablero.TableroLado1;
import algo3.fiuba.vista.vista_tablero.TableroLado2;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ContenedorPrincipal extends BorderPane {

    private Tablero tableroJ1;
    private Tablero tableroJ2;
    private BarraLateral barraLateral;
    private Juego juego;
    private ControladorDeTurnos ct;

    public ContenedorPrincipal(Stage stage, Juego juego) {
        this.juego = juego;
        this.ct = ControladorDeTurnos.getInstancia();
        this.barraLateral = new BarraLateral(juego);
        this.tableroJ1 = new TableroLado1(juego.getJugador1());
        this.tableroJ2 = new TableroLado2(juego.getJugador2());
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
    }

    public void dibujar() {
//        this.setMusica();
        this.dibujarBarraLateral();
        this.dibujarTablero();
    }

    public void update() {
        this.barraLateral.update();
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

    private void setMusica() {
        Media musica = new Media(getClass().getResource("/algo3/fiuba/resources/media/musicopening.mp3").toExternalForm());
        MediaPlayer rprMusica = new MediaPlayer(musica);
        rprMusica.setOnEndOfMedia(() -> rprMusica.seek(Duration.ZERO));
        rprMusica.play();
        rprMusica.setVolume(2);
        rprMusica.setAutoPlay(true);
        ControladorMusica cm = ControladorMusica.getInstancia();
        cm.setearControlMusica(rprMusica);
    }
}
