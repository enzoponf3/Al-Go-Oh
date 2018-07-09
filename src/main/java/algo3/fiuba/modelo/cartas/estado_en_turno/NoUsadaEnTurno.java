package algo3.fiuba.modelo.cartas.estado_en_turno;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EstadoCarta;

import java.util.List;

public class NoUsadaEnTurno implements EstadoEnTurno {


    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        return new UsadaEnTurno();
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new TurnoRival();
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(Monstruo carta, EstadoCarta estadoCarta) {
        List<AccionCarta> acciones = estadoCarta.accionesDisponibles(carta);
        acciones.remove(AccionCarta.RECIBIR_ATAQUE);

        return acciones;
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(Magica carta, EstadoCarta estadoCarta) {
        return estadoCarta.accionesDisponibles(carta);
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(Trampa carta, EstadoCarta estadoCarta) {
        return estadoCarta.accionesDisponibles(carta);
    }

    @Override
    public List<AccionCarta> accionesCartaDisponibles(CartaCampo carta, EstadoCarta estadoCarta) {
        return estadoCarta.accionesDisponibles(carta);
    }
}
