package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

public class GanaContraModoAtaque implements ResultadoCombate {

    private Integer diferenciaPuntos;

    public GanaContraModoAtaque(Integer diferenciaPuntos) {
        this.diferenciaPuntos = diferenciaPuntos;
    }

    @Override
    public void afectarDefensor(Monstruo defensor) {
        defensor.descartar();
        defensor.daniarJugador(diferenciaPuntos);
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        // no afecta al atacante
    }
}
