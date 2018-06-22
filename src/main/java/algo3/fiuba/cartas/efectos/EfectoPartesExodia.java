package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;

public class EfectoPartesExodia extends EfectoCarta {

    private static Integer contadorPartes = 0;
    private Jugador jugador;

    public EfectoPartesExodia(Jugador jugador) {
        this.jugador = jugador;
    }

    public void efectoExodia(Jugador jugador) {
        contadorPartes++;
        if (contadorPartes == 5)
            jugador.getOponente().modificarPuntosDeVida(-8000);
    }

    @Override
    public void activar(Carta carta) {
        efectoExodia(jugador);
    }

    public void desactivarEfecto() {
        // Por lo menos hay una parte
        contadorPartes--;
    }


}
