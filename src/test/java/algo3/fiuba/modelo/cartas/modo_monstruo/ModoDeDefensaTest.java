package algo3.fiuba.modelo.cartas.modo_monstruo;

import algo3.fiuba.modelo.resultado_combate.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModoDeDefensaTest {

    private ModoDeDefensa modoDeDefensa;

    @Before
    public void setUp() {
        modoDeDefensa = new ModoDeDefensa();
    }

    @Test
    public void cambiarModoMonstruo_devuelveModoDeAtaque() {
        ModoMonstruo modoDeAtaque = new ModoDeAtaque();

        Assert.assertTrue(modoDeDefensa.cambiarModoMonstruo() instanceof ModoDeAtaque);
    }

    @Test
    public void ganoAtacante_devuelveObjetoDeInstanciaCorrecta() {
        Assert.assertTrue(modoDeDefensa.ganoAtacante(0) instanceof GanaContraModoDeDefensa);
    }

    @Test
    public void pierdeAtacante_devuelveObjetoDeInstanciaCorrecta() {
        Assert.assertTrue(modoDeDefensa.perdioAtacante(0) instanceof PierdeContraModoDeDefensa);
    }

    @Test
    public void empataron_devuelveObjetoDeInstanciaCorrecta() {
        Assert.assertTrue(modoDeDefensa.empataron() instanceof EmpataContraModoDeDefensa);
    }

    @Test
    public void elijeComoPuntosDefensivosLosPuntosDeAtaque() {
        Integer puntosDeAtaque = 1000;
        Integer puntosDeDefensa = 2000;

        Assert.assertEquals(puntosDeDefensa, modoDeDefensa.puntosDefensivos(puntosDeAtaque, puntosDeDefensa));
    }

    @Test
    public void recibirAtaque_ganaAtacante(){
        Integer puntosDeAtaqueAtacante = 2000;
        Integer puntosDeDefensaDefensor = 1000;

        Integer diferenciaPuntos = Math.abs(puntosDeDefensaDefensor - puntosDeAtaqueAtacante);

        Assert.assertEquals(new GanaContraModoDeDefensa(), modoDeDefensa.recibirAtaque(puntosDeAtaqueAtacante, 0, puntosDeDefensaDefensor));
    }

    @Test
    public void recibirAtaque_pierdeAtacante(){
        Integer puntosDeAtaqueAtacante = 1000;
        Integer puntosDeDefensaDefensor = 2000;

        Integer diferenciaPuntos = Math.abs(puntosDeDefensaDefensor - puntosDeAtaqueAtacante);

        Assert.assertEquals(new PierdeContraModoDeDefensa(diferenciaPuntos), modoDeDefensa.recibirAtaque(puntosDeAtaqueAtacante, 0, puntosDeDefensaDefensor));
    }

    @Test
    public void recibirAtaque_empatan(){
        Integer puntosDeAtaqueAtacante = 1000;
        Integer puntosDeDefensaDefensor = 1000;

        Integer diferenciaPuntos = Math.abs(puntosDeDefensaDefensor - puntosDeAtaqueAtacante);

        Assert.assertEquals(new EmpataContraModoDeDefensa(), modoDeDefensa.recibirAtaque(puntosDeAtaqueAtacante, 0, puntosDeDefensaDefensor));

    }

}
