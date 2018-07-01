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
    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;

    private CartaVistaUtils cartaVistaUtils;

    public VistaZonaNoMonstruos(Jugador jugador) {
        cartaVistaUtils = new CartaVistaUtils();

        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i < 5; i++) {
            ImageView imagen2 = new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioNoMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            this.agregarCarta(imagen2);
        }
    }

    public void dibujar() {
        getChildren().clear();

        Integer i = 0;
        for(NoMonstruo noMonstruo: jugador.getNoMonstuosEnCampo()) {
            getChildren().add(new VistaCarta(cartaVistaUtils.getImagenDeCarta(noMonstruo.getNombre()), jugador, noMonstruo));
        }
        for (; i < 5; i++) {
            agregarCarta(new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioNoMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
        }
    }

    public void agregarCarta(ImageView carta) {
        this.getChildren().add(carta);
        this.setHgrow(carta, Priority.ALWAYS);
    }

    public void update() {
        this.dibujar();
    }
}
