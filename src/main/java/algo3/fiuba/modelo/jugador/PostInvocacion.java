package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.excepciones.JugadorInhabilitadoParaColocarCartasExcepcion;

public class PostInvocacion implements EstadoJugador {

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego) {
        throw new JugadorInhabilitadoParaColocarCartasExcepcion("Ya no puede invocar más cartas en el campo.");
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, NoMonstruo carta, EnJuego tipoEnJuego) {
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
}
