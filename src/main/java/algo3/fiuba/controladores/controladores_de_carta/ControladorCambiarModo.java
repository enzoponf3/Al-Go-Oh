package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorCambiarModo implements EventHandler<ActionEvent> {

    private Carta carta;

    private ControladorDeTurnos controladorDeTurnos;

    public ControladorCambiarModo(VistaCarta vistaCarta, Carta carta, VistaZonaMonstruos vistaZonaMonstruos) {
        this.carta = carta;
        controladorDeTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent event) {
        ((Monstruo)carta).cambiarModo();
        controladorDeTurnos.actualizarTablero();
    }
}
