package algo3.fiuba.cartas.resultado_combate;

import algo3.fiuba.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Test;

public class GanaContraModoAtaqueTest {

    @Test
    public void monstruoAtacanteSigueVivo() {
        Monstruo monstruoAtacante = new Monstruo("m", 0, 0);
        monstruoAtacante.pasarAModoAtaque();

        ResultadoCombate resultado = new GanaContraModoAtaque(1000);
        resultado.afectarAtacante(monstruoAtacante);

        Assert.assertTrue(monstruoAtacante.estaVivo());
    }
}
