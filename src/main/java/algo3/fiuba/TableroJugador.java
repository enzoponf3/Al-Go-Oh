package algo3.fiuba;

import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnJuego;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TableroJugador {

    public CartaCampo cartaCampo;
    public Stack<Carta> mazo;
    private Campo campo;
    public List<Carta> cementerio;

    public TableroJugador() {

        this.campo = new Campo();
        this.cementerio = new LinkedList<>();
        this.mazo = new Stack<>();
    }

    public void colocarCartaEnTablero(Monstruo monstruo, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        this.campo.colocarCarta(monstruo, tipoEnJuego, sacrificios);
    }

    public void colocarCartaEnTablero(Carta carta, EnJuego tipoEnJuego) {
        campo.colocarCarta(carta, tipoEnJuego);
    }

    public void colocarCartaEnTablero(CartaCampo carta, EnJuego tipoEnJuego) {
        carta.pasarAModoJuego(tipoEnJuego);
        cartaCampo = carta;
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

    public void activarEfectoSobreElementos(EfectoCarta efecto) {
        campo.activarEfectoSobreElementos(efecto);
    }

    public void removerCartaDelCampo(Carta carta) {
        carta.removerDelCampo(campo);
        //carta.removerDelCampo(campo);
    }

    @Override
    public String toString() {
        return "TableroJugador{" +
                "cartaCampo=" + cartaCampo +
                ", mazo=" + mazo +
                ", campo=" + campo +
                ", cementerio=" + cementerio +
                '}';
    }

    public void inicializar() {
        cartaCampo = null;
        cementerio = new LinkedList<>();
        campo.reiniciar();
    }

    public int cantidadCartasEnMazo() {
        return mazo.size();
    }

    public void agregarCartaACementerio(Carta carta) {
        cementerio.add(carta);
    }

    public void matarMonstruos() {
        campo.matarMonstruos();
    }

    public List<Monstruo> getMonstruos() {
        return campo.getMonstruos();
    }

    public List<NoMonstruo> getNoMonstruos() {
        return campo.getNoMonstruos();
    }

    public CartaCampo getCartaCampo() {
        return cartaCampo;
    }

}
