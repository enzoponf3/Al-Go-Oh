package algo3.fiuba.cartas.estrellas;

import algo3.fiuba.cartas.Monstruo;

public class UnaACuatroEstrellas implements Estrellas {

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
