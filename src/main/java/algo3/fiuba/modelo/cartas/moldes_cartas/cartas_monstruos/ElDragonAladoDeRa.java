package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.jugador.Jugador;

public class ElDragonAladoDeRa extends Monstruo {

    public ElDragonAladoDeRa(Jugador jugador) {
        super("El Dragon Alado de Ra", 8000, 8000, 10, new EfectoNulo());
        setJugador(jugador);
    }
}
