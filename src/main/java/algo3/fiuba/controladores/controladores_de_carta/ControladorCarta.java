package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.estados_cartas.EnMano;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.*;
import algo3.fiuba.vista.vista_tablero.VistaCartaCampo;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorCarta implements EventHandler<MouseEvent> {

    private VistaInformacionCartaEnMano vistaInformacionCartaEnMano;
    private VistaInformacionCartaEnJuego vistaInformacionCartaEnJuego;
    private Carta carta;

    public ControladorCarta(VistaCarta vistaCarta, Jugador jugador, Carta carta) {
        this.carta = carta;
        this.vistaInformacionCartaEnMano = new VistaInformacionCartaEnMano(vistaCarta, jugador, carta);
        this.vistaInformacionCartaEnJuego = new VistaInformacionCartaEnJuego(vistaCarta, jugador, carta);
    }

    @Override
    public void handle(MouseEvent evento) {
        if (carta.getEstadoCarta() instanceof EnMano) {
            vistaInformacionCartaEnMano.update(evento);
        } else if (carta.getEstadoCarta() instanceof EnJuego) {
            vistaInformacionCartaEnJuego.update(evento);
        }
    }

}
