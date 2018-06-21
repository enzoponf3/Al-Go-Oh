package algo3.fiuba.cartas.estado_en_turno;

public class TurnoRival implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        throw new RuntimeException("No se puede usar en el turno del rival");
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new NoUsadaEnTurno();
    }
}
