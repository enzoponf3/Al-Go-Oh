package algo3.fiuba.modelo.cartas.moldes_cartas;

import algo3.fiuba.modelo.cartas.AccionCarta;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

import java.util.LinkedList;
import java.util.List;

public class NoMonstruoNulo extends NoMonstruo {

    public NoMonstruoNulo() {
        super("Monstruo Nulo", new EfectoNulo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public boolean activarTrampa() {
        return false;
    }

    @Override
    public boolean negarAtaque() {
        return false;
    }

    @Override
    public List<AccionCarta> accionesDisponibles() {
        return new LinkedList<>();
    }

}
