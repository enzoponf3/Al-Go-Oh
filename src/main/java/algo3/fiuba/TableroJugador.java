package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

import java.util.LinkedList;
import java.util.Stack;

public class TableroJugador {

    public ZonaCartaCampo cartaCampo;
    public Stack<Carta> mazo;
    private Campo campo;
    public LinkedList<Carta> cementerio;

    public TableroJugador() {

        this.campo = new Campo();
        this.cementerio = new LinkedList<>();
        this.mazo = new Stack<>();
    }

    public void colocarCartaEnTablero(Carta carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        this.campo.colocarCarta(carta, tipoEnJuego, sacrificios);
    }

    public void agregarCartaAlCementerio(Carta carta) {
        this.cementerio.add(carta);
    }

    public Carta tomarCartaDelMazo() {
        return this.mazo.pop(); //Acá debería de sacar excepción de que no hay más en mazo o en Jugador?
    }

    public boolean cartaEstaEnTablero(Monstruo carta) {
        return this.campo.cartaSeEncuentaEnCampo(carta);
    }

    public boolean cartaEstaEnTablero(NoMonstruo carta) {
        return this.campo.cartaSeEncuentaEnCampo(carta);
    }


    public void agregarCartaAlMazo(Carta carta) {
        mazo.push(carta);
    }

    public boolean cartaEstaEnCementerio(Carta carta) {
        return cementerio.contains(carta);
    }

    public Integer monstruosEnJuego() {
        return campo.cantidadMonstruos();
    }
}
