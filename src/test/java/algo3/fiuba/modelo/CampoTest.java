package algo3.fiuba.modelo;

import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.Magica;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.moldes_cartas.CartaCampoNula;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Sogen;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.Fisura;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.OllaDeLaCodicia;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.CilindroMagico;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CampoTest {

    private Campo campo;
    private Jugador jugador;


    @Before
    public void setUp() {
        campo = new Campo();
        jugador = new Jugador();
        jugador.setOponente(new Jugador());
    }

    @Test
    public void recienCreadoEstaVacio() {
        Assert.assertTrue(campo.estaVacio());
    }

    @Test
    public void seAgrega1MonstruoEnZonaCorrecta_laCantidadDeMonstruosEs1() {
        Monstruo carta = new BebeDragon(jugador);
        campo.colocarCarta(carta, new BocaAbajo());

        Integer cantidadDeMonstruos = 1;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaMagicaEnZonaCorrecta_laCantidadDeNoMonstruosEs1() {
        Magica carta = new AgujeroNegro(jugador);
        campo.colocarCarta(carta, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 1;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs1() {
        Trampa trampa = new Refuerzos(jugador);
        campo.colocarCarta(trampa, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 1;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2MonstruosEnZonaCorrecta_laCantidadDeMonstruosEs2() {
        Monstruo carta1 = new BebeDragon(jugador);
        Monstruo carta2 = new Kuriboh(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 2;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasMagicasEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new AgujeroNegro(jugador);
        Magica carta2 = new Fisura(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Trampa carta1 = new CilindroMagico(jugador);
        Trampa carta2 = new Refuerzos(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1CartaMagicaY1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new AgujeroNegro(jugador);
        Trampa carta2 = new Refuerzos(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1Monstruo1CartaMagicaY1CartaTrampaEnZonaCorrecta_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new AgujeroNegro(jugador);
        Trampa carta2 = new Refuerzos(jugador);
        Monstruo carta3 = new GuerreroCelta(jugador);

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
        Monstruo carta1 = new GuerreroCelta(jugador);
        Monstruo carta2 = new Kuriboh(jugador);
        Monstruo carta3 = new GuerreroCastor(jugador);
        Monstruo carta4 = new BebeDragon(jugador);
        Monstruo carta5 = new PetitAngel(jugador);
        Monstruo carta6 = new IncursorDelHacha(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());
        campo.colocarCarta(carta3, new BocaAbajo());
        campo.colocarCarta(carta4, new BocaAbajo());
        campo.colocarCarta(carta5, new BocaAbajo());
        campo.colocarCarta(carta6, new BocaAbajo());
    }

    @Test(expected = CampoNoPermiteColocarCartaExcepcion.class)
    public void seAgrega6CartasMagicasEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Magica carta1 = new AgujeroNegro(jugador);
        Magica carta2 = new Fisura(jugador);
        Magica carta3 = new OllaDeLaCodicia(jugador);
        Magica carta4 = new AgujeroNegro(jugador);
        Magica carta5 = new Fisura(jugador);
        Magica carta6 = new OllaDeLaCodicia(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());
        campo.colocarCarta(carta3, new BocaAbajo());
        campo.colocarCarta(carta4, new BocaAbajo());
        campo.colocarCarta(carta5, new BocaAbajo());
        campo.colocarCarta(carta6, new BocaAbajo());
    }

    @Test(expected = CampoNoPermiteColocarCartaExcepcion.class)
    public void seAgrega6CartasTrampaEnZonaCorrecta_lanzaExcepcionPorqueElTopeEs5() {
        Trampa carta1 = new Refuerzos(jugador);
        Trampa carta2 = new CilindroMagico(jugador);
        Trampa carta3 = new Refuerzos(jugador);
        Trampa carta4 = new CilindroMagico(jugador);
        Trampa carta5 = new Refuerzos(jugador);
        Trampa carta6 = new CilindroMagico(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());
        campo.colocarCarta(carta3, new BocaAbajo());
        campo.colocarCarta(carta4, new BocaAbajo());
        campo.colocarCarta(carta5, new BocaAbajo());
        campo.colocarCarta(carta6, new BocaAbajo());
    }

    @Test
    public void seAgrega2MonstruosConElMismoNombre_laCantidadDeMonstruosEs2() {
        Monstruo carta1 = new GuerreroCelta(jugador);
        Monstruo carta2 = new GuerreroCelta(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 2;
        Integer cantidadDeNoMonstruos = 0;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasMagicasConElMismoNombre_laCantidadDeNoMonstruosEs2() {
        Magica carta1 = new AgujeroNegro(jugador);
        Magica carta2 = new AgujeroNegro(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega2CartasTrampaConElMismoNombre_laCantidadDeNoMonstruosEs2() {
        Trampa carta1 = new Refuerzos(jugador);
        Trampa carta2 = new Refuerzos(jugador);

        campo.colocarCarta(carta1, new BocaAbajo());
        campo.colocarCarta(carta2, new BocaAbajo());

        Integer cantidadDeMonstruos = 0;
        Integer cantidadDeNoMonstruos = 2;

        Assert.assertEquals(cantidadDeMonstruos, campo.cantidadMonstruos());
        Assert.assertEquals(cantidadDeNoMonstruos, campo.cantidadNoMonstruos());
    }

    @Test
    public void seAgrega1Monstruo_elMonstruoEstaEnElCampo() {
        Monstruo carta = new BebeDragon(jugador);
        campo.colocarCarta(carta, new BocaAbajo());

        Assert.assertTrue(campo.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaMagica_laCartaMagicaEstaEnElCampo() {
        Magica carta = new AgujeroNegro(jugador);
        campo.colocarCarta(carta, new BocaAbajo());

        Assert.assertTrue(campo.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaTrampa_laCartaTrampaEstaEnElCampo() {
        Trampa carta = new Refuerzos(jugador);
        campo.colocarCarta(carta, new BocaAbajo());

        Assert.assertTrue(campo.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaCampo_laCartaCampoEstaEnElCampo() {
        CartaCampo carta = new Wasteland(jugador);
        campo.colocarCarta(carta, new BocaArriba());

        Assert.assertTrue(campo.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1MonstruoYLuegoSeRemueve_elMonstruoNoEstaEnElCampo() {
        Monstruo carta = new BebeDragon(jugador);
        campo.colocarCarta(carta, new BocaAbajo());
        campo.removerCarta(carta);

        Assert.assertFalse(campo.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaMagicaYLuegoSeRemueve_laCartaMagicaNoEstaEnElCampo() {
        Magica carta = new AgujeroNegro(jugador);
        campo.colocarCarta(carta, new BocaAbajo());
        campo.removerCarta(carta);

        Assert.assertFalse(campo.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaTrampaYLuegoSeRemueve_laCartaTrampaNoEstaEnElCampo() {
        Trampa carta = new Refuerzos(jugador);
        campo.colocarCarta(carta, new BocaAbajo());
        campo.removerCarta(carta);

        Assert.assertFalse(campo.cartaEstaEnCampo(carta));
    }

    @Test
    public void seAgrega1CartaCampoYLuegoSeRemueve_laCartaCampoNoEstaEnElCampo() {
        CartaCampo cartaCampo = new Wasteland(jugador);
        campo.colocarCarta(cartaCampo, new BocaArriba());
        campo.removerCarta(cartaCampo);

        Assert.assertFalse(campo.cartaEstaEnCampo(cartaCampo));
    }

    @Test
    public void seAgrega1CartaCampoYLuegoSeAgregaOtra_quedaLaSegunda() {
        CartaCampo carta1 = new Wasteland(jugador);
        CartaCampo carta2 = new Sogen(jugador);

        campo.colocarCarta(carta1, new BocaArriba());
        campo.colocarCarta(carta2, new BocaArriba());

        Assert.assertFalse(campo.cartaEstaEnCampo(carta1));
        Assert.assertTrue(campo.cartaEstaEnCampo(carta2));
    }

    @Test
    public void siSePideLaCartaCampoDeUnCampoRecienInicializadoDevuelveUnaCartaCampoNula() {
        Assert.assertTrue(campo.getCartaCampo() instanceof CartaCampoNula);
    }

    @Test
    public void siSePideLaCartaCampoDeUnCampoAlQueSeQuitoSuCartaDeCampoDevuelveUnaCartaCampoNula() {
        CartaCampo cartaCampo = new Wasteland(jugador);
        campo.colocarCarta(cartaCampo, new BocaArriba());
        campo.removerCarta(cartaCampo);

        Assert.assertTrue(campo.getCartaCampo() instanceof CartaCampoNula);
    }

}
