package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;
import algo3.fiuba.cartas.Monstruo;

public class EfectoAgujeroNegro extends EfectoCarta {

    private Jugador jugador;
    private Jugador oponente;

    public EfectoAgujeroNegro(Jugador jugador, Jugador oponente) {
        this.jugador = jugador;
        this.oponente = oponente;
    }

    /*
    @Override
    public void activar(Juego juego, Carta carta) {
        juego.activarEfecto(this);
    }
*/
    @Override
    public void activar(Carta carta) {
        jugador.matarMonstruosEnCampo();
        oponente.matarMonstruosEnCampo();

    }

    @Override
    public void activar(Carta carta, Monstruo otraCarta) {

    }

/*
    public void matarMonstruos(Tablero tablero) {
        tablero.matarMonstruos();
    }
    */
}
