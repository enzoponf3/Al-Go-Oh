package algo3.fiuba.vista;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.List;

public class VistaZonaMonstruos extends HBox {

    private int indice;
    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;

    public VistaZonaMonstruos(Jugador jugador) {

        this.setSpacing(20);
        this.jugador = jugador;
        indice = 0;
        for (int i = 0; i <= 4; i++) {
            ImageView imagen2 = new ImageView(new Image("algo3/fiuba/resources/img/monstruo-atr.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            this.agregarCarta(imagen2);
        }
    }

    public void dibujar() {
        List<NoMonstruo> zonaNoMonstruos = jugador.getNoMonstuosEnCampo();
        //this.reemplazarCarta(null);
        for(NoMonstruo noMonstruo: zonaNoMonstruos) {
            String imageUrl = "/algo3/fiuba/resources/img/" + noMonstruo.getNombre() + ".gif";
            this.reemplazarCarta(new ImageView(new Image(imageUrl,
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
        }
    }

    public void agregarCarta(ImageView carta) {
        this.getChildren().add(carta);
        this.setHgrow(carta, Priority.ALWAYS);
    }

    public void reemplazarCarta(ImageView carta) {

        getChildren().remove(2);
        this.getChildren().add(indice, carta);
        indice++;
    }

    public void update() {
        this.dibujar();
    }
}
