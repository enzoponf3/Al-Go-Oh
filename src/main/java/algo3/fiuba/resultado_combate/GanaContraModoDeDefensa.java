package algo3.fiuba.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

public class GanaContraModoDeDefensa implements ResultadoCombate {

    @Override
    public void afectarDefensor(Monstruo defensor) {
        defensor.mandarDelCampoAlCementerio();
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        // no afecta al atacante
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GanaContraModoDeDefensa that = (GanaContraModoDeDefensa) o;
        return true;
    }

}
