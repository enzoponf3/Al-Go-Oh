package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.jugador.Jugador;

public class SliferElDragonDelCielo extends Monstruo {

    public SliferElDragonDelCielo(Jugador jugador) {
        super("Slifer el Dragon del Cielo", 8000, 8000, 10, new EfectoNulo());
        setJugador(jugador);
    }
}

