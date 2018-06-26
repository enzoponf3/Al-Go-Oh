package algo3.fiuba.modelo.cartas.estado_en_turno;

public class NoUsadaEnTurno implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        return new UsadaEnTurno();
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new TurnoRival();
    }
}
