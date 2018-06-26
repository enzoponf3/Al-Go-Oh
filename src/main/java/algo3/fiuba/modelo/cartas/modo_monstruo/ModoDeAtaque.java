package algo3.fiuba.modelo.cartas.modo_monstruo;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.resultado_combate.EmpataContraModoDeAtaque;
import algo3.fiuba.modelo.resultado_combate.ResultadoCombate;
import algo3.fiuba.modelo.resultado_combate.GanaContraModoDeAtaque;
import algo3.fiuba.modelo.resultado_combate.PierdeContraModoDeAtaque;

public class ModoDeAtaque extends ModoMonstruo {

    @Override
    public ModoMonstruo cambiarModoMonstruo() {
        return new ModoDeDefensa();
    }

    @Override
    public ResultadoCombate atacar(Monstruo monstruoAtacante, Monstruo otraCarta, Integer puntosAtaque) {
        return otraCarta.recibirAtaque(monstruoAtacante, puntosAtaque);
    }

    @Override
    public Integer puntosDefensivos(Integer ataqueDefensor, Integer defensaDefensor) {
        return ataqueDefensor;
    }

    @Override
    public ResultadoCombate ganoAtacante(Integer diferenciaPuntos) {
        return new GanaContraModoDeAtaque(diferenciaPuntos);
    }

    @Override
    public ResultadoCombate perdioAtacante(Integer diferenciaPuntos) {
        return new PierdeContraModoDeAtaque(diferenciaPuntos);
    }

    @Override
    public ResultadoCombate empataron() {
        return new EmpataContraModoDeAtaque();
    }
}
