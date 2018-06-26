package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorCementerio;
import algo3.fiuba.controladores.ControladorMazo;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Tablero extends GridPane {

    private double ANCHO_MAXIMO_CARTA = 100.0;
    private double ALTURA_MAXIMA_CARTA = 130.0;

    public Tablero() {

        this.setGridLinesVisible(true); // si las quieren ver habiliten esta linea
        this.setPadding(new Insets(5));
        this.setVgap(5.5);
        this.setHgap(5.5);
        this.getStylesheets().add("/algo3/fiuba/resources/estilos/estiloContenedorPrincipal.css");

        this.setMano();
        this.setMazo();
        this.setCampo();
        this.setCementerio();
        this.setCartaCampo();
    }

    public void setMano() {

        HBox mano = new HBox();
        for (int i = 0; i <= 4; i++) {
            VistaCarta carta = new VistaCarta();
            mano.getChildren().add(carta);
        }

        ScrollPane barraMano = new ScrollPane();
        barraMano.setMaxWidth(600);
        barraMano.setContent(mano);
        barraMano.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.add(barraMano, 1,0);
    }

    public void setMazo() {

        Label nroCartas = new Label("10");
        nroCartas.setTextFill(Color.WHITE); // AGREGAR AL CSS
        ImageView mazo = new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        nroCartas.setGraphic(mazo);
        mazo.setOnMouseClicked(new ControladorMazo());

        this.add(nroCartas, 0, 0);
    }

    public void setCampo() {
           //BATALLANDO

        HBox zonaCartasMagicas = new HBox();
        HBox zonaCartasMonstruo = new HBox();

        for (int i = 0; i < 5; i++) {

            zonaCartasMagicas.getChildren().add(new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
            zonaCartasMagicas.setSpacing(10);

            zonaCartasMonstruo.getChildren().add(new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false)));
            zonaCartasMonstruo.setSpacing(10);
        }

        this.add(zonaCartasMagicas, 1, 1);
        this.add(zonaCartasMonstruo, 1, 2);
    }

    public void setCementerio() {

        ImageView cementerio = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        cementerio.setOnMouseClicked(new ControladorCementerio());
        this.add(cementerio, 0, 2);
    }

    public void setCartaCampo() {

        ImageView campo = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.add(campo, 2, 2);
    }

}
