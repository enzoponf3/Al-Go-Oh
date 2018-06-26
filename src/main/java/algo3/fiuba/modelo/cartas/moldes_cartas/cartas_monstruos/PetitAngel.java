package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class PetitAngel extends Monstruo {

    public PetitAngel(Jugador jugador) {

        super("Petit Angel", 600, 900, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
