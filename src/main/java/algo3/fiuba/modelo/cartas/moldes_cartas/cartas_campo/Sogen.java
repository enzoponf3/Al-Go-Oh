package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.efectos.EfectoSogen;

public class Sogen extends CartaCampo {

    public Sogen(Jugador jugador) {
        super("Sogen", new EfectoNulo());
        super.setEfecto(new EfectoSogen(this, jugador));
        setJugador(jugador);
    }
}
