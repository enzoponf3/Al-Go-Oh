package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorCantidadDeSacrificios;
import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.vista_tablero.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public abstract class ControladorColocarCarta implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Carta carta;
    private VistaZoomEfectoMagica vistaZoomEfectoMagica;


    private ControladorDeTurnos controladorTurnos;

    public ControladorColocarCarta(VistaCarta vistaCarta, Jugador jugador, Carta carta) {
        this.jugador = jugador;
        this.carta = carta;
        controladorTurnos = ControladorDeTurnos.getInstancia();
        this.vistaZoomEfectoMagica = new VistaZoomEfectoMagica(vistaCarta);
    }

    @Override
    public void handle(ActionEvent event) {
        Monstruo[] monstruosASacrificar = ControladorCantidadDeSacrificios.getMonstruosASacrificar();

        try {
            jugador.colocarCartaEnCampo(carta, this.tipoEnJuego(), monstruosASacrificar);
            if(carta instanceof Magica && this.tipoEnJuego() instanceof BocaArriba) {
                vistaZoomEfectoMagica.update();
            }
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
