package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class SoldadoGiganteDePiedra extends Monstruo {

    public SoldadoGiganteDePiedra(Jugador jugador) {

        super("Soldado gigante de piedra", 1300, 2000, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
