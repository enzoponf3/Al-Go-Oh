package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.excepciones.EstrellasInvalidasExcepcion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NivelFactoryTest {


    @Before
    public void setUp() {

    }

    @Test(expected = EstrellasInvalidasExcepcion.class)
    public void noPuedeTener0Estrellas() {
        Integer estrellas = 0;
        NivelFactoryFactory.obtenerEstrellas(estrellas);
    }

    @Test
    public void tiene1estrellas_devuelveUnaACuatroEstrellas() {
        Integer estrellas = 1;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof UnaACuatroEstrellas);
    }

    @Test
    public void tiene2estrellas_devuelveUnaACuatroEstrellas() {
        Integer estrellas = 2;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof UnaACuatroEstrellas);
    }

    @Test
    public void tiene3estrellas_devuelveUnaACuatroEstrellas() {
        Integer estrellas = 3;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof UnaACuatroEstrellas);
    }

    @Test
    public void tiene4estrellas_devuelveUnaACuatroEstrellas() {
        Integer estrellas = 4;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof UnaACuatroEstrellas);
    }

    @Test
    public void tiene5estrellas_devuelveCincoOSeisEstrellas() {
        Integer estrellas = 5;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof CincoASeisEstrellas);
    }

    @Test
    public void tiene6estrellas_devuelveCincoOSeisEstrellas() {
        Integer estrellas = 6;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof CincoASeisEstrellas);
    }

    @Test
    public void tiene7estrellas_devuelveCincoOSeisEstrellas() {
        Integer estrellas = 7;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof MasDe7Estrellas);
    }

    @Test
    public void tiene8estrellas_devuelveCincoOSeisEstrellas() {
        Integer estrellas = 8;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof MasDe7Estrellas);
    }

    @Test
    public void tiene9estrellas_devuelveCincoOSeisEstrellas() {
        Integer estrellas = 9;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof MasDe7Estrellas);
    }

    @Test
    public void tiene10estrellas_devuelveCincoOSeisEstrellas() {
        Integer estrellas = 10;
        Assert.assertTrue(NivelFactoryFactory.obtenerEstrellas(estrellas) instanceof MasDe7Estrellas);
    }

    @Test(expected = EstrellasInvalidasExcepcion.class)
    public void noPuedeTenerMasDe10Estrellas() {
        Integer estrellas = 11;
        NivelFactoryFactory.obtenerEstrellas(estrellas);
    }




}
