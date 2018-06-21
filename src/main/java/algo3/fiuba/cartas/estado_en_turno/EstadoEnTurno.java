package algo3.fiuba.cartas.estado_en_turno;

public interface EstadoEnTurno {

    EstadoEnTurno verificarQueSePuedeUsar();

    EstadoEnTurno pasarTurno();
}
