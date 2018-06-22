package algo3.fiuba;


import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.EnCementerio;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.estados_cartas.EnMano;
import algo3.fiuba.cartas.estados_cartas.EnMazo;

import java.util.LinkedList;
import java.util.List;

public class Jugador {

    private Integer puntosDeVida;
    private TableroJugador tableroJugador;
    private List<Carta> mano;
    private Jugador oponente;

    public Jugador() {
        this.puntosDeVida = 8000;
        this.mano = new LinkedList<>();
        this.tableroJugador = new TableroJugador();
    }

    public boolean estaEnJuego() {
        return puntosDeVida > 0;
    }

    public void modificarPuntosDeVida(Integer puntos) {
        puntosDeVida += (-puntos > puntosDeVida) ? -puntosDeVida : puntos;
    }

    public void tomarCartaDelMazo() {
        mano.add(tableroJugador.tomarCartaDelMazo());
    }

    public Integer cantidadCartasEnMano() {
        return mano.size();
    }

    public Integer getPuntosDeVida() {
        return puntosDeVida;
    }

    public void colocarCartaEnCampo(Carta carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        carta.setJugador(this);
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego, sacrificios);
    }


    public boolean cartaEstaEnTablero(Carta carta) {
        return tableroJugador.cartaEstaEnCampo(carta);
    }

    public boolean cartaEstaEnTablero(Monstruo carta) {
        return tableroJugador.cartaEstaEnCampo(carta);
    }

    public boolean cartaEstaEnTablero(NoMonstruo carta) {
        return tableroJugador.cartaEstaEnCampo(carta);
    }

    public void agregarCartaAMazo(Carta carta) {
        carta.setEstado(EnMazo.getInstancia());
        tableroJugador.agregarCartaAlMazo(carta);
    }

    public void setTableroJugador(TableroJugador tableroJugador) {
        this.tableroJugador = tableroJugador;
    }

    public void mandarCartaDelCampoAlCementerio(Carta carta) {
        carta.descartar();
        tableroJugador.removerCartaDelCampo(carta);
    }

    public void mandarCartaACementerio(Carta carta) {
        tableroJugador.agregarCartaACementerio(carta);
        carta.setEstado(EnCementerio.getInstancia());
    }


    public boolean cartaEstaEnCementerio(Carta carta) {
        return tableroJugador.cartaEstaEnCementerio(carta);
    }

    public void agregarCartaAMano(Carta carta) {
        carta.setEstado(EnMano.getInstancia());
        mano.add(carta);
    }

    public boolean cartaEstaEnMano(Carta carta) {
        return mano.contains(carta);
    }

    public int cantidadCartasEnMazo() {
        return tableroJugador.cantidadCartasEnMazo();
    }

    public boolean cartaEstaEnMazo(Carta carta) {
        return false;
    }

    public List<Carta> getMano() {
        return mano;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "puntosDeVida=" + puntosDeVida +
                ", tableroJugador=" + tableroJugador +
                ", mano=" + mano +
                '}';
    }

    public void setOponente(Jugador oponente) {
        this.oponente = oponente;
    }

    public boolean recibirAtaque(Monstruo monstruo) {
        boolean continuarAtaque = true;
        List<NoMonstruo> noMonstruos = tableroJugador.getNoMonstruos();
        for (NoMonstruo noMonstruo : noMonstruos) {
            if ((continuarAtaque = noMonstruo.activarTrampa())) {
                noMonstruo.activarEfecto(monstruo);
                return continuarAtaque;
            }
        }
        return !continuarAtaque;
    }

    public void inicializar() {
        this.puntosDeVida = 8000;
        this.mano = new LinkedList<>();
        this.tableroJugador = new TableroJugador();
    }

    public Jugador getOponente() {
        return oponente;
    }

    public List<Monstruo> getMonstuosEnCampo() {
        return tableroJugador.getMonstruos();
    }
}
