package algo3.fiuba.entrega1;

import algo3.fiuba.Campo;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos_cartas.EfectoNulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.MouseAdapter;

public class CampoEntrega1Test {

    private Campo campo;

    @Before
    public void setUp() {
        campo = new Campo();
    }

    @Test
    public void campoRecienCreadoEstaVacio() {
        Assert.assertTrue(campo.estaVacio());
    }

    @Test
    public void campoSeAgregaMonstruoEnZonaCorrecta() {
        Monstruo carta = new Monstruo("m", 100, 100);
        campo.campoColocarCarta(carta);
        Assert.assertEquals(campo.cantidadMonstruos(), Integer.valueOf(1));
    }

    @Test
    public void campoSeAgregaCartaMagicaEnZonaCorrecta() {
        Magica carta = new Magica("n", new EfectoNulo());
        campo.campoColocarCarta(carta);
        Assert.assertEquals(campo.cantidadEspeciales(), Integer.valueOf(1));
    }

    @Test
    public void campoSeAgregaCartaTrampaEnZonaCorrecta() {
        Trampa trampa = new Trampa("n", new EfectoNulo());
        campo.campoColocarCarta(trampa);
        Assert.assertEquals(campo.cantidadEspeciales(), Integer.valueOf(1));
    }

}
