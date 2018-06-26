package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.jugador.Jugador;

public class ElDragonAladoDeRa extends Monstruo {

    public ElDragonAladoDeRa(Jugador jugador) {
        super("El Dragon Alado de Ra", 8000, 8000, 10, new EfectoNulo());
        setJugador(jugador);
    }
}
