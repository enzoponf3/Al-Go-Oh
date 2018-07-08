package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.Campo;
import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.excepciones.CartaInhabilitadaParaActivarseExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;

import java.util.LinkedList;
import java.util.List;

public class BocaArriba extends EnJuego {

    @Override
    public void activarEfecto(Carta carta, EfectoCarta efecto) {
        efecto.activar(carta);
    }

    @Override
    public void activarEfecto(Carta carta, Monstruo otraCarta1, Monstruo otraCarta2, EfectoCarta efecto) {
        efecto.activar(carta, otraCarta1, otraCarta2);
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto) {
        throw new CartaInhabilitadaParaActivarseExcepcion("Ya no puedes activar a exodia!");
    }


    @Override
    public void recibirAtaque(Monstruo carta) {
        carta.setEstado(new BocaArriba());
    }

    @Override
    public void recibirAtaque(NoMonstruo carta) {
        throw new RuntimeException("No se pueden atacar cartas No Monstruos.");
    }

    @Override
    public void activarEfecto(Trampa trampa, Monstruo atacante, Monstruo atacado, EfectoCarta efecto) {
        return;
        // !!! salvada
        // throw new CartaInhabilitadaParaActivarseExcepcion("No se puede Activar una carta Trampa en que esté boca arriba");
    }

    @Override
    public void colocarCartaEnCampo(Magica carta, Campo campo) {
        campo.colocarCarta(carta, this);
    }

    @Override
    public void colocarCartaEnCampo(Trampa carta, Campo campo) {
        campo.colocarCarta(carta, this);
    }

    @Override
    public void colocarCartaEnCampo(CartaCampo carta, Campo campo) {
        campo.colocarCarta(carta, this);
    }

    @Override
    public boolean estaBocaAbajo() {
        return false;
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Monstruo carta) {
        List<AccionCarta> acciones = new LinkedList<>();

        for (AccionCarta ac : carta.getModo().accionesDisponibles()) {
            acciones.add(ac);
        }
        acciones.add(AccionCarta.CAMBIAR_MODO);

        return acciones;
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
