package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

public interface EstadoCarta {

    boolean estaEnJuego();

    void verificarQuePuedeAtacar();

    void activarEfecto(Carta carta, EfectoCarta efecto);

    void activarEfecto(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2, EfectoCarta efecto);

    void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo defensor, EfectoCarta efecto);

    void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto);

    void recibirAtaque(Monstruo carta);

    void recibirAtaque(NoMonstruo carta);
}
