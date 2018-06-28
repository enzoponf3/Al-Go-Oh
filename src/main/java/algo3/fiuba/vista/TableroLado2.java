package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorCementerio;
import algo3.fiuba.controladores.ControladorMazo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import java.util.jar.JarEntry;

public class TableroLado2 extends Tablero {

    Jugador jugador;

    public TableroLado2(Jugador jugador) {

        this.setGridLinesVisible(true); // si las quieren ver habiliten esta linea
        this.setPadding(new Insets(5));
        this.setVgap(5.5);
        this.setHgap(5.5);
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");

        this.jugador = jugador;
        super.setMano(1, 2);
        super.setMazo(2, 2);
        super.setCampo(1, 1, 1, 0);
        super.setCementerio(2, 0);
        super.setCartaCampo(0, 0);
    }
}
