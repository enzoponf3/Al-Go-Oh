package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;

import java.util.List;

public interface EstadoJugador {

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego);

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Magica carta, EnJuego tipoEnJuego);

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Trampa carta, EnJuego tipoEnJuego);

    EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, CartaCampo carta, EnJuego tipoEnJuego);

    EstadoJugador cambioDeTurno();

    List<AccionJugador> accionesJugadorDisponibles();
}
