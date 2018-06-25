package algo3.fiuba.entrega2;

import algo3.fiuba.Juego;
import algo3.fiuba.jugador.Jugador;
import algo3.fiuba.cartas.*;
import algo3.fiuba.cartas.efectos.EfectoNulo;
import algo3.fiuba.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.cartas.moldes_cartas.cartas_campo.Sogen;
import algo3.fiuba.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.cartas.moldes_cartas.cartas_magicas.Fisura;
import algo3.fiuba.cartas.moldes_cartas.cartas_magicas.OllaDeLaCodicia;
import algo3.fiuba.cartas.moldes_cartas.cartas_monstruos.*;
import algo3.fiuba.cartas.moldes_cartas.cartas_trampas.CilindroMagico;
import algo3.fiuba.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Entrega2Test {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;

    @Before
    public void setUp() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();

        juego = Juego.getInstancia();
        juego.inicializar(jugador1, jugador2);
    }


    @Test
    public void colocoMonstruoACadaLadoDeCampo_activoCartaCampoWasteland_aumenta200ATKPropio_aumenta300DEFOponente() {
        Monstruo monstruo1 = new Monstruo("Monstruo 1",0,0,1, new EfectoNulo());
        Monstruo monstruo2 = new Monstruo("Monstruo 2",0,0,1, new EfectoNulo());

        CartaCampo wasteland = new Wasteland(jugador1, jugador2);

        jugador1.colocarCartaEnCampo(monstruo1, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruo2, new BocaAbajo());

        // Ni bien se coloca carta de campo esta se activa.
        jugador1.colocarCartaEnCampo(wasteland, new BocaArriba());

        // Se suma 300 a la defensa del oponente y el ataque permanece igual.
        int defensaFinalOponente = 300;
        Assert.assertEquals(defensaFinalOponente, (int)monstruo2.getDefensa());
        int ataqueFinalOponente = 0;
        Assert.assertEquals(ataqueFinalOponente, (int)monstruo2.getAtaque());

        // Se suma 200 al ataque propio y la defensa permanece igual.
        int ataqueFinalPropio = 200;
        Assert.assertEquals(ataqueFinalPropio, (int)monstruo1.getAtaque());
        int defensaFinalPropio = 0;
        Assert.assertEquals(defensaFinalPropio, (int)monstruo1.getDefensa());

        Monstruo monstruo3 = new Monstruo("Monstruo 3", 0, 0, 1, new EfectoNulo());
        Monstruo monstruo4 = new Monstruo("Monstruo 4", 0, 0, 1, new EfectoNulo());

        jugador1.colocarCartaEnCampo(monstruo3, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruo4, new BocaArriba());

        // El efecto de las cartas de campo se mantienen activas, aún para cartas agregadas después de colocar estas.
        Assert.assertEquals(defensaFinalOponente, (int) monstruo4.getDefensa());
        Assert.assertEquals(ataqueFinalPropio, (int)monstruo3.getAtaque());
    }


    @Test
    public void colocoMounstruoDeCadaLadoDeCampo_activoCartaCampoSogen_aumenta500DEFPropio_aumenta200ATKOponente() {
        Monstruo monstruoPropio = new Monstruo("m", 0, 0, 1, new EfectoNulo());
        Monstruo monstruoOponente = new Monstruo("m", 0, 0, 1, new EfectoNulo());
        CartaCampo sogen = new Sogen(jugador1, jugador2);

        jugador1.colocarCartaEnCampo(monstruoPropio, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruoOponente, new BocaArriba());

        // Ni bien se coloca una carta de campo esta se debe de activarEfecto.
        jugador1.colocarCartaEnCampo(sogen, new BocaArriba());

        // Se suma 200 al ataque de las cartas en el campo del oponente.
        int ataqueFinalOponente = 200;
        Assert.assertEquals(ataqueFinalOponente, (int)monstruoOponente.getAtaque());

        // Se suma 500 a la defenza de las cartas en el campo propio.
        int defensaFinalPropio = 500;
        Assert.assertEquals(defensaFinalPropio, (int)monstruoPropio.getDefensa());

        Monstruo monstruo3 = new Monstruo("Monstruo 3", 0, 0, 1, new EfectoNulo());
        Monstruo monstruo4 = new Monstruo("Monstruo 4", 0, 0, 1, new EfectoNulo());

        jugador1.colocarCartaEnCampo(monstruo3, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruo4, new BocaArriba());

        // El efecto de las cartas de campo se mantienen activas, aún para cartas agregadas después de colocar estas.
        Assert.assertEquals(ataqueFinalOponente, (int) monstruo4.getAtaque());
        Assert.assertEquals(defensaFinalPropio, (int)monstruo3.getDefensa());

    }


    @Test
    public void activoCartaOllaDelaCodicia_TomoDosCartasDelMazo() {
        Monstruo monstruo1 = new Monstruo("Rodri", 100, 100, 1, new EfectoNulo());
        Monstruo monstruo2 = new Monstruo("Delfi", 2120, 0, 2, new EfectoNulo());
        Magica ollaDeLaCodicia = new OllaDeLaCodicia(jugador1);

        jugador1.agregarCartaAMazo(monstruo1);
        jugador1.agregarCartaAMazo(monstruo2);
        jugador1.colocarCartaEnCampo(ollaDeLaCodicia, new BocaArriba());

        ollaDeLaCodicia.activarEfecto();
        // Se agregaron dos cartas a la mano del jugador, sacadas del mazo de este.
        Assert.assertTrue(jugador1.cartaEstaEnMano(monstruo1));
        Assert.assertTrue(jugador1.cartaEstaEnMano(monstruo2));

        Integer cartasEnMano = 2;
        Assert.assertEquals(cartasEnMano, jugador1.cantidadCartasEnMano());
        Assert.assertEquals(0, jugador1.cantidadCartasEnMazo());

        // Luego de ser usada la carta mágica va al cementerio.
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(ollaDeLaCodicia));
        Assert.assertFalse(jugador1.cartaEstaEnCampo(ollaDeLaCodicia));
    }

    @Test
    public void colocoDosCartasMonstruoEnCampoEnemigo_activoFisura_elDeMenorAtaqueEsDestruido() {
        Monstruo monstruoFuerte = new SevenColoredFish(jugador2);
        Monstruo monstruoDebil = new Jinzo7(jugador2);
        Magica fisura = new Fisura(jugador1);

        jugador2.colocarCartaEnCampo(monstruoDebil, new BocaArriba());
        jugador2.colocarCartaEnCampo(monstruoFuerte, new BocaArriba());
        jugador1.colocarCartaEnCampo(fisura, new BocaArriba());

        fisura.activarEfecto();

        // Después de ser usada la carta mágica va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(fisura));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(fisura));

        // La carta de menor ataque del enemigo va al cementerio.
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoFuerte));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoFuerte));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoDebil));
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoDebil));
    }

    @Test
    public void invocoAJinzo7_atacaDirectoALosPuntosDeVidaDelOponente() {
        Carta jinzo7 = new Jinzo7(jugador1);

        jugador1.colocarCartaEnCampo(jinzo7, new BocaArriba());

        jinzo7.activarEfecto();

        // No se ataca a las cartas en el campo enemigo.

        // Se atacan los puntos de vida del oponente.
        Integer vidaFinalEnemigo = 8000 - 500;
        Assert.assertEquals(vidaFinalEnemigo, jugador2.getPuntosDeVida());

        // Después de atacar Jinzo7 se mantiene en el tablero.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(jinzo7));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(jinzo7));
    }

    @Test
    public void invocarDragonDefinitivo_seSacrifiacanTresDragonesBlancosOjosAzules() {
        Monstruo dragonASacrificar1 = new DragonBlancoDeOjosAzules(jugador1);
        Monstruo dragonASacrificar2 = new DragonBlancoDeOjosAzules(jugador1);
        Monstruo dragonASacrificar3 = new DragonBlancoDeOjosAzules(jugador1);

        // Monstruos de sacrificio para poder invocar a los tres dragones blancos de ojos azúles.
        Monstruo monstruoASacrificar1 = new SevenColoredFish(jugador1);
        Monstruo monstruoASacrificar2 = new SevenColoredFish(jugador1);
        Monstruo monstruoASacrificar3 = new SevenColoredFish(jugador1);
        Monstruo monstruoASacrificar4 = new SevenColoredFish(jugador1);
        Monstruo monstruoASacrificar5 = new SevenColoredFish(jugador1);
        Monstruo monstruoASacrificar6 = new SevenColoredFish(jugador1);

        // Invoco los dragones, con sus respectivos sacrificios.
        jugador1.colocarCartaEnCampo(monstruoASacrificar1, new BocaAbajo());
        jugador1.colocarCartaEnCampo(monstruoASacrificar2, new BocaAbajo());
        jugador1.colocarCartaEnCampo(dragonASacrificar1, new BocaAbajo(), monstruoASacrificar1, monstruoASacrificar2);

        jugador1.colocarCartaEnCampo(monstruoASacrificar3, new BocaAbajo());
        jugador1.colocarCartaEnCampo(monstruoASacrificar4, new BocaAbajo());
        jugador1.colocarCartaEnCampo(dragonASacrificar2, new BocaAbajo(), monstruoASacrificar3, monstruoASacrificar4);

        jugador1.colocarCartaEnCampo(monstruoASacrificar5, new BocaAbajo());
        jugador1.colocarCartaEnCampo(monstruoASacrificar6, new BocaAbajo());
        jugador1.colocarCartaEnCampo(dragonASacrificar3, new BocaAbajo(), monstruoASacrificar5, monstruoASacrificar6);

        Carta dragonDefinitivo = new DragonDefinitivoDeOjosAzules(jugador1);

        jugador1.colocarCartaEnCampo(dragonDefinitivo, new BocaArriba(), dragonASacrificar1, dragonASacrificar2, dragonASacrificar3);

        // Para invocar al Dragón definitivo se tuvo que sacrificar a los tres dragones.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(dragonASacrificar1));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar1));
        Assert.assertFalse(jugador1.cartaEstaEnCampo(dragonASacrificar2));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar2));
        Assert.assertFalse(jugador1.cartaEstaEnCampo(dragonASacrificar3));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(dragonASacrificar3));

        // Se debería de haber colocado al dragón definitivo.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(dragonDefinitivo));
        Assert.assertTrue(dragonDefinitivo.estaEnJuego());
    }

    @Test
    public void colocoInsectoComeHombresBocaAbajo_monstruoOponenteLoAtaca_seActivaEfectoYSeDestruyeAtacante() {
        Monstruo insectoComeHombres = new InsectoComeHombres(jugador1);
        Monstruo monstruoAtacante = new BebeDragon(jugador2);

        jugador1.colocarCartaEnCampo(insectoComeHombres, new BocaAbajo());
        insectoComeHombres.pasarAModoDefensa();
        jugador2.colocarCartaEnCampo(monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(insectoComeHombres);

        Integer puntosInicialesDeVida = 8000;

        // El monstruo atacante fue destruído.
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoAtacante));
        Assert.assertEquals(puntosInicialesDeVida, jugador2.getPuntosDeVida());

        // El insecto come-hombres sigue vivo y jugador no perdió vida.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(insectoComeHombres));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(insectoComeHombres));
        Assert.assertEquals(puntosInicialesDeVida, jugador1.getPuntosDeVida());
    }

    @Test
    public void atacarATrampaCilindroMagico_seNiegaAtaqueYSeEfectuaALosPuntosDeVidaDelAtacante() {
        Monstruo monstruoAtacante = new SevenColoredFish(jugador2);
        Monstruo monstruoAtacado = new Jinzo7(jugador1);
        Carta cilindroMagico = new CilindroMagico(jugador1);

        jugador1.colocarCartaEnCampo(monstruoAtacado, new BocaArriba());
        jugador1.colocarCartaEnCampo(cilindroMagico, new BocaAbajo());
        jugador2.colocarCartaEnCampo(monstruoAtacante, new BocaArriba());

        monstruoAtacante.atacar(monstruoAtacado);

        // Las cartas monstruo de ambos lados del tablero siguen vivas.
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(jugador2.cartaEstaEnCampo(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCementerio(monstruoAtacante));

        // El que ataco recibió ataque a sus puntos de vida igual al ataque de la carta con la que atacó.
        Integer vidaFinalAtacante = 8000 - monstruoAtacante.getAtaque();
        Assert.assertEquals(vidaFinalAtacante, jugador2.getPuntosDeVida());

        // El atacado no recibe daño alguno.
        Integer vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, jugador1.getPuntosDeVida());

        // Después de ser activada una carta Trampa va al cementerio.
        Assert.assertFalse(jugador1.cartaEstaEnCampo(cilindroMagico));
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(cilindroMagico));
    }


    @Test
    public void colocoTrampaRefuerzos_seAtacaConMonstruoDe400ATKMas_monstruoAtacadoAumenta500ATKAlActivarTrampa() {
        Monstruo monstruoAtacado = new Kuriboh(jugador1); // ATK 300
        Trampa refuerzos = new Refuerzos(jugador1); // ATK 500
        Monstruo monstruoAtacante = new Jinzo7(jugador2);

        // Los monstruos por default se colocan en modo ataque
        jugador1.colocarCartaEnCampo(monstruoAtacado, new BocaAbajo());
        jugador1.colocarCartaEnCampo(refuerzos, new BocaAbajo());
        jugador2.colocarCartaEnCampo(monstruoAtacante, new BocaArriba());

        // Al atacar al monstruoAtacado se activa la trampa, que le suma 500ATK a este mismo.
        monstruoAtacante.atacar(monstruoAtacado);

        // Muere el monstruo atacante.
        Assert.assertFalse(monstruoAtacante.estaEnJuego());
        Assert.assertTrue(jugador2.cartaEstaEnCementerio(monstruoAtacante));
        Assert.assertFalse(jugador2.cartaEstaEnCampo(monstruoAtacante));

        Assert.assertTrue(monstruoAtacado.estaEnJuego());
        Assert.assertFalse(jugador1.cartaEstaEnCementerio(monstruoAtacado));
        Assert.assertTrue(jugador1.cartaEstaEnCampo(monstruoAtacado));

        // Se le resta a los puntos de vida del atacante la diferencia de ataques.
        Integer vidaFinalAtacante = 8000 - ((300 + 500) - 500);
        Assert.assertEquals(vidaFinalAtacante, jugador2.getPuntosDeVida());

        // El jugador atacado no recibe daño.
        Integer vidaFinalAtacado = 8000;
        Assert.assertEquals(vidaFinalAtacado, jugador1.getPuntosDeVida());

        // La carta Trampa después de activada va al cementerio.
        Assert.assertFalse(refuerzos.estaEnJuego());
        Assert.assertTrue(jugador1.cartaEstaEnCementerio(refuerzos));
        Assert.assertFalse(jugador1.cartaEstaEnCampo(refuerzos));
    }

    @Test
    public void extraerTodasLasCartasDeMazo_jugadorSinCartasPerdio() {
        Monstruo monstruo1 = new Monstruo("Rodri", 100, 100, 1, new EfectoNulo());
        Monstruo monstruo2 = new Monstruo("Delfi", 2120, 0, 2, new EfectoNulo());

        jugador1.agregarCartaAMazo(monstruo1);
        jugador2.agregarCartaAMazo(monstruo2);

        // Con jugadores recién creados y cartas en los mazos la partida no terminó.
        Assert.assertFalse(juego.terminoPartida());
        Assert.assertEquals(null, juego.ganadorPartida());

        // Se toma la última carta que había (se debería de poder jugar el último turno).
        // Cuando se quiere empezar otro turno sin cartas en mazo se termina partida.
        jugador1.tomarCartaDelMazo();
        //jugador1.tomarCartaDelMazo(); aca lanza excepcion, porque sacar una carta del mazo sin cartas no es posible (falta turnos)

        // Al no tener más cartas en mazo se termina la partida y el jugador sin cartas pierde.
        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador2, juego.ganadorPartida());
    }

    @Test
    public void colocarCincoPartesDeExodia_jugadorConPartesGanaPartido() {
        Monstruo parteExodia1 = new PiernaDerechaExodia(jugador1);
        Monstruo parteExodia2 = new PiernaIzquierdaExodia(jugador1);
        Monstruo parteExodia3 = new CabezaExodia(jugador1);
        Monstruo parteExodia4 = new BrazoDerechoExodia(jugador1);
        Monstruo parteExodia5 = new BrazoIzquierdoExodia(jugador1);

        jugador2.agregarCartaAMazo(new MagoOscuro(jugador2));
        jugador1.agregarCartaAMazo(new SevenColoredFish(jugador1));

        jugador1.agregarCartaAMazo(parteExodia1);
        jugador1.agregarCartaAMazo(parteExodia2);
        jugador1.agregarCartaAMazo(parteExodia3);
        jugador1.agregarCartaAMazo(parteExodia4);
        jugador1.agregarCartaAMazo(parteExodia5);

        for (int i = 0; i<5; i++) {
            jugador1.tomarCartaDelMazo();
        }

        // Cuando un jugador tiene las cinco partes en la mano, se termina la partida y este gana directamente.
        Assert.assertTrue(juego.terminoPartida());
        Assert.assertEquals(jugador1, juego.ganadorPartida());
    }
}

