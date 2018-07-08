package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.*;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.*;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;

public class ControladorCarta implements EventHandler<MouseEvent> {

    private Carta carta;
    private CartaVista cartaVista;
    private Jugador jugador;

    private CartaVistaUtils cartaVistaUtils;

    public ControladorCarta(CartaVista cartaVista, Jugador jugador, Carta carta) {
        this.carta = carta;
        this.cartaVista = cartaVista;
        this.jugador = jugador;

        cartaVistaUtils = new CartaVistaUtils();
    }

    @Override
    public void handle(MouseEvent evento) {
            ContextMenu menuAcciones = cartaVistaUtils.menuAcciones(cartaVista, jugador, carta, carta.accionesDisponibles());
            menuAcciones.show(cartaVista,evento.getScreenX(),evento.getScreenY());
    }
}
