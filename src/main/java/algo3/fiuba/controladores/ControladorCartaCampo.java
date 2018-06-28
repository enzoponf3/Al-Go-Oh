package algo3.fiuba.controladores;

import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.vista.VistaCartaCampo;
import algo3.fiuba.vista.VistaMano;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class ControladorCartaCampo implements EventHandler<MouseEvent> {
    private VistaCartaCampo vistaCartaCampo;
    private VistaMano vistaMano;
    private Jugador jugador;

    public ControladorCartaCampo(VistaCartaCampo zonaCartaDeCampo, Jugador jugador, VistaMano zonaMano) {
        this.vistaCartaCampo = zonaCartaDeCampo;
        this.vistaMano = zonaMano;
        this.jugador = jugador;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        // No hace nada... Por ver
    }
}
