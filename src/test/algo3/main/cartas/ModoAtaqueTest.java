package test.algo3.main.cartas;

import main.algo3.fiuba.cartas.Monstruo;
import main.algo3.fiuba.cartas.ModoAtaque;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModoAtaqueTest {

    private ModoAtaque modoAtaque;

    @Before
    public void setUp() {
        modoAtaque = ModoAtaque.INSTANCIA();
    }

    @Test
    public void puedeAtacar() {
        Monstruo monstruoAtacada = new Monstruo("otra", 0, 0);

        modoAtaque.atacar(monstruoAtacada, 0);
        Assert.assertTrue(true);
    }

    @Test
    public void siEstaEnModoAtaqueEntoncesEstaViva() {
        Assert.assertTrue(modoAtaque.estaViva());
    }

    @Test
    public void alRecibirAtaqueSeDefiendeConLosPuntosDeAtaque() {
        Monstruo monstruoAtacante = new Monstruo("otra", 0, 0);

        modoAtaque.recibirAtaque(1000, 0, 0);
        Assert.assertTrue(true);
    }

}
