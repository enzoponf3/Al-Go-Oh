package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoJinzo7;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class Jinzo7 extends Monstruo {

    public Jinzo7(Jugador jugador) {
        super("Jinzo7 #7", 500, 400, 2, new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoJinzo7(jugador.getOponente(), getAtaque()));
    }
}
