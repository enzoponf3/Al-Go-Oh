package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;

import java.util.LinkedList;
import java.util.List;

public class EfectoNulo extends EfectoCarta {

    @Override
    public void activar(Juego juego, Carta carta) {
        // no hace nada
    }

}
