package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class GuerreroCastor extends Monstruo {

    public GuerreroCastor(Jugador jugador) {

        super("Guerrero Castor", 1200, 1500, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
