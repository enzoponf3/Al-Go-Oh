package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class PiernaIzquierdaExodia extends Exodia{

    public PiernaIzquierdaExodia(Jugador jugador) {

        super("Pierna izquierda del prohibido", 200, 300, 1, jugador);
        setJugador(jugador);
    }
}
