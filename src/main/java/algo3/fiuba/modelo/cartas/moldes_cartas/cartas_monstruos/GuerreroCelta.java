package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class GuerreroCelta extends Monstruo {

    public GuerreroCelta(Jugador jugador) {

        super("Guerrero Celta", 1400, 1200, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
