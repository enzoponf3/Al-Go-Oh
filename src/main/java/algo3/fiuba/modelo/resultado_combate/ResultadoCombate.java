package algo3.fiuba.modelo.resultado_combate;

import algo3.fiuba.modelo.cartas.Monstruo;

public interface ResultadoCombate {

    void afectarDefensor(Monstruo defensor);

    void afectarAtacante(Monstruo atacante);
}
