package test.algo3.main.carta;

import main.algo3.fiuba.carta.Carta;
import main.algo3.fiuba.carta.ModoAtaque;
import main.algo3.fiuba.carta.ModoDefensa;
import org.junit.Before;
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
    }


}
