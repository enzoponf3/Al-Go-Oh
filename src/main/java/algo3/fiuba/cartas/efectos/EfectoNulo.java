package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;

public class EfectoNulo implements EfectoCarta {

    @Override
    public void activar(Tablero tablero) {
        // no hace nada
    }

    @Override
    public void activar(LinkedList<Monstruo> monstruo) {
        // no hace nada
    }
}
