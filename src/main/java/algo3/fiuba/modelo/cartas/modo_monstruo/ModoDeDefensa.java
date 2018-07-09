package algo3.fiuba.modelo.cartas.modo_monstruo;

import algo3.fiuba.modelo.cartas.AccionCarta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.resultado_combate.*;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

import java.util.LinkedList;
import java.util.List;

public class ModoDeDefensa extends ModoMonstruo {

    @Override
    public ModoMonstruo cambiarModoMonstruo() {
        return new ModoDeAtaque();
    }

    @Override
    public ResultadoCombate atacar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Integer puntosAtaque) {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar estando en Modo de Defensa.");
    }

    @Override
    public Integer puntosDefensivos(Integer ataqueDefensor, Integer defensaDefensor) {
        return defensaDefensor;
    }

    @Override
    public ResultadoCombate ganoAtacante(Integer diferenciaPuntos) {
        return new GanaContraModoDeDefensa();
    }

    @Override
    public ResultadoCombate perdioAtacante(Integer diferenciaPuntos) {
        return new PierdeContraModoDeDefensa(diferenciaPuntos);
    }

    @Override
    public ResultadoCombate empataron() {
        return new EmpataContraModoDeDefensa();
    }

    @Override
    public List<AccionCarta> accionesDisponibles() {
        return new LinkedList<>();
    }

    @Override
    public boolean estaEnModoDeDefensa() {
        return true;
    }
}
