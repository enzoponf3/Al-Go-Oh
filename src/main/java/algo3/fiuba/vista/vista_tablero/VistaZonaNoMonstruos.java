package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.NoMonstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.LinkedList;
import java.util.List;

public class VistaZonaNoMonstruos extends HBox {

    private int indice;
    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;
    private LinkedList<VistaCarta> vistasNoMonstruos;

    public VistaZonaNoMonstruos(Jugador jugador) {

        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i < 5; i++) {
            ImageView imagen2 = new ImageView(new Image("algo3/fiuba/resources/img/magica-atr.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            this.agregarCarta(imagen2);
        }
        vistasNoMonstruos = new LinkedList<>();
    }

    public void dibujar() {
        indice = 0;
        for(NoMonstruo noMonstruo: jugador.getNoMonstuosEnCampo()) {
            vistasNoMonstruos.add(new VistaCarta("/algo3/fiuba/resources/img/" + noMonstruo.getNombre() + ".jpg", jugador, noMonstruo));
        }
        for(VistaCarta vistaMonstruo: vistasNoMonstruos) {
            this.reemplazarCartaVista(vistaMonstruo);
            indice++;
        }
    }

    public void agregarCarta(ImageView carta) {
        this.getChildren().add(carta);
        this.setHgrow(carta, Priority.ALWAYS);
    }

    public void reemplazarCartaVista(VistaCarta vistaCarta) {
        getChildren().remove(indice);
        getChildren().add(indice, vistaCarta);
    }

    public void update() {
        this.dibujar();
    }
}
