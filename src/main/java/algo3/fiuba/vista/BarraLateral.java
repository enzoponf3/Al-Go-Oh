package algo3.fiuba.vista;

import algo3.fiuba.controladores.BotonCambiarDeFase;
import algo3.fiuba.controladores.ControladorBotonAyuda;
import algo3.fiuba.controladores.ControladorBotonSalida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BarraLateral extends StackPane {

    ImageView imagen = new ImageView(new Image("/algo3/fiuba/resources/img/Life_point_counter.jpg",
            200, 150, false, false));

    public BarraLateral() {

        // BOTONERA
        Boton botonAyuda = new Boton("Ayuda", new ControladorBotonAyuda());
        Boton botonSalir = new Boton("Salir", new ControladorBotonSalida());
        Boton botonFase = new Boton("Cambiar de fase", new BotonCambiarDeFase()); // añadir funcion
        Boton botonFinTurno = new Boton("Terminar turno", null);  //añadir funcion

        // Consolas de puntos

        // CONSOLA J1
        Rectangle fotoJugador = new Rectangle(115, 115);
        fotoJugador.setStroke(Color.WHITE);

       // Rectangle fondoConsola = new Rectangle(200, 150);
        Label consolaJ1 = new Label("imagen mugrosa", imagen);
        consolaJ1.setTextFill(Color.WHITE);
        consolaJ1.setContentDisplay(ContentDisplay.CENTER);

        // CONSOLAJ2
        Rectangle fotoJugador2 = new Rectangle(115, 115);
        fotoJugador2.setStroke(Color.WHITE);
        Rectangle fondoConsola = new Rectangle(200, 150);
        Label consolaJ2 = new Label("SEEETOOOOO", fondoConsola);
        consolaJ1.setTextFill(Color.WHITE);
        consolaJ2.setContentDisplay(ContentDisplay.CENTER);

        // CONTENEDORES LATERALES
        HBox boxBtnsAyudaSalir = new HBox(botonAyuda, botonSalir);
        boxBtnsAyudaSalir.setAlignment(Pos.CENTER);
        boxBtnsAyudaSalir.setSpacing(20);

        VBox boxBtnsFaseTurno = new VBox(boxBtnsAyudaSalir, botonFase, botonFinTurno);
        boxBtnsFaseTurno.setAlignment(Pos.CENTER);
        boxBtnsFaseTurno.setSpacing(10);

        VBox vbox = new VBox(fotoJugador, consolaJ1, boxBtnsFaseTurno, consolaJ2, fotoJugador2);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        vbox.getStyleClass().add("vbox");
        this.getChildren().add(vbox);
    }
}
