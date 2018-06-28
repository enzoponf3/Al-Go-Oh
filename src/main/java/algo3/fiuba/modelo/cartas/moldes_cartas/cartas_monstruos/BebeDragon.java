package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class BebeDragon extends Monstruo {

    public BebeDragon(Jugador jugador) {

        super("Bebe Dragon", 1200, 700, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
