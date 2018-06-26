package algo3.fiuba.modelo;

import algo3.fiuba.modelo.Turno;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

public class TurnoTest {

    private Turno turno;

    @Before
    public void setUp() {
        turno = Turno.getInstancia();
    }

    @Test
    public void seAgregaUnObservadorDelTurno_alPasarElTurnoAvisaAlbservado() {
        ObservadorDePrueba observador = new ObservadorDePrueba();
        turno.addObserver(observador);

        // Inicialmente al obtener valor devuelve false.
        Assert.assertFalse(observador.obtenerValor());

        turno.pasarTurno();

        Assert.assertTrue(observador.obtenerValor());
    }

    @Test
    public void seAgreganVariosObservadorDelTurno_alPasarElTurnoAvisaALosObservados() {
        ObservadorDePrueba observador1 = new ObservadorDePrueba();
        turno.addObserver(observador1);
        ObservadorDePrueba observador2 = new ObservadorDePrueba();
        turno.addObserver(observador2);
        ObservadorDePrueba observador3 = new ObservadorDePrueba();
        turno.addObserver(observador3);

        // Inicialmente al obtener valor devuelve false.
        Assert.assertFalse(observador1.obtenerValor());
        Assert.assertFalse(observador2.obtenerValor());
        Assert.assertFalse(observador3.obtenerValor());

        turno.pasarTurno();

        Assert.assertTrue(observador1.obtenerValor());
        Assert.assertTrue(observador2.obtenerValor());
        Assert.assertTrue(observador3.obtenerValor());
    }


    public class ObservadorDePrueba implements Observer {

        public boolean valor = false;

        @Override
        public void update(Observable o, Object arg) {
            valor = true;
        }

        public boolean obtenerValor() {
            return valor;
        }
    }
}
