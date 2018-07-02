package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
        // No hace nada... Por ver, rta: no va a hacer nada, no se puede retirar...
    }
}
