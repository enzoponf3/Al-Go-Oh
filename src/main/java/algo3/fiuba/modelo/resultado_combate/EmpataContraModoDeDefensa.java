package algo3.fiuba.modelo.resultado_combate;

import algo3.fiuba.modelo.cartas.Monstruo;


public class EmpataContraModoDeDefensa implements ResultadoCombate {

    public EmpataContraModoDeDefensa() {
    }

    @Override
    public void afectarDefensor(Monstruo defensor) {
        // no afecta al defensor
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        // no afecta al atacante
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpataContraModoDeDefensa that = (EmpataContraModoDeDefensa) o;
        return true;
    }
}
