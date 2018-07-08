package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

import java.util.LinkedList;
import java.util.List;

public class EnCementerio extends FueraDeJuego {

    @Override
    public boolean estaEnJuego() {
        return false;
    }

    @Override
    public void verificarQuePuedeAtacar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar si se encuentra en el cementerio.");
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Monstruo carta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Magica carta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Trampa carta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesDisponibles(CartaCampo carta) {
        return new LinkedList<>();
    }
}
