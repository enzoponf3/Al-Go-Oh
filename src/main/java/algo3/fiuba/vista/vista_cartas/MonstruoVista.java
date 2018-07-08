package algo3.fiuba.vista.vista_cartas;

import algo3.fiuba.controladores.ControladorCantidadDeSacrificios;
import algo3.fiuba.controladores.ControladorMonstruoAAtacar;
import algo3.fiuba.controladores.botones.checkboxs.CheckBoxMonstruo;
import algo3.fiuba.modelo.cartas.Monstruo;
import algo3.fiuba.modelo.cartas.estado_en_turno.UsadaEnTurno;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaAbajo;
import algo3.fiuba.modelo.cartas.modo_monstruo.ModoDeDefensa;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.jugador.PostInvocacion;
import algo3.fiuba.modelo.jugador.PreInvocacion;
import algo3.fiuba.modelo.jugador.TurnoDelOponente;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MonstruoVista extends CartaVista {

    private Monstruo monstruo;

    public MonstruoVista(String imageUrl, Jugador jugador, Monstruo monstruo) {
        super(imageUrl, jugador, monstruo);
        this.monstruo = monstruo;
    }

    @Override
    public void dibujar() {
        super.dibujar();

        Rectangle rectanguloFondo = new Rectangle(76, 21, Color.LIGHTGOLDENRODYELLOW);
        StackPane.setMargin(rectanguloFondo, new Insets(76, 0, 0, 0));

        Label labelPuntosDeAtaque = new Label("" + monstruo.getAtaque());
        labelPuntosDeAtaque.setStyle("-fx-border-color: brown" );
        StackPane.setMargin(labelPuntosDeAtaque, new Insets(75, 35, 0, 0));

        Label labelPuntosDeDefensa = new Label("" + monstruo.getDefensa());
        labelPuntosDeDefensa.setStyle("-fx-border-color: brown");
        StackPane.setMargin(labelPuntosDeDefensa, new Insets(75, 0, 0, 40));

        super.getChildren().addAll(rectanguloFondo,labelPuntosDeAtaque,labelPuntosDeDefensa);

        if ((jugador.getEstadoJugador() instanceof TurnoDelOponente &&
                (!carta.estaEnJuego() || carta.getEstadoCarta() instanceof BocaAbajo))
                || (jugador.getEstadoJugador() instanceof PostInvocacion && !carta.estaEnJuego())) {
            rectanguloFondo.setVisible(false);
            labelPuntosDeAtaque.setVisible(false);
            labelPuntosDeDefensa.setVisible(false);
        }

        if ((jugador.getEstadoJugador() instanceof PreInvocacion) && carta.estaEnJuego()) {
            CheckBoxMonstruo checkBoxParaSacrificio = new CheckBoxMonstruo(monstruo);
            checkBoxParaSacrificio.setOnAction(new ControladorCantidadDeSacrificios());

            super.getChildren().add(checkBoxParaSacrificio);
        }

        if (jugador.getEstadoJugador() instanceof TurnoDelOponente
                && jugador.getOponente().getEstadoJugador() instanceof PostInvocacion && carta.estaEnJuego()) {
            CheckBoxMonstruo checkBoxMonstruoAAtacar = new CheckBoxMonstruo(monstruo);
            checkBoxMonstruoAAtacar.setOnAction(new ControladorMonstruoAAtacar());

            super.getChildren().add(checkBoxMonstruoAAtacar);
        }

        if (carta.getEstadoEnTurno() instanceof UsadaEnTurno) {
            super.setDisable(true);
        }

        if(monstruo.getModo() instanceof ModoDeDefensa) {
            this.setRotate(90);
        }
    }
}
