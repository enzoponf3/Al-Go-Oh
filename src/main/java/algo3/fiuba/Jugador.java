package algo3.fiuba;


import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

import java.util.HashSet;
import java.util.Set;

public class Jugador {

    private Integer puntosDeVida;
    private TableroJugador tableroJugador;
    private Set<Carta> mano;


    public Jugador() {
        this.puntosDeVida = 8000;
        this.mano = new HashSet<>();
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

    public Integer cantidadCartas() {
        return mano.size();
    }

    public Integer getPuntosDeVida() {
        return puntosDeVida;
    }

    public void colocarCartaEnTablero(Carta carta, EnJuego tipoEnJuego) {
        if(!mano.contains(carta)) {
            throw new RuntimeException("No se posee la carta que se quiere colocar en Tablero");
        }
        tableroJugador.colocarCartaEnTablero(carta, tipoEnJuego);
        mano.remove(carta);
    }

    public boolean cartaEnTablero(Carta carta) {
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
}
