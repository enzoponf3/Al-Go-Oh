package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.efectos.EfectoFisura;

public class Fisura extends Magica {
    public Fisura(Jugador jugador) {
        super("Fisura", new EfectoFisura(jugador.getOponente()));
        setJugador(jugador);
    }
}
