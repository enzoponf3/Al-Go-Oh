package algo3.fiuba.modelo.cartas.estado_en_turno;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EstadoCarta;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

import java.util.LinkedList;
import java.util.List;

public class UsadaEnTurno implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("La carta ya no se puede usar en este turno.");
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new TurnoRival();
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(Monstruo carta, EstadoCarta estadoCarta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(Magica carta, EstadoCarta estadoCarta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(Trampa carta, EstadoCarta estadoCarta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(CartaCampo carta, EstadoCarta estadoCarta) {
        return new LinkedList<>();
    }
}
