package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.excepciones.CartaNoInicializadaEnDueloExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

import java.util.LinkedList;
import java.util.List;

public class EstadoNoInicializado implements EstadoCarta {

    @Override
    public void verificarQuePuedeAtacar() {
        return;
    }

    @Override
    public boolean estaEnJuego() {
        throw new CartaNoInicializadaEnDueloExcepcion("La carta nunca se ha inicializado en el duelo.");
    }

    @Override
    public void activarEfecto(Carta carta, EfectoCarta efecto) {
        throw new CartaNoInicializadaEnDueloExcepcion("La carta nunca se ha inicializado en el duelo.");
    }

    @Override
    public void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo atacado, EfectoCarta efecto) {
        throw new CartaNoInicializadaEnDueloExcepcion("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public void activarEfecto(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2, EfectoCarta efecto) {
        throw new CartaNoInicializadaEnDueloExcepcion("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public void recibirAtaque(Monstruo carta) {
        throw new CartaNoInicializadaEnDueloExcepcion("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new CartaNoInicializadaEnDueloExcepcion("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto){
        throw new CartaNoInicializadaEnDueloExcepcion("No se pueden atacar Monstruos que están fuera de juego.");
    }

    @Override
    public EstadoCarta girarCarta() {
        return this;
    }

    @Override
    public boolean estaBocaAbajo() {
        throw new CartaNoInicializadaEnDueloExcepcion("La carta nunca se ha inicializado en el duelo.");
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Monstruo carta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Magica carta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Trampa carta) {
        return new LinkedList<>();
    }

    @Override
    public List<AccionCarta> accionesDisponibles(CartaCampo carta) {
        return new LinkedList<>();
    }
}
