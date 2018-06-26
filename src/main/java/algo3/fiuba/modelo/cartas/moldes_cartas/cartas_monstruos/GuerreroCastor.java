package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class GuerreroCastor extends Monstruo {

    public GuerreroCastor(Jugador jugador) {

        super("Guerrero Castor", 1200, 1500, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
