package algo3.fiuba.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.efectos.EfectoFisura;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class Fisura extends Magica {
    public Fisura(Jugador jugador) {
        super("Fisura", new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoFisura(jugador));
    }
}
