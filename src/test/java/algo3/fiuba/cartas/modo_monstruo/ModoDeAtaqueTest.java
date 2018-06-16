package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.resultado_combate.EmpataContraModoAtaque;
import algo3.fiuba.cartas.resultado_combate.GanaContraModoDeAtaque;
import algo3.fiuba.cartas.resultado_combate.PierdeContraModoDeAtaque;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModoDeAtaqueTest {

    private ModoDeAtaque modoDeAtaque;

    @Before
    public void setUp() {
        modoDeAtaque = ModoDeAtaque.getInstancia();
    }

    @Test
    public void cambiarModoMonstruo_devuelveModoDeDefensa() {
        ModoMonstruo modoDeDefensa = ModoDeDefensa.getInstancia();

        Assert.assertEquals(modoDeDefensa, modoDeAtaque.cambiarModoMonstruo());
    }

    @Test
    public void ganoAtacante_devuelveObjetoDeInstanciaCorrecta() {
        Assert.assertTrue(modoDeAtaque.ganoAtacante(0) instanceof GanaContraModoDeAtaque);
    }

    @Test
    public void pierdeAtacante_devuelveObjetoDeInstanciaCorrecta() {
        Assert.assertTrue(modoDeAtaque.perdioAtacante(0) instanceof PierdeContraModoDeAtaque);
    }

    @Test
    public void empataron_devuelveObjetoDeInstanciaCorrecta() {
        Assert.assertTrue(modoDeAtaque.empataron() instanceof EmpataContraModoAtaque);
    }

    @Test
    public void elijeComoPuntosDefensivosLosPuntosDeAtaque() {
        Integer puntosDeAtaque = 1000;
        Integer puntosDeDefensa = 2000;

        Assert.assertEquals(puntosDeAtaque, modoDeAtaque.puntosDefensivos(puntosDeAtaque, puntosDeDefensa));
    }

    @Test
    public void recibirAtaque_ganaAtacante(){
        Integer puntosDeAtaqueAtacante = 2000;
        Integer puntosDeAtaqueDefensor = 1000;

        Integer diferenciaPuntos = Math.abs(puntosDeAtaqueDefensor - puntosDeAtaqueAtacante);

        Assert.assertEquals(new GanaContraModoDeAtaque(diferenciaPuntos), modoDeAtaque.recibirAtaque(puntosDeAtaqueAtacante, puntosDeAtaqueDefensor, 0));
    }

    @Test
    public void recibirAtaque_pierdeAtacante(){
        Integer puntosDeAtaqueAtacante = 1000;
        Integer puntosDeAtaqueDefensor = 2000;

        Integer diferenciaPuntos = Math.abs(puntosDeAtaqueDefensor - puntosDeAtaqueAtacante);

        Assert.assertEquals(new PierdeContraModoDeAtaque(diferenciaPuntos), modoDeAtaque.recibirAtaque(puntosDeAtaqueAtacante, puntosDeAtaqueDefensor, 0));
    }

    @Test
    public void recibirAtaque_empatan(){
        Integer puntosDeAtaqueAtacante = 1000;
        Integer puntosDeAtaqueDefensor = 1000;

        Integer diferenciaPuntos = Math.abs(puntosDeAtaqueDefensor - puntosDeAtaqueAtacante);

        Assert.assertEquals(new EmpataContraModoAtaque(), modoDeAtaque.recibirAtaque(puntosDeAtaqueAtacante, puntosDeAtaqueDefensor, 0));

    }
}
