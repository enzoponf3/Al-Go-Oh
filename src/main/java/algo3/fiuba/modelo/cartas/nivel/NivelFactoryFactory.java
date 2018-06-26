package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.excepciones.EstrellasInvalidasExcepcion;

public class NivelFactoryFactory {

    private NivelFactoryFactory() {
        // No tiene constructor.
    }

    public static Nivel obtenerEstrellas(Integer cantidadDeEstrellas) {
        if (cantidadDeEstrellas < 1)
            throw new EstrellasInvalidasExcepcion("No puede tener estrellas negativas o nulas."); // !!!
        if (cantidadDeEstrellas < 5)
            return UnaACuatroEstrellas.getInstancia();
        if (cantidadDeEstrellas < 7)
            return CincoASeisEstrellas.getInstancia();
        if (cantidadDeEstrellas > 10)
            throw new EstrellasInvalidasExcepcion("No puede tener más de 10 estrellas."); // !!!

        return MasDe7Estrellas.getInstancia();
    }
}
