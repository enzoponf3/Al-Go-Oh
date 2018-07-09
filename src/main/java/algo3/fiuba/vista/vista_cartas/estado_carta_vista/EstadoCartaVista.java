package algo3.fiuba.vista.vista_cartas.estado_carta_vista;

import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.vista.vista_cartas.CartaVista;
import algo3.fiuba.vista.vista_cartas.MonstruoVista;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class EstadoCartaVista {

    public abstract void aniadirFuncionalidad(CartaVista cartaVista);

    public abstract void aniadirFuncionalidad(MonstruoVista cartaVista, Monstruo monstruo);

    protected void generarAtaqueYDefensaDinamica(MonstruoVista cartaVista, Monstruo monstruo) {
        Rectangle rectanguloFondo = new Rectangle(76, 21, Color.LIGHTGOLDENRODYELLOW);
        StackPane.setMargin(rectanguloFondo, new Insets(76, 0, 0, 0));

        Label labelPuntosDeAtaque = new Label("" + monstruo.getAtaque());
        labelPuntosDeAtaque.setStyle("-fx-border-color: brown" );
        StackPane.setMargin(labelPuntosDeAtaque, new Insets(75, 35, 0, 0));

        Label labelPuntosDeDefensa = new Label("" + monstruo.getDefensa());
        labelPuntosDeDefensa.setStyle("-fx-border-color: brown");
        StackPane.setMargin(labelPuntosDeDefensa, new Insets(75, 0, 0, 40));

        cartaVista.getChildren().addAll(rectanguloFondo,labelPuntosDeAtaque,labelPuntosDeDefensa);

    }
}
