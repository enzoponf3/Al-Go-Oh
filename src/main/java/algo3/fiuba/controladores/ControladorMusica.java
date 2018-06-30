package algo3.fiuba.controladores;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class ControladorMusica implements EventHandler<ActionEvent> {

    public static ControladorMusica INSTANCIA;
    public MediaPlayer controlMusic;


    public static ControladorMusica getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new ControladorMusica();
        return INSTANCIA;
    }

    @Override
    public void handle(ActionEvent event) {
        if (!this.controlMusic.isMute())  this.controlMusic.setMute(true);
        else this.controlMusic.setMute(false);
    }

    public void setearControlMusica(MediaPlayer rpr) {
        this.controlMusic = rpr;
    }
}
