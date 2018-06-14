package algo3.fiuba.cartas.estados_cartas;

import algo3.fiuba.cartas.efectos_cartas.EfectoCarta;

public interface EstadoCarta {

    boolean estaEnJuego();

    public void activar(EfectoCarta efecto);
}
