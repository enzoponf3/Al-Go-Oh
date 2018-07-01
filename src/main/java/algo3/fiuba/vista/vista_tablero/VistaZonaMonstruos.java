package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

public class VistaZonaMonstruos extends HBox {

    private final Image imagenFondo;
    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;

    public VistaZonaMonstruos(Jugador jugador) {

        this.setSpacing(20);
        this.jugador = jugador;
        this.imagenFondo = new Image("algo3/fiuba/resources/img/monstruo-atr.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false);
        for (int i = 0; i < 5; i++) {
            ImageView imagen = new ImageView(this.imagenFondo);
            this.agregarCarta(imagen);
        }
    }

    public void agregarCarta(ImageView carta) {
        try {
            this.getChildren().add(carta);
            this.setHgrow(carta, Priority.ALWAYS);
        } catch (CampoNoPermiteColocarCartaExcepcion e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("El campo esta lleno");
            error.show();
        }
    }

    public void dibujar() {
        int i = 0;
        for(Monstruo monstruo: jugador.getMonstuosEnCampo()) {
            VistaCarta vistaMonstruo = new VistaCarta("/algo3/fiuba/resources/img/" + monstruo.getNombre() + ".jpg", jugador, monstruo);
            this.reemplazarCartaVista(vistaMonstruo, i);
            i++;
        }
        for(i = jugador.getMonstuosEnCampo().size(); i < 5; i++) {
            getChildren().remove(i);
            ImageView imagen = new ImageView(imagenFondo);
            getChildren().add(i, imagen);
        }
    }

    public void reemplazarCartaVista(VistaCarta vistaCarta, int indice) {
        getChildren().remove(indice);
        getChildren().add(indice, vistaCarta);
    }

    public void update() {
        this.dibujar();
    }
}
