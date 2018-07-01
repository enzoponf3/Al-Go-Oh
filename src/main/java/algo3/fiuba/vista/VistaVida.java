package algo3.fiuba.vista;

import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.net.URI;

public class VistaVida extends Label {

    Jugador jugador;
    ImageView imagenVida = new ImageView(new Image("/algo3/fiuba/resources/img/fondo-arena.jpg", 200, 80, false, false));

    public VistaVida(Jugador jugador) {
        this.jugador = jugador;

        this.setText("LP: " + jugador.getPuntosDeVida());
        this.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        this.setGraphic(imagenVida);
        this.setTextFill(Color.WHITE);
        this.setContentDisplay(ContentDisplay.CENTER);
    }

    public void update() {
        /*
        //sacar?? mmm
        File file = new File("/home/locadesquiciada/Documentos/ALGORITMOS III/TP2/Al-Go-Oh/src/main/java/algo3/fiuba/resources/media/LP_effect.mp3");
        URI uri = file.toURI();
        String retVal = uri.toString();

        javafx.scene.media.Media n = new javafx.scene.media.Media(retVal);
        MediaPlayer j = new MediaPlayer(n);
        j.setVolume(200);
        j.play();
        */
        this.setText("LP: " + jugador.getPuntosDeVida());
    }
}
