package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.controladores.ControladorCantidadDeSacrificios;
import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.*;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ControladorBocaAbajoEnMano implements EventHandler<ActionEvent> {

    private VistaCarta vistaCarta;
    private Jugador jugador;
    private Carta carta;
    private VistaMano vistaMano;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaCartaCampo vistaCartaCampo;
    private ControladorDeTurnos controladorTurnos;

    public ControladorBocaAbajoEnMano(VistaCarta vistaCarta, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo) {
        this.vistaCarta = vistaCarta;
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        controladorTurnos = ControladorDeTurnos.getInstancia();

    }

    @Override
    public void handle(ActionEvent event) {
        Monstruo[] monstruosASacrificar = ControladorCantidadDeSacrificios.getMonstruosASacrificar();

        // !!!! salta excepción de que no se pueden colocar más cartas (jugador inhabilitado), mostrar mensaje.
        try {
            jugador.colocarCartaEnCampo(carta, new BocaAbajo(), monstruosASacrificar);
            controladorTurnos.actualizarTablero();
        } catch (CampoNoPermiteColocarCartaExcepcion e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("El campo está lleno!");
            error.show();
        }
    }
}
