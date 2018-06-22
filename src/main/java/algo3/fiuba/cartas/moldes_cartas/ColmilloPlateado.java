package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class ColmilloPlateado extends Monstruo {

    public ColmilloPlateado(Jugador jugador) {

        super("Colmillo Plateado", 1200, 800, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
