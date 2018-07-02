package algo3.fiuba.controladores.botones;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.ContenedorEntrada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class ControladorEntrar implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene pantallaJuego;
    private ContenedorEntrada contenedorEntrada;
    private Jugador jugador1;
    private Jugador jugador2;

    public ControladorEntrar(Stage stage, Scene proximaPantalla, ContenedorEntrada contenedorEntrada, Jugador jugador1, Jugador jugador2) {
        this.stage = stage;
        this.pantallaJuego = proximaPantalla;
        this.contenedorEntrada = contenedorEntrada;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void handle(ActionEvent event) {
        String nombreJugador1 = contenedorEntrada.getNombreJugador1();
        String nombreJugador2 = contenedorEntrada.getNombreJugador2();
        if (nombreJugador1.isEmpty() || nombreJugador2.isEmpty()) {
            Alert nombresVacios = new Alert(Alert.AlertType.ERROR);
            nombresVacios.setHeaderText(null);
            nombresVacios.setContentText("Los 2 jugadores deben ingresar sus nombres!");
            nombresVacios.show();
        } else {
            jugador1.setNombre(nombreJugador1);
            jugador2.setNombre(nombreJugador2);
            stage.setScene(pantallaJuego);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Al-Go-Oh!");
        }
    }

}
