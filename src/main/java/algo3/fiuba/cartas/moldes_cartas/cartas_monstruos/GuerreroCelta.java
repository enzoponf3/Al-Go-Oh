package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class GuerreroCelta extends Monstruo {

    public GuerreroCelta(Jugador jugador) {

        super("Guerrero Celta", 1400, 1200, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
