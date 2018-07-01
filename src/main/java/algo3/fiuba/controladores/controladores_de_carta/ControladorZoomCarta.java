package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.vista.VistaProyeccionCarta;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorZoomCarta implements EventHandler<MouseEvent> {
    private String imageUrl;
    VistaProyeccionCarta vistaProyeccionCarta;

    public ControladorZoomCarta(String imageUrl) {
        this.imageUrl = imageUrl;
        vistaProyeccionCarta = VistaProyeccionCarta.getInstancia();
    }

    public ControladorZoomCarta() {
        this.imageUrl = "/algo3/fiuba/resources/img/carta-vista-trasera.png";
        vistaProyeccionCarta = VistaProyeccionCarta.getInstancia();
    }


    @Override
    public void handle(MouseEvent event) {
        vistaProyeccionCarta.zoomImg(imageUrl);
        vistaProyeccionCarta.update();
    }
}
