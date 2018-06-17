package algo3.fiuba;

import algo3.fiuba.Campo;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CampoTest {

    private Campo campo;
    private EfectoCarta efectoNulo;


    @Before
    public void setUp() {
        campo = new Campo();
        efectoNulo = EfectoNulo.getInstancia();
    }

    @Test
    public void recienCreadoEstaVacio() {
        Assert.assertTrue(campo.estaVacio());
    }

    @Test
    public void seAgrega1MonstruoEnZonaCorrecta_laCantidadDeMonstruosEs1() {
        Carta carta = new Monstruo("m", 100, 100, 0, efectoNulo);
        campo.colocarCarta(carta, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 1;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaMagicaEnZonaCorrecta_laCantidadDeNoMonstruosEs1() {
        Carta carta = new Magica("n", efectoNulo);
        campo.colocarCarta(carta, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 1;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs1() {
        Carta trampa = new Trampa("n", efectoNulo);
        campo.colocarCarta(trampa, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 1;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2MonstruosEnZonaCorrecta_laCantidadDeMonstruosEs2() {
        Carta carta1 = new Monstruo("m1", 100, 100, 0, efectoNulo);
        Carta carta2 = new Monstruo("m2", 100, 100, 0, efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 2;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasMagicasEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Carta carta1 = new Magica("nm1", efectoNulo);
        Carta carta2 = new Magica("nm2", efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Carta carta1 = new Trampa("nm1", efectoNulo);
        Carta carta2 = new Trampa("nm2", efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaMagicaY1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Carta carta1 = new Magica("nm1", efectoNulo);
        Carta carta2 = new Trampa("nm2", efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1Monstruo1CartaMagicaY1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Carta carta1 = new Magica("nm1", efectoNulo);
        Carta carta2 = new Trampa("nm2", efectoNulo);
        Carta carta3 = new Monstruo("m1", 100, 100, 0, efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());
        campo.colocarCarta(carta3, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 1;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test(expected = RuntimeException.class)
    public void seAgrega6MonstruosEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Carta carta1 = new Monstruo("m1", 100, 100, 0, efectoNulo);
        Carta carta2 = new Monstruo("m2", 100, 100, 0, efectoNulo);
        Carta carta3 = new Monstruo("m3", 100, 100, 0, efectoNulo);
        Carta carta4 = new Monstruo("m4", 100, 100, 0, efectoNulo);
        Carta carta5 = new Monstruo("m5", 100, 100, 0, efectoNulo);
        Carta carta6 = new Monstruo("m6", 100, 100, 0, efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());
        campo.colocarCarta(carta3, BocaAbajo.getInstancia());
        campo.colocarCarta(carta4, BocaAbajo.getInstancia());
        campo.colocarCarta(carta5, BocaAbajo.getInstancia());
        campo.colocarCarta(carta6, BocaAbajo.getInstancia());
    }

    @Test(expected = RuntimeException.class)
    public void seAgrega6CartasMagicasEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Carta carta1 = new Magica("nm1", efectoNulo);
        Carta carta2 = new Magica("nm2", efectoNulo);
        Carta carta3 = new Magica("nm3", efectoNulo);
        Carta carta4 = new Magica("nm4", efectoNulo);
        Carta carta5 = new Magica("nm5", efectoNulo);
        Carta carta6 = new Magica("nm6", efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());
        campo.colocarCarta(carta3, BocaAbajo.getInstancia());
        campo.colocarCarta(carta4, BocaAbajo.getInstancia());
        campo.colocarCarta(carta5, BocaAbajo.getInstancia());
        campo.colocarCarta(carta6, BocaAbajo.getInstancia());
    }

    @Test(expected = RuntimeException.class)
    public void seAgrega6CartasTrampaEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Carta carta1 = new Trampa("nm1", efectoNulo);
        Carta carta2 = new Trampa("nm2", efectoNulo);
        Carta carta3 = new Trampa("nm3", efectoNulo);
        Carta carta4 = new Trampa("nm4", efectoNulo);
        Carta carta5 = new Trampa("nm5", efectoNulo);
        Carta carta6 = new Trampa("nm6", efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());
        campo.colocarCarta(carta3, BocaAbajo.getInstancia());
        campo.colocarCarta(carta4, BocaAbajo.getInstancia());
        campo.colocarCarta(carta5, BocaAbajo.getInstancia());
        campo.colocarCarta(carta6, BocaAbajo.getInstancia());
    }

    @Test
    public void seAgrega2MonstruosConElMimoNombre_laCantidadDeMonstruosEs2() {
        Carta carta1 = new Monstruo("m1", 100, 100, 0, efectoNulo);
        Carta carta2 = new Monstruo("m1", 100, 100, 0, efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 2;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasMagicasConElMismoNombre_laCantidadDeNoMonstruosEs2() {
        Carta carta1 = new Magica("nm1", efectoNulo);
        Carta carta2 = new Magica("nm1", efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasTrampaConElMismoNombre_laCantidadDeNoMonstruosEs2() {
        Carta carta1 = new Trampa("nm1", efectoNulo);
        Carta carta2 = new Trampa("nm1", efectoNulo);

        campo.colocarCarta(carta1, BocaAbajo.getInstancia());
        campo.colocarCarta(carta2, BocaAbajo.getInstancia());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }






}
