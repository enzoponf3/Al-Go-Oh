package algo3.fiuba.modelo;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.modificadores.Modificador;
import algo3.fiuba.modelo.excepciones.CartasInsuficientesExcepcion;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TableroJugador {

    private Stack<Carta> mazo;
    private Campo campo;
    private List<Carta> cementerio;

    public TableroJugador() {
        this.campo = new Campo();
        this.cementerio = new LinkedList<>();
        this.mazo = new Stack<>();
    }

    public void colocarCartaEnCampo(Monstruo carta, EnJuego tipoEnJuego) {
        this.campo.colocarCarta(carta, tipoEnJuego);
    }

    public void colocarCartaEnCampo(Magica carta, EnJuego tipoEnJuego) {
        tipoEnJuego.colocarCartaEnCampo(carta, campo);
    }

    public void colocarCartaEnCampo(Trampa carta, EnJuego tipoEnJuego) {
        this.campo.colocarCarta(carta, tipoEnJuego);
    }


    public void colocarCartaEnCampo(CartaCampo carta, EnJuego tipoEnJuego) {
        this.campo.colocarCarta(carta, tipoEnJuego);
    }

    public Carta tomarCartaDelMazo() {
        try {
            return this.mazo.pop(); //Acá debería de sacar excepción de que no hay más en mazo o en Jugador?
        } catch (Exception e) {
            throw new CartasInsuficientesExcepcion("Usted no posee mas cartas!");
        }
    }

    public boolean cartaEstaEnCampo(Carta carta) {
        return this.campo.cartaEstaEnCampo(carta);
    }

    public void agregarCartaAlMazo(Carta carta) {
        mazo.push(carta);
    }

    public boolean cartaEstaEnCementerio(Carta carta) {
        return cementerio.contains(carta);
    }

    public void removerCartaDelCampo(Carta carta) {
        carta.removerDelCampo(campo);
    }

    @Override
    public String toString() {
        return "TableroJugador{" +
                ", mazo=" + mazo +
                ", campo=" + campo +
                ", cementerio=" + cementerio +
                '}';
    }

    public int cantidadCartasEnMazo() {
        return mazo.size();
    }

    public void agregarCartaACementerio(Carta carta) {
        cementerio.add(carta);
    }

    public List<Monstruo> getMonstruos() {
        return campo.getMonstruos();
    }

    public List<NoMonstruo> getNoMonstruos() {
        return campo.getNoMonstruos();
    }

    public void agregarModificador(Modificador modificador) {
        campo.agregarModificador(modificador);
    }

    public void removerModificador(Modificador modificador) {
        campo.removerModificador(modificador);
    }

    public void setMazo(Stack<Carta> mazo) {
        this.mazo = mazo;
    }

    public CartaCampo getCartaCampo() {
        return campo.getCartaCampo();
    }

}
