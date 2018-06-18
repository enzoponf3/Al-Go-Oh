package algo3.fiuba.cartas.estrellas;

public class EstrellasFactory {

    private EstrellasFactory() {
        // No tiene constructor
    }

    public static Estrellas obtenerEstrellas(Integer cantidadDeEstrellas) {
        if (cantidadDeEstrellas < 1)
            throw new RuntimeException("No puede tener estrellas negativas o nulas"); // !!!
        if (cantidadDeEstrellas < 5)
            return UnaACuatroEstrellas.getInstancia();
        if (cantidadDeEstrellas < 7)
            return CincoOSeisEstrellas.getInstancia();

        return MasDe7Estrellas.getInstancia();
    }
}
