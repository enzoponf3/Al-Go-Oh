package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class PezDe7Colores extends Monstruo {

    public PezDe7Colores(Jugador jugador) {
        super("Pez de 7 Colores", 1800, 800, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
