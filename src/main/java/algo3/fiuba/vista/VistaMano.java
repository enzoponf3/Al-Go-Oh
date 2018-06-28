package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorMano;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.awt.*;

public class VistaMano extends ScrollPane {

    ControladorMano controladorMano;

    public VistaMano() {

        this.controladorMano = new ControladorMano();
        this.setMaxWidth(535);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);

        GridPane mano = new GridPane();
        mano.setGridLinesVisible(true);
        int i;
        for (i = 0; i <= 10; i++) {
            VistaCarta carta = new VistaCarta();
            mano.add(carta, i, 0);
        }
        this.setContent(mano);
    }

    public void agregarImagenAMano() {}
}
