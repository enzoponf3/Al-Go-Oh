package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorMano;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class VistaMano extends ScrollPane {

    ControladorMano controladorMano;

    public VistaMano() {

        this.controladorMano = new ControladorMano();
        this.setMaxWidth(535);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        GridPane mano = new GridPane();

        int i;
        for (i = 0; i <= 10; i++) {
            VistaCarta carta = new VistaCarta();
            mano.add(carta,0, 0);
        }
    }

    public void agregarImagenAmano() {}
}
