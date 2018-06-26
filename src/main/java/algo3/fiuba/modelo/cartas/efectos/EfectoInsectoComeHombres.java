package algo3.fiuba.modelo.cartas.efectos;

import algo3.fiuba.modelo.cartas.Carta;

public class EfectoInsectoComeHombres extends EfectoCarta {

    public EfectoInsectoComeHombres() {

    }

    @Override
    public void activar(Carta carta) {
        carta.mandarDelCampoAlCementerio();
    }
}
