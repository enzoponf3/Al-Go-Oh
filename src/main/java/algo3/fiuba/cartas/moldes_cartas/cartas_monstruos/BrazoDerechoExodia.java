package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.moldes_cartas.Exodia;

public class BrazoDerechoExodia extends Exodia {

    public BrazoDerechoExodia(Jugador jugador) {

        super("Brazo derecho del prohibido", 200, 300, 1, jugador);
        setJugador(jugador);
    }
}
