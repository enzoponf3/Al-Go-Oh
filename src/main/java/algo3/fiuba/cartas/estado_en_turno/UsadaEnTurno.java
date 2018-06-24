package algo3.fiuba.cartas.estado_en_turno;

import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;

public class UsadaEnTurno implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        throw new InhabilitadoParaAtacarExcepcion("La carta ya no se puede usar en este turno.");
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new TurnoRival();
    }
}
