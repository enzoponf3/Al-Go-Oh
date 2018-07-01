package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.VistaProyeccionCarta;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorZoomCarta implements EventHandler<MouseEvent> {

    private String imageUrl;
    private VistaProyeccionCarta vistaProyeccionCarta;
    private CartaVistaUtils cartaVistaUtils;

    public ControladorZoomCarta(String imageUrl) {
        this.imageUrl = imageUrl;
        vistaProyeccionCarta = VistaProyeccionCarta.getInstancia();

        cartaVistaUtils = new CartaVistaUtils();
    }

    public ControladorZoomCarta() {
        cartaVistaUtils = new CartaVistaUtils();

        this.imageUrl = cartaVistaUtils.getImagenCartaBocaAbajo();
        vistaProyeccionCarta = VistaProyeccionCarta.getInstancia();
    }


    @Override
    public void handle(MouseEvent event) {
        vistaProyeccionCarta.zoomImg(imageUrl);
        vistaProyeccionCarta.update();
    }
}
