package algo3.fiuba.cartas.nivel;

import algo3.fiuba.cartas.Monstruo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MasDe7EstrellasTest {

    private MasDe7Estrellas masDe7Estrellas;

    private Monstruo monstruo1;
    private Monstruo monstruo2;
    private Monstruo monstruo3;

    @Before
    public void setUp() {
        masDe7Estrellas = MasDe7Estrellas.getInstancia();
    }

    @Test
    public void requiere2Sacrificios() {
        Integer sacrificiosRequeridos = 2;

        Assert.assertEquals(sacrificiosRequeridos, masDe7Estrellas.sacrificiosRequeridos());
    }

    @Test
    public void sacrificiosSuficientes_menosDe2SacrificiosDevuelveFalse() {
        Monstruo[] monstruos0 = {};
        Monstruo[] monstruos1 = {monstruo1};

        Assert.assertFalse(masDe7Estrellas.sacrificiosSuficientes(monstruos0));
        Assert.assertFalse(masDe7Estrellas.sacrificiosSuficientes(monstruos1));
    }

    @Test
    public void sacrificiosSuficientes_exactamente2SacrificiosDevuelveTrue() {
        Monstruo[] monstruos = {monstruo1, monstruo2};

        Assert.assertTrue(masDe7Estrellas.sacrificiosSuficientes(monstruos));
    }

    @Test
    public void sacrificiosSuficientes_masDe2SacrificiosDevuelveFalse() {
        Monstruo[] monstruos = {monstruo1, monstruo2, monstruo3};

        Assert.assertFalse(masDe7Estrellas.sacrificiosSuficientes(monstruos));
    }
}
