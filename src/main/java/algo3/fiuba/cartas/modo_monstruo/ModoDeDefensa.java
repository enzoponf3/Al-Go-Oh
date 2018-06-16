package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.resultado_combate.ResultadoCombate;
import algo3.fiuba.cartas.resultado_combate.GanaContraModoDefensa;
import algo3.fiuba.cartas.resultado_combate.PierdeContraModoDefensa;
import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;

public class ModoDeDefensa extends ModoMonstruo {

    private static ModoDeDefensa INSTANCIA;

    private ModoDeDefensa() {
    }

    public static ModoDeDefensa getInstancia() {
        if (INSTANCIA == null){
            INSTANCIA = new ModoDeDefensa();
        }

        return INSTANCIA;
    }

    @Override
    public ModoMonstruo cambiarModoMonstruo() {
        return ModoDeAtaque.getInstancia();
    }

    @Override
    public ResultadoCombate atacar(Monstruo otraCarta, Integer puntosAtaque) {
        throw new InhabilitadoParaAtacarExcepcion("No puede atacar estando en Modo de Defensa.");
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
