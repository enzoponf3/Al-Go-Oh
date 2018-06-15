package algo3.fiuba.cartas;

import algo3.fiuba.Campo;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.efectos.EfectoCarta;
import algo3.fiuba.cartas.estados_cartas.EnCementerio;
import algo3.fiuba.cartas.estados_cartas.EnJuego;
import algo3.fiuba.cartas.estados_cartas.EstadoCarta;
import algo3.fiuba.cartas.estados_cartas.FueraDeJuego;

import java.util.Objects;

public abstract class Carta {

    private String nombre;
    protected EstadoCarta estadoCarta;
    protected Jugador jugador;
    protected EfectoCarta efecto;

    public Carta(String nombre, EfectoCarta efecto) {
        this.nombre = nombre;
        this.estadoCarta = new FueraDeJuego();
    }

    public void pasarAModoJuego(EnJuego tipoEnJuego) {
        estadoCarta = tipoEnJuego;
    }

    public abstract void colocarEnCampo(Campo campo, EnJuego tipoEnJuego);

    public boolean estaEnJuego() {
        return estadoCarta.estaEnJuego();
    }

    public void descartar() {
        jugador.mandarAlCementerio(this);
        estadoCarta = new EnCementerio();
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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
    public void activar() {
        estadoCarta.activar(efecto);
    }
}
