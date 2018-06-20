package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class SevenColoredFish extends Monstruo {

    public SevenColoredFish(Jugador jugador) {
        super("7 Colored Fish", 1800, 800, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
