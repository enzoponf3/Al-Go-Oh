package algo3.fiuba.vista;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tablero extends GridPane {

    private double ANCHO_MAXIMO_CARTA = 110;
    private double ALTURA_MAXIMA_CARTA = 130;

    public Tablero() {

        //this.setGridLinesVisible(true); // si las quieren ver habiliten esta linea
        this.setPadding(new Insets(5));
        this.setVgap(5.5);
        this.setHgap(5.5);
        this.getStylesheets().add("/algo3/fiuba/vista/resources/estilos/estiloContenedorPrincipal.css");

        this.setMano();
        this.setMazo();
        this.setCampo();
        this.setCementerio();
        this.setCartaCampo();
    }

    public void setMano() {

           //ArrayList<Carta> mano = new ArrayList
        GridPane mano = new GridPane();
        for (int i = 2; i <= 7; i++) {
            ImageView carta = new ImageView(new Image("/algo3/fiuba/vista/resources/img/carta-vista-trasera.png",
                    ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
            carta.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                       // PONER ZOOM
                }
            });
            mano.add(carta, i, 0);
        }
        ScrollPane barraMano = new ScrollPane();
        barraMano.setMaxWidth(535);
        barraMano.setContent(mano);
        barraMano.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // No hay otra opcion?
        ColumnConstraints espacioLibre = new ColumnConstraints(150);
        this.getColumnConstraints().add(espacioLibre);

        this.add(barraMano, 2,0,6, 1);
    }

    public void setMazo() {

        ImageView mazo = new ImageView(new Image("/algo3/fiuba/vista/resources/img/carta-vista-trasera.png",
                ANCHO_MAXIMO_CARTA, ALTURA_MAXIMA_CARTA, false, false));
        mazo.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                //robarCarta();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.show();
            }
        });
        this.add(mazo, 0, 0);
    }

       public void setCampo() {
           //BATALLANDO

           // LADO 1
           for (int j = 1; j <= 2; j++) {
               for (int i = 2; i < 7; i++) {
                   this.add(new Rectangle(101, 120), i, j);
               }
           }

           // LADO DOS
           /*for (int j = 4; j <= 5; j++) {
               for (int i = 2; i < 7; i++) {
                   this.add(new Rectangle(101, 120), i, j);
               }
           }*/
           this.getChildren().remove(6);
           ImageView carta = new ImageView(new Image("/algo3/fiuba/vista/resources/img/carta-vista-trasera.png", 101, 128, false, false));
           carta.setRotate(90); // EJEJEJ QUEDA RE CHOOTOO!! JAJAJAJA VER TAMAÑO
           this.add(carta, 2, 2);

       }

       public void setCementerio() {

           Rectangle cementerio = new Rectangle(101, 128);
           cementerio.setFill(Color.BLACK);
           cementerio.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
               @Override
               public void handle(javafx.scene.input.MouseEvent event) {
                   Alert a = new Alert(Alert.AlertType.ERROR);
                   a.setContentText("No puedes robar del cementerio!");
                   a.show();
                   //a.hide
               }
           });
       }

       public void setCartaCampo() {
           Rectangle campo = new Rectangle(101, 128);
           campo.setStroke(Color.WHITE);
           campo.setFill(Color.AZURE);
           this.add(campo, 7, 2);
       }

}
