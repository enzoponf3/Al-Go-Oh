package algo3.fiuba.jugador;


import algo3.fiuba.TableroJugador;
import algo3.fiuba.Turno;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.CartaCampo;
import algo3.fiuba.cartas.Monstruo;
import algo3.fiuba.cartas.estados_cartas.EnCementerio;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.NoMonstruo;
import algo3.fiuba.cartas.estados_cartas.EnMano;
import algo3.fiuba.cartas.estados_cartas.EnMazo;
import algo3.fiuba.cartas.modificadores.Modificador;

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
        return estaVivo() && tieneCartas();
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public boolean tieneCartas() {
        return this.cantidadCartasEnMazo() > 0;
    }

    public void modificarPuntosDeVida(Integer puntos) {
        puntosDeVida += (-puntos > puntosDeVida) ? -puntosDeVida : puntos;
    }

    public void tomarCartaDelMazo() {
        Carta carta = tableroJugador.tomarCartaDelMazo();
        carta.agregarAMano(mano);
    }

    public Integer cantidadCartasEnMano() {
        return mano.size();
    }

    public Integer getPuntosDeVida() {
        return puntosDeVida;
    }

    public void colocarCartaEnCampo(Carta carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        //tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego, sacrificios);
        carta.colocarEnCampo(this, tipoEnJuego, sacrificios);
        carta.setJugador(this); // !!! sacar
        Turno.getInstancia().addObserver(carta);

    }

    public void colocarCartaEnCampo(Monstruo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego, sacrificios);
        carta.setJugador(this);
    }

    public void colocarCartaEnCampo(NoMonstruo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego, sacrificios);
        carta.setJugador(this);
    }

    public void colocarCartaEnCampo(CartaCampo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        tableroJugador.colocarCartaEnCampo(carta, tipoEnJuego, sacrificios);
        carta.setJugador(this);
    }


    public boolean cartaEstaEnCampo(Carta carta) {
        return tableroJugador.cartaEstaEnCampo(carta);
    }

    public boolean cartaEstaEnCampo(Monstruo carta) {
        return tableroJugador.cartaEstaEnCampo(carta);
    }

    public boolean cartaEstaEnCampo(NoMonstruo carta) {
        return tableroJugador.cartaEstaEnCampo(carta);
    }

    public void agregarCartaAMazo(Carta carta) {
        carta.setEstado(new EnMazo());
        tableroJugador.agregarCartaAlMazo(carta);
    }

    public void setTableroJugador(TableroJugador tableroJugador) {
        this.tableroJugador = tableroJugador;
    }

    public void mandarCartaDelCampoAlCementerio(Carta carta) {
        carta.setEstado(new EnCementerio());
        tableroJugador.removerCartaDelCampo(carta);
        tableroJugador.agregarCartaACementerio(carta);
    }

    public void mandarCartaACementerio(Carta carta) {
        tableroJugador.agregarCartaACementerio(carta);
        carta.setEstado(new EnCementerio());
    }

    public boolean cartaEstaEnCementerio(Carta carta) {
        return tableroJugador.cartaEstaEnCementerio(carta);
    }

    public void agregarCartaAMano(Carta carta) {
        carta.setEstado(new EnMano());
        carta.activarEfecto(carta, this);
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

    public boolean recibirAtaque(Monstruo monstruoAtacante, Monstruo monstruoAtacado) {
        boolean continuarAtaque = true;
        List<NoMonstruo> noMonstruos = tableroJugador.getNoMonstruos();
        for (NoMonstruo noMonstruo : noMonstruos) {
            if ((continuarAtaque = noMonstruo.activarTrampa())) {
                noMonstruo.activarEfecto(monstruoAtacante, monstruoAtacado);
                return noMonstruo.bloquearAtaque();
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

    public void setOponente(Jugador oponente) {
        this.oponente = oponente;
    }

    public List<Monstruo> getMonstuosEnCampo() {
        return tableroJugador.getMonstruos();
    }

    public void agregarModificador(Modificador modificador) {
        tableroJugador.agregarModificador(modificador);
    }


}
