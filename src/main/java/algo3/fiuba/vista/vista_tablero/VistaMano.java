package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.controladores.controladores_de_carta.ControladorCarta;
import algo3.fiuba.controladores.ControladorMano;
import algo3.fiuba.controladores.ControladorTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import java.util.LinkedList;
import java.util.List;

public class VistaMano extends ScrollPane {

    private ControladorTurnos controladorTurnos;
    private Jugador jugador;
    ControladorMano controladorMano;
    List<VistaCarta> vistaCartas;

    public VistaMano(Jugador jugador) {
        this.controladorMano = new ControladorMano(this, jugador);
        this.jugador = jugador;
        this.vistaCartas = new LinkedList<>();
        this.controladorTurnos = ControladorTurnos.getInstancia();

    }

    public void dibujar() {
        vistaCartas.clear();
        this.setMaxWidth(555);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloVistaMano.css");
        this.getStyleClass().add("hola");

        GridPane vistaMano = new GridPane();
        vistaMano.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloVistaMano.css");
        vistaMano.getStyleClass().add("mano");
        List<Carta> mano = jugador.getMano();
        int i = 0;
        for(Carta carta: mano) {
            Jugador jugadorActual = controladorTurnos.getJugador();
            VistaCarta vistaCarta;
            if(jugadorActual == jugador && jugador.getEstadoJugador() instanceof PreInvocacion) {
                vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/" + carta.getNombre() + ".jpg", jugador, carta);

            }
            else {
                vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/carta-vista-trasera.png", jugador, carta);
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
