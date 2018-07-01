package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.LinkedList;
import java.util.List;

public class VistaZonaNoMonstruos extends HBox {

    private Jugador jugador;
    private static final double ANCHO_MAXIMO_CARTA = 95.0;
    private static final double ALTURA_MAXIMA_CARTA = 110.0;
    private static final Integer LIMITE_CARTAS = 5;

    private CartaVistaUtils cartaVistaUtils;

    public VistaZonaNoMonstruos(Jugador jugador) {
        cartaVistaUtils = new CartaVistaUtils();

        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i < LIMITE_CARTAS; i++) {
            ImageView imagenEspacioVacio = new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioNoMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            getChildren().add(imagenEspacioVacio);
        }
    }

    public void dibujar() {
        getChildren().clear();

        Integer i = 0;
        for(NoMonstruo noMonstruo: jugador.getNoMonstuosEnCampo()) {
            getChildren().add(new VistaCarta(cartaVistaUtils.getImagenDeCarta(noMonstruo.getNombre()), jugador, noMonstruo));
        }
        for (; i < LIMITE_CARTAS; i++) {
            getChildren().add(new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioNoMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
        }
    }

    public void update() {
        this.dibujar();
    }
}
