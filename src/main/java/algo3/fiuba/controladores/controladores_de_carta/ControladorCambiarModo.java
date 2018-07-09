package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.vista.vista_cartas.MonstruoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorCambiarModo implements EventHandler<ActionEvent> {

    private Monstruo monstruo;
    private MonstruoVista monstruoVista;

    private ControladorDeTurnos controladorDeTurnos;

    public ControladorCambiarModo(Monstruo monstruo, MonstruoVista monstruoVista) {
        this.monstruo = monstruo;
        this.monstruoVista = monstruoVista;

        controladorDeTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent event) {
        monstruo.cambiarModo();
        controladorDeTurnos.actualizarTablero();
    }
}
