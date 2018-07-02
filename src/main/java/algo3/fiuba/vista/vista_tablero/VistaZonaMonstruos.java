package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.moldes_cartas.MonstruoNulo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VistaZonaMonstruos extends HBox {

    protected Jugador jugador;
    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;

    private static final Integer LIMITE_CARTAS = 5;
    private ControladorDeTurnos controladorDeTurnos;
    private CartaVistaUtils cartaVistaUtils;

    public VistaZonaMonstruos(Jugador jugador) {
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
                VistaCarta vistaMonstruo = new VistaCarta(cartaVistaUtils.getImagenDeCarta(monstruo.getNombre()), jugador, monstruo);
                super.getChildren().add(vistaMonstruo);
                if (!jugador.equals(controladorDeTurnos.getJugador())) {
                    vistaMonstruo.deshabilitarCarta();
                }
            }
        }
    }

    public void update() {
        this.dibujar();
    }
}
