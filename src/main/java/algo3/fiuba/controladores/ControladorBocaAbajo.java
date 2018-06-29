package algo3.fiuba.controladores;

import algo3.fiuba.vista.VistaInformacionCarta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorModoDefensa implements EventHandler<ActionEvent> {

    private VistaInformacionCarta vistaInformacionCarta;

    public ControladorModoDefensa(VistaInformacionCarta vistaInformacionCarta) {
        this.vistaInformacionCarta = vistaInformacionCarta;
    }

    @Override
    public void handle(ActionEvent event) {
        vistaInformacionCarta.update();
    }
}
