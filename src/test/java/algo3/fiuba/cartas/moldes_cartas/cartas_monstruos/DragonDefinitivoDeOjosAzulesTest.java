package algo3.fiuba.cartas.moldes_cartas.cartas_monstruos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.excepciones.SacrificiosInsuficientesExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DragonDefinitivoDeOjosAzulesTest {

    private DragonDefinitivoDeOjosAzules dragonDefinitivo;
    private Jugador jugador;

    @Before
    public void setUp() {
        jugador = new Jugador();
        dragonDefinitivo = new DragonDefinitivoDeOjosAzules(jugador);
    }


    @Test
    public void sacrificandoTresDragonesDeOjosAzulesSePuedeInvocar() {
        Monstruo dragonASacrificar1 = new DragonBlancoDeOjosAzules(jugador);
        Monstruo dragonASacrificar2 = new DragonBlancoDeOjosAzules(jugador);
        Monstruo dragonASacrificar3 = new DragonBlancoDeOjosAzules(jugador);

        // Monstruos de sacrificio para poder invocar a los tres dragones blancos de ojos azúles.
        Monstruo monstruoASacrificar1 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar2 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar3 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar4 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar5 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar6 = new SevenColoredFish(jugador);

        // Invoco los dragones, con sus respectivos sacrificios.
        jugador.colocarCartaEnCampo(monstruoASacrificar1, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar2, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(dragonASacrificar1, BocaAbajo.getInstancia(), monstruoASacrificar1, monstruoASacrificar2);

        jugador.colocarCartaEnCampo(monstruoASacrificar3, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar4, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(dragonASacrificar2, BocaAbajo.getInstancia(), monstruoASacrificar3, monstruoASacrificar4);

        jugador.colocarCartaEnCampo(monstruoASacrificar5, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar6, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(dragonASacrificar3, BocaAbajo.getInstancia(), monstruoASacrificar5, monstruoASacrificar6);

        dragonDefinitivo = new DragonDefinitivoDeOjosAzules(jugador);

        jugador.colocarCartaEnCampo(dragonDefinitivo, BocaArriba.getInstancia(), dragonASacrificar1, dragonASacrificar2, dragonASacrificar3);

        // Para invocar al Dragón definitivo se tuvo que sacrificar a los tres dragones.
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonASacrificar1));
        Assert.assertTrue(jugador.cartaEstaEnCementerio(dragonASacrificar1));
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonASacrificar2));
        Assert.assertTrue(jugador.cartaEstaEnCementerio(dragonASacrificar2));
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonASacrificar3));
        Assert.assertTrue(jugador.cartaEstaEnCementerio(dragonASacrificar3));

        // Se debería de haber colocado al dragón definitivo.
        Assert.assertTrue(jugador.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertTrue(dragonDefinitivo.estaEnJuego());
    }


    @Test(expected = SacrificiosInsuficientesExcepcion.class)
    public void sinSacrificios_noSePuedeInvocar() {
        jugador.colocarCartaEnCampo(dragonDefinitivo, BocaArriba.getInstancia());

        // No se debería de haber colocado al dragón definitivo.
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertFalse(dragonDefinitivo.estaEnJuego());
    }

    @Test(expected = SacrificiosInsuficientesExcepcion.class)
    public void unSacrificioCualquiera_noSePuedeInvocar() {
        Monstruo monstruoASacrificar1 = new SevenColoredFish(jugador);

        jugador.colocarCartaEnCampo(dragonDefinitivo, BocaArriba.getInstancia(), monstruoASacrificar1);

        // No se debería de haber colocado al dragón definitivo.
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertFalse(dragonDefinitivo.estaEnJuego());
    }

    @Test(expected = SacrificiosInsuficientesExcepcion.class)
    public void tresSacrificiosCualquiera_noSePuedeInvocar() {
        Monstruo monstruoASacrificar1 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar2 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar3 = new SevenColoredFish(jugador);

        jugador.colocarCartaEnCampo(monstruoASacrificar1, BocaArriba.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar2, BocaArriba.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar3, BocaArriba.getInstancia());

        jugador.colocarCartaEnCampo(dragonDefinitivo, BocaArriba.getInstancia(), monstruoASacrificar1, monstruoASacrificar2, monstruoASacrificar3);

        // No se debería de haber colocado al dragón definitivo.
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertFalse(dragonDefinitivo.estaEnJuego());
    }

    @Test(expected = SacrificiosInsuficientesExcepcion.class)
    public void sacrificandoUnDragonesDeOjosAzulesNoSePuedeInvocar() {
        Monstruo dragonASacrificar1 = new DragonBlancoDeOjosAzules(jugador);
        Monstruo dragonASacrificar2 = new DragonBlancoDeOjosAzules(jugador);

        // Monstruos de sacrificio para poder invocar a los tres dragones blancos de ojos azúles.
        Monstruo monstruoASacrificar1 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar2 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar3 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar4 = new SevenColoredFish(jugador);

        // Invoco los dragones, con sus respectivos sacrificios.
        jugador.colocarCartaEnCampo(monstruoASacrificar1, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar2, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(dragonASacrificar1, BocaAbajo.getInstancia(), monstruoASacrificar1, monstruoASacrificar2);

        jugador.colocarCartaEnCampo(monstruoASacrificar3, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar4, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(dragonASacrificar2, BocaAbajo.getInstancia(), monstruoASacrificar3, monstruoASacrificar4);

        Carta dragonDefinitivo = new DragonDefinitivoDeOjosAzules(jugador);

        jugador.colocarCartaEnCampo(dragonDefinitivo, BocaArriba.getInstancia(), dragonASacrificar1, dragonASacrificar2);

        // Para invocar al Dragón definitivo se tuvo que sacrificar a los tres dragones.
        Assert.assertTrue(jugador.cartaEstaEnCampo(dragonASacrificar1));
        Assert.assertFalse(jugador.cartaEstaEnCementerio(dragonASacrificar1));
        Assert.assertTrue(jugador.cartaEstaEnCampo(dragonASacrificar2));
        Assert.assertFalse(jugador.cartaEstaEnCementerio(dragonASacrificar2));

        // Se debería de haber colocado al dragón definitivo.
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertFalse(dragonDefinitivo.estaEnJuego());
    }

    @Test(expected = SacrificiosInsuficientesExcepcion.class)
    public void sacrificandoDosDragonesDeOjosAzulesSePuedeInvocar() {
        Monstruo dragonASacrificar1 = new DragonBlancoDeOjosAzules(jugador);

        // Monstruos de sacrificio para poder invocar a los tres dragones blancos de ojos azúles.
        Monstruo monstruoASacrificar1 = new SevenColoredFish(jugador);
        Monstruo monstruoASacrificar2 = new SevenColoredFish(jugador);

        // Invoco los dragones, con sus respectivos sacrificios.
        jugador.colocarCartaEnCampo(monstruoASacrificar1, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(monstruoASacrificar2, BocaAbajo.getInstancia());
        jugador.colocarCartaEnCampo(dragonASacrificar1, BocaAbajo.getInstancia(), monstruoASacrificar1, monstruoASacrificar2);

        Carta dragonDefinitivo = new DragonDefinitivoDeOjosAzules(jugador);

        jugador.colocarCartaEnCampo(dragonDefinitivo, BocaArriba.getInstancia(), dragonASacrificar1);

        // Para invocar al Dragón definitivo se tuvo que sacrificar a los tres dragones.
        Assert.assertTrue(jugador.cartaEstaEnCampo(dragonASacrificar1));
        Assert.assertFalse(jugador.cartaEstaEnCementerio(dragonASacrificar1));

        // Se debería de haber colocado al dragón definitivo.
        Assert.assertFalse(jugador.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertFalse(dragonDefinitivo.estaEnJuego());
    }


}
