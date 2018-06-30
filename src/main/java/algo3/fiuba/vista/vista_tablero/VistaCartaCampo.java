package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.CartaCampo;
import algo3.fiuba.modelo.cartas.moldes_cartas.cartas_campo.CartaCampoNula;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.vista_tablero.VistaMano;
import algo3.fiuba.vista.vista_tablero.VistaZonaMonstruos;
import algo3.fiuba.vista.vista_tablero.VistaZonaNoMonstruos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaCartaCampo extends Label {

    private VistaMano vistaMano;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private Carta carta;
    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    private Jugador jugador;
    ImageView cartaCampoFondo = new ImageView(new Image("/algo3/fiuba/resources/img/campo-atr.jpg",
            ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));

    public VistaCartaCampo(Jugador jugador, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruo,
                           VistaZonaNoMonstruos vistaZonaNoMonstruo) {
        this.jugador = jugador;
        this.carta = jugador.getCartaCampoActiva();
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruo;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruo;
    }

    public void dibujar() {
        CartaCampo cartaCampoActiva = jugador.getCartaCampoActiva();
        if (cartaCampoActiva != null && !(cartaCampoActiva instanceof CartaCampoNula)) {
            String nombre = jugador.getCartaCampoActiva().getNombre();
            VistaCarta vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/" + nombre + ".jpg", jugador, carta, vistaMano,
                    vistaZonaMonstruos, vistaZonaNoMonstruos, this);
            this.setGraphic(vistaCarta);
        } else {
            this.setGraphic(cartaCampoFondo);
        }
    }
}
