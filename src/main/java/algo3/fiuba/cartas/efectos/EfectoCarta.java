package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;
import java.util.List;

public abstract class EfectoCarta {

    public void activar(Juego juego, Carta carta) {
        return;
    }

    public void activar(Carta carta) {
        return;
    }

    public void activar(Carta carta, Monstruo otraCarta) {
        return;
    }

}
