package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

public interface ResultadoCombate {

    public void afectarDefensor(Monstruo defensor);

    public void afectarAtacante(Monstruo atacante);
}
