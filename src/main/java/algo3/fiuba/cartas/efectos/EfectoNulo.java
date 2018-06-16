package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;
import java.util.List;

public class EfectoNulo implements EfectoCarta {

    @Override
    public void activar(Tablero tablero) {
        // no hace nada
    }

    @Override
    public void activar(List<Monstruo> monstruo) {
        // no hace nada
    }
}
