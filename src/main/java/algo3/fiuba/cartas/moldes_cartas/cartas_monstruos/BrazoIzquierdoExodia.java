package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;

public class BrazoIzquierdoExodia extends Monstruo {

    public BrazoIzquierdoExodia(Jugador jugador) {

        super("Brazo izquierdo del prohibido", 200, 300, 1, EfectoPartesExodia.getInstancia());
        setJugador(jugador);
    }
}

