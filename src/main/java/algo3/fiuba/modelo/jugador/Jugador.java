package algo3.fiuba.modelo.jugador;


import algo3.fiuba.modelo.TableroJugador;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.cartas.estados_cartas.EnCementerio;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.cartas.estados_cartas.EnMano;
import algo3.fiuba.modelo.cartas.estados_cartas.EnMazo;
import algo3.fiuba.modelo.cartas.modificadores.Modificador;

import java.util.*;

public class Jugador implements Observer {

    private Integer puntosDeVida;
    private TableroJugador tableroJugador;
    private List<Carta> mano;
    private EstadoJugador estadoJugador;
    private Jugador oponente;
    private static final Integer PUNTOS_DE_VIDA_INICIALES = 8000;
    private String nombre;

    public Jugador() {
        this.puntosDeVida = PUNTOS_DE_VIDA_INICIALES;
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
        carta.colocarEnCampo(this, tipoEnJuego, sacrificios);
        Turno.getInstancia().addObserver(carta);
    }

    public void colocarCartaEnCampo(Monstruo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        estadoJugador = estadoJugador.colocarCartaEnCampo(this, tableroJugador, carta, tipoEnJuego);
    }

    public void colocarCartaEnCampo(Magica carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        estadoJugador = estadoJugador.colocarCartaEnCampo(this, tableroJugador, carta, tipoEnJuego);
    }

    public void colocarCartaEnCampo(Trampa carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        estadoJugador = estadoJugador.colocarCartaEnCampo(this, tableroJugador, carta, tipoEnJuego);
    }

    public void colocarCartaEnCampo(CartaCampo carta, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        estadoJugador = estadoJugador.colocarCartaEnCampo(this, tableroJugador, carta, tipoEnJuego);
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

    public void removerCartaDelCampo(Carta carta) {
        tableroJugador.removerCartaDelCampo(carta);
    }

    @Override
    public void update(Observable o, Object arg) {
        estadoJugador = estadoJugador.cambioDeTurno();
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
                return noMonstruo.negarAtaque();
            }
        }
        return !continuarAtaque;
    }

    public void inicializar() {
        this.puntosDeVida = PUNTOS_DE_VIDA_INICIALES;
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

    public List<NoMonstruo> getNoMonstuosEnCampo() {
        return tableroJugador.getNoMonstruos();
    }

    public CartaCampo getCartaCampoActiva() {
        return tableroJugador.getCartaCampo();
    }

    public void agregarModificador(Modificador modificador) {
        tableroJugador.agregarModificador(modificador);
    }

    public void removerModificador(Modificador modificador) {
        tableroJugador.removerModificador(modificador);
    }

    public void setEstadoJugador(EstadoJugador estadoJugador) {
        this.estadoJugador = estadoJugador;
    }

    public EstadoJugador getEstadoJugador() {
        return this.estadoJugador;
    }

    public void setMazo(Stack<Carta> mazo) {
        tableroJugador.setMazo(mazo);
    }

    public void sacarCartaDeMano(Carta carta) {
        mano.remove(carta);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
