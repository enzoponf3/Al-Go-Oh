package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class Kuriboh extends Monstruo {

    public Kuriboh(Jugador jugador) {
        super("Kuriboh", 300, 200, 1, new EfectoNulo());
        setJugador(jugador);
    }
}
