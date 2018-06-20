package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public interface EstadoCarta {

    boolean estaEnJuego();

    void verificarQuePuedeAtacar();

    void activarEfecto(Juego juego, Carta carta, EfectoCarta efecto);

    void recibirAtaque(Monstruo carta);

    void recibirAtaque(NoMonstruo carta);
}
