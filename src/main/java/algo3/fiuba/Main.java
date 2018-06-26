package algo3.fiuba;

import algo3.fiuba.vista.ContenedorEntrada;
import algo3.fiuba.vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stagePrincipal) throws Exception{

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stagePrincipal);
        Scene sceneJuego = new Scene(contenedorPrincipal, 1150, 800);

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada(stagePrincipal, sceneJuego);
        Scene sceneBienvenida = new Scene(contenedorEntrada, 300, 340);

        //contenedorEntrada.setBotonJugar(stagePrincipal, sceneJuego);
        stagePrincipal.getIcons().add(new Image("/algo3/fiuba/resources/img/icono-yugioh.jpeg"));
        stagePrincipal.setScene(sceneBienvenida);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
