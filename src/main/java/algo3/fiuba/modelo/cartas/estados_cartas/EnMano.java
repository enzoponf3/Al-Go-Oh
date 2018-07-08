package algo3.fiuba.modelo.cartas.estados_cartas;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.efectos.EfectoCarta;
import algo3.fiuba.modelo.excepciones.MonstruoInhabilitadoParaAtacarExcepcion;

import java.util.LinkedList;
import java.util.List;

public class EnMano extends FueraDeJuego {

    @Override
    public void verificarQuePuedeAtacar() {
        throw new MonstruoInhabilitadoParaAtacarExcepcion("No puede atacar si está en la mano.");
    }

    @Override
    public void activarEfecto(Carta carta, Jugador jugador, EfectoCarta efecto) {
        efecto.activar(carta);
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Monstruo carta) {
        List<AccionCarta> acciones = new LinkedList<>();
        acciones.add(AccionCarta.COLOCAR_EN_CAMPO);

        return acciones;
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Magica carta) {
        List<AccionCarta> acciones = new LinkedList<>();
        acciones.add(AccionCarta.COLOCAR_EN_CAMPO);

        return acciones;
    }

    @Override
    public List<AccionCarta> accionesDisponibles(Trampa carta) {
        List<AccionCarta> acciones = new LinkedList<>();
        acciones.add(AccionCarta.COLOCAR_EN_CAMPO);

        return acciones;
    }

    @Override
    public List<AccionCarta> accionesDisponibles(CartaCampo carta) {
        List<AccionCarta> acciones = new LinkedList<>();
        acciones.add(AccionCarta.COLOCAR_EN_CAMPO);

        return acciones;
    }
}
