package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.Trampa;

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

    public boolean colocarCartaEnTablero(Carta carta) {

        return this.campo.campoColocarCarta(carta);
    }

    public void agregarCartaMuerta(Carta carta) {

        this.cementerio.add(carta);
    }

    public Carta tomarCartaMazo() {
        return this.mazo.pop(); //Acá debería de sacar excepción de que no hay más en mazo o en Jugador?
    }

    public boolean cartaEnTablero(Carta carta) {
        return this.campo.cartaSeEncuentaEnCampo(carta);
    }

    public void agregarCartaAMazo(Carta carta) {
        mazo.push(carta);
    }

    public boolean cartaEnCementerio(Monstruo monstruoAtacante) {
        return cementerio.contains(monstruoAtacante);
    }

    public Integer monstruosEnJuego() {
        return campo.cantidadMonstruos();
    }
}