package algo3.fiuba.entrega1;

import algo3.fiuba.Juego;
import algo3.fiuba.Turno;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Magica;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;
import org.junit.*;


public class Entrega1OficialTest {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;
    private Turno turno;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);

        turno = Turno.getInstancia();
    }

    @Test
    public void colocarUnaCartaDeMonstruoEnModoDeAtaquePuedeAtacarOtroMonstruo() {
        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new BebeDragon(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoDefensor, new BocaArriba());
        turno.pasarTurno();

        monstruoAtacante.atacar(monstruoDefensor);

        // Como está en modo ataque puede atacar sin tirar excepción.
    }


    @Test(expected = MonstruoInhabilitadoParaAtacarExcepcion.class)
    public void colocarUnaCartaDeMonstruoEnModoDeDefensaAlQuererAtacarLanzaExcepcion() {
        Monstruo monstruoAtacante = new BebeDragon(jugador1);
        Monstruo monstruoDefensor = new BebeDragon(jugador2);

        // Los monstruos se colocan por default en modo ataque, por eso luego se cambia el modo a modo de defensa.
        jugador1.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());
        monstruoAtacante.cambiarModo();
        turno.pasarTurno();

        jugador2.colocarCartaEnCampo((Carta) monstruoDefensor, new BocaArriba());
        turno.pasarTurno();


        monstruoAtacante.atacar(monstruoDefensor);

        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacante));
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoDefensor));
        // Como está en modo defensa no puede atacar y tira excepción.
    }


    @Test(expected = CartaInhabilitadaParaActivarseExcepcion.class)
    public void colocarCartaMagicaEnCampoBocaAbajo_NoActivaNingunEfecto() {
        /*
        EfectoCarta efectoCarta = new EfectoAgujeroNegro();
        Magica cartaMagica = new Magica("agujero negro", efectoCarta);
*/
        Magica cartaMagica = new AgujeroNegro(jugador1);

        //cartaMagica.pasarAModoJuego(new BocaAbajo());
        jugador1.colocarCartaEnCampo(cartaMagica, new BocaAbajo());
        cartaMagica.activarEfecto();
        // Como está boca abajo no puede activarEfecto el efecto y lanza error.
    }

    @Test
    public void colocarCartaTrampaEnCampoBocaAbajo() {
        Trampa trampa = new Trampa("trampa test", new EfectoNulo());
        trampa.setJugador(jugador1);

        jugador1.colocarCartaEnCampo(trampa, new BocaAbajo());
        jugador1.cartaEstaEnCampo(trampa);
    }

    @Test
    public void mandarCartaAlCementerio() {
        Monstruo carta = new BebeDragon(jugador1);

        jugador1.colocarCartaEnCampo(carta, new BocaArriba());
        jugador1.mandarCartaDelCampoAlCementerio(carta);

        Assert.assertFalse(carta.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(carta));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(carta));
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMayorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugador1PierdePuntosDeVida() {
        Integer ataqueDefensor = 1000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor, 0, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnCampo((Carta) monstruoDefensor, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador tenía 8000 hp - 1000 de diferencia en ataques.
        Integer puntosDeVidaEsperados = 8000 - 1000;

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador1.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConMenorAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2MuereYJugador2PierdePuntosDeVida() {
        Integer ataqueDefensor = 2000;
        Integer ataqueAtacante = 1000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnCampo((Carta) monstruoDefensor, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoDefensor);

        // El jugador tenía 8000 hp - 1000 de diferencia en ataques.
        Integer puntosDeVidaEsperados = 8000 - 1000;

        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeAtaque_jugador2ColocaCartaModoDeAtaqueConIgualAtaque_monstruoJ2AtacaAMonstruoJ1_monstruoJ2yMonstruoJ1MuerenYNadiePierdePuntosDeVida() {
        Integer ataqueDefensor = 2000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", ataqueDefensor,2000, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante,2000, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque.
        jugador1.colocarCartaEnCampo((Carta) monstruoDefensor, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoDefensor);

        // Como no hay diferencia ninguno pierde puntos de vida.
        Integer puntosDeVidaEsperados = 8000;

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
        Assert.assertEquals(puntosDeVidaEsperados, jugador1.getPuntosDeVida());
    }

    @Test
    public void jugador1ColocaMonstruoModoDeDefensa_jugador2ColocaCartaModoDeAtaqueConMayorAtaqueQueLaDefensaDelAnterior_monstruoJ2AtacaAMonstruoJ1_monstruoJ1MuereYJugadorJ1NoPierdePuntosDeVida() {
        Integer defensaDefensor = 1000;
        Integer ataqueAtacante = 2000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0, defensaDefensor, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnCampo((Carta) monstruoDefensor, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        // Paso a modo de defensa al defensor
        monstruoDefensor.cambiarModo();

        monstruoAtacante.atacar(monstruoDefensor);

        // Si un monstruo muere en modo el jugador no pierde puntos de vida
        Integer puntosDeVidaEsperados = 8000;

        Assert.assertFalse(monstruoDefensor.estaEnJuego());
        Assert.assertEquals(puntosDeVidaEsperados, jugador1.getPuntosDeVida());
    }


    @Test
    public void jugador1ColocaMonstruoModoDeDefensa_jugador2ColocaCartaModoDeAtaqueConMenorAtaqueQueLaDefensaDelAnterior_monstruoJ2AtacaAMonstruoJ1_ningunMonstruoMuere/*YJugador2PierdePuntosDeVida*/() {
        Integer defensaDefensor = 2000;
        Integer ataqueAtacante = 1000;

        Monstruo monstruoDefensor = new Monstruo("monstruo test 1", 0, defensaDefensor, 1, new EfectoNulo());
        monstruoDefensor.setJugador(jugador1);
        Monstruo monstruoAtacante = new Monstruo("monstruo test 2", ataqueAtacante, 0, 1, new EfectoNulo());
        monstruoAtacante.setJugador(jugador2);

        // Los monstruos se colocan por default en modo ataque
        jugador1.colocarCartaEnCampo((Carta) monstruoDefensor, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoAtacante, new BocaArriba());

        // Paso a modo de defensa al defensor
        monstruoDefensor.cambiarModo();

        monstruoAtacante.atacar(monstruoDefensor);

        // Si un monstruo muere en modo el jugador no pierde puntos de vida
        Integer puntosDeVidaEsperados = 8000;

        Assert.assertTrue(monstruoDefensor.estaEnJuego());
        Assert.assertTrue(monstruoAtacante.estaEnJuego());
        //Assert.assertEquals(puntosDeVidaEsperados, jugador2.getPuntosDeVida());
    }


    @Test
    public void colocarMonstruosEnAmbosLadosDelCampo_colocarAgujeroNegroBocaArriba_seDestruyeronTodosLosMonstruosDeAmbosLadosDelCampoYNingunJugadorRecibioDanio() {
        Magica agujeroNegro = new AgujeroNegro(jugador1);

        Monstruo monstruoJugador1 = new Monstruo("Rodri", 100, 100, 1, new EfectoNulo());
        Monstruo monstruoJugador2 = new Monstruo("Delfi", 2120, 0, 2, new EfectoNulo());

        jugador1.colocarCartaEnCampo((Carta) monstruoJugador1, new BocaArriba());
        turno.pasarTurno();
        jugador2.colocarCartaEnCampo((Carta) monstruoJugador2, new BocaArriba());
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo(agujeroNegro, new BocaArriba());

        agujeroNegro.activarEfecto();

        Assert.assertFalse(jugador1.cartaEstaEnCampo(monstruoJugador1));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoJugador1));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoJugador2));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoJugador2));
    }

    @Test
    public void seColocaUnMonstruoEnElCampo_seQuiereColocarUnMonstruoDe5o6Estrellas_seSacrificaAlPrimerMonstruoParaColocarAlSegundo() {
        Monstruo cartaMonstruoASacrificar = new Monstruo("aSacrificar", 1000, 1000, 1, new EfectoNulo());
        Monstruo cartaMonstruoAInvocar = new Monstruo("Sacrificador", 2300, 2000, 6, new EfectoNulo());

        // Coloco el monstruo a sacrificar en el campo y verifico que esté
        jugador1.colocarCartaEnCampo((Carta) cartaMonstruoASacrificar, new BocaArriba());

        Assert.assertTrue(cartaMonstruoASacrificar.estaEnJuego());

        turno.pasarTurno();
        turno.pasarTurno();

        // Coloco el monstruo a invocar en el campo y verifico la destrucción del anterior
        jugador1.colocarCartaEnCampo((Carta) cartaMonstruoAInvocar, new BocaArriba(), cartaMonstruoASacrificar);

        Assert.assertTrue(cartaMonstruoAInvocar.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(cartaMonstruoAInvocar));
        Assert.assertFalse(cartaMonstruoASacrificar.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(cartaMonstruoASacrificar));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cartaMonstruoASacrificar));
    }


    @Test
    public void seColocan2MonstruosEnElCampo_seQuiereColocarUnMonstruoDe7OMasEstrellas_seSacrificanLosDosMonstruosParaInvocarlo() {
        Monstruo monstruoASacrificar1 = new Monstruo("aSacrificar 1", 1000, 1000, 1, new EfectoNulo());
        Monstruo monstruoASacrificar2 = new Monstruo("aSacrificar 2", 1000, 1000, 1, new EfectoNulo());
        Monstruo cartaMonstruoAInvocar = new Monstruo("Sacrificador", 2300, 2000, 7, new EfectoNulo());

        // Coloco los monstruos a sacrificar en el campo y verifico que estén.
        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar1, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();
        jugador1.colocarCartaEnCampo((Carta) monstruoASacrificar2, new BocaArriba());
        turno.pasarTurno();
        turno.pasarTurno();

        Assert.assertTrue(monstruoASacrificar1.estaEnJuego());
        Assert.assertTrue(monstruoASacrificar2.estaEnJuego());

        // Coloco la carta a invocar y verificio que esté y, la destrucción de los anteriores.
        jugador1.colocarCartaEnCampo((Carta) cartaMonstruoAInvocar, new BocaArriba(), monstruoASacrificar1, monstruoASacrificar2);

        Assert.assertTrue(cartaMonstruoAInvocar.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCampo(cartaMonstruoAInvocar));
        Assert.assertFalse(monstruoASacrificar1.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(monstruoASacrificar1));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoASacrificar1));
        Assert.assertFalse(monstruoASacrificar2.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCampo(monstruoASacrificar2));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(monstruoASacrificar2));
    }

}
