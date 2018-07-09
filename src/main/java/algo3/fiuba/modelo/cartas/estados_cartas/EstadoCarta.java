package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

import java.util.List;

public interface EstadoCarta {

    boolean estaEnJuego();

    void verificarQuePuedeAtacar();

    void activarEfecto(Carta carta, EfectoCarta efecto);

    void activarEfecto(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2, EfectoCarta efecto);

    void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo defensor, EfectoCarta efecto);

    void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto);

    void recibirAtaque(Monstruo carta);

    void recibirAtaque(NoMonstruo carta);

    EstadoCarta girarCarta();

    boolean estaBocaAbajo();

    boolean estaEnMazo();

    List<AccionCarta> accionesDisponibles(Monstruo carta);

    List<AccionCarta> accionesDisponibles(Magica carta);

    List<AccionCarta> accionesDisponibles(Trampa carta);

    List<AccionCarta> accionesDisponibles(CartaCampo carta);
}
