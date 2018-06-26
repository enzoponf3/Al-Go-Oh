package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.jugador.Jugador;

public class SliferElDragonDelCielo extends Monstruo {

    public SliferElDragonDelCielo(Jugador jugador) {
        super("Slifer el Dragon del Cielo", 8000, 8000, 10, new EfectoNulo());
        setJugador(jugador);
    }
}

