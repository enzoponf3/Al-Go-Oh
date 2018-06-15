package algo3.fiuba;


import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.resultado_combate.NoMonstro;

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

    public void colocarCartaEnTablero(Carta carta, EnJuego tipoEnJuego) {
        /*
        if(!mano.contains(carta)) {
            throw new RuntimeException("No se posee la carta que se quiere colocar en Tablero");
        }
        */
        tableroJugador.colocarCartaEnTablero(carta, tipoEnJuego);
        mano.remove(carta);
    }

    public boolean cartaEstaEnTablero(Carta carta) {
        return carta.estaEnTablero(this);
    }

    public boolean cartaEstaEnTablero(Monstruo carta) {
        return tableroJugador.cartaEnTablero(carta);
    }

    public boolean cartaEstaEnTablero(NoMonstro carta) {
        return tableroJugador.cartaEnTablero(carta);
    }

    public void agregarCartaAMazo(Carta carta) {
        tableroJugador.agregarCartaAlMazo(carta);
    }

    public void setTableroJugador(TableroJugador tableroJugador) {
        this.tableroJugador = tableroJugador;
    }

    public void mandarAlCementerio(Carta carta) {
        tableroJugador.agregarCartaAlCementerio(carta);
    }

    public boolean cartaEstaEnCementerio(Carta carta) {
        return tableroJugador.cartaEstaEnCementerio(carta);
    }

    public void agregarEnMano(Carta carta) {
        mano.add(carta);
    }
}
