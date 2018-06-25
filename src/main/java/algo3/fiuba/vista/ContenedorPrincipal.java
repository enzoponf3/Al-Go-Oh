package algo3.fiuba.vista;

import algo3.fiuba.vista.eventos.EventoAyuda;
import algo3.fiuba.vista.eventos.EventoSalir;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ContenedorPrincipal extends BorderPane {

    Tablero tablero;

    public ContenedorPrincipal(Stage stage) {

        this.getStylesheets().add("/algo3/fiuba/vista/estilos/estiloContenedorPrincipal.css");
        this.setBarraLateral();
        this.setTablero();
    }

    private void setBarraLateral() {

        // BOTONES
        Button botonAyuda = new Button("Ayuda");
        botonAyuda.setOnAction(new EventoAyuda());

        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(new EventoSalir());

        Button botonFase = new Button("Cambiar de fase");
        // añadir funcion

        Button botonFinTurno = new Button("Terminar turno");
        //añadir funcion


        //Consolas de puntos
        CanvasBarraLateral consolaJ1 = new CanvasBarraLateral(199.0, 100.0);
        GraphicsContext graficas = consolaJ1.getGraphicsContext2D();
        consolaJ1.drawInCanvas(graficas, 0.0,0.0);
       // Label nombre = new Label(nombreJ1);

        // CONTADOR DE PUNTOS DE VIDA J2
        CanvasBarraLateral consolaJ2 = new CanvasBarraLateral(200.0, 700.0);
        GraphicsContext grafico = consolaJ2.getGraphicsContext2D();
        consolaJ2.drawInCanvas(grafico, 0.0, 330.0);
        //Label nombre2 = new Label(nombreJ2);

        // PROYECTOR DE EFECTOS DE CARTA
        //String info = tablero.getInfoCarta();
        Label muestrarioInfoCarta = new Label("hola");//info);
        muestrarioInfoCarta.getStyleClass().add("muestrarioInfoCarta");

        // CONTENEDORES LATERALES
        HBox boxBtnsAyudaSalir = new HBox(botonAyuda, botonSalir);
        boxBtnsAyudaSalir.setAlignment(Pos.CENTER);
        boxBtnsAyudaSalir.setSpacing(20);

        VBox boxBtnsFaseTurno = new VBox(boxBtnsAyudaSalir, botonFase, botonFinTurno);
        boxBtnsFaseTurno.setAlignment(Pos.CENTER);
        boxBtnsFaseTurno.setSpacing(10);

        VBox vbox = new VBox(consolaJ1, boxBtnsFaseTurno, muestrarioInfoCarta, consolaJ2);
        vbox.setPadding(new Insets(15));
        vbox.setSpacing(10);

        vbox.getStyleClass().add("vbox");

        this.setLeft(vbox);
    }

    private void setTablero() {

        tablero = new Tablero();
        tablero.getStyleClass().add("tablero");
        this.setCenter(tablero);
    }

}
