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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Tablero extends GridPane {

    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    public Tablero tablero;
    Jugador jugador;

    public void setMano(Integer colIndex, Integer rowIndex) {

        GridPane mano = new GridPane();
       // HBox mano = new HBox();
        for (int i = 0; i <= 10; i++) {
            VistaCarta carta = new VistaCarta();
            mano.add(carta, i,0);
        }
        VistaCarta c = new VistaCarta();
        mano.add(c, mano.getColumnCount() +1 ,0);
        ScrollPane barraMano = new ScrollPane();
        barraMano.setMaxWidth(535);
        barraMano.setContent(mano);
        barraMano.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.add(barraMano, colIndex,rowIndex);
    }

    public void setMazo(Integer colIndex, Integer rowIndex) {

        Label nroCartas = new Label("10");
        nroCartas.setContentDisplay(ContentDisplay.CENTER);
        nroCartas.setTextFill(Color.WHITE); // AGREGAR AL CSS
        ImageView mazo = new ImageView(new Image("/algo3/fiuba/resources/img/carta-vista-trasera.png",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));

        nroCartas.setGraphic(mazo);
        mazo.setDisable(true);
        mazo.setOnMouseClicked(new ControladorMazo());

        this.add(nroCartas, colIndex, colIndex);
    }

    public void setCampo( Integer colIndex, Integer rowIndex, Integer colIndex2, Integer rowIndex2) {

        HBox zonaCartasMagicas = new HBox();
        HBox zonaCartasMonstruo = new HBox();

        for (int i = 0; i < 5; i++) {

            ImageView imagen =new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            zonaCartasMagicas.getChildren().add(imagen);
            zonaCartasMagicas.setSpacing(20);

            ImageView imagen2 =new ImageView(new Image("algo3/fiuba/resources/img/Dragon Negro de Ojos Rojos.gif",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            zonaCartasMonstruo.getChildren().add(imagen2);
            zonaCartasMonstruo.setSpacing(20);
            zonaCartasMonstruo.getChildren().get(i).setRotate(90);
            zonaCartasMonstruo.setHgrow(imagen2, Priority.ALWAYS);
        }

        this.add(zonaCartasMagicas, colIndex, rowIndex);
        this.add(zonaCartasMonstruo, colIndex2, rowIndex2);
    }

    public void setCementerio(Integer colIndex, Integer rowIndex) {

        ImageView cementerio = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        cementerio.setOnMouseClicked(new ControladorCementerio());
        this.add(cementerio, colIndex, rowIndex);
    }

    public void setCartaCampo(Integer colIndex, Integer rowIndex) {

        ImageView campo = new ImageView(new Image("/algo3/fiuba/resources/img/cartavacia.jpg",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        this.add(campo, colIndex, rowIndex);
    }

}
