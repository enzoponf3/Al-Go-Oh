package algo3.fiuba.cartas.nivel;

import algo3.fiuba.cartas.Monstruo;

public interface Nivel {
    
    boolean sacrificiosSuficientes(Monstruo... sacrificios);

    Integer sacrificiosRequeridos();
}
