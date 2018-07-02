package algo3.fiuba.modelo.cartas.estado_en_turno;

import algo3.fiuba.modelo.cartas.Monstruo;

public interface EstadoEnTurno {

    EstadoEnTurno verificarQueSePuedeUsar();

    EstadoEnTurno pasarTurno();
}
