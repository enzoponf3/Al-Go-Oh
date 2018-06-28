package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorCarta;
import algo3.fiuba.controladores.ControladorMano;
import algo3.fiuba.controladores.ControladorTurnos;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.TurnoDelOponente;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import java.util.LinkedList;
import java.util.List;

public class VistaMano extends ScrollPane {

    private ControladorTurnos controladorTurnos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private Jugador jugador;
    ControladorMano controladorMano;
    List<VistaCarta> vistaCartas;

    public VistaMano(Jugador jugador, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos) {
        this.controladorMano = new ControladorMano(this, jugador);
        this.jugador = jugador;
        this.vistaCartas = new LinkedList<>();
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.controladorTurnos = ControladorTurnos.getInstancia();
    }

    public void dibujar() {

        this.setMaxWidth(555);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");
        this.getStyleClass().add("mano");

        GridPane vistaMano = new GridPane();
        vistaMano.setGridLinesVisible(true);
        List<Carta> mano = jugador.getMano();
        int i = 0;
        for(Carta carta: mano) {
            Jugador jugadorActual = controladorTurnos.getJugador();
            VistaCarta vistaCarta;
            if(jugadorActual == jugador) {
                vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/" + carta.getNombre() + ".gif", jugador, carta, this, vistaZonaMonstruos, vistaZonaNoMonstruos);
            }
            else {
                vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/carta-vista-trasera.png", jugador, carta, this, vistaZonaMonstruos, vistaZonaNoMonstruos);
                vistaCarta.deshabilitarCarta();
            }
            vistaCarta.setOnMouseClicked(new ControladorCarta(vistaCarta, jugador, carta, this, vistaZonaNoMonstruos, vistaZonaMonstruos));
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
