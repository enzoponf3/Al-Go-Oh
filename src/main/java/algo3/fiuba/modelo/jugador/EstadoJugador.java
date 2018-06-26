package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;

public interface EstadoJugador {

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego);

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, NoMonstruo carta, EnJuego tipoEnJuego);

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, CartaCampo carta, EnJuego tipoEnJuego);

    EstadoJugador cambioDeTurno();

}
