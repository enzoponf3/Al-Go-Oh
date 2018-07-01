package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.excepciones.JugadorInhabilitadoParaColocarCartasExcepcion;

public class PostInvocacion implements EstadoJugador {

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("Ya no puede invocar más cartas en el campo.");
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Magica carta, EnJuego tipoEnJuego) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("Ya no puede invocar más cartas en el campo.");
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Trampa carta, EnJuego tipoEnJuego) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("Ya no puede invocar más cartas en el campo.");
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, CartaCampo carta, EnJuego tipoEnJuego) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("Ya no puede invocar más cartas en el campo.");
    }

    @Override
    public EstadoJugador cambioDeTurno() {
        return new TurnoDelOponente();
    }

    @Override
    public EstadoJugador cambioDeFase() {
        return new TurnoDelOponente();
    }
}
