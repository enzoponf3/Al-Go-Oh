package algo3.fiuba.vista.vista_cartas.estado_carta_vista;

import algo3.fiuba.modelo.cartas.AccionCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.AccionJugador;
import algo3.fiuba.modelo.jugador.Jugador;

import java.util.List;

public class EstadoCartaVistaFactory {

    public static EstadoCartaVista getEstadoCartaVista(Jugador jugador, Carta carta) {
        List<AccionJugador> accionesJugador = jugador.accionesDisponibles();
        List<AccionCarta> accionesCarta = carta.accionesDisponibles();

        if (accionesJugador.isEmpty()) {
            if (accionesCarta.contains(AccionCarta.RECIBIR_ATAQUE)) {
                if (accionesCarta.contains(AccionCarta.GIRAR_CARTA)) {
                    return new AtacableBocaAbajoVista();
                }

                return new AtacableBocaArribaVista();
            }

            return new NoVisibleVista();
        }

        if (accionesJugador.contains(AccionJugador.COLOCAR_MONSTRUO)) {
            if (accionesCarta.contains(AccionCarta.CAMBIAR_MODO)) {
                return new SacrificableVista();
            } else {
                return new NoVisibleVista();
            }
        }

        if (accionesCarta.contains(AccionCarta.CAMBIAR_MODO)) {
            return new AtacanteVista();
        } else {
            return new NoVisibleVista();
        }
    }
}
