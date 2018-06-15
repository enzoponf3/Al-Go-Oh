package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;

public class EfectoAgujeroNegro implements EfectoCarta {
    @Override
    public void activar(Tablero tablero) {
        tablero.activarEfectoSobreElementos(this);
    }

    @Override
    public void activar(LinkedList<Monstruo> monstruos) {
        monstruos.clear();
    }
}
