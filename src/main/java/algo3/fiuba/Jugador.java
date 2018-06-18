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

    public Jugador() {
        this.puntosDeVida = 8000;
        this.mano = new LinkedList<>();
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

    public Integer cantidadCartas() {
        return mano.size();
    }

    public Integer getPuntosDeVida() {
        return puntosDeVida;
    }

    public void colocarCartaEnTablero(Monstruo monstruo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        monstruo.setJugador(this);
        tableroJugador.colocarCartaEnTablero(monstruo, tipoEnJuego, sacrificios);
    }

    public void colocarCartaEnTablero(Carta carta, EnJuego tipoEnJuego) {
        carta.setJugador(this);
        tableroJugador.colocarCartaEnTablero(carta, tipoEnJuego);
    }


    public boolean cartaEstaEnTablero(Carta carta) {
        return carta.estaEnTablero(tableroJugador);
    }

    public boolean cartaEstaEnTablero(Monstruo carta) {
        return tableroJugador.cartaEstaEnTablero(carta);
    }

    public boolean cartaEstaEnTablero(NoMonstruo carta) {
        return tableroJugador.cartaEstaEnTablero(carta);
    }

    public void agregarCartaAMazo(Carta carta) {
        carta.setEstado(EnMazo.getInstancia());
        tableroJugador.agregarCartaAlMazo(carta);
    }

    public void setTableroJugador(TableroJugador tableroJugador) {
        this.tableroJugador = tableroJugador;
    }

    public void mandarCartaDelTableroAlCementerio(Carta carta) {
        carta.descartar();
        tableroJugador.removerCartaDelCampo(carta);
        //tableroJugador.mandarCartaACementerio(carta);
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

    public void removerCartaDelTablero(Monstruo carta) {
        tableroJugador.removerCartaDelCampo(carta);
    }

    public void removerCartaDelTablero(NoMonstruo carta) {
        tableroJugador.removerCartaDelCampo(carta);
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
}
