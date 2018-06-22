package algo3.fiuba.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.efectos.EfectoSogen;
import algo3.fiuba.cartas.efectos.EfectoWasteland;

public class Sogen extends CartaCampo {
    public Sogen(Jugador jugador, Jugador oponente) {
        super("Sogen", new EfectoSogen(jugador, oponente));
        setJugador(jugador);
    }
}
