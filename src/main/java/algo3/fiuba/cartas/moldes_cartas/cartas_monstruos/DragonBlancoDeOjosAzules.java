package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoNulo;

public class DragonBlancoDeOjosAzules extends Monstruo {

    public DragonBlancoDeOjosAzules(Jugador jugador) {
        super("Dragon Blanco de Ojos Azules", 3000, 2500, 8, new EfectoNulo());
        setJugador(jugador);
    }
}
