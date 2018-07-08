package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.controladores.controladores_de_carta.ControladorCarta;
import algo3.fiuba.controladores.ControladorMano;
import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import java.util.LinkedList;
import java.util.List;

public class VistaMano extends ScrollPane {

    private ControladorDeTurnos controladorTurnos;
    private Jugador jugador;
    ControladorMano controladorMano;

    private CartaVistaUtils cartaVistaUtils;

    public VistaMano(Jugador jugador) {
        this.controladorMano = new ControladorMano(this, jugador);
        this.jugador = jugador;
        this.controladorTurnos = ControladorDeTurnos.getInstancia();

        this.cartaVistaUtils = new CartaVistaUtils();
    }

    public void dibujar() {
        List<CartaVista> vistaCartas = new LinkedList<>();

        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
        this.getStyleClass().add("scroll-pane");

        this.setMaxWidth(555);
        this.setFitToHeight(true);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);

        GridPane vistaMano = new GridPane();
        List<Carta> mano = jugador.getMano();
        int i = 0;
        for(Carta carta: mano) {
            Jugador jugadorActual = controladorTurnos.getJugadorActual();
            CartaVista vistaCarta;
            if(jugadorActual == jugador && jugador.getEstadoJugador() instanceof PreInvocacion) {
                vistaCarta = new CartaVista(cartaVistaUtils.getImagenDeCarta(carta.getNombre()), jugador, carta);

            }
            else {
                vistaCarta = new CartaVista(cartaVistaUtils.getImagenCartaBocaAbajo(), jugador, carta);
                vistaCarta.deshabilitarCarta();
            }

            vistaCarta.setOnMouseClicked(new ControladorCarta(vistaCarta, jugador, carta));
            vistaCartas.add(vistaCarta);
            vistaMano.add(vistaCarta, i, 0);

            vistaCarta.update();
            i++;
        }
        this.setContent(vistaMano);
    }

    public void update() {
        this.dibujar();
    }
}
