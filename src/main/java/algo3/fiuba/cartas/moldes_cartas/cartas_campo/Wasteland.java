package algo3.fiuba.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoWasteland;

public class Wasteland extends CartaCampo {
    public Wasteland(Jugador jugador, Jugador oponente) {
        super("Wasteland", new EfectoWasteland(jugador, oponente));
        setJugador(jugador);
    }
}
