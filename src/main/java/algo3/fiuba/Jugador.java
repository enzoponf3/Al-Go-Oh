package algo3.fiuba;


import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.NoMonstruo;

import java.util.HashSet;
import java.util.Set;

public class Jugador {

    private Integer puntosDeVida;
    private TableroJugador tableroJugador;
    private Set<Carta> mano;


    public Jugador() {
        this.puntosDeVida = 8000;
        this.mano = new HashSet<>();
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

    public void colocarCartaEnTablero(Carta carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        carta.setJugador(this);
        tableroJugador.colocarCartaEnTablero(carta, tipoEnJuego, sacrificios);
        // mano.remove(carta);
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
        tableroJugador.agregarCartaAlMazo(carta);
    }

    public void setTableroJugador(TableroJugador tableroJugador) {
        this.tableroJugador = tableroJugador;
    }

    public void mandarCartaDelTableroAlCementerio(Carta carta) {
        tableroJugador.mandarCartaAlCementerio(carta);
    }

    /*
    public void removerCartaDelTablero(Carta carta) {
        tableroJugador.removerCarta(carta);
    }
    */

    public boolean cartaEstaEnCementerio(Carta carta) {
        return tableroJugador.cartaEstaEnCementerio(carta);
    }

    public void agregarEnMano(Carta carta) {
        mano.add(carta);
    }

    public void removerCartaDelTablero(Monstruo carta) {
        tableroJugador.removerCarta(carta);
    }

    public void removerCartaDelTablero(NoMonstruo carta) {
        tableroJugador.removerCarta(carta);
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
