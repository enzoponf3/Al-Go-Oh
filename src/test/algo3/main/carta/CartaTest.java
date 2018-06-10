package test.algo3.main.carta;

import main.algo3.fiuba.carta.Carta;
import main.algo3.fiuba.carta.ModoAtaque;
import main.algo3.fiuba.carta.ModoDefensa;
import org.junit.Assert;
import org.junit.Test;

public class CartaTest {

    @Test(expected = RuntimeException.class)
    public void cartaNoPuedeAtacarEnModoDefensa() {
        Carta cartaAtacante = new Carta("cartaAtacante", 1000, 1000);
        Carta cartaDefensiva = new Carta("cartaDefensiva", 1500, 1500);

        cartaAtacante.pasarAModoJuego(ModoDefensa.INSTANCIA());
        cartaDefensiva.pasarAModoJuego(ModoAtaque.INSTANCIA());

        cartaAtacante.atacar(cartaDefensiva);
    }

    @Test
    public void cartaEnModoAtaquePuedeAtacarACartaEnJuego() {
        Carta cartaAtacante = new Carta("cartaAtacante", 1000, 1000);
        Carta cartaDefensiva = new Carta("cartaDefensiva", 1500, 1500);

        cartaAtacante.pasarAModoJuego(ModoAtaque.INSTANCIA());
        cartaDefensiva.pasarAModoJuego(ModoAtaque.INSTANCIA());

        cartaAtacante.atacar(cartaDefensiva);
        Assert.assertTrue(true);
    }

    @Test
    public void atacarACartaEnModoDefensa_DefensorTieneMenosPuntosDeDefensa_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Carta cartaAtacante = new Carta("cartaAtacante", puntosAtacante, 0);
        Carta cartaDefensiva = new Carta("cartaDefensiva", 0, puntosDefensor);

        cartaAtacante.pasarAModoJuego(ModoAtaque.INSTANCIA());
        cartaDefensiva.pasarAModoJuego(ModoDefensa.INSTANCIA());

        cartaAtacante.atacar(cartaDefensiva);
        Assert.assertTrue(cartaAtacante.estaViva());
        Assert.assertFalse(cartaDefensiva.estaViva());
    }

    @Test
    public void atacarACartaEnModoDefensa_DefensorTieneMasPuntosDeDefensa_NoMuereNadie() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Carta cartaAtacante = new Carta("cartaAtacante", puntosAtacante, 0);
        Carta cartaDefensiva = new Carta("cartaDefensiva", 0, puntosDefensor);

        cartaAtacante.pasarAModoJuego(ModoAtaque.INSTANCIA());
        cartaDefensiva.pasarAModoJuego(ModoDefensa.INSTANCIA());

        cartaAtacante.atacar(cartaDefensiva);
        Assert.assertTrue(cartaAtacante.estaViva());
        Assert.assertTrue(cartaDefensiva.estaViva());
    }


    @Test
    public void atacarACartaEnModoAtaque_DefensorTieneMenosPuntosDeAtaque_MuereElDefensor() {
        Integer puntosAtacante = 2000;
        Integer puntosDefensor = 1500;

        Carta cartaAtacante = new Carta("cartaAtacante", puntosAtacante, 0);
        Carta cartaDefensiva = new Carta("cartaDefensiva", puntosDefensor, 0);

        cartaAtacante.pasarAModoJuego(ModoAtaque.INSTANCIA());
        cartaDefensiva.pasarAModoJuego(ModoAtaque.INSTANCIA());

        cartaAtacante.atacar(cartaDefensiva);
        Assert.assertTrue(cartaAtacante.estaViva());
        Assert.assertFalse(cartaDefensiva.estaViva());
    }

    @Test
    public void atacarACartaEnModoAtaque_DefensorTieneMasPuntosDeAtaque_MuereElAtacante() {
        Integer puntosAtacante = 1000;
        Integer puntosDefensor = 1500;

        Carta cartaAtacante = new Carta("cartaAtacante", puntosAtacante, 0);
        Carta cartaDefensiva = new Carta("cartaDefensiva", puntosDefensor, 0);

        cartaAtacante.pasarAModoJuego(ModoAtaque.INSTANCIA());
        cartaDefensiva.pasarAModoJuego(ModoAtaque.INSTANCIA());

        cartaAtacante.atacar(cartaDefensiva);
        Assert.assertFalse(cartaAtacante.estaViva());
        Assert.assertTrue(cartaDefensiva.estaViva());
    }





}
