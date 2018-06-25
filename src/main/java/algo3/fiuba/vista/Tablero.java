package algo3.fiuba.vista;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Tablero extends GridPane {

       public Tablero() {

           this.setGridLinesVisible(true);
           this.setPadding(new Insets(5));
           this.setVgap(5.5);
           this.setHgap(5.5);
           this.getStylesheets().add("/algo3/fiuba/vista/estilos/estiloContenedorPrincipal.css");

           this.setMano();
           this.setMazo();
           this.setCampo();
           this.setCementerio();
       }

       public void setMano() {

           //ArrayList<Carta> mano = new ArrayList
          // ScrollPane mano = new ScrollPane();
           Rectangle r = new Rectangle(501, 120);
           r.setFill(Color.WHITE);
           // viendo
           Scrollbar j = new Scrollbar();
           add(r, 1, 0, 6,1);
           for (int i = 2; i<7; i++) {
               ImageView carta = new ImageView(new Image("/algo3/fiuba/vista/resosources/carta-vista-trasera.png", 101, 120, false, false));
               //this.add(carta, i, 0,4,0);
               carta.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>() {
                   @Override
                   public void handle(javafx.scene.input.MouseEvent event) {
                       // PONER ZOOM
                   }
               });
           }
           ColumnConstraints column1 = new ColumnConstraints();
           column1.setPercentWidth(20);
           this.getColumnConstraints().add(column1);
           //this.add(carta,3,0);
           //this.add(carta,4,0);
       }

       public void setMazo() {

           ImageView mazo = new ImageView(new Image("/algo3/fiuba/vista/resosources/carta-vista-trasera.png", 101, 120, false, false));
           mazo.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
               @Override
               public void handle(javafx.scene.input.MouseEvent event) {
                   //robarCarta();
                   Alert a = new Alert(Alert.AlertType.INFORMATION);
                   a.show();
               }
           });
           this.add(mazo, 0, 1);
           ImageView mazo2 = new ImageView(new Image("/algo3/fiuba/vista/resosources/carta-vista-trasera.png", 101, 120, false, false));
           mazo2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
               @Override
               public void handle(javafx.scene.input.MouseEvent event) {
                   //robarCarta();
                   Alert a = new Alert(Alert.AlertType.INFORMATION);
                   a.show();
               }
           });
           this.add(mazo2, 0, 5);
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
           for (int j = 4; j <= 5; j++) {
               for (int i = 2; i < 7; i++) {
                   this.add(new Rectangle(101, 120), i, j);
               }
           }
           this.getChildren().remove(14);
           ImageView carta = new ImageView(new Image("/algo3/fiuba/vista/resosources/carta-vista-trasera.png", 101, 120, false, false));
           carta.setRotate(90); // EJEJEJ QUEDA RE CHOOTOO!! JAJAJAJA VER TAMAÑO
           this.add(carta, 2, 4);

       }

       public void setCementerio() {

           Rectangle cementerio = new Rectangle(101, 120);
           cementerio.setFill(Color.BLACK);
           cementerio.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
               @Override
               public void handle(javafx.scene.input.MouseEvent event) {
                   Alert a = new Alert(Alert.AlertType.ERROR);
                   a.setContentText("No puedes robar del cementerio!");
                   a.show();
               }
           });
           this.add(cementerio, 0,2);
           cementerio = new Rectangle(101, 120);
           cementerio.setFill(Color.BLACK);
           cementerio.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
               @Override
               public void handle(javafx.scene.input.MouseEvent event) {
                   Alert a = new Alert(Alert.AlertType.ERROR);
                   a.setContentText("No puedes robar del cementerio!");
                   a.hide(); // me gusta más así
               }
           });
           this.add(cementerio, 0,4);
       }

}
