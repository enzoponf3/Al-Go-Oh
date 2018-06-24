package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;

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

    public void desactivarEfecto() {
        // Por lo menos hay una parte
        contadorPartes--;
    }


}
