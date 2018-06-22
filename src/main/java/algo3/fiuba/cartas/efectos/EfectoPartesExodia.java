package algo3.fiuba.cartas.efectos;

import algo3.fiuba.Juego;
import algo3.fiuba.Jugador;
import algo3.fiuba.cartas.Carta;

import java.util.ArrayList;

public class EfectoPartesExodia extends EfectoCarta {

    private ArrayList efectosAcumulados = new ArrayList();

    @Override
    public void activar(Carta carta) {
        efectosAcumulados.add(carta);
        if (efectosAcumulados.size() == 5)
            efectoExodia();
    }

    public void efectoExodia() {
        // juego.terminar()
        throw new Error();

    }

    public Integer getTam(){return efectosAcumulados.size();}
}
