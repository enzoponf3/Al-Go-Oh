package algo3.fiuba.modelo.resultado_combate;

import algo3.fiuba.modelo.cartas.Monstruo;

public class EmpataContraModoDeAtaque implements ResultadoCombate {

    @Override
    public void afectarDefensor(Monstruo defensor) {
        defensor.mandarDelCampoAlCementerio();
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        atacante.mandarDelCampoAlCementerio();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpataContraModoDeAtaque that = (EmpataContraModoDeAtaque) o;
        return true;
    }
}
