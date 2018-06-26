package algo3.fiuba.cartas.moldes_cartas.cartas_campo;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.efectos.EfectoWasteland;

public class Wasteland extends CartaCampo {

    public Wasteland(Jugador jugador) {
        super("Wasteland", new EfectoWasteland(jugador, jugador.getOponente()));
        setJugador(jugador);
    }
}
