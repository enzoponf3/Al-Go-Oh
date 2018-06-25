package algo3.fiuba.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stagePrincipal) {

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stagePrincipal);
        Scene sceneJuego = new Scene(contenedorPrincipal, 1200, 720);

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada(stagePrincipal, sceneJuego);
        Scene sceneBienvenida = new Scene(contenedorEntrada, 300, 340);

        stagePrincipal.setScene(sceneBienvenida);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
