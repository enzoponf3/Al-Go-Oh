package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class MagoOscuro extends Monstruo {

    public MagoOscuro(Jugador jugador) {
        super("Mago Oscuro", 2500, 2100, 7, new EfectoNulo());
        setJugador(jugador);
    }
}
