package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorGirarCarta implements EventHandler<ActionEvent> {

    private Carta carta;

    private ControladorDeTurnos controladorTurnos;

    public ControladorGirarCarta(Carta carta) {
        this.carta = carta;
        controladorTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent event) {
        carta.girarCarta();
        controladorTurnos.actualizarTablero();
    }
}
