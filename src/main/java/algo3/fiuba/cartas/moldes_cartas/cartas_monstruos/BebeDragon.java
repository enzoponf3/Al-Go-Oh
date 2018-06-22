package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class BebeDragon extends Monstruo {

    public BebeDragon(Jugador jugador) {

        super("Bebé Dragón", 1200, 700, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
