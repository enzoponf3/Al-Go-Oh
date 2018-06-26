package algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.efectos.EfectoPartesExodia;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;

import java.util.List;

public class PiernaIzquierdaExodia extends Monstruo {

    public PiernaIzquierdaExodia(Jugador jugador) {
        super("Pierna izquierda del prohibido", 200, 300, 1, new EfectoPartesExodia(jugador.getOponente()));
        setJugador(jugador);
    }

    @Override
    public void agregarAMano(List<Carta> mano) {
        super.agregarAMano(mano);
        activarEfecto(this, jugador);
    }

    @Override
    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        super.colocarEnCampo(jugador, tipoEnJuego, sacrificios);
        efecto.desactivar();
    }
}
