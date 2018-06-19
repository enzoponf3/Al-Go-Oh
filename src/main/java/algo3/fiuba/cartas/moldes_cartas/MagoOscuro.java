package algo3.fiuba.cartas.moldes_cartas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class MagoOscuro extends Monstruo {

    public MagoOscuro(Jugador jugador) {
        super("Mago Oscuro", 2500, 2100, 7, new EfectoNulo());
        setJugador(jugador);
    }
}
