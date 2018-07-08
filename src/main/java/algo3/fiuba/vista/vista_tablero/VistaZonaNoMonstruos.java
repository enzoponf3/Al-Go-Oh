package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.cartas.moldes_cartas.NoMonstruoNulo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VistaZonaNoMonstruos extends HBox {

    private Jugador jugador;
    private static final double ANCHO_MAXIMO_CARTA = 95.0;
    private static final double ALTURA_MAXIMA_CARTA = 110.0;
    private static final Integer LIMITE_CARTAS = 5;
    private ControladorDeTurnos controladorDeTurnos;
    private CartaVistaUtils cartaVistaUtils;

    public VistaZonaNoMonstruos(Jugador jugador) {
        cartaVistaUtils = new CartaVistaUtils();
        controladorDeTurnos = ControladorDeTurnos.getInstancia();
        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i < LIMITE_CARTAS; i++) {
            ImageView imagenEspacioVacio = new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioNoMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            super.getChildren().add(imagenEspacioVacio);
        }
    }

    public void dibujar() {
        super.getChildren().clear();

        for(NoMonstruo noMonstruo: jugador.getNoMonstuosEnCampo()) {
            if (noMonstruo instanceof NoMonstruoNulo) {
                super.getChildren().add(new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioNoMonstruo(),
                        ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
            } else {
                CartaVista vistaNoMonstruo = new CartaVista(cartaVistaUtils.getImagenDeCarta(noMonstruo.getNombre()), jugador, noMonstruo);
                vistaNoMonstruo.update();
                super.getChildren().add(vistaNoMonstruo);
                /*!!!
                if (!jugador.equals(controladorDeTurnos.getJugadorActual())) {
                    vistaNoMonstruo.deshabilitarCarta();
                }
                */

            }
        }
    }

    public void update() {
        this.dibujar();
    }
}
