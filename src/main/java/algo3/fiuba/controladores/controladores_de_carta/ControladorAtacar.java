package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorAtacar implements EventHandler<ActionEvent> {

    private final VistaZonaMonstruos vistaZonaMonstruo;
    private final VistaCarta vistaCarta;
    private final Carta monstruo;
    private final Jugador jugador;

    public ControladorAtacar(VistaCarta vistaCarta, Carta monstruo, VistaZonaMonstruos vistaZonaMonstruos, Jugador jugador) {
        this.vistaCarta = vistaCarta;
        this.monstruo = monstruo;
        this.jugador = jugador;
        this.vistaZonaMonstruo = vistaZonaMonstruos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
