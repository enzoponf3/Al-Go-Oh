package algo3.fiuba.vista;

import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public abstract class VistaZonaCartas extends HBox {

    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;
    private int indice;

    public VistaZonaCartas(Jugador jugador) {
        this.setSpacing(20);
        this.jugador = jugador;
        indice = 0;
    }

    public void agregarCarta(ImageView carta) {
        this.getChildren().add(carta);
        this.setHgrow(carta, Priority.ALWAYS);
    }

    public void reemplazarCarta(ImageView carta) {
        this.getChildren().remove(indice);
        this.getChildren().add(0, carta);
        indice++;
    }

    public abstract void dibujar();

    public void update() {
        this.dibujar();
    }
}
