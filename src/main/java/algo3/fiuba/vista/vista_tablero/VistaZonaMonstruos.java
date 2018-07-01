package algo3.fiuba.vista.vista_tablero;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.excepciones.CampoNoPermiteColocarCartaExcepcion;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.CartaVistaUtils;
import algo3.fiuba.vista.VistaCarta;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class VistaZonaMonstruos extends HBox {

    private int indice;
    protected Jugador jugador;
    protected double ANCHO_MAXIMO_CARTA = 95.0;
    protected double ALTURA_MAXIMA_CARTA = 110.0;
    private List<VistaCarta> vistasMonstruos;

    private CartaVistaUtils cartaVistaUtils;

    public VistaZonaMonstruos(Jugador jugador) {

        this.setSpacing(20);
        this.jugador = jugador;
        for (int i = 0; i < 5; i++) {
            ImageView imagen2 = new ImageView(new Image("algo3/fiuba/resources/img/monstruo-atr.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            this.agregarCarta(imagen2);
        }

        this.vistasMonstruos = new LinkedList<>();
        this.cartaVistaUtils = new CartaVistaUtils();
    }

    // !!!! ESTO HABRÍA QUE SACARLO PORQUE LO HACE LE
    public void agregarCarta(ImageView carta) {

        try {
            this.getChildren().add(carta);
            this.setHgrow(carta, Priority.ALWAYS);
        } catch (CampoNoPermiteColocarCartaExcepcion e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("El campo esta lleno");
            error.show();
        }
    }

    public void dibujar() {
        indice = 0;
        for (Monstruo monstruo : jugador.getMonstuosEnCampo()) {
            vistasMonstruos.add(new VistaCarta(cartaVistaUtils.getImagenDeCarta(monstruo.getNombre()), jugador, monstruo));
        }
        for (VistaCarta vistaMonstruo : vistasMonstruos) {
            this.reemplazarCartaVista(vistaMonstruo);
            indice++;
        }
    }

    public void reemplazarCartaVista(VistaCarta vistaCarta) {
        getChildren().remove(indice);
        getChildren().add(indice, vistaCarta);
    }

    // !!!! MODELO
    public void agregarMonstruo(VistaCarta vistaCarta) {
        vistasMonstruos.add(vistaCarta);
    }

    public void update() {
        this.dibujar();
    }

    public List<VistaCarta> getVistasMonstruos() {
        return vistasMonstruos;
    }
}
