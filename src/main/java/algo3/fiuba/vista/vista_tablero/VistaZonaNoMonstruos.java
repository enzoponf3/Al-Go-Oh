package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.LinkedList;
import java.util.List;

public class VistaZonaNoMonstruos extends HBox {

    private final Image imagenFondo;
    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;

    public VistaZonaNoMonstruos(Jugador jugador) {

        this.setSpacing(20);
        this.jugador = jugador;
        this.imagenFondo = new Image("algo3/fiuba/resources/img/magica-atr.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false);
        for (int i = 0; i < 5; i++) {
            ImageView imagen = new ImageView(imagenFondo);
            this.agregarCarta(imagen);
        }
    }

    public void dibujar() {
        int i = 0;
        for(NoMonstruo noMonstruo: jugador.getNoMonstuosEnCampo()) {
            VistaCarta vistaNoMonstruo = new VistaCarta("/algo3/fiuba/resources/img/" + noMonstruo.getNombre() + ".jpg", jugador, noMonstruo);
            this.reemplazarCartaVista(vistaNoMonstruo, i);
            i++;
        }
        for(i = jugador.getNoMonstuosEnCampo().size(); i < 5; i++) {
            getChildren().remove(i);
            ImageView imagen = new ImageView(imagenFondo);
            getChildren().add(i, imagen);
        }
    }

    public void agregarCarta(ImageView carta) {
        this.getChildren().add(carta);
        this.setHgrow(carta, Priority.ALWAYS);
    }

    public void reemplazarCartaVista(VistaCarta vistaCarta, int indice) {
        getChildren().remove(indice);
        getChildren().add(indice, vistaCarta);
    }

    public void update() {
        this.dibujar();
    }
}
