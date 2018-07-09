package algo3.fiuba.modelo.cartas.estado_en_turno;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EstadoCarta;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

import java.util.LinkedList;
import java.util.List;

public class TurnoRival implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No se puede usar en el turno del rival");
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new NoUsadaEnTurno();
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(Monstruo carta, EstadoCarta estadoCarta) {
        List<AccionCarta> acciones = new LinkedList<>();

        if (estadoCarta.accionesDisponibles(carta).contains(AccionCarta.RECIBIR_ATAQUE)) {
            acciones.add(AccionCarta.RECIBIR_ATAQUE);
        }

        return acciones;
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
