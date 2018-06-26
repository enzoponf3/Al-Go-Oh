package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.resultado_combate.EmpataContraModoDeAtaque;
import algo3.fiuba.resultado_combate.GanaContraModoDeAtaque;
import algo3.fiuba.resultado_combate.PierdeContraModoDeAtaque;
//import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModoDeAtaqueTest {

    private ModoDeAtaque modoDeAtaque;

    @Before
    public void setUp() {
        modoDeAtaque = new ModoDeAtaque();
    }

    @Test
    public void cambiarModoMonstruo_devuelveModoDeDefensa() {
        ModoMonstruo modoDeDefensa = new ModoDeDefensa();

        Assert.assertTrue(modoDeAtaque.cambiarModoMonstruo() instanceof ModoDeDefensa);
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
        Assert.assertTrue(modoDeAtaque.empataron() instanceof EmpataContraModoDeAtaque);
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

        Assert.assertEquals(new EmpataContraModoDeAtaque(), modoDeAtaque.recibirAtaque(puntosDeAtaqueAtacante, puntosDeAtaqueDefensor, 0));

    }
}
