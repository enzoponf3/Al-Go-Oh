package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;

public class BrazoDerechoExodia extends Exodia {

    public BrazoDerechoExodia(Jugador jugador) {

        super("Brazo derecho del prohibido", 200, 300, 1, jugador);
        setJugador(jugador);
    }
}
