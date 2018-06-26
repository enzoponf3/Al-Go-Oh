package algo3.fiuba.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Boton extends Button {

    public Boton(String text, EventHandler<ActionEvent> evento) {
        setText(text);
        setOnAction(evento);
    }
}
