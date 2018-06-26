package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.excepciones.CartaNoInicializadaEnDueloExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.Trampa;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

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
}
