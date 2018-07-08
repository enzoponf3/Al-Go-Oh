package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.vista_cartas.CartaVista;

public class ControladorBocaAbajoEnMano extends ControladorColocarCarta {

    public ControladorBocaAbajoEnMano(CartaVista vistaCarta, Jugador jugador, Carta carta) {
        super(vistaCarta, jugador, carta);
    }

    @Override
    public EnJuego tipoEnJuego(Carta carta) {
        return new BocaAbajo();
    }
}
