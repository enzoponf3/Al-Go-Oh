package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.resultado_combate.EmpataContraModoAtaque;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.resultado_combate.GanaContraModoDeAtaque;
import algo3.fiuba.cartas.resultado_combate.PierdeContraModoDeAtaque;

public class ModoDeAtaque extends ModoMonstruo {

    private static ModoDeAtaque INSTANCIA;

    public static ModoDeAtaque getInstancia() {
        if (INSTANCIA == null){
            INSTANCIA = new ModoDeAtaque();
        }

        return INSTANCIA;
    }

    @Override
    public ModoMonstruo cambiarModoMonstruo() {
        return ModoDeDefensa.getInstancia();
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
        return new EmpataContraModoAtaque();
    }
}
