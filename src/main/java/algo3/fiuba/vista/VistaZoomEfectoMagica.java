package algo3.fiuba.vista;


import algo3.fiuba.vista.VistaCarta;
import algo3.fiuba.vista.VistaProyeccionCarta;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;



public class VistaZoomEfectoMagica {

    private String imageUrl;
    private ImageView imagenProyectada;
    private Image imagen;
    private VistaProyeccionCarta vistaProyeccionCarta;

    public VistaZoomEfectoMagica(VistaCarta vistaCarta) {
        this.imageUrl = vistaCarta.getImageUrl();
        this.vistaProyeccionCarta = VistaProyeccionCarta.getInstancia();
    }

    public void update() {
        dibujar();
    }

    private void dibujar() {
        imagen = new Image(imageUrl, 200, 300, false, false);
        imagenProyectada = new ImageView();
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(imagenProyectada.imageProperty(), imagen)),new KeyFrame(Duration.seconds(1), new KeyValue(imagenProyectada.imageProperty(), null)));
        timeline.play();
        vistaProyeccionCarta.zoomImgView(imagenProyectada);
        vistaProyeccionCarta.update();

    }
}
