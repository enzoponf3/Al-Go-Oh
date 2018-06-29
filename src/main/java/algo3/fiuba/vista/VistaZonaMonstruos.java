package algo3.fiuba.vista;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.LinkedList;
import java.util.List;

public class VistaZonaMonstruos extends HBox {

    private int indice;
    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;
    private LinkedList<VistaCarta> vistasMonstruos;

    public VistaZonaMonstruos(Jugador jugador) {

        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i <= 4; i++) {
            ImageView imagen2 = new ImageView(new Image("algo3/fiuba/resources/img/monstruo-atr.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            this.agregarCarta(imagen2);
        }
        vistasMonstruos = new LinkedList<VistaCarta>();
    }

    /*
    public void dibujar() {
        List<Monstruo> zonaMonstruos = jugador.getMonstuosEnCampo();
        //this.reemplazarCarta(null);
        indice = 0;
        for(Monstruo monstruo: zonaMonstruos) {
            String imageUrl = "/algo3/fiuba/resources/img/" + monstruo.getNombre() + ".jpg";
            this.reemplazarCarta(new ImageView(new Image(imageUrl,
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
            indice++;
        }
    }
    */
    public void agregarCarta(ImageView carta) {
        this.getChildren().add(carta);
        this.setHgrow(carta, Priority.ALWAYS);
    }
    /*
    public void reemplazarCarta(ImageView carta) {

        getChildren().remove(indice);
        getChildren().add(indice, carta);
    }
    */
    public void dibujar() {
        indice = 0;
        for(VistaCarta vistaMonstruo: vistasMonstruos) {
            this.reemplazarCartaVista(vistaMonstruo);
            indice++;
        }
    }

    public void reemplazarCartaVista(VistaCarta vistaCarta) {
        getChildren().remove(indice);
        getChildren().add(indice, vistaCarta);
    }
    public void agregarMonstruo(VistaCarta vistaCarta) {
        vistasMonstruos.add(vistaCarta.clonar());
        //no se puede tener un mismo nodo en distintos lugares, sino colapsa y no se ve en ningun lado
    }

    public void update() {
        this.dibujar();
    }
}
