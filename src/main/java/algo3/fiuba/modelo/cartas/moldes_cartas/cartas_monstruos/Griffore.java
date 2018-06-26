package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class Griffore extends Monstruo {

    public Griffore(Jugador jugador) {

        super("Griffore", 1200, 1500, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
