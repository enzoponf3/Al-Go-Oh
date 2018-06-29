package algo3.fiuba.vista;


import algo3.fiuba.controladores.ControladorCarta;
import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class VistaCarta extends Label {

    private VistaCartaCampo vistaCartaCampo;
    private VistaZonaNoMonstruos vistaZonaNoMonstruos;
    private VistaZonaMonstruos vistaZonaMonstruos;
    private VistaMano vistaMano;
    private Carta carta;
    private Jugador jugador;
    private ImageView imagenCarta;
    private ImageView imagenCartaBocaAbajo;
    private String imageUrl;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;
    private boolean estadoVision;

    public VistaCarta(String imageUrl, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo) {
        this.imageUrl = imageUrl;
        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.imagenCartaBocaAbajo =  new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png", ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        estadoVision = true;
        this.dibujar();
    }

    public VistaCarta(String imageUrl, Jugador jugador, Carta carta, VistaMano vistaMano, VistaZonaMonstruos vistaZonaMonstruos, VistaZonaNoMonstruos vistaZonaNoMonstruos, VistaCartaCampo vistaCartaCampo, Boolean estadoVision) {
        this.imageUrl = imageUrl;
        this.imagenCarta = new ImageView(new Image(imageUrl,
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.imagenCartaBocaAbajo =  new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png", ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.jugador = jugador;
        this.carta = carta;
        this.vistaMano = vistaMano;
        this.vistaZonaMonstruos = vistaZonaMonstruos;
        this.vistaZonaNoMonstruos = vistaZonaNoMonstruos;
        this.vistaCartaCampo = vistaCartaCampo;
        this.estadoVision = estadoVision;
        this.dibujar();
    }

    public void dibujar() {
        if (estadoVision) this.setGraphic(imagenCarta);
        else this.setGraphic(imagenCartaBocaAbajo);

        this.setContentDisplay(ContentDisplay.CENTER);
        this.setOnMouseClicked(new ControladorCarta(this, jugador, carta, vistaMano, vistaZonaNoMonstruos, vistaZonaMonstruos, vistaCartaCampo));
    }

    public void deshabilitarCarta() {
        this.setDisable(true);
    }

    public void update() {
        this.dibujar();
    }

    public double getAlturaCarta() {
        return ALTURA_MAXIMA_CARTA;
    }

    public double getAnchoCarta() {
        return ANCHO_MAXIMO_CARTA;
    }

    public void cambiarVision() {
        estadoVision = !estadoVision;
    }

    public boolean getEstadoVision() {
        return estadoVision;
    }

    public VistaCarta clonar() {
       VistaCarta vistaCartaClon = new VistaCarta(imageUrl,jugador,carta,vistaMano,vistaZonaMonstruos,vistaZonaNoMonstruos,vistaCartaCampo,estadoVision);
       System.out.print(vistaCartaClon.getEstadoVision());
       return vistaCartaClon;
    }



}
