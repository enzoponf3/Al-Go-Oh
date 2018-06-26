package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.cartas.Monstruo;

public class UnaACuatroEstrellas implements Nivel {

    private Integer CANTIDAD_DE_SACRIFICIOS;
    private static UnaACuatroEstrellas INSTANCIA;

    private UnaACuatroEstrellas() {
        CANTIDAD_DE_SACRIFICIOS = 0;
    }

    public static UnaACuatroEstrellas getInstancia() {
        if (INSTANCIA == null)
            INSTANCIA = new UnaACuatroEstrellas();
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
