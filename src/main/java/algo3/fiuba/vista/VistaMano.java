package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorCarta;
import algo3.fiuba.controladores.ControladorMano;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_magicas.AgujeroNegro;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class VistaMano extends ScrollPane {

    private VistaZonaCartas vistaZonaNoMonstruos;
    private VistaZonaCartas vistaZonaMonstruos;
    private Jugador jugador;
    ControladorMano controladorMano;
    List<VistaCarta> vistaCartas;

    public VistaMano(Jugador jugador, VistaZonaCartas vistaZonaMonstruos, VistaZonaCartas vistaZonaNoMonstruos) {
        this.controladorMano = new ControladorMano(this, jugador);
        this.jugador = jugador;
        this.vistaCartas = new LinkedList<>();
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
    }

    public void dibujar() {
        this.setMaxWidth(535);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);

        GridPane vistaMano = new GridPane();
        vistaMano.setGridLinesVisible(true);
        List<Carta> mano = jugador.getMano();
        int i = 0;
        for(Carta carta: mano) {
            VistaCarta vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/" + carta.getNombre() + ".gif", jugador, carta, this, vistaZonaMonstruos, vistaZonaNoMonstruos);
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

    public void agregarImagenAMano() {}
}
