package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

public class PierdeContraModoDefensa implements ResultadoCombate {

    private Integer diferenciaPuntos;

    public PierdeContraModoDefensa(Integer diferenciaPuntos) {
        this.diferenciaPuntos = diferenciaPuntos;
    }

    @Override
    public void afectarDefensor(Monstruo defensor) {

    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        atacante.daniarJugador(diferenciaPuntos);
    }
}
