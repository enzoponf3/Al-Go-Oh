package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.cartas.estado_en_turno.NoUsadaEnTurno;
import algo3.fiuba.modelo.cartas.estado_en_turno.TurnoRival;
import algo3.fiuba.modelo.cartas.estado_en_turno.UsadaEnTurno;
import algo3.fiuba.modelo.cartas.estados_cartas.*;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.Wasteland;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_monstruos.BebeDragon;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_trampas.Refuerzos;
import algo3.fiuba.modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccionCartaTest {

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
    public void cartaMagica_noUsadaEnTurno_noInicializada() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_noUsadaEnTurno_enMazo() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_noUsadaEnTurno_enMano() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMano());

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.COLOCAR_EN_CAMPO));
    }

    @Test
    public void cartaMagica_noUsadaEnTurno_BocaArriba() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaArriba());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_noUsadaEnTurno_BocaAbajo() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaAbajo());

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.ACTIVAR_EFECTO));
    }

    @Test
    public void cartaMagica_noUsadaEnTurno_enCementerio() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnCementerio());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_turnoDelOponente_noInicializada() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_turnoDelOponente_enMazo() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_turnoDelOponente_enMano() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_turnoDelOponente_BocaArriba() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaArriba());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_turnoDelOponente_BocaAbajo() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaAbajo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMagica_turnoDelOponente_enCementerio() {
        Carta carta = new AgujeroNegro(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    /////////////////

    @Test
    public void cartaTrampa_noUsadaEnTurno_noInicializada() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_noUsadaEnTurno_enMazo() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_noUsadaEnTurno_enMano() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMano());

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.COLOCAR_EN_CAMPO));
    }

    @Test
    public void cartaTrampa_noUsadaEnTurno_BocaArriba() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaArriba());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_noUsadaEnTurno_BocaAbajo() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaAbajo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_noUsadaEnTurno_enCementerio() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnCementerio());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_turnoDelOponente_noInicializada() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_turnoDelOponente_enMazo() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_turnoDelOponente_enMano() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_turnoDelOponente_BocaArriba() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaArriba());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_turnoDelOponente_BocaAbajo() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaAbajo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaTrampa_turnoDelOponente_enCementerio() {
        Carta carta = new Refuerzos(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }


    ///////////////////////////////////

    @Test
    public void cartaCampo_noUsadaEnTurno_noInicializada() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_noUsadaEnTurno_enMazo() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_noUsadaEnTurno_enMano() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMano());

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.COLOCAR_EN_CAMPO));
    }

    @Test
    public void cartaCampo_noUsadaEnTurno_BocaArriba() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaArriba());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_noUsadaEnTurno_BocaAbajo() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaAbajo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_noUsadaEnTurno_enCementerio() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnCementerio());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_turnoDelOponente_noInicializada() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_turnoDelOponente_enMazo() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_turnoDelOponente_enMano() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_turnoDelOponente_BocaArriba() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaArriba());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_turnoDelOponente_BocaAbajo() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaAbajo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaCampo_turnoDelOponente_enCementerio() {
        Carta carta = new Wasteland(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }


    ///////////////////////////////////

    @Test
    public void cartaMonstruo_noUsadaEnTurno_noInicializada() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_noUsadaEnTurno_enMazo() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_noUsadaEnTurno_enMano() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnMano());

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.COLOCAR_EN_CAMPO));
    }

    @Test
    public void cartaMonstruo_noUsadaEnTurno_BocaArriba_modoDeAtaque() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaArriba());

        Assert.assertEquals(2, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.ATACAR));
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.CAMBIAR_MODO));
    }

    @Test
    public void cartaMonstruo_noUsadaEnTurno_BocaAbajo_modoDeAtaque() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaAbajo());

        Assert.assertEquals(3, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.ATACAR));
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.CAMBIAR_MODO));
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.GIRAR_CARTA));
    }

    @Test
    public void cartaMonstruo_noUsadaEnTurno_BocaArriba_modoDeDefensa() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaArriba());
        ((BebeDragon) carta).cambiarModo();

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.CAMBIAR_MODO));
    }

    @Test
    public void cartaMonstruo_noUsadaEnTurno_BocaAbajo_modoDeDefensa() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new BocaAbajo());
        ((BebeDragon) carta).cambiarModo();

        Assert.assertEquals(2, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.CAMBIAR_MODO));
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.GIRAR_CARTA));
    }


    @Test
    public void cartaMonstruo_noUsadaEnTurno_enCementerio() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new NoUsadaEnTurno());
        carta.setEstado(new EnCementerio());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_usadaEnTurno_noInicializada() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new UsadaEnTurno());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_usadaEnTurno_enMazo() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new UsadaEnTurno());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_usadaEnTurno_enMano() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new UsadaEnTurno());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_usadaEnTurno_BocaArriba() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new UsadaEnTurno());
        carta.setEstado(new BocaArriba());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_usadaEnTurno_BocaAbajo() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new UsadaEnTurno());
        carta.setEstado(new BocaAbajo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_usadaEnTurno_enCementerio() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new UsadaEnTurno());
        carta.setEstado(new EnCementerio());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }


    @Test
    public void cartaMonstruo_turnoDelOponente_noInicializada() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EstadoNoInicializado());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_turnoDelOponente_enMazo() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMazo());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_turnoDelOponente_enMano() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

    @Test
    public void cartaMonstruo_turnoDelOponente_BocaArriba() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaArriba());

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.RECIBIR_ATAQUE));
    }

    @Test
    public void cartaMonstruo_turnoDelOponente_BocaAbajo() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new BocaAbajo());

        Assert.assertEquals(1, carta.accionesDisponibles().size());
        Assert.assertTrue(carta.accionesDisponibles().contains(AccionCarta.RECIBIR_ATAQUE));
    }

    @Test
    public void cartaMonstruo_turnoDelOponente_enCementerio() {
        Carta carta = new BebeDragon(jugador1);
        carta.setEstadoEnTurno(new TurnoRival());
        carta.setEstado(new EnMano());

        Assert.assertTrue(carta.accionesDisponibles().isEmpty());
    }

}
