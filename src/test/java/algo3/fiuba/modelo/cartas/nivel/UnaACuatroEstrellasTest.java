package algo3.fiuba.modelo.cartas.nivel;

import algo3.fiuba.modelo.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnaACuatroEstrellasTest {

    private UnaACuatroEstrellas unaACuatroEstrellas;

    private Monstruo monstruo1;
    private Monstruo monstruo2;

    @Before
    public void setUp() {
        unaACuatroEstrellas = UnaACuatroEstrellas.getInstancia();
    }

    @Test
    public void requiere2Sacrificios() {
        Integer sacrificiosRequeridos = 0;

        Assert.assertEquals(sacrificiosRequeridos, unaACuatroEstrellas.sacrificiosRequeridos());
    }

    @Test
    public void sacrificiosSuficientes_exactamente0SacrificiosDevuelveTrue() {
        Monstruo[] monstruos = {};

        Assert.assertTrue(unaACuatroEstrellas.sacrificiosSuficientes(monstruos));
    }

    @Test
    public void sacrificiosSuficientes_masDe0SacrificiosDevuelveFalse() {
        Monstruo[] monstruos1 = {monstruo1};
        Monstruo[] monstruos2 = {monstruo1, monstruo2};

        Assert.assertFalse(unaACuatroEstrellas.sacrificiosSuficientes(monstruos1));
        Assert.assertFalse(unaACuatroEstrellas.sacrificiosSuficientes(monstruos2));
    }

}
