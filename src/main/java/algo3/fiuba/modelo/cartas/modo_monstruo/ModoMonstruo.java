package algo3.fiuba.modelo.cartas.modo_monstruo;

import algo3.fiuba.modelo.cartas.AccionCarta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.resultado_combate.ResultadoCombate;

import java.util.List;

public abstract class ModoMonstruo {

    public abstract ResultadoCombate atacar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Integer puntosAtaque);

    public ResultadoCombate recibirAtaque(Integer ataqueAtacante, Integer ataqueDefensor, Integer defensaDefensor) {
        Integer diferenciaPuntos = puntosDefensivos(ataqueDefensor, defensaDefensor) - ataqueAtacante;
        Integer moduloDiferenciaPuntos = Math.abs(diferenciaPuntos);

        if (diferenciaPuntos > 0)
            return perdioAtacante(moduloDiferenciaPuntos);
        if (diferenciaPuntos < 0)
            return ganoAtacante(moduloDiferenciaPuntos);
        return empataron();
    }

    public abstract Integer puntosDefensivos(Integer ataqueDefensor, Integer defensaDefensor);

    public abstract ResultadoCombate ganoAtacante(Integer diferenciaPuntos);

    public abstract ResultadoCombate perdioAtacante(Integer diferenciaPuntos);

    public abstract ResultadoCombate empataron();

    public abstract ModoMonstruo cambiarModoMonstruo();

    public abstract List<AccionCarta> accionesDisponibles();

    public abstract boolean estaEnModoDeDefensa();
}
