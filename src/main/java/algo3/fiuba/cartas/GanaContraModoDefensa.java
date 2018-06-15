package algo3.fiuba.cartas;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;

public class GanaContraModoDefensa implements ResultadoCombate {

    @Override
    public void afectarDefensor(Monstruo defensor) {
        defensor.descartar();
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        // no afecta al atacante
    }
}
