package algo3.fiuba;

import algo3.fiuba.controladores.ControladorDeTurnos;
import algo3.fiuba.modelo.Juego;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.utils.MazoUtils;
import algo3.fiuba.vista.ContenedorEntrada;
import algo3.fiuba.vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private MazoUtils mazoUtils;

    public Main() {
        this.mazoUtils = new MazoUtils();
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception{

        Juego juego = crearModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stagePrincipal, juego);
        contenedorPrincipal.dibujar();
        ControladorDeTurnos controladorTurnos = ControladorDeTurnos.getInstancia();
        controladorTurnos.setContenedorPrincipal(contenedorPrincipal);
        Scene sceneJuego = new Scene(contenedorPrincipal, 1000, 700);

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada(stagePrincipal, sceneJuego, juego.getJugador1(), juego.getJugador2());
        Scene sceneBienvenida = new Scene(contenedorEntrada, 300, 340);

        stagePrincipal.getIcons().add(new Image("/algo3/fiuba/resources/img/icono-yugioh.jpeg"));
        stagePrincipal.setScene(sceneBienvenida);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Juego crearModelo() {

        Juego juego = Juego.getInstancia();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        juego.inicializar(jugador1,jugador2);
        juego.inicializarMazos(mazoUtils.getMuestra9Cartas1(jugador1), mazoUtils.getMuestra9Cartas2(jugador2));
        juego.inicializarManos();
        ControladorDeTurnos controladorTurnos = ControladorDeTurnos.getInstancia();
        controladorTurnos.setJugadores(jugador1, jugador2);
        return juego;
    }
}
