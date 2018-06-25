package algo3.fiuba.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Tablero extends GridPane {

       public Tablero() {

           this.setGridLinesVisible(true);
           this.setPadding(new Insets(10));

           this.setMano();
           this.setMazo();
           this.setCampo();
           this.setCementerio();
       }

       public void setMano() {

           //ArrayList<Carta> mano = new ArrayList
          // ScrollPane mano = new ScrollPane();
           ImageView carta = new ImageView(new Image("/algo3/fiuba/vista/resosources/carta-vista-trasera.png", 101, 128, false, false));
            // estoy aca

       }

       public void setMazo() {

           ImageView mazo = new ImageView(new Image("/algo3/fiuba/vista/resosources/carta-vista-trasera.png", 101, 128, false, false));
           mazo.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
               @Override
               public void handle(javafx.scene.input.MouseEvent event) {
                   //robarCarta();
                   Alert a = new Alert(Alert.AlertType.INFORMATION);
                   a.setContentText("No puedes tomar esta carta si no es tu turno!");
                   a.show();
               }
           });
           this.add(mazo, 0, 0);
       }

       public void setCampo() {

           //BATALLANDO

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
               }
           });
           this.add(cementerio, 0,2);
       }
}
