package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;

public class PiernaDerechaExodia extends Monstruo {

    public PiernaDerechaExodia(Jugador jugador) {
        super("Pierna derecha del prohibido", 200, 300, 1,new EfectoPartesExodia(jugador.getOponente()));
        setJugador(jugador);
    }
}
