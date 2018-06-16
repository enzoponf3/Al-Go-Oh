package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

public class EmpataContraModoAtaque implements ResultadoCombate {

    @Override
    public void afectarDefensor(Monstruo defensor) {
        defensor.descartar();
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        atacante.descartar();
    }
}
