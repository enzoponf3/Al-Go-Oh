package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;
import algo3.fiuba.modelo.cartas.efectos.EfectoOllaDeLaCodicia;

public class OllaDeLaCodicia extends Magica {

    public OllaDeLaCodicia(Jugador jugador) {
        super("Olla de la Codicia", new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoOllaDeLaCodicia(jugador));
    }


}
