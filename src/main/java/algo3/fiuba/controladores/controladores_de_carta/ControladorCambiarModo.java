package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Monstruo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorCambiarModo implements EventHandler<ActionEvent> {

    private Monstruo monstruo;

    private ControladorDeTurnos controladorDeTurnos;

    public ControladorCambiarModo(Monstruo monstruo) {
        this.monstruo = monstruo;
        controladorDeTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent event) {
        monstruo.cambiarModo();
        controladorDeTurnos.actualizarTablero();
    }
}
