package algo3.fiuba.cartas.estado_en_turno;

import algo3.fiuba.excepciones.InhabilitadoParaAtacarExcepcion;

public class TurnoRival implements EstadoEnTurno {

    @Override
    public EstadoEnTurno verificarQueSePuedeUsar() {
        throw new InhabilitadoParaAtacarExcepcion("No se puede usar en el turno del rival");
    }

    @Override
    public EstadoEnTurno pasarTurno() {
        return new NoUsadaEnTurno();
    }
}
