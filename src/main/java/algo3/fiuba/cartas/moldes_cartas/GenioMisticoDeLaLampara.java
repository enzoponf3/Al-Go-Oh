package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class GenioMisticoDeLaLampara extends Monstruo {

    public GenioMisticoDeLaLampara(Jugador jugador) {

        super("Genio mistico de la lámpara", 1800, 1000, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
