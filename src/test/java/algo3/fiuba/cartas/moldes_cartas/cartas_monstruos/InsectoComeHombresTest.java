package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsectoComeHombresTest {

    private InsectoComeHombres insectoComeHombres;
    private Jugador jugador1;
    private Jugador jugador2;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        insectoComeHombres = new InsectoComeHombres(jugador1);
    }

    @Test
    public void alColocarseEnCampoBocaArribaNoSeActivaElEfecto() {
        Carta monstruoRival = new SevenColoredFish(jugador2);

        jugador1.colocarCartaEnCampo(insectoComeHombres, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruoRival, new BocaArriba());

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));

        Assert.assertTrue(monstruoRival.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoRival));
    }

    @Test
    public void seColocaEnElCampoBocaAbajo_alSerAtacadoActivaElEfecto() {
        Monstruo monstruoRival = new SevenColoredFish(jugador2);

        jugador1.colocarCartaEnCampo(insectoComeHombres, new BocaAbajo());
        jugador2.colocarCartaEnCampo(monstruoRival, new BocaArriba());

        monstruoRival.atacar(insectoComeHombres);

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));

        // Se activó el efecto y murió la otra carta
        Assert.assertFalse(monstruoRival.estaEnJuego());
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoRival));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoRival));
    }

    @Test
    public void seColocaEnElCampoBocaArriba_alSerAtacadoNoActivaElEfecto() {
        Monstruo monstruoRival = new SevenColoredFish(jugador2);

        jugador1.colocarCartaEnCampo(insectoComeHombres, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruoRival, new BocaArriba());

        monstruoRival.atacar(insectoComeHombres);

        Assert.assertTrue(insectoComeHombres.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));

        // Se activó el efecto y murió la otra carta
        Assert.assertTrue(monstruoRival.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoRival));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoRival));
    }



}
