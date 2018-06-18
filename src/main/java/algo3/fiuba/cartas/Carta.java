package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.Jugador;
import algo3.fiuba.Tablero;
import algo3.fiuba.TableroJugador;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.*;

import java.util.Objects;

public abstract class Carta {

    private String nombre;
    protected EstadoCarta estadoCarta;
    protected Jugador jugador;
    protected EfectoCarta efecto;

    public Carta(String nombre, EfectoCarta efecto) {
        this.nombre = nombre;
        this.estadoCarta = new EstadoNoInicializado();
        this.efecto = efecto;
    }

    public void pasarAModoJuego(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
    }

    public abstract void colocarEnCampo(Campo campo, EnJuego tipoEnJuego, Monstruo... sacrificios);

    public boolean estaEnJuego() {
        return estadoCarta.estaEnJuego();
    }

    public void descartar() {
        jugador.mandarCartaACementerio(this);
        estadoCarta = EnCementerio.getInstancia();
    }

    public void setEstado(EstadoCarta estadoCarta) {
        this.estadoCarta = estadoCarta;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void activar(Tablero tablero) {
        estadoCarta.activar(tablero, efecto);
    }

    public abstract boolean estaEnTablero(TableroJugador tableroJugador);

    public abstract void removerDelCampo(Campo campo);

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", estadoCarta=" + estadoCarta +
                ", efecto=" + efecto +
                '}';
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
