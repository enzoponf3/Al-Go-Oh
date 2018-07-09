package algo3.fiuba.modelo.jugador;

import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;

import java.util.LinkedList;
import java.util.List;

import static algo3.fiuba.modelo.jugador.AccionJugador.TERMINAR_TURNO;

public class PreInvocacion implements EstadoJugador {

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Monstruo carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        jugador.sacarCartaDeMano(carta);
        return new PostInvocacion();
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Magica carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        jugador.sacarCartaDeMano(carta);
        return new PreInvocacion();
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, Trampa carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        jugador.sacarCartaDeMano(carta);
        return new PreInvocacion();
    }

    @Override
    public EstadoJugador colocarCartaEnCampo(Jugador jugador, TableroJugador tableroJugador, CartaCampo carta, EnJuego tipoEnJuego) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego);
        jugador.sacarCartaDeMano(carta);
        return new PreInvocacion();
    }

    @Override
    public EstadoJugador cambioDeTurno() {
        return new TurnoDelOponente();
    }

    @Override
    public List<AccionJugador> accionesJugadorDisponibles() {
        List<AccionJugador> acciones = new LinkedList<>();
        acciones.add(AccionJugador.COLOCAR_MONSTRUO);
        acciones.add(AccionJugador.COLOCAR_DISTINTA_A_MONSTRUO);
        acciones.add(AccionJugador.TERMINAR_TURNO);

        return acciones;
    }
}
