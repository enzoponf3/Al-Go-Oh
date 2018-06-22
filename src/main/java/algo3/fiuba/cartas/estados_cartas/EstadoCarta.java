package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;

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
