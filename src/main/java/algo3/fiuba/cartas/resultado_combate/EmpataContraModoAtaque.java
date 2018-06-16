package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

import java.util.Objects;

public class EmpataContraModoAtaque implements ResultadoCombate {

    @Override
    public void afectarDefensor(Monstruo defensor) {
        defensor.descartar();
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        atacante.descartar();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpataContraModoAtaque that = (EmpataContraModoAtaque) o;
        return true;
    }
}
