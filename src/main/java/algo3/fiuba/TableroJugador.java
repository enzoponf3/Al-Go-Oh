package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
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

    public boolean colocarCartaEnTablero(Carta unaCarta, EnJuego tipoEnJuego) {

        return this.campo.colocarCarta(unaCarta, tipoEnJuego);
    }

    public void agregarCartaMuerta(Carta unaCarta) {

        this.cementerio.add(unaCarta);
    }

    public Carta tomarCartaDelMazo() {
        return this.mazo.pop(); //Acá debería de sacar excepción de que no hay más en mazo o en Jugador?
    }

    public boolean cartaEnTablero(Carta carta) {
        return true;
    }

    public void agregarCartaAlMazo(Carta carta) {
        mazo.push(carta);
    }

    public boolean cartaEnCementerio(Monstruo monstruoAtacante) {
        return cementerio.contains(monstruoAtacante);
    }
}
