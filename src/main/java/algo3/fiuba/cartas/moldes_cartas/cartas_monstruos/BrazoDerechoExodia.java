package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;

public class BrazoDerechoExodia extends Monstruo {

    public BrazoDerechoExodia(Jugador jugador) {

        super("Brazo derecho del prohibido", 200, 300, 1, EfectoPartesExodia.getInstancia());
        setJugador(jugador);
    }
}
