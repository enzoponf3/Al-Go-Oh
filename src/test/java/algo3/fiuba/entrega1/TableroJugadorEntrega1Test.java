package algo3.fiuba.entrega1;

import algo3.fiuba.Jugador;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.efectos_cartas.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TableroJugadorEntrega1Test {

    private TableroJugador tableroJugador;

    @Before
    public void setUp() {
        tableroJugador = new TableroJugador();
    }

    // CARTAS MONSTRUO
    @Test
    public void colocarCartaMonstruoEnTableroJugador() {

        Monstruo cartaMonstruo = new Monstruo("monstruo", 100, 100, 0);

        Assert.assertTrue(tableroJugador.colocarCartaEnTablero(cartaMonstruo));
    }

    @Test
    public void colocarCartaMagicaEnTableroJugador() {

        Magica cartaMagica = new Magica("una carta magica ", new EfectoNulo());

        Assert.assertTrue(tableroJugador.colocarCartaEnTablero(cartaMagica));
    }

    @Test
    public void colocarCartaTrampaEnTableroJugador() {

        //ImplementarCartaTrampa
    }

    @Test
    public void cartaEnCementerioNoPuedeSerRevivida() {

        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Monstruo monstruoAtacante = new Monstruo("monstruoAtacante", puntosAtacante, 0, 0);
        Monstruo monstruoDefensor = new Monstruo("monstruoDefensor", puntosDefensor, 0, 0);

        Jugador jugadorAtacante = new Jugador();
        Jugador jugadorDefensor = new Jugador();

        monstruoAtacante.setJugador(jugadorAtacante);
        monstruoDefensor.setJugador(jugadorDefensor);

        monstruoAtacante.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoAtacante.pasarAModoAtaque();

        monstruoDefensor.pasarAModoJuego(BocaArriba.INSTANCIA());
        monstruoDefensor.pasarAModoAtaque();

        monstruoAtacante.atacar(monstruoDefensor);

        Assert.assertFalse(monstruoAtacante.estaVivo());

        tableroJugador.agregarCartaMuerta(monstruoAtacante);
        Assert.assertTrue(tableroJugador.cartaEnCementerio(monstruoAtacante));
    }

}