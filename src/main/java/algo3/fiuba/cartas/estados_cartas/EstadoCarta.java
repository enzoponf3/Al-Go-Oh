package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.efectos.EfectoCarta;

public interface EstadoCarta {

    boolean estaEnJuego();

    void activar(Tablero tablero, EfectoCarta efecto);

    void verificarQuePuedeAtacar();
}
