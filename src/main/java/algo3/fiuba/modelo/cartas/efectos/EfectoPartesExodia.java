package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.jugador.Jugador;
import algo3.fiuba.modelo.cartas.Carta;

public class EfectoPartesExodia extends EfectoCarta {

    private static Integer contadorPartes = 0;
    private Jugador oponente;

    public EfectoPartesExodia(Jugador oponente) {
        this.oponente = oponente;
    }

    public void efectoExodia() {
        contadorPartes++;
        if (contadorPartes == 5)
            oponente.modificarPuntosDeVida(-8000);
    }

    @Override
    public void activar(Carta carta) {
        efectoExodia();
    }

    @Override
    public void desactivar() {
        contadorPartes--;
    }


}
