package algo3.fiuba.modelo.cartas.moldes_cartas;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class MonstruoNulo extends Monstruo {

    public MonstruoNulo() {
        super("Monstruo Nulo", 0, 0, 1, new EfectoNulo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
