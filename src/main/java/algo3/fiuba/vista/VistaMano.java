package algo3.fiuba.vista;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class VistaMano extends ScrollPane {

    public VistaMano() {

        this.setMaxWidth(535);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        GridPane mano = new GridPane();


        for (int i = 0; i <= 10; i++) {
            VistaCarta carta = new VistaCarta();
            mano.add(carta, i, 0);
        }
    }

    public void agregarImagenAmano() {}
}
