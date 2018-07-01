package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class AgujeroTrampa extends Trampa {

    public AgujeroTrampa(Jugador jugador) {
        super("Agujero Trampa", new EfectoNulo());
        setJugador(jugador);
    }
}
