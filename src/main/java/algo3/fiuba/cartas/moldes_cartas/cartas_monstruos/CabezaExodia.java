package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;

public class CabezaExodia extends Monstruo {

    public CabezaExodia(Jugador jugador) {

        super("Exodia, el prohibido", 1000, 1000, 3, new EfectoPartesExodia(jugador));
        setJugador(jugador);
    }
}
