package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Monstruo;

import java.util.List;

public class EfectoOllaDeLaCodicia implements EfectoCarta {
    @Override
    public void activar(Tablero tablero) {
        tablero.activarEfectoSobreElementos(this);
    }

    @Override
    public void activar(List<Monstruo> monstruo) {
        // no hace nada
    }
}
