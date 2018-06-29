package algo3.fiuba.vista;


import algo3.fiuba.controladores.ControladorCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCarta extends StackPane {

    private VistaZonaCartas vistaZonaNoMonstruos;
    private VistaZonaCartas vistaZonaMonstruos;
    private VistaMano vistaMano;
    private Carta carta;
    private Jugador jugador;
    private ImageView imagenCarta;
    private double ANCHO_MAXIMO_CARTA = 95.0;
    private double ALTURA_MAXIMA_CARTA = 110.0;

    public VistaCarta(String imageUrl, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaCartas vistaZonaMonstruos, VistaZonaCartas vistaZonaNoMonstruos) {

        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.dibujar();
    }

    public void dibujar() {
        this.getChildren().add(imagenCarta);
        //this.setGraphic(imagenCarta);
        //this.setContentDisplay(ContentDisplay.CENTER);
        this.setOnMouseClicked(new ControladorCarta(this, jugador, carta, vistaMano, vistaZonaNoMonstruos, vistaZonaMonstruos));
    }

    public void deshabilitarCarta() {
        this.setDisable(true);
    }

    public void update() {
        this.dibujar();
    }
}
