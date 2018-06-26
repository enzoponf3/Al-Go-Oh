package algo3.fiuba.modelo.resultado_combate;

import algo3.fiuba.modelo.cartas.Monstruo;

public class ResultadoCombateNulo implements ResultadoCombate {

    @Override
    public void afectarDefensor(Monstruo defensor) {
        return;
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        return;
    }
}
