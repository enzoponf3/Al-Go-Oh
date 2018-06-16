package algo3.fiuba.cartas.modo_monstruo;

import algo3.fiuba.cartas.resultado_combate.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModoDeDefensaTest {
    private ModoDeDefensa modoDeDefensa;

    @Before
    public void setUp() {
        modoDeDefensa = ModoDeDefensa.getInstancia();
    }

    @Test
    public void cambiarModoMonstruo_devuelveModoDeDefensa() {
        ModoMonstruo modoDeAtaque = ModoDeAtaque.getInstancia();

        Assert.assertEquals(modoDeAtaque, modoDeDefensa.cambiarModoMonstruo());
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
        Assert.assertTrue(modoDeDefensa.empataron() instanceof PierdeContraModoDeDefensa);
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

        Assert.assertEquals(new PierdeContraModoDeDefensa(diferenciaPuntos), modoDeDefensa.recibirAtaque(puntosDeAtaqueAtacante, 0, puntosDeDefensaDefensor));

    }

}
