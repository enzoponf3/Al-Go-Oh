package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.jugador.Jugador;

public class ObeliscoElAtormentador extends Monstruo {

    public ObeliscoElAtormentador(Jugador jugador) {
        super("Obelisco el Atormentador", 4000, 4000, 10, new EfectoNulo());
        setJugador(jugador);
    }
}

