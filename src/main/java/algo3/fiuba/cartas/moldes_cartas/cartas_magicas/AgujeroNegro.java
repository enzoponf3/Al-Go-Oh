package algo3.fiuba.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.efectos.EfectoAgujeroNegro;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class AgujeroNegro extends Magica {
    public AgujeroNegro(Jugador jugador) {
        super("Agujero Negro", new EfectoNulo());
        setJugador(jugador);
        this.setEfecto(new EfectoAgujeroNegro(jugador, jugador.getOponente()));
    }
}
