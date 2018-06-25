package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.excepciones.CampoNoPermiteColocarCartaExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CampoTest {

    private Campo campo;


    @Before
    public void setUp() {
        campo = new Campo();
    }

    @Test
    public void recienCreadoEstaVacio() {
        Assert.assertTrue(campo.estaVacio());
    }

    @Test
    public void seAgrega1MonstruoEnZonaCorrecta_laCantidadDeMonstruosEs1() {
        Monstruo carta = new Monstruo("m", 100, 100, 1, new EfectoNulo());
        campo.colocarCarta(carta, new BocaAbajo());

        Integer cantidadDeMonstruos = 1;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaMagicaEnZonaCorrecta_laCantidadDeNoMonstruosEs1() {
        Magica carta = new Magica("n", new EfectoNulo());
        campo.colocarCarta(carta, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 1;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs1() {
        Trampa trampa = new Trampa("n", new EfectoNulo());
        campo.colocarCarta(trampa, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 1;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2MonstruosEnZonaCorrecta_laCantidadDeMonstruosEs2() {
        Monstruo carta1 = new Monstruo("m1", 100, 100, 1, new EfectoNulo());
        Monstruo carta2 = new Monstruo("m2", 100, 100, 1, new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 2;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasMagicasEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new Magica("nm1", new EfectoNulo());
        Magica carta2 = new Magica("nm2", new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Trampa carta1 = new Trampa("nm1", new EfectoNulo());
        Trampa carta2 = new Trampa("nm2", new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaMagicaY1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new Magica("nm1", new EfectoNulo());
        Trampa carta2 = new Trampa("nm2", new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1Monstruo1CartaMagicaY1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new Magica("nm1", new EfectoNulo());
        Trampa carta2 = new Trampa("nm2", new EfectoNulo());
        Monstruo carta3 = new Monstruo("m1", 100, 100, 1, new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());
        campo.colocarCarta(carta3, new BocaAbajo());

        Integer cantidadDeMonstruos = 1;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test(expected = CampoNoPermiteColocarCartaExcepcion.class)
    public void seAgrega6MonstruosEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Monstruo carta1 = new Monstruo("m1", 100, 100, 1, new EfectoNulo());
        Monstruo carta2 = new Monstruo("m2", 100, 100, 1, new EfectoNulo());
        Monstruo carta3 = new Monstruo("m3", 100, 100, 1, new EfectoNulo());
        Monstruo carta4 = new Monstruo("m4", 100, 100, 1, new EfectoNulo());
        Monstruo carta5 = new Monstruo("m5", 100, 100, 1, new EfectoNulo());
        Monstruo carta6 = new Monstruo("m6", 100, 100, 1, new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());
        campo.colocarCarta(carta3, new BocaAbajo());
        campo.colocarCarta(carta4, new BocaAbajo());
        campo.colocarCarta(carta5, new BocaAbajo());
        campo.colocarCarta(carta6, new BocaAbajo());
    }

    @Test(expected = CampoNoPermiteColocarCartaExcepcion.class)
    public void seAgrega6CartasMagicasEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Magica carta1 = new Magica("nm1", new EfectoNulo());
        Magica carta2 = new Magica("nm2", new EfectoNulo());
        Magica carta3 = new Magica("nm3", new EfectoNulo());
        Magica carta4 = new Magica("nm4", new EfectoNulo());
        Magica carta5 = new Magica("nm5", new EfectoNulo());
        Magica carta6 = new Magica("nm6", new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());
        campo.colocarCarta(carta3, new BocaAbajo());
        campo.colocarCarta(carta4, new BocaAbajo());
        campo.colocarCarta(carta5, new BocaAbajo());
        campo.colocarCarta(carta6, new BocaAbajo());
    }

    @Test(expected = CampoNoPermiteColocarCartaExcepcion.class)
    public void seAgrega6CartasTrampaEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Trampa carta1 = new Trampa("nm1", new EfectoNulo());
        Trampa carta2 = new Trampa("nm2", new EfectoNulo());
        Trampa carta3 = new Trampa("nm3", new EfectoNulo());
        Trampa carta4 = new Trampa("nm4", new EfectoNulo());
        Trampa carta5 = new Trampa("nm5", new EfectoNulo());
        Trampa carta6 = new Trampa("nm6", new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());
        campo.colocarCarta(carta3, new BocaAbajo());
        campo.colocarCarta(carta4, new BocaAbajo());
        campo.colocarCarta(carta5, new BocaAbajo());
        campo.colocarCarta(carta6, new BocaAbajo());
    }

    @Test
    public void seAgrega2MonstruosConElMimoNombre_laCantidadDeMonstruosEs2() {
        Monstruo carta1 = new Monstruo("m1", 100, 100, 1, new EfectoNulo());
        Monstruo carta2 = new Monstruo("m1", 100, 100, 1, new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 2;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasMagicasConElMismoNombre_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new Magica("nm1", new EfectoNulo());
        Magica carta2 = new Magica("nm1", new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasTrampaConElMismoNombre_laCantidadDeNoMonstruosEs2() {
        Trampa carta1 = new Trampa("nm1", new EfectoNulo());
        Trampa carta2 = new Trampa("nm1", new EfectoNulo());

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }






}
