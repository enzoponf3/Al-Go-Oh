package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.resultado_combate.GanaContraModoAtaque;
import algo3.fiuba.cartas.resultado_combate.PierdeContraModoAtaque;

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
    public ResultadoCombate atacar(Monstruo otraCarta, Integer puntosAtaque) {
        return otraCarta.recibirAtaque(puntosAtaque);
    }

    @Override
    public Integer puntosDefensivos(Integer ataqueDefensor, Integer defensaDefensor) {
        return ataqueDefensor;
    }

    @Override
    public ResultadoCombate ganoAtacante(Integer diferenciaPuntos) {
        return new GanaContraModoAtaque(diferenciaPuntos);
    }

    @Override
    public ResultadoCombate perdioAtacante(Integer diferenciaPuntos) {
        return new PierdeContraModoAtaque(diferenciaPuntos);
    }

    @Override
    public ResultadoCombate empataron() {
        return new GanaContraModoAtaque(0);
    }
}
