package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.cartas.Monstruo;

public class MasDe7Estrellas implements Nivel {

    private Integer CANTIDAD_DE_SACRIFICIOS;
    private static MasDe7Estrellas INSTANCIA;

    private MasDe7Estrellas() {
        CANTIDAD_DE_SACRIFICIOS = 2;
    }

    public static MasDe7Estrellas getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new MasDe7Estrellas();
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
