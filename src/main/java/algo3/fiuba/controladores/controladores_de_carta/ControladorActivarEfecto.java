package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorActivarEfecto implements EventHandler<ActionEvent> {

    private Carta carta;
    private ControladorDeTurnos controladorDeTurnos;

    public ControladorActivarEfecto(Carta carta) {
        this.carta = carta;
        this.controladorDeTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent event) {
        carta.activarEfecto();
        controladorDeTurnos.actualizarTablero();
    }
}
