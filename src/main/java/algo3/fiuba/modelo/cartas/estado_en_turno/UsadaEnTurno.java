package algo3.fiuba.modelo.cartas.estado_en_turno;

import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

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
