package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.moldes_cartas.Exodia;

public class PiernaDerechaExodia extends Exodia {

    public PiernaDerechaExodia(Jugador jugador) {

        super("Pierna derecha del prohibido", 200, 300, 1, jugador);
        setJugador(jugador);
    }
}
