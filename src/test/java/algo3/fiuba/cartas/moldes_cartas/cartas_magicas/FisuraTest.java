package algo3.fiuba.cartas.moldes_cartas.cartas_magicas;

import algo3.fiuba.Juego;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.Jinzo7;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.SevenColoredFish;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FisuraTest {

    private Fisura fisura;
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
    public void colocoDosCartasMonstruoEnCampoEnemigo_activoFisura_elDeMenorAtaqueEsDestruido() {
        Monstruo monstruoFuerte = new SevenColoredFish(jugador2);
        Monstruo monstruoDebil = new Jinzo7(jugador2);
        fisura = new Fisura(jugador1);

        jugador2.colocarCartaEnCampo((Carta) monstruoDebil, new BocaArriba());
        jugador2.colocarCartaEnCampo((Carta) monstruoFuerte, new BocaArriba());
        jugador1.colocarCartaEnCampo(fisura, new BocaArriba());

        fisura.activarEfecto();

        // Después de ser usada la carta mágica va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));

        // La carta de menor ataque del enemigo va al cementerio.
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoFuerte));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoFuerte));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoDebil));
    }
}
