package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;

public class EfectoPartesExodia extends EfectoCarta {

    private Integer contadorPartes = 0;
    private static EfectoPartesExodia INSTANCIA;

    public static EfectoPartesExodia getInstancia() {
        if (INSTANCIA == null){
            INSTANCIA = new EfectoPartesExodia();
        }
        return INSTANCIA;
    }

    public void efectoExodia(Jugador jugador) {
        contadorPartes += 1;
        if (contadorPartes == 5)
            jugador.getOponente().matarJugador();
    }

    @Override
    public void activar(Jugador jugador) {
        efectoExodia(jugador);
    }

    public void desactivarEfecto() {
        // Por lo menos hay una parte
        contadorPartes -= 1;
    }


}
