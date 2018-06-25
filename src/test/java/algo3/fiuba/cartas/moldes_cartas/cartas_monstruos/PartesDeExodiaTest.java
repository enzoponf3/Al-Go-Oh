package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Juego;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartesDeExodiaTest {

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
    public void alRobarLaQuintaParteDeExodiaHabiendoColocandoUnaParteEnElCampoNoSeActivaElEfecto() {
        Monstruo parteExodia1 = new PiernaDerechaExodia(jugador1);
        Monstruo parteExodia2 = new PiernaIzquierdaExodia(jugador1);
        Monstruo parteExodia3 = new CabezaExodia(jugador1);
        Monstruo parteExodia4 = new BrazoDerechoExodia(jugador1);
        Monstruo parteExodia5 = new BrazoIzquierdoExodia(jugador1);

        jugador2.agregarCartaAMazo(new MagoOscuro(jugador2));
        jugador1.agregarCartaAMazo(new SevenColoredFish(jugador1));

        jugador1.agregarCartaAMazo(parteExodia1);
        jugador1.agregarCartaAMazo(parteExodia2);
        jugador1.agregarCartaAMazo(parteExodia3);
        jugador1.agregarCartaAMazo(parteExodia4);
        jugador1.agregarCartaAMazo(parteExodia5);

        jugador1.tomarCartaDelMazo();
        jugador1.colocarCartaEnCampo(parteExodia5, new BocaArriba());

        for (int i = 0; i<4; i++) {
            jugador1.tomarCartaDelMazo();
        }

        Assert.assertFalse(juego.terminoPartida());
        Assert.assertEquals(null, juego.ganadorPartida());
    }

}
