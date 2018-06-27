package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.jugador.Jugador;

public class ObeliscoElAtormentador extends Monstruo {

    public ObeliscoElAtormentador(Jugador jugador) {
        super("Obelisco el Atormentador", 4000, 4000, 10, new EfectoNulo());
        setJugador(jugador);
    }
}

