package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class PetitAngel extends Monstruo {

    public PetitAngel(Jugador jugador) {

        super("Petit Angel", 600, 900, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
