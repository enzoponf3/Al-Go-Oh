package algo3.fiuba.vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class VistaZonaCartas extends HBox {

    public VistaZonaCartas() {

        this.setSpacing(20);
    }

    public void agregarCarta(ImageView carta) {

        // LO MAS PROBABLE ES QUE SEA UNA VISTA CARTA PERO LPM
        this.getChildren().add(carta);
        this.setHgrow(carta, Priority.ALWAYS);
    }

    public void reemplazarCarta() {

        //this.getChildren().remove(/*ver indice*/);
        //this.getChildren().add(/*añadir con indice*/)
    }
}
