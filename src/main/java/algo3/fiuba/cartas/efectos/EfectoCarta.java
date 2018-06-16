package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;
import java.util.List;

public interface EfectoCarta {

    void activar(Tablero tablero);

    void activar(List<Monstruo> monstruo);
}
