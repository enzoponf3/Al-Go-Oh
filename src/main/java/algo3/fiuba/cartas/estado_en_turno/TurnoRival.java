package algo3.fiuba.cartas.estado_en_turno;

import algo3.fiuba.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

public class TurnoRival implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No se puede usar en el turno del rival");
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new NoUsadaEnTurno();
    }
}
