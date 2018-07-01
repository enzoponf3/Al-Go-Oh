package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorActivarEfecto implements EventHandler<ActionEvent> {
    private Carta carta;

    public ControladorActivarEfecto(Carta carta) {
        this.carta = carta;
    }

    @Override
    public void handle(ActionEvent event) {
        if (carta instanceof Magica) carta.activarEfecto();
    }
}
