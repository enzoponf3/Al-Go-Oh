package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class DiablilloSalvaje extends Monstruo{

    public DiablilloSalvaje(Jugador jugador) {

        super("Diablillo Salvaje", 1300, 1400, 4, new EfectoNulo());
        setJugador(jugador);
    }
}
