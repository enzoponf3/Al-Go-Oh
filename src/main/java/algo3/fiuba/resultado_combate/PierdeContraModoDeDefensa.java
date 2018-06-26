package algo3.fiuba.resultado_combate;

import algo3.fiuba.cartas.Monstruo;

import java.util.Objects;

public class PierdeContraModoDeDefensa implements ResultadoCombate {

    private Integer diferenciaPuntos;

    public PierdeContraModoDeDefensa(Integer diferenciaPuntos) {
        this.diferenciaPuntos = diferenciaPuntos;
    }

    @Override
    public void afectarDefensor(Monstruo defensor) {
        // no afecta al defensor
    }

    @Override
    public void afectarAtacante(Monstruo atacante) {
        atacante.daniarJugador(diferenciaPuntos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PierdeContraModoDeDefensa that = (PierdeContraModoDeDefensa) o;
        return Objects.equals(diferenciaPuntos, that.diferenciaPuntos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(diferenciaPuntos);
    }
}
