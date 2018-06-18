package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public interface EstadoCarta {

    boolean estaEnJuego();

    void verificarQuePuedeAtacar();

    void activar(Juego juego, Carta carta, EfectoCarta efecto);
}
