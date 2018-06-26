package algo3.fiuba.modelo.cartas.estado_en_turno;

public interface EstadoEnTurno {

    EstadoEnTurno verificarQueSePuedeUsar();

    EstadoEnTurno pasarTurno();
}
