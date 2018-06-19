package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoJinzo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class Jinzo extends Monstruo {

    public Jinzo(Jugador jugador) {
        super("Jinzo #7", 500, 400, 2, new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoJinzo(null, getAtaque()));
    }
}
