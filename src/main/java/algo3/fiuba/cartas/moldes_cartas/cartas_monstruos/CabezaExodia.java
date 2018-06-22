package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.moldes_cartas.Exodia;

public class CabezaExodia extends Exodia {

    public CabezaExodia(Jugador jugador) {

        super("Exodia, el prohibido", 1000, 1000, 3, jugador);
        setJugador(jugador);
    }
}
