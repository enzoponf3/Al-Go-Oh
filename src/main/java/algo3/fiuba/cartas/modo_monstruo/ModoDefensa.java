package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.resultado_combate.GanaContraModoDefensa;
import algo3.fiuba.cartas.resultado_combate.PierdeContraModoDefensa;
import algo3.fiuba.excepciones.MonstruoEnModoDefensaNoPuedeAtacarException;

public class ModoDefensa extends ModoMonstruo {

    private static ModoDefensa INSTANCIA;

    private ModoDefensa() {
    }

    public static ModoDefensa INSTANCIA() {
        if (INSTANCIA == null){
            INSTANCIA = new ModoDefensa();
        }

        return INSTANCIA;
    }

    @Override
    public ResultadoCombate atacar(Monstruo otraCarta, Integer puntosAtaque) {
        throw new MonstruoEnModoDefensaNoPuedeAtacarException();
    }

    @Override
    public Integer puntosDefensivos(Integer ataqueDefensor, Integer defensaDefensor) {
        return defensaDefensor;
    }

    @Override
    public ResultadoCombate ganoAtacante(Integer diferenciaPuntos) {
        return new GanaContraModoDefensa();
    }

    @Override
    public ResultadoCombate perdioAtacante(Integer diferenciaPuntos) {
        return new PierdeContraModoDefensa(diferenciaPuntos);
    }

    @Override
    public ResultadoCombate empataron() {
        return new PierdeContraModoDefensa(0);
    }
}
