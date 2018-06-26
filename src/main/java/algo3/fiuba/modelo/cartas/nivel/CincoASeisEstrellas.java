package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.cartas.Monstruo;

public class CincoASeisEstrellas implements Nivel {

    private Integer CANTIDAD_DE_SACRIFICIOS;
    private static CincoASeisEstrellas INSTANCIA;

    private CincoASeisEstrellas() {
        CANTIDAD_DE_SACRIFICIOS = 1;
    }

    public static CincoASeisEstrellas getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new CincoASeisEstrellas();
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
