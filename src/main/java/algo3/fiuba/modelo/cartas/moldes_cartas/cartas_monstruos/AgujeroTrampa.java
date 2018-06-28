package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class AgujeroTrampa extends Monstruo {

    public AgujeroTrampa(Jugador jugador) {
        super("Agujero Trampa", 1800, 800, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
