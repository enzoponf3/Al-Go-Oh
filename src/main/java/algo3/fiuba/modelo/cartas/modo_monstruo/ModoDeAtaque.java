package algo3.fiuba.modelo.cartas.modo_monstruo;

import algo3.fiuba.modelo.cartas.AccionCarta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.resultado_combate.EmpataContraModoDeAtaque;
import algo3.fiuba.modelo.resultado_combate.ResultadoCombate;
import algo3.fiuba.modelo.resultado_combate.GanaContraModoDeAtaque;
import algo3.fiuba.modelo.resultado_combate.PierdeContraModoDeAtaque;

import java.util.LinkedList;
import java.util.List;

public class ModoDeAtaque extends ModoMonstruo {

    @Override
    public ModoMonstruo cambiarModoMonstruo() {
        return new ModoDeDefensa();
    }

    @Override
    public ResultadoCombate atacar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Integer puntosAtaque) {
        return monstruoAtacado.recibirAtaque(monstruoAtacante, puntosAtaque);
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

    @Override
    public List<AccionCarta> accionesDisponibles() {
        List<AccionCarta> acciones = new LinkedList<>();
        acciones.add(AccionCarta.ATACAR);

        return acciones;
    }

    @Override
    public boolean estaEnModoDeDefensa() {
        return false;
    }
}
