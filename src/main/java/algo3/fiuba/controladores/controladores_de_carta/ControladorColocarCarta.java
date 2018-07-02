package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorCantidadDeSacrificios;
import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public abstract class ControladorColocarCarta implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Carta carta;

    private ControladorDeTurnos controladorTurnos;

    public ControladorColocarCarta(Jugador jugador, Carta carta) {
        this.jugador = jugador;
        this.carta = carta;
        controladorTurnos = ControladorDeTurnos.getInstancia();
    }

    @Override
    public void handle(ActionEvent event) {
        Monstruo[] monstruosASacrificar = ControladorCantidadDeSacrificios.getMonstruosASacrificar();

        try {
            jugador.colocarCartaEnCampo(carta, this.tipoEnJuego(), monstruosASacrificar);
            controladorTurnos.actualizarTablero();
        } catch (Exception e) {
            Alert invocacionInvalidaAlert = new Alert(Alert.AlertType.WARNING);
            invocacionInvalidaAlert .setHeaderText(null);
            invocacionInvalidaAlert .setContentText(e.getMessage());
            invocacionInvalidaAlert .show();
        }
    }

    public abstract EnJuego tipoEnJuego();
}
