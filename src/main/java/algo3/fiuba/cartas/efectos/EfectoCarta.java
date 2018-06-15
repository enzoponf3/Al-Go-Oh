package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;

public interface EfectoCarta {

    void activar(Tablero tablero);

    void activar(LinkedList<Monstruo> monstruo);
}
