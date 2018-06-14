package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

public class PierdeContraModoAtaque implements ResultadoCombate {

    private Integer diferenciaPuntos;

    public PierdeContraModoAtaque(Integer diferenciaPuntos) {
        this.diferenciaPuntos = diferenciaPuntos;
    }

    @Override
    public void afectarDefensor(Monstruo defensor) {
        // no afecta al defensor
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        atacante.matarMonstruo();
        atacante.daniarJugador(diferenciaPuntos);
    }
}
