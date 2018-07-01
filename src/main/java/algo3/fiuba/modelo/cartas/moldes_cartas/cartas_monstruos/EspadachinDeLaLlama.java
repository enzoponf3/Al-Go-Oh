package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.jugador.Jugador;

public class EspadachinDeLaLlama extends Monstruo {

    public EspadachinDeLaLlama(Jugador jugador) {
        super("Espadachin de la Llama", 1800, 1600, 5, new EfectoNulo());
        setJugador(jugador);
    }
}
