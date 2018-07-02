package algo3.fiuba.modelo.campo;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.GuerreroCelta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.Kuriboh;
import algo3.fiuba.modelo.cartas.moldes_cartas.MonstruoNulo;
import algo3.fiuba.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZonaCartasTest {

    private ZonaCartas<Monstruo> zonaCartas;
    private Jugador jugador;
    private Integer limiteCartas;
    private Monstruo cartaNula;

    @Before
    public void setUp() {
        limiteCartas = 5;
        cartaNula = new MonstruoNulo();
        zonaCartas = new ZonaCartas<>(limiteCartas, cartaNula);
        jugador = new Jugador();
    }

    @Test
    public void alCrearseElTamanioEs0() {
        Assert.assertEquals(Integer.valueOf(0), zonaCartas.tamanio());
    }

    @Test
    public void alCrearseEstaVacia() {
        Assert.assertTrue(zonaCartas.estaVacia());
    }

    @Test
    public void siAgregoUnaCartaOcupaLaPosicion0() {
        Monstruo carta = new BebeDragon(jugador);
        zonaCartas.agregar(carta);

        Assert.assertTrue(zonaCartas.contiene(carta));
        Assert.assertEquals(carta, zonaCartas.getCartas().get(0));
    }

    @Test
    public void siAgregoOtraCartaOcupaElLugar1YElPrimeroSigueOcupandoElLugar0() {
        Monstruo carta1 = new BebeDragon(jugador);
        Monstruo carta2 = new Kuriboh(jugador);

        zonaCartas.agregar(carta1);
        zonaCartas.agregar(carta2);

        Assert.assertTrue(zonaCartas.contiene(carta1));
        Assert.assertTrue(zonaCartas.contiene(carta2));

        Assert.assertEquals(carta1, zonaCartas.getCartas().get(0));
        Assert.assertEquals(carta2, zonaCartas.getCartas().get(1));
    }

    @Test
    public void remuevoUnaCarta_yaNoEstaContenida() {
        Monstruo carta = new BebeDragon(jugador);
        zonaCartas.agregar(carta);
        zonaCartas.remover(carta);

        Assert.assertFalse(zonaCartas.contiene(carta));
        Assert.assertEquals(cartaNula, zonaCartas.getCartas().get(0));
    }

    @Test
    public void agregoUnaSegundaCartaYRemuevoLaPrimera_laSegundaCartaMantieneSuPosicion() {
        Monstruo carta1 = new BebeDragon(jugador);
        Monstruo carta2 = new Kuriboh(jugador);

        zonaCartas.agregar(carta1);
        zonaCartas.agregar(carta2);
        zonaCartas.remover(carta1);

        Assert.assertFalse(zonaCartas.contiene(carta1));
        Assert.assertTrue(zonaCartas.contiene(carta2));

        Assert.assertEquals(cartaNula, zonaCartas.getCartas().get(0));
        Assert.assertEquals(carta2, zonaCartas.getCartas().get(1));
    }

    @Test
    public void agregoUnaSegundaCartaRemuevoLaPrimeraYAgregoUnaTercera_laTercerCartaOcupaLaPosicion0() {
        Monstruo carta1 = new BebeDragon(jugador);
        Monstruo carta2 = new Kuriboh(jugador);
        Monstruo carta3 = new GuerreroCelta(jugador);

        zonaCartas.agregar(carta1);
        zonaCartas.agregar(carta2);
        zonaCartas.remover(carta1);
        zonaCartas.agregar(carta3);

        Assert.assertFalse(zonaCartas.contiene(carta1));
        Assert.assertTrue(zonaCartas.contiene(carta2));

        Assert.assertEquals(carta3, zonaCartas.getCartas().get(0));
        Assert.assertEquals(carta2, zonaCartas.getCartas().get(1));
    }






    @Test
    public void alCrearseTieneLaCantidadDeCartasIgualAlLimite() {
        Assert.assertEquals(limiteCartas, (Integer) zonaCartas.getCartas().size());
    }

    @Test
    public void alAgregarUnaCartaTieneLaCantidadDeCartasIgualAlLimite() {
        Monstruo carta1 = new BebeDragon(jugador);
        zonaCartas.agregar(carta1);

        Assert.assertEquals(limiteCartas, (Integer) zonaCartas.getCartas().size());
    }

    @Test
    public void alAgregarYRemoverUnaCartaTieneLaCantidadDeCartasIgualAlLimite() {
        Monstruo carta1 = new BebeDragon(jugador);
        zonaCartas.agregar(carta1);
        zonaCartas.remover(carta1);

        Assert.assertEquals(limiteCartas, (Integer) zonaCartas.getCartas().size());
    }

    @Test
    public void alAgregarDosCartasTieneLaCantidadDeCartasIgualAlLimite() {
        Monstruo carta1 = new BebeDragon(jugador);
        Monstruo carta2 = new Kuriboh(jugador);

        zonaCartas.agregar(carta1);
        zonaCartas.agregar(carta2);

        Assert.assertEquals(limiteCartas, (Integer) zonaCartas.getCartas().size());
    }

    @Test
    public void agregoUnaSegundaCartaYRemuevoLaPrimera_laCantidadDeCartasIgualAlLimite() {
        Monstruo carta1 = new BebeDragon(jugador);
        Monstruo carta2 = new Kuriboh(jugador);

        zonaCartas.agregar(carta1);
        zonaCartas.agregar(carta2);
        zonaCartas.remover(carta1);

        Assert.assertEquals(limiteCartas, (Integer) zonaCartas.getCartas().size());
    }






}
