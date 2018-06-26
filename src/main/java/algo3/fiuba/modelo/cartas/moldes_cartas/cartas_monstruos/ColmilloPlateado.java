package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class ColmilloPlateado extends Monstruo {

    public ColmilloPlateado(Jugador jugador) {

        super("Colmillo Plateado", 1200, 800, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
