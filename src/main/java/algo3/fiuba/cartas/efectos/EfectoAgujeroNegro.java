package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Monstruo;

import java.util.LinkedList;
import java.util.List;

public class EfectoAgujeroNegro implements EfectoCarta {
    @Override
    public void activar(Tablero tablero) {
        tablero.activarEfectoSobreElementos(this);
    }

    @Override
    public void activar(List<Monstruo> monstruos) {
        monstruos.clear();
    }
}
