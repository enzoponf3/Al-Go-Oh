package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;

public class EfectoSogen extends EfectoCarta{

    @Override
    public void activar(Juego juego, Carta carta) {
        juego.activarEfecto(this, carta);
    }
}
