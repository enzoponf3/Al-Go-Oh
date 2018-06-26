package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.efectos.EfectoRefuerzos;

public class Refuerzos extends Trampa {

    public Refuerzos(Jugador jugador) {
        super("Refuerzos", new EfectoRefuerzos());
        setJugador(jugador);
    }

    @Override
    public boolean bloquearAtaque() {
        return false;
    }
}
