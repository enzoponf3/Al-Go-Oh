package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class CabezaExodia extends Exodia{

    public CabezaExodia(Jugador jugador) {

        super("Exodia, el prohibido", 1000, 1000, 3, jugador);
        setJugador(jugador);
    }
}
