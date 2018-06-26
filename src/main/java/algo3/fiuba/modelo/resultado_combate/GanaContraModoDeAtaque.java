package algo3.fiuba.modelo.resultado_combate;

import algo3.fiuba.modelo.cartas.Monstruo;

import java.util.Objects;

public class GanaContraModoDeAtaque implements ResultadoCombate {

    private Integer diferenciaPuntos;

    public GanaContraModoDeAtaque(Integer diferenciaPuntos) {
        this.diferenciaPuntos = diferenciaPuntos;
    }

    @Override
    public void afectarDefensor(Monstruo defensor) {
        defensor.mandarDelCampoAlCementerio();
        defensor.daniarJugador(diferenciaPuntos);
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        // no afecta al atacante
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GanaContraModoDeAtaque that = (GanaContraModoDeAtaque) o;
        return Objects.equals(diferenciaPuntos, that.diferenciaPuntos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(diferenciaPuntos);
    }
}
