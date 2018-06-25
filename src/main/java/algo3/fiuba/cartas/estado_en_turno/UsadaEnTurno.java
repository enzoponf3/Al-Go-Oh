package algo3.fiuba.cartas.estado_en_turno;

import algo3.fiuba.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

public class UsadaEnTurno implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("La carta ya no se puede usar en este turno.");
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new TurnoRival();
    }
}
