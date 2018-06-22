package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.moldes_cartas.Exodia;

public class BrazoIzquierdoExodia extends Exodia {

    public BrazoIzquierdoExodia(Jugador jugador) {

        super("Brazo izquierdo del prohibido", 200, 300, 1, jugador);
        setJugador(jugador);
    }
}

