package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.cartas.Monstruo;

public interface Nivel {
    
    boolean sacrificiosSuficientes(Monstruo... sacrificios);

    Integer sacrificiosRequeridos();
}
