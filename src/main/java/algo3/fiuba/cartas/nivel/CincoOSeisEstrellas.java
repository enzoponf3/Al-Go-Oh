package algo3.fiuba.cartas.nivel;

import algo3.fiuba.cartas.Monstruo;

public class CincoOSeisEstrellas implements Nivel {

    private Integer CANTIDAD_DE_SACRIFICIOS;
    private static CincoOSeisEstrellas INSTANCIA;

    private CincoOSeisEstrellas() {
        CANTIDAD_DE_SACRIFICIOS = 1;
    }

    public static CincoOSeisEstrellas getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new CincoOSeisEstrellas();
        return INSTANCIA;
    }

    @Override
    public boolean sacrificiosSuficientes(Monstruo... sacrificios) {
        return sacrificios.length == CANTIDAD_DE_SACRIFICIOS;
    }

    @Override
    public Integer sacrificiosRequeridos() {
        return CANTIDAD_DE_SACRIFICIOS;
    }
}
