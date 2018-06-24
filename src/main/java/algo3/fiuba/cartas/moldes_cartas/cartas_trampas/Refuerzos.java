package algo3.fiuba.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.efectos.EfectoRefuerzos;

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
