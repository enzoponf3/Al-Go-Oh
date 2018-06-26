package algo3.fiuba.jugador;

import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

public interface EstadoJugador {

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego);

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, NoMonstruo carta, EnJuego tipoEnJuego);

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, CartaCampo carta, EnJuego tipoEnJuego);

    EstadoJugador cambioDeTurno();

}
