package algo3.fiuba.controladores.controladores_de_carta;

import algo3.fiuba.modelo.cartas.Carta;
import algo3.fiuba.modelo.cartas.estados_cartas.BocaArriba;
import algo3.fiuba.modelo.cartas.estados_cartas.EnJuego;
import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.vista.vista_cartas.CartaVista;

public class ControladorBocaArribaEnMano extends ControladorColocarCarta {


    public ControladorBocaArribaEnMano(CartaVista vistaCarta, Jugador jugador, Carta carta) {
        super(vistaCarta, jugador, carta);
    }

    @Override
    public EnJuego tipoEnJuego(Carta carta) {
        /*if (carta instanceof Monstruo){
            Media musica = new Media(getClass().getResource("/algo3/fiuba/resources/media/monstruo.mp3").toExternalForm());
            MediaPlayer rprMusica = new MediaPlayer(musica);
            rprMusica.play();
        } else if (carta instanceof CartaCampo){
            Media musica = new Media(getClass().getResource("/algo3/fiuba/resources/media/cartacampofx.mp3").toExternalForm());
            MediaPlayer rprMusica = new MediaPlayer(musica);
            rprMusica.play();
        }*/
        return new BocaArriba();
    }
}
