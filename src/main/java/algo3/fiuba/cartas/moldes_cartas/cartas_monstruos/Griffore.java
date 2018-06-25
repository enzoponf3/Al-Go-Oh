package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class Griffore extends Monstruo {

    public Griffore(Jugador jugador) {

        super("Griffore", 1200, 1500, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
