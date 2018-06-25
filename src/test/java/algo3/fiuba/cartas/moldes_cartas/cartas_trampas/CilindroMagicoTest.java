package algo3.fiuba.cartas.moldes_cartas.cartas_trampas;

import algo3.fiuba.Juego;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.SevenColoredFish;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CilindroMagicoTest {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);
    }

    @Test
    public void atacarATrampaCilindroMagicoSeNiegaAtaqueYSeEfectuaALosPuntosDeVidaDelAtacanteYMuereAlTenerExactamenteXPuntosDeVida() {
        Monstruo monstruoAtacante = new SevenColoredFish(jugador2);
        Monstruo monstruoAtacado = new Jinzo7(jugador1);
        Carta cilindroMagico = new CilindroMagico(jugador1);

        jugador1.colocarCartaEnCampo((Carta) monstruoAtacado, new BocaArriba());
        jugador1.colocarCartaEnCampo(cilindroMagico, new BocaAbajo());
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        //El jugador queda en 1800 puntos de vida
        jugador1.modificarPuntosDeVida(6200);

        //SevenColoredFish tiene 1800 puntos de ataque
        monstruoAtacante.atacar(monstruoAtacado);

        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador2, juego.ganadorPartida());
    }
}
