package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.VistaInformacionCartaEnJuego;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorCambiarModo implements EventHandler<ActionEvent> {

    private VistaCarta vistaCarta;
    private Carta carta;
    private VistaZonaMonstruos vistaZonaMonstruos;

    public ControladorCambiarModo(VistaCarta vistaCarta, Carta carta, VistaZonaMonstruos vistaZonaMonstruos) {
        this.vistaCarta = vistaCarta;
        this.carta = carta;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
    }

    @Override
    public void handle(ActionEvent event) {
        ((Monstruo)carta).cambiarModo();

    }
}
