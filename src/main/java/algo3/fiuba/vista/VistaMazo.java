package algo3.fiuba.vista;

import algo3.fiuba.controladores.ControladorMazo;
import algo3.fiuba.modelo.jugador.Jugador;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class VistaMazo extends Label {

    private double ANCHO_MAXIMO_CARTA = 90.0;
    private double ALTURA_MAXIMA_CARTA = 105.0;
    private int cantidad;
    private ImageView fondoMazo;

    // LE PODEMOS PASAR CON EL CONTROLADOR EL NUMERO DE CARTAS
    public VistaMazo(ImageView fondoMazo) {

        this.cantidad = 40;
        this.fondoMazo = fondoMazo;

        this.setText(String.valueOf(cantidad));
        //this.setDisable(true);
        this.setTextFill(Color.WHITE);
        this.setGraphic(fondoMazo);
        this.setContentDisplay(ContentDisplay.CENTER);
    }

    public void update() {

        cantidad--;

        this.setText(String.valueOf(cantidad));
        this.setDisable(true);
        this.setTextFill(Color.WHITE);
        this.setGraphic(fondoMazo);
        this.setContentDisplay(ContentDisplay.CENTER);
    }

    public void actualizarCantidad(Integer tam) {

        this.setText("" + tam);
    }

    public void habilitarMazo() {

        if (this.isDisabled()) this.setDisable(false);
       // this.setOnMouseClicked(new ControladorMazo());
    }

}
