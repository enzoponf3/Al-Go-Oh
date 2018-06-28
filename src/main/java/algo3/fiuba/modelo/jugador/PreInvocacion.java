package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;

public class PreInvocacion implements EstadoJugador {

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        carta.setJugador(jugador);
        return new PostInvocacion();
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Magica carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        carta.setJugador(jugador);
        return new PreInvocacion();
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Trampa carta, EnJuego tipoEnJuego) {
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
