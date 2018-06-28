package algo3.fiuba.modelo.cartas;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.Turno;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.cartas.estado_en_turno.EstadoEnTurno;
import algo3.fiuba.modelo.cartas.estado_en_turno.NoUsadaEnTurno;
import algo3.fiuba.modelo.cartas.estados_cartas.*;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public abstract class Carta implements Observer {

    private String nombre;
    protected EstadoCarta estadoCarta;
    protected Jugador jugador;
    protected EfectoCarta efecto;
    protected EstadoEnTurno estadoEnTurno;
    private Turno turno;

    public Carta(String nombre, EfectoCarta efecto) {
        this.nombre = nombre;
        this.estadoCarta = new EstadoNoInicializado();
        this.efecto = efecto;

        turno = Turno.getInstancia();
    }

    @Override
    public void update(Observable o, Object arg) {
        estadoEnTurno = estadoEnTurno.pasarTurno();
    }

    public void colocarEnCampo(Jugador jugador, EnJuego tipoEnJuego, Monstruo... sacrificios) {
        this.estadoCarta = tipoEnJuego;
        this.estadoEnTurno = new NoUsadaEnTurno();
    }

    public boolean estaEnJuego() {
        return estadoCarta.estaEnJuego();
    }

    public void mandarDelCampoAlCementerio() {
        jugador.mandarCartaDelCampoAlCementerio(this);
    }

    public void setEstado(EstadoCarta estadoCarta) {
        this.estadoCarta = estadoCarta;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void activarEfecto() {
        this.girarCarta();
        estadoCarta.activarEfecto(this,  efecto);
    }

    public void activarEfecto(Monstruo atacante, Monstruo atacado) {
        this.girarCarta();
        estadoCarta.activarEfecto(this,  atacante, atacado, efecto);
    }

    public void activarEfecto(Carta carta, Jugador jugador) {
        this.girarCarta();
        estadoCarta.activarEfecto(this, jugador, efecto);
    }

    public abstract boolean estaEnCampo(Campo campo);

    public abstract void removerDelCampo(Campo campo);

    public void girarCarta() {
        estadoCarta = estadoCarta.girarCarta();
    }

    protected void setEfecto(EfectoCarta efecto) {
        this.efecto = efecto;
    }

    public void agregarAMano(List<Carta> mano) {
        estadoCarta = new EnMano();
        mano.add(this);
    }

    public EstadoCarta getEstadoCarta() {
        return estadoCarta;
    }

    public EstadoEnTurno getEstadoEnTurno() {
        return estadoEnTurno;
    }

    public String getNombre() {
        return nombre;
    }
}
