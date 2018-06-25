package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class MagoOscuro extends Monstruo {

    public MagoOscuro(Jugador jugador) {
        super("Mago Oscuro", 2500, 2100, 7, new EfectoNulo());
        setJugador(jugador);
    }
}
