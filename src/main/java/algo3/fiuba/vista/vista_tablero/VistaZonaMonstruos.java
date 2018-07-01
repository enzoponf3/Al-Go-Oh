package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
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
import java.util.List;

public class VistaZonaMonstruos extends HBox {

    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;

    private CartaVistaUtils cartaVistaUtils;

    public VistaZonaMonstruos(Jugador jugador) {
        cartaVistaUtils = new CartaVistaUtils();

        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i < 5; i++) {
            ImageView imagenEspacioVacio = new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            getChildren().add(imagenEspacioVacio);
        }
    }

    public void dibujar() {
        getChildren().clear();

        Integer i = 0;
        for(Monstruo monstruo: jugador.getMonstuosEnCampo()) {
            getChildren().add(new VistaCarta(cartaVistaUtils.getImagenDeCarta(monstruo.getNombre()), jugador, monstruo));
            i++;
        }
        for (; i < 5; i++) {
            getChildren().add(new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
        }
    }
    public void update() {
        this.dibujar();
    }
}
