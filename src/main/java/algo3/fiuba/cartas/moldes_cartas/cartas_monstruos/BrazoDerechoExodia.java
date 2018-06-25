package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Campo;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoPartesExodia;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

import java.util.List;

public class BrazoDerechoExodia extends Monstruo {

    public BrazoDerechoExodia(Jugador jugador) {
        super("Brazo derecho del prohibido", 200, 300, 1, new EfectoPartesExodia(jugador.getOponente()));
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
