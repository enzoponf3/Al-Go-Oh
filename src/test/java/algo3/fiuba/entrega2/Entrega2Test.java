package algo3.fiuba.entrega2;

import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoWasteland;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega2Test {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        tablero = Tablero.getInstancia();
        tablero.empezarDuelo(jugador1, jugador2);
    }
    /*
    @Test
    public void colocarUnMonstruoACadaLadoJugarWastelandElAtaqueDeUnoAumentaEn200YLaDefensaDelOtroAumentaEn300() {
        Monstruo monstruo1 = new Monstruo("Monstruo 1",300,0,1);
        Monstruo monstruo2 = new Monstruo("Monstruo 2",0,200,1);

        EfectoCarta efectoWasteland = new EfectoWasteland();
        Magica wasteland = new Magica("Wasteland",efectoWasteland);

        jugador1.colocarCartaEnTablero(monstruo1, BocaArriba.getInstancia());
        jugador2.colocarCartaEnTablero(monstruo2, BocaAbajo.getInstancia());
        jugador2.colocarCartaEnTablero(wasteland, BocaArriba.getInstancia());

        wasteland.activar(tablero);

        monstruo1.atacar(monstruo2);
        Assert.assertFalse(monstruo1.estaEnJuego());
        Assert.assertFalse(monstruo2.estaEnJuego());
    }
*/
    }

