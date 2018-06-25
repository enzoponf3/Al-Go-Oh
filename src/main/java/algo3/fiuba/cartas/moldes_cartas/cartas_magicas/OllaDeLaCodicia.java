package algo3.fiuba.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.efectos.EfectoOllaDeLaCodicia;

public class OllaDeLaCodicia extends Magica {

    public OllaDeLaCodicia(Jugador jugador) {
        super("Olla de la Codicia", new EfectoNulo());
        setJugador(jugador);
        setEfecto(new EfectoOllaDeLaCodicia(jugador));
    }


}
