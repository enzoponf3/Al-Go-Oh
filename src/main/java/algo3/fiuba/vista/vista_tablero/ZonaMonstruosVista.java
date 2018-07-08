package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.moldes_cartas.MonstruoNulo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import algo3.fiuba.vista.vista_cartas.MonstruoVista;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ZonaMonstruosVista extends HBox {

    protected Jugador jugador;
    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;

    private static final Integer LIMITE_CARTAS = 5;
    private ControladorDeTurnos controladorDeTurnos;
    private CartaVistaUtils cartaVistaUtils;

    public ZonaMonstruosVista(Jugador jugador) {
        cartaVistaUtils = new CartaVistaUtils();
        controladorDeTurnos = ControladorDeTurnos.getInstancia();
        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i < LIMITE_CARTAS; i++) {
            ImageView imagenEspacioVacio = new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioMonstruo(),
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            super.getChildren().add(imagenEspacioVacio);
        }
    }

    public void dibujar() {
        super.getChildren().clear();

        for(Monstruo monstruo: jugador.getMonstuosEnCampo()) {
            if (monstruo instanceof MonstruoNulo) {
                super.getChildren().add(new ImageView(new Image(cartaVistaUtils.getImagenEspacioVacioMonstruo(),
                        ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
            } else {
                //CartaVista vistaMonstruo = new CartaVista(cartaVistaUtils.getImagenDeCarta(monstruo.getNombre()), jugador, monstruo);
                MonstruoVista vistaMonstruo = new MonstruoVista(cartaVistaUtils.getImagenDeCarta(monstruo.getNombre()), jugador, monstruo);
                vistaMonstruo.update();
                super.getChildren().add(vistaMonstruo);
                /*!!!!
                if (!jugador.equals(controladorDeTurnos.getJugadorActual())) {
                    vistaMonstruo.deshabilitarCarta();
                }
                */
            }

        }
    }

    public void update() {
        this.dibujar();
    }
}
