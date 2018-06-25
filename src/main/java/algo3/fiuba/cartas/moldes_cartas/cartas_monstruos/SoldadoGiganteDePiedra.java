package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class SoldadoGiganteDePiedra extends Monstruo {

    public SoldadoGiganteDePiedra(Jugador jugador) {

        super("Soldado gigante de piedra", 1300, 2000, 3, new EfectoNulo());
        setJugador(jugador);
    }
}
