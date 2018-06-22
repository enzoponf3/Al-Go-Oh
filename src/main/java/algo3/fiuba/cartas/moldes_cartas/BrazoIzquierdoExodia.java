package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;

public class BrazoIzquierdoExodia extends Exodia {

    public BrazoIzquierdoExodia(Jugador jugador) {

        super("Brazo izquierdo del prohibido", 200, 300, 1, jugador);
        setJugador(jugador);
    }
}

