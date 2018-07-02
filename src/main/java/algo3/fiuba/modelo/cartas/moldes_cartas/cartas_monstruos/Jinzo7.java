package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.cartas.estado_en_turno.TurnoRival;
import algo3.fiuba.modelo.cartas.estado_en_turno.UsadaEnTurno;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoJinzo7;
import algo3.fiuba.modelo.cartas.efectos.EfectoNulo;

public class Jinzo7 extends Monstruo {

    public Jinzo7(Jugador jugador) {
        super("Jinzo7 #7", 500, 400, 2, new EfectoNulo());
        super.setJugador(jugador);
        super.setEfecto(new EfectoJinzo7(jugador.getOponente(), getAtaque()));
    }

    @Override
    public void activarEfecto() {
        super.activarEfecto();
        estadoEnTurno = new UsadaEnTurno();
    }
}
