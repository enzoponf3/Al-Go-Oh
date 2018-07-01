package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.CartaCampoNula;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCartaCampo extends Label {

    private Carta carta;
    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    private Jugador jugador;
    ImageView cartaCampoFondo = new ImageView(new Image("/algo3/fiuba/resources/img/campo-atr.jpg",
            ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));

    private CartaVistaUtils cartaVistaUtils;

    public VistaCartaCampo(Jugador jugador) {
        this.jugador = jugador;
        this.carta = jugador.getCartaCampoActiva();
        cartaVistaUtils = new CartaVistaUtils();
    }

    public void dibujar() {
        CartaCampo cartaCampoActiva = jugador.getCartaCampoActiva();
        if(!(cartaCampoActiva instanceof CartaCampoNula)) {
            String nombre = jugador.getCartaCampoActiva().getNombre();
            VistaCarta vistaCarta = new VistaCarta(cartaVistaUtils.getImagenDeCarta(nombre), jugador, carta);
            this.setGraphic(vistaCarta);
        } else {
            this.setGraphic(cartaCampoFondo);
        }
    }
}
