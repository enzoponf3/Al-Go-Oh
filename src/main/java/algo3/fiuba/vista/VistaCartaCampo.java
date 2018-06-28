package algo3.fiuba.vista;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
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

        if (jugador.getCartaCampoActiva() != null) {
            String nombre = jugador.getCartaCampoActiva().getNombre();
            VistaCarta vistaCarta = new VistaCarta("/algo3/fiuba/resources/img/" + nombre + ".gif", jugador, carta, vistaMano, vistaZonaMonstruos, vistaZonaNoMonstruos);
            this.setGraphic(vistaCarta);
        } else if (jugador.getCartaCampoActiva() == null){
            this.setGraphic(cartaCampoFondo);
        }
    }
}
