package algo3.fiuba.cartas.nivel;

public class NivelFactoryFactory {

    private NivelFactoryFactory() {
        // No tiene constructor
    }

    public static Nivel obtenerEstrellas(Integer cantidadDeEstrellas) {
        if (cantidadDeEstrellas < 1)
            throw new RuntimeException("No puede tener estrellas negativas o nulas"); // !!!
        if (cantidadDeEstrellas < 5)
            return UnaACuatroEstrellas.getInstancia();
        if (cantidadDeEstrellas < 7)
            return CincoOSeisEstrellas.getInstancia();

        return MasDe7Estrellas.getInstancia();
    }
}
