package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.jugador.Jugador;

public class CraneoConvocado extends Monstruo {

    public CraneoConvocado(Jugador jugador) {
        super("Cráneo Convocado", 2500, 1200, 6, new EfectoNulo());
        super.setJugador(jugador);
    }
}
