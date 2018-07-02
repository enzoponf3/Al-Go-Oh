package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.controladores.controladores_de_carta.ControladorCarta;
import algo3.fiuba.controladores.ControladorMano;
import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
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
        List<VistaCarta> vistaCartas = new LinkedList<>();

        this.setMaxWidth(555);
        this.setFitToHeight(true);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);

        GridPane vistaMano = new GridPane();
        List<Carta> mano = jugador.getMano();
        int i = 0;
        for(Carta carta: mano) {
            Jugador jugadorActual = controladorTurnos.getJugador();
            VistaCarta vistaCarta;
            if(jugadorActual == jugador && jugador.getEstadoJugador() instanceof PreInvocacion) {
                vistaCarta = new VistaCarta(cartaVistaUtils.getImagenDeCarta(carta.getNombre()), jugador, carta);

            }
            else {
                vistaCarta = new VistaCarta(cartaVistaUtils.getImagenCartaBocaAbajo(), jugador, carta);
                vistaCarta.deshabilitarCarta();
            }
            vistaCarta.setOnMouseClicked(new ControladorCarta(vistaCarta, jugador, carta));
            vistaCartas.add(vistaCarta);
            vistaMano.add(vistaCarta, i, 0);
            i++;
        }
        this.setContent(vistaMano);
    }

    public void update() {
        this.dibujar();
    }
}
