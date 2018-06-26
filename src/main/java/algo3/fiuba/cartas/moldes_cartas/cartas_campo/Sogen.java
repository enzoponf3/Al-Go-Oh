package algo3.fiuba.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.efectos.EfectoSogen;

public class Sogen extends CartaCampo {

    public Sogen(Jugador jugador) {
        super("Sogen", new EfectoSogen(jugador, jugador.getOponente()));
        setJugador(jugador);
    }
}
