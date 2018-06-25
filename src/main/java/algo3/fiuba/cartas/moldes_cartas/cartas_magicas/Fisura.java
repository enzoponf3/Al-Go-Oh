package algo3.fiuba.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.efectos.EfectoFisura;

public class Fisura extends Magica {
    public Fisura(Jugador jugador) {
        super("Fisura", new EfectoFisura(jugador.getOponente()));
        setJugador(jugador);
    }
}
