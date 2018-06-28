package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.efectos.EfectoAgujeroNegro;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class AgujeroNegro extends Magica {
    public AgujeroNegro(Jugador jugador) {
        super("Agujero Oscuro", new EfectoNulo());
        setJugador(jugador);
        this.setEfecto(new EfectoAgujeroNegro(jugador, jugador.getOponente()));
    }
}
