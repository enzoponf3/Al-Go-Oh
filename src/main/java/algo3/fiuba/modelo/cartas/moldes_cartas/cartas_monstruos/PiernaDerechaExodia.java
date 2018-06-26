package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoPartesExodia;

import java.util.List;

public class PiernaDerechaExodia extends Monstruo {

    public PiernaDerechaExodia(Jugador jugador) {
        super("Pierna derecha del prohibido", 200, 300, 1,new EfectoPartesExodia(jugador.getOponente()));
        setJugador(jugador);
    }

    @Override
    public void agregarAMano(List<Carta> mano) {
        super.agregarAMano(mano);
        activarEfecto(this, jugador);
    }
}
