package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorMano;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import java.util.List;

public class VistaMano extends ScrollPane {

    private Jugador jugador;
    ControladorMano controladorMano;

    public VistaMano(Jugador jugador) {

        this.controladorMano = new ControladorMano(this, jugador);
        this.jugador = jugador;
    }

    public void dibujar() {

        this.setMaxWidth(535);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
        this.getStyleClass().add("mano");

        GridPane vistaMano = new GridPane();
        vistaMano.setGridLinesVisible(true);
        List<Carta> mano = jugador.getMano();
        int i = 0;
        for(Carta carta: mano) {
            VistaCarta vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/" + carta.getNombre() + ".gif",
                    jugador);
            vistaMano.add(vistaCarta, i, 0);
            i++;
        }
        this.setContent(vistaMano);
    }

    public void update() {
        this.dibujar();
    }
}
