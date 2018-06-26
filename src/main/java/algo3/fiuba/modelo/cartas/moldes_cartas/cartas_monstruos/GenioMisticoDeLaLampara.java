package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class GenioMisticoDeLaLampara extends Monstruo {

    public GenioMisticoDeLaLampara(Jugador jugador) {

        super("Genio mistico de la lámpara", 1800, 1000, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
