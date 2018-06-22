package algo3.fiuba.cartas;

import algo3.fiuba.*;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estado_en_turno.EstadoEnTurno;
import algo3.fiuba.cartas.estados_cartas.*;
import algo3.fiuba.cartas.modificadores.Modificador;
import algo3.fiuba.cartas.modificadores.ModificadorRefuerzos;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public abstract class Carta implements Observer {

    private String nombre;
    protected EstadoCarta estadoCarta;
    protected Jugador jugador;
    protected EfectoCarta efecto;
    protected EstadoEnTurno estadoEnTurno;

    public Carta(String nombre, EfectoCarta efecto) {
        this.nombre = nombre;
        this.estadoCarta = new EstadoNoInicializado();
        this.efecto = efecto;
    }

    @Override
    public void update(Observable o, Object arg) {
        estadoEnTurno = estadoEnTurno.pasarTurno();
    }

    public abstract void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios);

    public void pasarAModoJuego(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
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
        estadoCarta.activarEfecto(this,  efecto);
    }

    public void activarEfecto(Monstruo atacante, Monstruo atacado) {
        estadoCarta.activarEfecto(this,  atacante, atacado, efecto);
    }


    public abstract boolean estaEnTablero(Campo campo);

    public abstract void removerDelCampo(Campo campo);

    protected void setEfecto(EfectoCarta efecto) {
        this.efecto = efecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(nombre, carta.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }
}
