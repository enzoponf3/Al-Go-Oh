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
    public List<AccionCarta> accionesDisponibles(Monstruo carta, EstadoCarta estadoCarta) {
        return estadoCarta.accionesDisponibles(carta);
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Magica carta, EstadoCarta estadoCarta) {
        return estadoCarta.accionesDisponibles(carta);
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Trampa carta, EstadoCarta estadoCarta) {
        return estadoCarta.accionesDisponibles(carta);
    }

    @Override
    public List<AccionCarta> accionesDisponibles(CartaCampo carta, EstadoCarta estadoCarta) {
        return estadoCarta.accionesDisponibles(carta);
    }
}
