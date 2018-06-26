package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;

public class PreInvocacion implements EstadoJugador {

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        carta.setJugador(jugador);
        return new PostInvocacion();
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, NoMonstruo carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        carta.setJugador(jugador);
        return new PreInvocacion();
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, CartaCampo carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        carta.setJugador(jugador);
        return new PreInvocacion();
    }

    @Override
    public EstadoJugador cambioDeTurno() {
        return new TurnoDelOponente();
    }
}
